package models;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class MovieRecomendationManager {
    private Set<Movie> movies;
    private Set<Director> directors;
    private Set<Actor> actors;
    private Set<User> users;
    private User currentUser;

    public MovieRecomendationManager(Set<Movie> movies, Set<Director> directors, Set<Actor> actors, Set<User> users) {
        this.movies = movies;
        this.directors = directors;
        this.actors = actors;
        this.users = users;
    }

    public MovieRecomendationManager() {
        movies = new HashSet<>();
        users = new HashSet<>();
        directors = new HashSet<>();
        actors = new HashSet<>();
        currentUser = null;
        addDefaultDirectors(createDefaultDirectors());
        addDefaultActors(createDefaultActors());
        addDefaultMovies();
        addUser(new User("admin", "bustiad@gmail.com", "@dm1n"));
        addUser(new User(1, "Èrik", LocalDate.of(2004, 10, 15), "Spanish", "erik", "sonwerik@mail.com", "miau"));
        addUser(new User(2, "Jordi", LocalDate.of(2000, 1, 1), "Spanish", "jordi", "jordi@mail.com", "password"));
        addUser(new User(3, "Alam", LocalDate.of(2006, 1, 1), "Spanish", "alam", "alam@mail.com", "contraseña"));
        addUser(new User(4, "Joan", LocalDate.of(2006, 1, 1), "Spanish", "joan", "joan@mail.com", "contrasenya"));
    }

    private Set<Director> createDefaultDirectors() {
        Director christopherNolan = new Director(0, "Christopher Nolan", LocalDate.of(1970, 7, 30), "British");
        Director francisFordCoppola = new Director(1, "Francis Ford Coppola", LocalDate.of(1939, 4, 7), "U.S.");
        Director quentinTarantino = new Director(2, "Quentin Tarantino", LocalDate.of(1963, 3, 27), "U.S.");
        Director martinScorsese = new Director(3, "Martin Scorsese", LocalDate.of(1942, 11, 17), "U.S.");
        Director toddPhillips = new Director(4, "Todd Phillips", LocalDate.of(1970, 12, 20), "U.S.");
        Director jonathanDemme = new Director(5, "Jonathan Demme", LocalDate.of(1944, 2, 22), "U.S.");
        Director alfredHitchcock = new Director(6, "Alfred Hitchcock", LocalDate.of(1899, 8, 13), "British");
        Director stanleyKubrick = new Director(7, "Stanley Kubrick", LocalDate.of(1928, 7, 26), "U.S.");
        Director davidFrankel = new Director(1, "David Frankel", LocalDate.of(1959, 4, 2), "American");

        return Set.of(christopherNolan, francisFordCoppola, quentinTarantino, martinScorsese, toddPhillips, jonathanDemme, alfredHitchcock, stanleyKubrick, davidFrankel);
    }

    private void addDefaultDirectors(Set<Director> dir) {
        directors.addAll(dir);
    }

    private Set<Actor> createDefaultActors() {
        Actor leonardoDiCaprio = new Actor(0, "Leonardo DiCaprio", LocalDate.of(1974, 11, 11), "U.S.");
        Actor josephGordonLevitt = new Actor(1, "Joseph Gordon-Levitt", LocalDate.of(1981, 2, 17), "U.S.");
        Actor kenWatanabe = new Actor(2, "Ken Watanabe", LocalDate.of(1959, 10, 21), "Japanese");
        Actor marlonBrando = new Actor(3, "Marlon Brando", LocalDate.of(1924, 4, 3), "U.S.");
        Actor alPacino = new Actor(4, "Al Pacino", LocalDate.of(1940, 4, 25), "U.S.");
        Actor jamesCaan = new Actor(5, "James Caan", LocalDate.of(1940, 3, 26), "U.S.");
        Actor robertDuvall = new Actor(6, "Robert Duvall", LocalDate.of(1931, 1, 5), "U.S.");
        Actor johnTravolta = new Actor(7, "John Travolta", LocalDate.of(1954, 2, 18), "U.S.");
        Actor samuelLJackson = new Actor(8, "Samuel L. Jackson", LocalDate.of(1948, 12, 21), "U.S.");
        Actor umaThurman = new Actor(9, "Uma Thurman", LocalDate.of(1970, 4, 29), "U.S.");
        Actor bruceWillis = new Actor(10, "Bruce Willis", LocalDate.of(1955, 3, 19), "German");
        Actor joaquinPhoenix = new Actor(11, "Joaquin Phoenix", LocalDate.of(1974, 10, 28), "U.S.");
        Actor robertDeNiro = new Actor(12, "Robert De Niro", LocalDate.of(1943, 8, 17), "U.S.");
        Actor zazieBeetz = new Actor(13, "Zazie Beetz", LocalDate.of(1991, 5, 25), "U.S.");
        Actor jamieFoxx = new Actor(14, "Jamie Foxx", LocalDate.of(1967, 12, 13), "U.S.");
        Actor christophWaltz = new Actor(15, "Christoph Waltz", LocalDate.of(1956, 10, 4), "Austrian");
        Actor kerryWashington = new Actor(16, "Kerry Washington", LocalDate.of(1977, 1, 31), "U.S.");
        Actor waltonGoggins = new Actor(17, "Walton Goggins", LocalDate.of(1971, 11, 10), "U.S.");
        Actor jodieFoster = new Actor(18, "Jodie Foster", LocalDate.of(1962, 11, 19), "U.S.");
        Actor cybillShepherd = new Actor(19, "Cybill Shepherd", LocalDate.of(1950, 2, 18), "U.S.");
        Actor harveyKeitel = new Actor(20, "Harvey Keitel", LocalDate.of(1939, 5, 13), "U.S.");
        Actor anthonyHopkins = new Actor(21, "Anthony Hopkins", LocalDate.of(1937, 12, 31), "British");
        Actor scottGlenn = new Actor(22, "Scott Glenn", LocalDate.of(1939, 1, 26), "U.S.");
        Actor tedLevine = new Actor(23, "Ted Levine", LocalDate.of(1957, 5, 29), "U.S.");
        Actor rayLiotta = new Actor(24, "Ray Liotta", LocalDate.of(1954, 12, 18), "U.S.");
        Actor joePesci = new Actor(25, "Joe Pesci", LocalDate.of(1943, 2, 9), "U.S.");
        Actor lorraineBracco = new Actor(26, "Lorraine Bracco", LocalDate.of(1954, 10, 2), "U.S.");
        Actor matthewMcConaughey = new Actor(27, "Matthew McConaughey", LocalDate.of(1969, 11, 4), "U.S.");
        Actor anneHathaway = new Actor(28, "Anne Hathaway", LocalDate.of(1982, 11, 12), "U.S.");
        Actor michaelCaine = new Actor(29, "Michael Caine", LocalDate.of(1933, 3, 14), "British");
        Actor lilyGladstone = new Actor(30, "Lily Gladstone", LocalDate.of(1986, 8, 2), "U.S.");
        Actor anthonyPerkins = new Actor(31, "Anthony Perkins", LocalDate.of(1932, 4, 4), "U.S.");
        Actor janetLeigh = new Actor(32, "Janet Leigh", LocalDate.of(1927, 7, 6), "U.S.");
        Actor veraMiles = new Actor(33, "Vera Miles", LocalDate.of(1929, 8, 23), "U.S.");
        Actor johnGavin = new Actor(34, "John Gavin", LocalDate.of(1931, 4, 8), "U.S.");
        Actor tomCruise = new Actor(35, "Tom Cruise", LocalDate.of(1962, 7, 3), "U.S.");
        Actor nicoleKidman = new Actor(36, "Nicole Kidman", LocalDate.of(1967, 6, 20), "U.S.");
        Actor sydneyPollack = new Actor(37, "Sydney Pollack", LocalDate.of(1934, 7, 1), "U.S.");
        Actor merylStreep = new Actor(38, "Meryl Streep", LocalDate.of(1949, 6, 22), "U.S.");
        Actor emilyBlunt = new Actor(39, "Emily Blunt", LocalDate.of(1983, 2, 23), "British");
        Actor stanleyTucci = new Actor(40, "Stanley Tucci", LocalDate.of(1960, 11, 11), "U.S.");


        return Set.of(leonardoDiCaprio, josephGordonLevitt, kenWatanabe, marlonBrando, alPacino, jamesCaan, robertDuvall, johnTravolta, samuelLJackson, umaThurman, bruceWillis, joaquinPhoenix, robertDeNiro,
                zazieBeetz, jamieFoxx, christophWaltz, kerryWashington, waltonGoggins, jodieFoster, cybillShepherd, harveyKeitel, anthonyHopkins, scottGlenn, tedLevine, rayLiotta, joePesci,
                lorraineBracco, matthewMcConaughey, anneHathaway, michaelCaine, lilyGladstone, anthonyPerkins, janetLeigh, veraMiles, johnGavin, tomCruise, nicoleKidman, sydneyPollack, merylStreep,
                emilyBlunt, stanleyTucci);
    }

    private void addDefaultActors(Set<Actor> act) {
        actors.addAll(act);
    }

    public Director findDirectorByName(String name) {
        return directors.stream()
                .filter(director -> director.getName().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("classes.Director no existent: " + name));
    }

    public Actor findActorByName(String name) {
        return actors.stream()
                .filter(actor -> actor.getName().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("ImplementationActor no existent: " + name));
    }


    private void addDefaultMovies() {
        movies.add(new Movie(Year.of(2010), "Inception", 1,
                Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Joseph Gordon-Levitt"), findActorByName("Ken Watanabe")),
                Set.of("Action", "Adventure", "Science Fiction")
        ));

        movies.add(new Movie(Year.of(1972), "The Godfather", 2,
                Set.of(findDirectorByName("Francis Ford Coppola")),
                Set.of(findActorByName("Marlon Brando"), findActorByName("Al Pacino"), findActorByName("James Caan"), findActorByName("Robert Duvall")),
                Set.of("Crime", "Drama")
        ));

        movies.add(new Movie(Year.of(1994), "Pulp Fiction", 3,
                Set.of(findDirectorByName("Quentin Tarantino")),
                Set.of(findActorByName("John Travolta"), findActorByName("Samuel L. Jackson"), findActorByName("Uma Thurman"), findActorByName("Bruce Willis")),
                Set.of("Crime", "Thriller")
        ));

        movies.add(new Movie(Year.of(2019), "Joker", 4,
                Set.of(findDirectorByName("Todd Phillips")),
                Set.of(findActorByName("Joaquin Phoenix"), findActorByName("Robert De Niro"), findActorByName("Zazie Beetz")),
                Set.of("Crime", "Drama", "Thriller")
        ));

        movies.add(new Movie(Year.of(2012), "Django Unchained", 5,
                Set.of(findDirectorByName("Quentin Tarantino")),
                Set.of(findActorByName("Jamie Foxx"), findActorByName("Christoph Waltz"), findActorByName("Leonardo DiCaprio"),
                        findActorByName("Kerry Washington"), findActorByName("Samuel L. Jackson"), findActorByName("Walton Goggins")),
                Set.of("Western")
        ));

        movies.add(new Movie(Year.of(1976), "Taxi Driver", 6,
                Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Robert De Niro"), findActorByName("Jodie Foster"), findActorByName("Cybill Shepherd"), findActorByName("Harvey Keitel")),
                Set.of("Drama", "Crime")
        ));

        movies.add(new Movie(Year.of(1991), "The Silence of the Lambs", 7,
                Set.of(findDirectorByName("Jonathan Demme")),
                Set.of(findActorByName("Jodie Foster"), findActorByName("Anthony Hopkins"), findActorByName("Scott Glenn"), findActorByName("Ted Levine")),
                Set.of("Horror", "Crime", "Thriller", "Drama")
        ));

        movies.add(new Movie(Year.of(1990), "GoodFellas", 8,
                Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Robert De Niro"), findActorByName("Ray Liotta"), findActorByName("Joe Pesci"), findActorByName("Lorraine Bracco")),
                Set.of("Drama", "Crime")
        ));

        movies.add(new Movie(Year.of(2014), "Interstellar", 9,
                Set.of(findDirectorByName("Christopher Nolan")),
                Set.of(findActorByName("Matthew McConaughey"), findActorByName("Anne Hathaway"), findActorByName("Michael Caine")),
                Set.of("Science Fiction", "Drama", "Adventure")
        ));

        movies.add(new Movie(Year.of(2006), "The Devil Wears Prada", 10,
                Set.of(findDirectorByName("David Frankel")),
                Set.of(findActorByName("Meryl Streep"), findActorByName("Anne Hathaway"), findActorByName("Emily Blunt"), findActorByName("Stanley Tucci")),
                Set.of("Comedy", "Drama")
        ));

        movies.add(new Movie(Year.of(2023), "Killers of the Flower Moon", 11,
                Set.of(findDirectorByName("Martin Scorsese")),
                Set.of(findActorByName("Leonardo DiCaprio"), findActorByName("Robert De Niro"), findActorByName("Lily Gladstone")),
                Set.of("History", "Crime", "Drama")
        ));

        movies.add(new Movie(Year.of(1960), "Psycho", 12,
                Set.of(findDirectorByName("Alfred Hitchcock")),
                Set.of(findActorByName("Anthony Perkins"), findActorByName("Janet Leigh"), findActorByName("Vera Miles"), findActorByName("John Gavin")),
                Set.of("Mystery", "Thriller", "Horror")
        ));

        movies.add(new Movie(Year.of(1999), "Eyes Wide Shut", 13,
                Set.of(findDirectorByName("Stanley Kubrick")),
                Set.of(findActorByName("Tom Cruise"), findActorByName("Nicole Kidman"), findActorByName("Sydney Pollack")),
                Set.of("Thriller", "Drama", "Mystery")
        ));
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User u) {
        this.currentUser = u;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String name) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(name)) {
                return u;
            }
        }
        System.out.println("\nUsuari no trobat");
        return null;
    }

    public boolean checkUser(String checkUser) {
        return users.stream().anyMatch(user -> user.getUsername().equals(checkUser));
    }

    public boolean checkPassword(String checkUser, String checkPasswd) {
        return users.stream()
                .filter(user -> user.getUsername().equals(checkUser))
                .anyMatch(user -> user.getPassword().equals(checkPasswd));
    }


    public void showAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void removeUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public LinkedHashSet<Movie> filterMovies(String query) {
        String finalQuery = query.toLowerCase();
        System.out.println();
        return movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(finalQuery) ||
                        movie.getYear().toString().contains(finalQuery) ||
                        movie.getDirectors().stream().anyMatch(d -> d.getName().toLowerCase().contains(finalQuery)) ||
                        movie.getActors().stream().anyMatch(a -> a.getName().toLowerCase().contains(finalQuery)) ||
                        movie.getGenre().stream().anyMatch(g -> g.toLowerCase().contains(finalQuery)))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void listMovies() {
        movies.forEach(movie -> System.out.println("  - " + movie.getTitle() + " (" + movie.getYear() + ")"));
        System.out.println();
    }

    public void addFriend(User currentUser, User foundUser) {
        foundUser.addPendingFriend(currentUser);
    }

    public boolean areTheyFriends(User currentUser, User foundUser) {
        return currentUser.getFriends().contains(foundUser) && foundUser.getFriends().contains(currentUser);
    }

    public void displayFoundProfile(User u) {
        System.out.println(u.getUsername());
    }

    public void acceptFriendRequest(User acceptedUser) {
        currentUser.getPendingFR().remove(acceptedUser);
        currentUser.getFriends().add(acceptedUser);
    }

    @Override
    public String toString() {
        return "RecomenderManager{" +
                "movies=" + movies +
                ", users=" + users +
                '}';


    }

}
