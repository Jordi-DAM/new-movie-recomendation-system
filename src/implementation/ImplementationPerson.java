package personDao;

import classes.Person;
import connexio.CRUD;
import connexio.Connexio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImplementationPerson implements CRUD<Person> {
    private Connection con = Connexio.getConnection();

    @Override
    public int create(Person person) {
        String query = "INSERT INTO Person (FirstName, LastName, BirthDate, Nationality) VALUES (?, ?, ?, ?)";
        int idNewPerson = -1;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setDate(3, Date.valueOf(person.getDateOfBirth()));
            ps.setString(4, person.getNationality());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                rs.next();
                idNewPerson = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idNewPerson;
    }

    @Override
    public Person read(int id) {
        String query = "SELECT * FROM Person WHERE PersonId = ?";
        boolean check = false;
        Person person = new Person();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    check = true;
                    person.setId(rs.getInt("PersonId"));
                    person.setName(rs.getString("FirstName"));
                    person.setSurname(rs.getString("LastName"));
                    person.setDateOfBirth(rs.getDate("BirthDate").toLocalDate());
                    person.setNationality(rs.getString("Nationality"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            return person;
        } else {
            return null;
        }
    }

    @Override
    public void update(Person person) {
        String query = "UPDATE Person SET FirstName = ?, LastName = ?, BirthDate = ?, Nationality = ? WHERE PersonId = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setDate(3, Date.valueOf(person.getDateOfBirth()));
            ps.setString(4, person.getNationality());
            ps.setInt(5, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Person WHERE PersonId = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Person> getItems() {
        String query = "SELECT * FROM Person";
        List<Person> ls = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int personId = rs.getInt("PersonId");
                    ls.add(read(personId));
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