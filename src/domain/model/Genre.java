package domain.model;


public class Genre {
    private int idGenre;
    private String name;

    public Genre() {
    }

    @Override
    public String toString() {
        return "Genre{" +
                ", name='" + name + '\'' +
                '}';
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
