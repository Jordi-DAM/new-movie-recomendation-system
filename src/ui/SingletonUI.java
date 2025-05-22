package ui;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonUI {
    static UI ui = null;

    public static UI getUi() {
        if (ui == null) {
            try {
                ui = new UI();
                System.out.println("UI created");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return ui;
    }
}
