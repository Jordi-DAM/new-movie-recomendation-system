package classes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class User{
    private String username;
    private String mail;
    private String password;
    private Movie favouriteMovie;
    private ArrayList<User> pendingFR;
    private ArrayList<User> friends;


    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        favouriteMovie = null;
        pendingFR = new ArrayList<>();
        friends = new ArrayList<>();
    }

    public User(String username) {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", favouriteMovie=" + favouriteMovie +
                ", pendingFR=" + pendingFR +
                ", friends=" + friends +
                '}';
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

    public ArrayList<User> getPendingFR() {
        return pendingFR;
    }

    public void setPendingFR(ArrayList<User> pendingFR) {
        this.pendingFR = pendingFR;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }
}