package ui;

import domain.model.Movie;
import domain.model.Person;
import domain.service.MovieService;
import domain.service.MovieServiceFactory;
import domain.service.UserService;
import domain.service.UserServiceFactory;

import java.sql.SQLException;
import java.util.List;

public class UI {
    private UserService userService;
    private MovieService movieService;

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

    public List<Movie> getMoviesByActor(Person actor) throws SQLException {
        return movieService.readMovieByActor(actor);
    }

    public Person readPerson(int id) throws SQLException {
        return movieService.readPerson(id);
    }


}
