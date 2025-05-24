package persistance.dao;

import domain.model.Person;
import domain.model.User;
import persistance.db.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUser implements CRUD<User> {
    private java.sql.Connection con = Connection.getConnection();

    @Override
    public int create(User user) throws SQLException {
        String query = "INSERT INTO USER (Username, Password, Email) VALUES (?, ?, ?)";
        int idNewUser = -1;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getMail());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                rs.next();
                idNewUser = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idNewUser;
    }

    @Override
    public User read(int id) throws SQLException {
        String query = "SELECT * FROM USER WHERE UserId = ?";
        boolean check = false;
        User user = new User();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    check = true;
                    user.setId(rs.getInt("UserId"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getString("Password"));
                    user.setMail(rs.getString("Email"));
                    user.setFavouriteMovie(new DaoMovie().read(rs.getInt("Favourite_Movie")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            return user;
        } else {
            return null;
        }
    }

    public User readUserByUsername(String username) throws SQLException {
        String query = "SELECT * FROM USER WHERE Username = ?";
        boolean check = false;
        User user = new User();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    check = true;
                    user.setId(rs.getInt("UserId"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getString("Password"));
                    user.setMail(rs.getString("Email"));
                    user.setFavouriteMovie(new DaoMovie().read(rs.getInt("Favourite_Movie")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            return user;
        } else {
            return null;
        }
    }

    public Boolean checkUsernameAvailability(String username) throws SQLException {
        String query = "SELECT * FROM USER WHERE Username = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return false;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean checkEmailAvailability(String email) throws SQLException {
        String query = "SELECT * FROM USER WHERE Email = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return false;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean checkPasswordForUser(String username, String password) throws SQLException {
        String query = "SELECT Password FROM USER WHERE Username = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    if (password.equals(rs.getString("Password"))) {
                        return true;
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<User> getItems() throws SQLException {
        String query = "SELECT * FROM User";
        List<User> ls = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("UserId"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getString("Password"));
                    user.setMail(rs.getString("Email"));
                    user.setFavouriteMovie(new DaoMovie().read(rs.getInt("Favourite_Movie")));
                    ls.add(user);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public void update(User user) throws SQLException {
        String query = "UPDATE User SET Username = ?, Password = ?, Email = ?, Favourite_Movie = ? WHERE UserId = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getMail());
            ps.setInt(4, user.getFavouriteMovie().getId());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM User WHERE UserId = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
