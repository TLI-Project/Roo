package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static String url = "jdbc:mysql://aa1cma7c5gq1xq9.cjvinftl7gsm.us-east-2.rds.amazonaws.com:3306";
    public static String username = "admin";
    public static String password = "WinnieThePooh!";

    public void createDatabase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded :)");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Can't find driver :('", e);
        }

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected :)");

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

            String car_table = "CREATE TABLE IF NOT EXISTS car " +
                    "(car_id int(10) NOT NULL AUTO_INCREMENT, " +
                    "model varchar(50) NOT NULL, " +
                    "manufacturer varchar(50) NOT NULL, " +
                    "year int(4) NOT NULL, " +
                    "price int(10) NOT NULL, " +
                    "transmission varchar(50) NOT NULL, " +
                    "vin varchar(50) NOT NULL, " +
                    "lot varchar(50) NOT NULL, " +
                    "PRIMARY KEY (car_id)) " +
                    "DEFAULT CHARSET=utf8";
            stmt.execute(car_table);

            String bank = "CREATE TABLE IF NOT EXISTS bank " +
                    "(bank_id int(10) NOT NULL AUTO_INCREMENT, " +
                    "name varchar(50) NOT NULL, " +
                    "PRIMARY KEY (bank_id)) " +
                    "DEFAULT CHARSET=utf8";
            stmt.execute(bank);

            String dealership = "CREATE TABLE IF NOT EXISTS dealership " +
                    "(dealership_id int(10) NOT NULL AUTO_INCREMENT, " +
                    "name varchar(50) NOT NULL, " +
                    "PRIMARY KEY (dealership_id)) " +
                    "DEFAULT CHARSET=utf8";
            stmt.execute(dealership);

            String user = "CREATE TABLE IF NOT EXISTS user " +
                    "(user_id int(10) NOT NULL AUTO_INCREMENT, " +
                    "name varchar(50) NOT NULL, " +
                    "username varchar(50) NOT NULL, " +
                    "password varchar(50) NOT NULL, " +
                    "PRIMARY KEY (user_id)) " +
                    "DEFAULT CHARSET=utf8";
            stmt.execute(user);
        } catch (SQLException e) {
            throw new IllegalStateException("Can't connect :(", e);
        }
    }
}