package UI;

import models.User;
import connexio.CRUD;
import implementation.ImplementationUser;

public class UsersManager {
    private CRUD<User>userManager;

    public UsersManager() {
        this.userManager = new ImplementationUser();
    }

    public CRUD<User> getUserManager() {
        return userManager;
    }

    public void setUserManager(CRUD<User> userManager) {
        this.userManager = userManager;
    }
}
