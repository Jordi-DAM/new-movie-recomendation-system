package persistance.db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    static java.sql.Connection con = null;

    public static java.sql.Connection getConnection() {
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