package persistance.dao;

import domain.model.Genre;
import domain.model.Person;
import persistance.db.Connection;
import domain.model.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMovie implements CRUD<Movie> {

    static java.sql.Connection con = Connection.getConnection();

    @Override
    public Movie read(int movieId) throws SQLException {
        String query = "SELECT * FROM MOVIE WHERE MovieId = ?\n";
        Movie movie = new Movie();
        boolean check = false;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, movieId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    check = true;
                    movie.setId(rs.getInt("MovieId"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setYear(rs.getInt("Year"));
                    movie.setDirector(new DaoPerson().read(rs.getInt("Director")));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        query = "SELECT ActorId FROM Actor_Movie WHERE MovieId = ?";
        List<Person> actors = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, movieId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    actors.add(new DaoPerson().read(rs.getInt("ActorId")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        movie.setActors(actors);

        query = "SELECT GenreId FROM Movie_Genre WHERE MovieId = ?";
        List<Genre> genres = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, movieId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    genres.add(new DaoGenre().read(rs.getInt("GenreId")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        movie.setGenre(genres);
        if (check) {
            return movie;
        } else return null;

    }

    public ArrayList<Movie> readByActor(Person actor) throws SQLException {
        String query = "SELECT M.MovieId, M.Title ,M.Director, M.Year, AM.ActorId as actor FROM MOVIE M\n" +
                "JOIN Actor_Movie AM ON AM.MovieId = M.MovieId\n" +
                "WHERE AM.ActorId = ? \n" +
                "LIMIT 5";

        ArrayList<Movie> movies = new ArrayList<>();
        boolean check = false;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, actor.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    check = true;
                    movie.setId(rs.getInt("MovieId"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setDirector(new DaoPerson().read(rs.getInt("Director")));
                    movie.setYear(rs.getInt("Year"));

                    String query2 = "SELECT ActorId FROM Actor_Movie WHERE MovieId = ?";
                    List<Person> actors = new ArrayList<>();
                    try (PreparedStatement ps2 = con.prepareStatement(query2)) {
                        ps2.setInt(1, movie.getId());
                        try (ResultSet rs2 = ps2.executeQuery()) {
                            while (rs2.next()) {
                                actors.add(new DaoPerson().read(rs2.getInt("ActorId")));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    movie.setActors(actors);
                    String query3 = "SELECT GenreId FROM Movie_Genre WHERE MovieId = ?";
                    List<Genre> genres = new ArrayList<>();
                    try (PreparedStatement ps3 = con.prepareStatement(query3)) {
                        ps3.setInt(1, movie.getId());

                        try (ResultSet rs3 = ps3.executeQuery()) {
                            while (rs3.next()) {
                                genres.add(new DaoGenre().read(rs3.getInt("GenreId")));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    movie.setGenre(genres);
                    movies.add(movie);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            return movies;
        } else return null;
    }


    @Override
    public int create(Movie movie) {
        return 0;
    }


    @Override
    public List<Movie> getItems() {
        String query = "SELECT * FROM MOVIE\n";
        ArrayList<Movie> movies = new ArrayList<>();
        boolean check = false;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie();
                    check = true;
                    movie.setId(rs.getInt("MovieId"));
                    movie.setTitle(rs.getString("Title"));
                    movie.setDirector(new DaoPerson().read(rs.getInt("Director")));
                    movie.setYear(rs.getInt("Year"));

                    String query2 = "SELECT ActorId FROM Actor_Movie WHERE MovieId = ?";
                    List<Person> actors = new ArrayList<>();
                    try (PreparedStatement ps2 = con.prepareStatement(query2)) {
                        ps2.setInt(1, movie.getId());

                        try (ResultSet rs2 = ps2.executeQuery()) {
                            while (rs2.next()) {
                                actors.add(new DaoPerson().read(rs2.getInt("ActorId")));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    movie.setActors(actors);

                    String query3 = "SELECT GenreId FROM Movie_Genre WHERE MovieId = ?";
                    List<Genre> genres = new ArrayList<>();
                    try (PreparedStatement ps3 = con.prepareStatement(query3)) {
                        ps3.setInt(1, movie.getId());

                        try (ResultSet rs3 = ps3.executeQuery()) {
                            while (rs3.next()) {
                                genres.add(new DaoGenre().read(rs3.getInt("GenreId")));
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    movie.setGenre(genres);
                    movies.add(movie);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (check) {
            return movies;
        } else return null;
    }

    @Override
    public void update(Movie movie) {

    }

    @Override
    public void delete(int id) {

    }
}
