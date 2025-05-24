package domain.model;

import java.util.ArrayList;

public class User {
    public int id;
    private String username;
    private String mail;
    private String password;
    private Movie favouriteMovie;


    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        favouriteMovie = null;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "\nNom d'usuari: " + username +
                "\nCorreu electrònic: " + mail +
                "\nPel·lícula preferida: " +
                (favouriteMovie != null ? favouriteMovie.getTitle() : "Cap");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Movie getFavouriteMovie() {
        return favouriteMovie;
    }

    public void setFavouriteMovie(Movie favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }
}