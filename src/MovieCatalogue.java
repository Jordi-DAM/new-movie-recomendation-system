import models.Movie;
import connexio.CRUD;
import implementation.ImpletationMovie;

public class MovieCatalogue {
    private CRUD<Movie>movieCatalgue;

    public MovieCatalogue() {
        this.movieCatalgue = new ImpletationMovie();
    }

    public CRUD<Movie> getMovieCatalgue() {
        return movieCatalgue;
    }

    public void setMovieCatalgue(CRUD<Movie> movieCatalgue) {
        this.movieCatalgue = movieCatalgue;
    }
}
