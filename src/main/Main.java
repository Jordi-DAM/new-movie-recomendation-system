package main;

import domain.model.Movie;
import domain.model.User;
import ui.UI;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        UI ui = new UI();
        Scanner sc = new Scanner(System.in);

        System.out.print("""
                
                --------------------------
                RECOMANADOR DE PEL·LÍCULES
                --------------------------
                
                """);

        while (true) {
            boolean loggedIn = showLoginMenu(sc, ui);
            if (!loggedIn) {
                System.out.println("\nSortint del programa...");
                System.out.println("Fins aviat!");
                sc.close();
                return;
            }

            boolean exit = showMovieMenu(sc, ui);
            if (exit) {
                System.out.println("\nSortint del programa...");
                System.out.println("Fins aviat!");
                sc.close();
                return;
            }
        }
    }

    private boolean showLoginMenu(Scanner sc, UI ui) {
        while (true) {
            try {
                System.out.print("""
                        INICI DE SESSIÓ
                        
                        1. Nou usuari
                        2. Iniciar sessió
                        3. Entra com a convidat
                        0. Sortir del programa
                        
                        """);
                System.out.print("Triï una opció: ");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        createUser(sc, ui);
                        enter(sc);
                        break;
                    case 2:
                        if (login(sc, ui)) return true;
                        break;
                    case 3:
                        System.out.println();
                        return true;
                    case 0:
                        return false;
                    default:
                        System.out.println("\nOpció no vàlida. Torni a intentar-ho.\n");
                }
            } catch (InputMismatchException | SQLException e) {
                System.out.println("\nNomés s'accepten nombres enters.\n");
                sc.nextLine();
            }
        }
    }

    private boolean showMovieMenu(Scanner sc, UI ui) {
        while (true) {
            try {
                System.out.println("""
                        RECOMANADOR DE PEL·LÍCULES
                        
                        1. Llistat de pel·lícules disponibles
                        2. Cercador de pel·lícules per id
                        3. Cercador de pel·licules per actor
                        4. El meu Perfil
                        5. Buscar perfil
                        6. Tancar sessió
                        0. Sortir del programa
                        """);
                System.out.print("Triï una opció: ");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        displayMovieList(ui.getItems());
                        enter(sc);
                        break;
                    case 2:
                        System.out.println(ui.readMovie(sc.nextInt()));
                        sc.nextLine();
                        enter(sc);
                        break;
                    case 3:
                        System.out.println("\nEls id d'actor van del 66 al 266\n");
                        System.out.println(ui.getMoviesByActor(sc.nextInt()));
                        sc.nextLine();
                        enter(sc);
                        break;
                    case 4:
                        displayProfile(ui.getCurrentUser());
                        enter(sc);
                        break;
                    case 5:
                        profileSearcher(sc, ui);
                        enter(sc);
                        break;
                    case 6:
                        System.out.println("\nTancant sessió...\n");
                        return false;
                    case 0:
                        return true;
                    default:
                        System.out.println("Opció no vàlida. Torni a intentar-ho.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nNomés s'accepten nombres enters.");
                sc.nextLine();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean MailChecking(String mail) {
        Pattern verifyEmail = Pattern.compile("([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)");
        Matcher search = verifyEmail.matcher(mail);
        return search.matches();
    }

    public static boolean PasswordChecking(String password) {
        Pattern securePassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher search = securePassword.matcher(password);
        return search.matches();
    }

    public static void createUser(Scanner sc, UI ui) throws SQLException {
        String username, email, password;

        while (true) {
            try {
                System.out.print("\nNom d'usuari: ");
                username = sc.nextLine();

                if (username.contains(" ")) {
                    throw new IllegalArgumentException("El nom d'usuari no pot contenir espais.");
                }
                if (!ui.checkUsernameAvailability(username)) {
                    System.out.println("Aquest nom d'usuari ja existeix. Torni-ho a intentar.");
                    continue;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        while (true) {
            try {
                System.out.print("Correu electrònic: ");
                email = sc.nextLine();

                if (email.contains(" ")) {
                    throw new IllegalArgumentException("El correu electrònic no pot contenir espais.");
                }
                if (!MailChecking(email)) {
                    System.out.println("Correu no vàlid\n");
                    continue;
                }

                String finalEmail = email;
                if (!ui.checkEmailAvailability(finalEmail)) {
                    System.out.println("Aquest correu electrònic ja està registrat\n");
                    continue;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        while (true) {
            try {
                System.out.print("Contrasenya: ");
                password = sc.nextLine();

                if (password.contains(" ")) {
                    throw new IllegalArgumentException("La contrasenya no pot contenir espais.");
                }
                if (!PasswordChecking(password)) {
                    System.out.println("La contrasenya no compleix els requisits de seguretat\n");
                    continue;
                }

                System.out.print("Confirmi la contrasenya: ");
                if (!password.equals(sc.nextLine())) {
                    System.out.println("Les contrasenyes no coincideixen\n");
                    continue;
                }
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        ui.createUser(new User(username, email, password));
        System.out.println("\nUsuari creat correctament!\n");
    }

    public static boolean login(Scanner sc, UI ui) {
        while (true) {
            try {
                System.out.print("\nNom d'usuari: ");
                String checkUser = sc.nextLine();

                if (checkUser.contains(" ")) {
                    throw new IllegalArgumentException("El nom d'usuari no pot contenir espais.");
                }

                System.out.print("Contrasenya: ");
                String checkPasswd = sc.nextLine();

                if (checkPasswd.contains(" ")) {
                    throw new IllegalArgumentException("La contrasenya no pot contenir espais.");
                }

                boolean userExists = !ui.checkUsernameAvailability(checkUser);
                boolean passwordCorrect = ui.checkPasswordForUsername(checkUser, checkPasswd);

                if (userExists && passwordCorrect) {
                    ui.setCurrentUser(ui.readUserByUsername(checkUser));
                    System.out.println("\nS'ha iniciat sessió correctament\n");
                    return true;
                }

                System.out.println("\nUsuari i/o contrasenya incorrectes");

                String answer;
                do {
                    System.out.print("Vols tornar enrere i registrar-te? ");
                    answer = sc.nextLine().toLowerCase();
                    if (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("n")) {
                        System.out.println("\nRespon ❝si❞ o ❝no❞");
                    }
                } while (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("n"));

                if (answer.equalsIgnoreCase("si") || answer.equalsIgnoreCase("s")) {
                    return false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nRespon ❝si❞ o ❝no❞");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void profileSearcher(Scanner sc, UI ui) {
        System.out.print("\nCerca un nom d'usuari: ");
        String inputUsername = sc.nextLine();

        try {
            User foundUser = ui.readUserByUsername(inputUsername);

            if (foundUser == null) {
                System.out.println("Aquest usuari no existeix");
                return;
            }

            System.out.print("Vols veure el perfil de " + foundUser.getUsername() + "? ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("si")) {
                displayProfile(foundUser);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception e) {
            System.out.println("Error inesperat: " + e.getMessage());
        }

        System.out.println();
    }


    public static void displayProfile(User u) {
        System.out.println(u);
    }

    public static void enter(Scanner sc) {
        System.out.print("Prem enter per continuar.\n");
        sc.nextLine();
    }

    public void displayMovieList(List<Movie> movieList) {
        for (Movie m : movieList) {
            System.out.println(m);
        }
    }
}