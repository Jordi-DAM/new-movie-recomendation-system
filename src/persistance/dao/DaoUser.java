package persistance.dao;

import domain.model.User;

import java.sql.SQLException;
import java.util.List;

public class DaoUser implements CRUD<User> {
    @Override
    public int create(User user) throws SQLException {
        return 0;
    }

    @Override
    public User read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getItems() throws SQLException {
        return List.of();
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
