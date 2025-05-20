package connexio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {
    static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:MovieRecommender");
                System.out.println("Connected to database successfully");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return con;
    }
}