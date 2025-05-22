package persistance.dao;

import domain.model.Genre;
import persistance.db.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGenre implements CRUD<Genre> {
    private java.sql.Connection con = Connection.getConnection();

    @Override
    public int create(Genre genre) throws SQLException {
        String query = "INSERT INTO Genre (Name) VALUES (?)";
        int idNewGenre = -1;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, genre.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                rs.next();
                idNewGenre = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idNewGenre;
    }

    @Override
    public Genre read(int id) throws SQLException {
        String query = "SELECT * FROM Genre WHERE GenreId = ?";
        boolean check = false;
        Genre genre = new Genre();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    check = true;
                    genre.setIdGenre(rs.getInt("GenreId"));
                    genre.setName(rs.getString("Name"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            return genre;
        } else {
            return null;
        }
    }

    @Override
    public void update(Genre genre) throws SQLException {
        String query = "UPDATE Genre SET Name = ? WHERE GenreId = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, genre.getName());
            ps.setInt(2, genre.getIdGenre());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM Genre WHERE GenreId = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Genre> getItems() throws SQLException {
        String query = "SELECT * FROM Genre";
        List<Genre> ls = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int genreId = rs.getInt("GenreId");
                    ls.add(read(genreId));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }
}