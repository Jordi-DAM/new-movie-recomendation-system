package main;

import domain.model.Movie;
import domain.model.Person;
import ui.SingletonUI;
import ui.UI;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        UI ui = new UI();
        System.out.println("What movie do you want?");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println(ui.readMovie(n));
        for (Movie m : ui.getItems()) {
            System.out.println(m);
        }
        System.out.println("Actors IDs go from 66 to 266");
        System.out.println("What actor do you want to display the movies of?");
        Person actor = ui.readPerson(sc.nextInt());
        sc.nextLine();
        for (Movie m : ui.getMoviesByActor(actor)) {
            System.out.println(m);
        }
//        ui.getItems();
    }

}
