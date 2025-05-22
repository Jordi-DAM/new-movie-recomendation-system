package domain.service;

import domain.model.Movie;
import ui.UI;

public class MovieServiceFactory {
    static MovieService movieService = null;

    public static MovieService getMovieService() {
        if (movieService == null) {
            try {
                movieService = new MovieService();
                System.out.println("Movie Service created");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return movieService;
    }
}
