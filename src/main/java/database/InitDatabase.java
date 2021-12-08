package Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InitDatabase {

    //  creates database 'auto_education', creates table 'car', populates table with data
    public static void main(Connection conn) throws SQLException, IOException {
        makeDatabase(conn);
        carTable(conn);
        writeToCarTable(conn, "data/sensoCarSet.csv");
    }

    //  creates database 'auto_education' (unless it has already been created)
    private static void makeDatabase(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String create_db = "CREATE DATABASE IF NOT EXISTS auto_education";
        stmt.execute(create_db);
        stmt.execute("USE auto_education");
        stmt.close();
    }

    //  creates table 'car' in database 'auto_education'
    private static void carTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String car_table = "CREATE TABLE IF NOT EXISTS car " +
                "(car_id int(10) NOT NULL AUTO_INCREMENT, " +
                "make text NOT NULL, " +
                "model text NOT NULL, " +
                "carDescription text NOT NULL, " +
                "listPrice float NOT NULL," +
                "year int(10) NOT NULL, " +
                "kms int(10) NOT NULL, " +
                "color text NOT NULL," +
                "interior text NOT NULL," +
                "interiorDescription text NOT NULL," +
                "engine text NOT NULL," +
                "engineDescription text NOT NULL," +
                "performancePackage text NOT NULL," +
                "performancePackageDescription text NOT NULL," +
                "carCondition text NOT NULL," +
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
                "image text NOT NULL," +
                "PRIMARY KEY (car_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(car_table);
        stmt.close();
    }

    //  persists data from sensoCarSet.csv into db
    private static void writeToCarTable(Connection conn, String filePath) throws SQLException, IOException {
        String insert = "INSERT INTO car " +
                "(car_id, make, model, carDescription, listPrice, year, kms, color, interior, interiorDescription, " +
                "engine, engineDescription, performancePackage, performancePackageDescription, carCondition, " +
                "d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        //  reads .csv
        PreparedStatement preparedStmt = conn.prepareStatement(insert);
        BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

        int count = 0;
        int batchSize = 20;
        String lineText;
        lineReader.readLine();

        try {
            //  loops through every line of the dataset
            while ((lineText = lineReader.readLine()) != null) {
                List<String> data = new ArrayList<>();
                checkWrappedText(lineText, data);   // checks if an entry has commas encased within quotations
                Map<String, String> cols = getData(data);   //  gets data from csv
                parseData(preparedStmt, cols);  // ensures proper format for each entry
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

    //  checks if an entry has commas within an entry itself
    private static void checkWrappedText(String lineText, List<String> data) {
        int first_pos = 0;
        boolean wrapped = false;

        for (int last_pos = 0; last_pos < lineText.length(); last_pos++) {
            if (lineText.charAt(last_pos) == '\"') {
                wrapped = !wrapped;
            } else if (lineText.charAt(last_pos) == ',' && !wrapped) {
                data.add(lineText.substring(first_pos, last_pos));
                first_pos = last_pos + 1;
            }
        }
        data.add(lineText.substring(first_pos));
    }

    //  puts data into a hashmap (key is the column name, value is the data itself)
    private static Map<String, String> getData(List<String> data) {
        Map<String, String> cols = new HashMap<>();
        cols.put("car_id", data.get(0));
        cols.put("make", data.get(1));
        cols.put("model", data.get(2));
        cols.put("carDescription", data.get(3));
        cols.put("listPrice", data.get(4));
        cols.put("year", data.get(5));
        cols.put("kms", data.get(6));
        cols.put("color", data.get(7));
        cols.put("interior", data.get(8));
        cols.put("interiorDescription", data.get(9));
        cols.put("engine", data.get(10));
        cols.put("engineDescription", data.get(11));
        cols.put("performancePackage", data.get(12));
        cols.put("performancePackageDescription", data.get(13));
        cols.put("carCondition", data.get(14));
        cols.put("d1", data.get(15));
        cols.put("d2", data.get(16));
        cols.put("d3", data.get(17));
        cols.put("d4", data.get(18));
        cols.put("d5", data.get(19));
        cols.put("d6", data.get(20));
        cols.put("d7", data.get(21));
        cols.put("d8", data.get(22));
        cols.put("d9", data.get(23));
        cols.put("d10", data.get(24));
        cols.put("image", data.get(25));
        return cols;
    }

    //  removes quotation marks (applies to entries that have commas within themselves)
    private static void removeQuotes(PreparedStatement preparedStmt, String col, int index) throws SQLException {
        if (col.isEmpty() || col.charAt(0) != '"') {
            preparedStmt.setString(index, col);
        } else {
            String str = col.substring(1, col.length() - 1);
            preparedStmt.setString(index, str);
        }
    }

    //  makes sure data is of the proper type and contains no quotes
    private static void parseData(PreparedStatement preparedStmt, Map<String, String> cols) throws SQLException {
        preparedStmt.setInt(1, Integer.parseInt(cols.get("car_id")));
        preparedStmt.setString(2, cols.get("make"));
        preparedStmt.setString(3, cols.get("model"));
        removeQuotes(preparedStmt, cols.get("carDescription"), 4);
        preparedStmt.setFloat(5, Float.parseFloat(cols.get("listPrice")));
        preparedStmt.setInt(6, Integer.parseInt(cols.get("year")));
        preparedStmt.setInt(7, Integer.parseInt(cols.get("kms")));
        preparedStmt.setString(8, cols.get("color"));
        removeQuotes(preparedStmt, cols.get("interior"), 9);
        removeQuotes(preparedStmt, cols.get("interiorDescription"), 10);
        removeQuotes(preparedStmt, cols.get("engine"), 11);
        removeQuotes(preparedStmt, cols.get("engineDescription"), 12);
        removeQuotes(preparedStmt, cols.get("performancePackage"), 13);
        removeQuotes(preparedStmt, cols.get("performancePackageDescription"), 14);
        preparedStmt.setString(15, cols.get("carCondition"));
        preparedStmt.setFloat(16, Float.parseFloat(cols.get("d1")));
        preparedStmt.setFloat(17, Float.parseFloat(cols.get("d2")));
        preparedStmt.setFloat(18, Float.parseFloat(cols.get("d3")));
        preparedStmt.setFloat(19, Float.parseFloat(cols.get("d4")));
        preparedStmt.setFloat(20, Float.parseFloat(cols.get("d5")));
        preparedStmt.setFloat(21, Float.parseFloat(cols.get("d6")));
        preparedStmt.setFloat(22, Float.parseFloat(cols.get("d7")));
        preparedStmt.setFloat(23, Float.parseFloat(cols.get("d8")));
        preparedStmt.setFloat(24, Float.parseFloat(cols.get("d9")));
        preparedStmt.setFloat(25, Float.parseFloat(cols.get("d10")));
        preparedStmt.setString(26, cols.get("image"));
    }
}
