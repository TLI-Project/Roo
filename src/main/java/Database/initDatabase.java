package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class initDatabase {

    public static void main(Connection conn) {
        try {
            makeDatabase(conn);
            carTable(conn);
            bankTable(conn);
            dealershipTable(conn);
            userTable(conn);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't create :(", e);
        }
    }

    private static void makeDatabase(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String create_db = "CREATE DATABASE IF NOT EXISTS auto_education";
        stmt.execute(create_db);
        stmt.execute("USE auto_education");

        String client_table = "CREATE TABLE IF NOT EXISTS client " +
                "(client_id int(10) NOT NULL AUTO_INCREMENT, " +
                "first_name varchar(50) NOT NULL, " +
                "last_name varchar(50) NOT NULL, " +
                "email varchar(100) NOT NULL, " +
                "street_address varchar(100) NOT NULL, " +
                "city varchar(100) NOT NULL, " +
                "province varchar(100) NOT NULL, " +
                "credit_score int(3) NOT NULL, " +
                "preferred_vehicle int(10) NOT NULL, " +
                "income int(10) NOT NULL, " +
                "budget int(10) NOT NULL, " +
                "PRIMARY KEY (client_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(client_table);
        stmt.close();
    }

    private static void carTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String car_table = "CREATE TABLE IF NOT EXISTS car " +
                "(car_id int(10) NOT NULL AUTO_INCREMENT, " +
                "make varchar(50) NOT NULL, " +
                "model varchar(50) NOT NULL, " +
                "listPrice float NOT NULL," +
                "year int(10) NOT NULL, " +
                "engine varchar(50) NOT NULL," +
                "interior varchar(50) NOT NULL," +
                "paint varchar(50) NOT NULL," +
                "PRIMARY KEY (car_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(car_table);
        stmt.close();
    }

    private static void bankTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String bank = "CREATE TABLE IF NOT EXISTS bank " +
                "(bank_id int(10) NOT NULL AUTO_INCREMENT, " +
                "name varchar(50) NOT NULL, " +
                "PRIMARY KEY (bank_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(bank);
        stmt.close();
    }

    private static void dealershipTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String dealership = "CREATE TABLE IF NOT EXISTS dealership " +
                "(dealership_id int(10) NOT NULL AUTO_INCREMENT, " +
                "name varchar(50) NOT NULL, " +
                "PRIMARY KEY (dealership_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(dealership);
        stmt.close();
    }

    private static void userTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String user = "CREATE TABLE IF NOT EXISTS user " +
                "(user_id int(10) NOT NULL AUTO_INCREMENT, " +
                "name varchar(50) NOT NULL, " +
                "username varchar(50) NOT NULL, " +
                "password varchar(50) NOT NULL, " +
                "PRIMARY KEY (user_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(user);
        stmt.close();
    }

}
