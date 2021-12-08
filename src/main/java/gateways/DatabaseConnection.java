package gateways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static constants.DatabaseConstants.*;

public class DatabaseConnection {

    public static Connection conn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded :)");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Can't find driver :('", e);
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected :)");

            return conn;

        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect :(", e);
        }
    }
}
