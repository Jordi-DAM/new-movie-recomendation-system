package domain.service;

import domain.model.Movie;
import domain.model.Person;
import persistance.dao.DaoMovie;
import persistance.dao.DaoPerson;

import java.sql.SQLException;
import java.util.List;

public class MovieService {
    private DaoMovie daoMovie;
    private DaoPerson daoPerson;

    public MovieService() {
        this.daoMovie = new DaoMovie();
        this.daoPerson = new DaoPerson();
    }

    public List<Movie> getItems() {
        System.out.println("Juanito");
        return daoMovie.getItems();
    }

    public Movie readMovie(int id) throws SQLException {
        return daoMovie.read(id);
    }

    public List<Movie> readMovieByActor(Person actor) throws SQLException {
        return daoMovie.readByActor(actor);
    }

    public Person readPerson(int id) throws SQLException {
        return daoPerson.read(id);
    }

}
