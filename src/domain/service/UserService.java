package domain.service;

import persistance.dao.DaoUser;

public class UserService {
    private DaoUser daoUser;


    public UserService() {
        this.daoUser = new DaoUser();
    }

}
