package gateways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static constants.DatabaseConstants.*;

public class DatabaseConnection {

    /**
     * Create a connection to the database.
     * @return a connection to the database that allows you to access entities within it.
     */
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
