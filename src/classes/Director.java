package classes;

import java.sql.Date;
import java.time.LocalDate;

public class Director extends Person {

    public Director(int id, String name, String surname, Date dateOfBirth, String nationality) {
        super(id, name, surname, dateOfBirth, nationality);
    }

    public Director() {

    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public Date getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    @Override
    public void setNationality(String nationality) {
        super.setNationality(nationality);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
