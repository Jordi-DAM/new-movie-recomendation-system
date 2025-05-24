package ui;

import domain.model.Movie;
import domain.model.Person;
import domain.model.User;
import domain.service.MovieService;
import domain.service.MovieServiceFactory;
import domain.service.UserService;
import domain.service.UserServiceFactory;

import java.sql.SQLException;
import java.util.List;

public class UI {
    private UserService userService;
    private MovieService movieService;
    private User currentUser;

    public UI() {
        this.movieService = MovieServiceFactory.getMovieService();
        this.userService = UserServiceFactory.getUserService();
    }

    public List<Movie> getItems() {
        System.out.println("Pepito");
        return movieService.getItems();
    }

    public Movie readMovie(int id) throws SQLException {
        return movieService.readMovie(id);
    }

    public List<Movie> getMoviesByActor(int id) throws SQLException {
        return movieService.readMovieByActor(id);
    }

    public Person readPerson(int id) throws SQLException {
        return movieService.readPerson(id);
    }

    public User readUser(int id) throws SQLException {
        return userService.readUser(id);
    }

    public User readUserByUsername(String username) throws SQLException {
        return userService.readUserByUsername(username);
    }

    public Boolean checkUsernameAvailability(String username) throws SQLException {
        return userService.checkUsernameAvailability(username);
    }

    public Boolean checkEmailAvailability(String email) throws SQLException {
        return userService.checkEmailAvailability(email);
    }

    public int createUser(User user) throws SQLException {
        return userService.createUser(user);
    }

    public Boolean checkPasswordForUsername(String username, String password) throws SQLException {
        return userService.checkPasswordForUser(username, password);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
