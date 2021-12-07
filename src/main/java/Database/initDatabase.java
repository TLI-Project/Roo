package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class initDatabase {

    public static void main(Connection conn) {
        try {
            makeDatabase(conn);
            carTable(conn);
            bankTable(conn);
            dealershipTable(conn);
            userTable(conn);
            writeToCarTable(conn, "data/sensoCarSet.csv");
        } catch (SQLException | IOException e) {
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
                "carDescription varchar(10000) NOT NULL, " +
                "listPrice float NOT NULL," +
                "year int(10) NOT NULL, " +
                "kms int(10) NOT NULL, " +
                "color varchar(100) NOT NULL," +
                "interior varchar(1000) NOT NULL," +
                "interiorDescription varchar(10000) NOT NULL," +
                "engine varchar(1000) NOT NULL," +
                "engineDescription varchar(10000) NOT NULL," +
                "performancePackage varchar(1000) NOT NULL," +
                "performancePackageDescription varchar(10000) NOT NULL," +
                "carCondition varchar(50) NOT NULL," +
                "d1 float NOT NULL," +
                "d2 float NOT NULL," +
                "d3 float NOT NULL," +
                "d4 float NOT NULL," +
                "d5 float NOT NULL," +
                "d6 float NOT NULL," +
                "d7 float NOT NULL," +
                "d8 float NOT NULL," +
                "d9 float NOT NULL," +
                "d10 float NOT NULL," +
                "image varchar(200) NOT NULL," +
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

    private static void writeToCarTable(Connection conn, String filePath) throws SQLException, IOException {
        String insert = "INSERT INTO car " +
                "(car_id, make, model, carDescription, listPrice, year, kms, color, interior, interiorDescription, " +
                "engine, engineDescription, performancePackage, performancePackageDescription, carCondition, " +
                "d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = conn.prepareStatement(insert);
        BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

        int count = 0;
        int batchSize = 20;
        String lineText;

        lineReader.readLine();

        try {
            while ((lineText = lineReader.readLine()) != null) {
                List<String> data = new ArrayList<>();
                int first_pos = 0;
                boolean wrapped = false;

                for (int last_pos = 0; last_pos < lineText.length(); last_pos++) {
                    if (lineText.charAt(last_pos) == '\"') {
                        wrapped = !wrapped;
                    }
                    else if (lineText.charAt(last_pos) == ',' && !wrapped) {
                        data.add(lineText.substring(first_pos, last_pos));
                        first_pos = last_pos + 1;
                    }
                }
                data.add(lineText.substring(first_pos));

                String car_id = data.get(0);
                String make = data.get(1);
                String model = data.get(2);
                String carDescription = data.get(3);
                String listPrice = data.get(4);
                String year = data.get(5);
                String kms = data.get(6);
                String color = data.get(7);
                String interior = data.get(8);
                String interiorDescription = data.get(9);
                String engine = data.get(10);
                String engineDescription = data.get(11);
                String performancePackage = data.get(12);
                String performancePackageDescription = data.get(13);
                String carCondition = data.get(14);
                String d1 = data.get(15);
                String d2 = data.get(16);
                String d3 = data.get(17);
                String d4 = data.get(18);
                String d5 = data.get(19);
                String d6 = data.get(20);
                String d7 = data.get(21);
                String d8 = data.get(22);
                String d9 = data.get(23);
                String d10 = data.get(24);
                String image = data.get(25);

                int int_car_id = Integer.parseInt(car_id);
                preparedStmt.setInt(1, int_car_id);

                preparedStmt.setString(2, make);

                preparedStmt.setString(3, model);

                if (carDescription.isEmpty() || carDescription.charAt(0) != '"') {
                    preparedStmt.setString(4, carDescription);
                } else {
                    String str = carDescription.substring(1, carDescription.length() - 1);
                    preparedStmt.setString(4, str);
                }

                float float_listPrice = Float.parseFloat(listPrice);
                preparedStmt.setFloat(5, float_listPrice);

                int int_year = Integer.parseInt(year);
                preparedStmt.setInt(6, int_year);

                int int_kms = Integer.parseInt(kms);
                preparedStmt.setInt(7, int_kms);

                preparedStmt.setString(8, color);

                if (interior.isEmpty() || interior.charAt(0) != '"') {
                    preparedStmt.setString(9, interior);
                } else {
                    String str = interior.substring(1, interior.length() - 1);
                    preparedStmt.setString(9, str);
                }

                if (interiorDescription.isEmpty() || interiorDescription.charAt(0) != '"') {
                    preparedStmt.setString(10, interiorDescription);
                } else {
                    String str = interiorDescription.substring(1, interiorDescription.length() - 1);
                    preparedStmt.setString(10, str);
                }

                if (engine.isEmpty() || engine.charAt(0) != '"') {
                    preparedStmt.setString(11, engine);
                } else {
                    String str = engine.substring(1, engine.length() - 1);
                    preparedStmt.setString(11, str);
                }

                if (engineDescription.isEmpty() || engineDescription.charAt(0) != '"') {
                    preparedStmt.setString(12, engineDescription);
                } else {
                    String str = engineDescription.substring(1, engineDescription.length() - 1);
                    preparedStmt.setString(12, str);
                }

                if (performancePackage.isEmpty() || performancePackage.charAt(0) != '"') {
                    preparedStmt.setString(13, performancePackage);
                } else {
                    String str = performancePackage.substring(1, performancePackage.length() - 1);
                    preparedStmt.setString(13, str);
                }

                if (performancePackageDescription.isEmpty() || performancePackageDescription.charAt(0) != '"') {
                    preparedStmt.setString(14, performancePackageDescription);
                } else {
                    String str = performancePackageDescription.substring(1, performancePackageDescription.length() - 1);
                    preparedStmt.setString(14, str);
                }

                preparedStmt.setString(15, carCondition);

                double double_d1 = Double.parseDouble(d1);
                preparedStmt.setDouble(16, double_d1);

                double double_d2 = Double.parseDouble(d2);
                preparedStmt.setDouble(17, double_d2);

                double double_d3 = Double.parseDouble(d3);
                preparedStmt.setDouble(18, double_d3);

                double double_d4 = Double.parseDouble(d4);
                preparedStmt.setDouble(19, double_d4);

                double double_d5 = Double.parseDouble(d5);
                preparedStmt.setDouble(20, double_d5);

                double double_d6 = Double.parseDouble(d6);
                preparedStmt.setDouble(21, double_d6);

                double double_d7 = Double.parseDouble(d7);
                preparedStmt.setDouble(22, double_d7);

                double double_d8 = Double.parseDouble(d8);
                preparedStmt.setDouble(23, double_d8);

                double double_d9 = Double.parseDouble(d9);
                preparedStmt.setDouble(24, double_d9);

                double double_d10 = Double.parseDouble(d10);
                preparedStmt.setDouble(25, double_d10);

                preparedStmt.setString(26, image);

                preparedStmt.addBatch();
                count++;

                if (count % batchSize == 0) {
                    preparedStmt.executeBatch();
                }
            }
            lineReader.close();
            preparedStmt.executeBatch();
            preparedStmt.close();

        } catch (IOException | SQLException e) {
            System.out.println(e);
        }

    }

}
