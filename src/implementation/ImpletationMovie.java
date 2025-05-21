package implementation;

import connexio.CRUD;
import connexio.Connexio;
import models.Movie;

import java.sql.Connection;
import java.util.List;

public class ImpletationMovie implements CRUD<Movie> {

    static Connection con = Connexio.getConnection();


    @Override
    public int create(Movie movie) {
        return 0;
    }

    @Override
    public Movie read(int id) {
        return null;
    }

    @Override
    public List<Movie> getItems() {
        return List.of();
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public void delete(int id) {

    }
}
