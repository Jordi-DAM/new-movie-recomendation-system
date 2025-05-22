package domain.service;

import domain.model.User;

public class UserServiceFactory {
    static UserService userService = null;

    public static UserService getUserService() {
        if (userService == null) {
            try {
                userService = new UserService();
                System.out.println("User Service created");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return userService;
    }
}
