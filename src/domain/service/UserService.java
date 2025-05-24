package domain.service;

import domain.model.User;
import persistance.dao.DaoUser;

import java.sql.SQLException;

public class UserService {
    private DaoUser daoUser;


    public UserService() {
        this.daoUser = new DaoUser();
    }

    public User readUser(int id) throws SQLException {
        return daoUser.read(id);
    }

    public User readUserByUsername(String username) throws SQLException {
        return daoUser.readUserByUsername(username);
    }

    public Boolean checkUsernameAvailability(String username) throws SQLException {
        return daoUser.checkUsernameAvailability(username);
    }

    public Boolean checkEmailAvailability(String email) throws SQLException {
        return daoUser.checkEmailAvailability(email);
    }

    public int createUser(User user) throws SQLException {
        return daoUser.create(user);
    }

    public Boolean checkPasswordForUser(String username, String password) throws SQLException {
        return daoUser.checkPasswordForUser(username, password);
    }


}
