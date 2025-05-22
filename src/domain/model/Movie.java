package domain.model;

import java.util.List;


public class Movie {
    private int id;
    private String title;
    private Person director;
    private List<Person> actors;
    private List<Genre> genre;
    private int year;

    public Movie(int id, String title, Person director, List<Person> actors, List<Genre> genre, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.genre = genre;
        this.year = year;
    }

    public Movie() {

    }

    @Override
    public String toString() {
        return "Movie{" +
                "Title='" + title + '\'' +
                ", Director=" + director +
                ", Actors=" + actors +
                ", Genre=" + genre +
                ", Release Year=" + year +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
