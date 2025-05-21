package implementation;

import models.User;
import connexio.CRUD;

import java.util.List;

public class ImplementationUser implements CRUD<User> {
    @Override
    public int create(User user) {
        return 0;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public List<User> getItems() {
        return List.of();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
