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

/**
 * Takes care of initializing the database with the necessary dataset.
 */
public class initDatabase {

    /**
     * Call all the commands to create the database and dataset.
     * @param conn is the connection to the RDS server.
     */
    public static void main(Connection conn) {
        try {
            makeDatabase(conn);
            carTable(conn);
            writeToCarTable(conn, "data/sensoCarSet.csv");
        } catch (SQLException | IOException e) {
            throw new IllegalStateException("Can't create :(", e);
        }
    }

    /**
     * Makes the and sets the sensoCarData database
     * @param conn connection to the RDS server
     * @throws SQLException
     */
    private static void makeDatabase(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String create_db = "CREATE DATABASE IF NOT EXISTS sensoCarData";
        stmt.execute(create_db);
        stmt.execute("USE sensoCarData");
        stmt.close();
    }

    /**
     * Makes the carTable with its required columns.
     * @param conn connection to the RDS server
     * @throws SQLException
     */
    private static void carTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String car_table = "CREATE TABLE IF NOT EXISTS car " +
                "(car_id int(10) NOT NULL AUTO_INCREMENT, " +
                "make varchar(50) NOT NULL, " +
                "model varchar(50) NOT NULL, " +
                "listPrice float NOT NULL," +
                "year int(10) NOT NULL, " +
                "kms int(10) NOT NULL, " +
                "color varchar(50) NOT NULL," +
                "interior varchar(100) NOT NULL," +
                "interiorDescription varchar(200) NOT NULL," +
                "engine varchar(100) NOT NULL," +
                "engineDescription varchar(200) NOT NULL," +
                "carCondition varchar(50) NOT NULL," +
                "depreciation varchar(200) NOT NULL," +
                "image varchar(200) NOT NULL," +
                "PRIMARY KEY (car_id)) " +
                "DEFAULT CHARSET=utf8";
        stmt.execute(car_table);
        stmt.close();
    }


    private static void writeToCarTable(Connection conn, String filePath) throws SQLException, IOException {
        String insert = "INSERT INTO car " +
                "(car_id, make, model, listPrice, year, kms, color, interior, interiorDescription, " +
                "engine, engineDescription, carCondition, depreciation, image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
                String listPrice = data.get(3);
                String year = data.get(4);
                String kms = data.get(5);
                String color = data.get(6);
                String interior = data.get(7);
                String interiorDescription = data.get(8);
                String engine = data.get(9);
                String engineDescription = data.get(10);
                String carCondition = data.get(11);
                String depreciation = data.get(12);
                String image = data.get(13);

                int int_car_id = Integer.parseInt(car_id);
                preparedStmt.setInt(1, int_car_id);

                preparedStmt.setString(2, make);

                preparedStmt.setString(3, model);

                int int_listPrice = Integer.parseInt(listPrice);
                preparedStmt.setInt(4, int_listPrice);

                int int_year = Integer.parseInt(year);
                preparedStmt.setInt(5, int_year);

                int int_kms = Integer.parseInt(kms);
                preparedStmt.setInt(6, int_kms);

                preparedStmt.setString(7, color);

                preparedStmt.setString(8, interior);

                if (interiorDescription.isEmpty() || interiorDescription.charAt(0) != '"') {
                    preparedStmt.setString(9, interiorDescription);
                } else {
                    String str = interiorDescription.substring(1, interiorDescription.length() - 1);
                    preparedStmt.setString(9, str);
                }

                preparedStmt.setString(10, engine);

                if (engineDescription.isEmpty() || engineDescription.charAt(0) != '"') {
                    preparedStmt.setString(11, engineDescription);
                } else {
                    String str = engineDescription.substring(1, engineDescription.length() - 1);
                    preparedStmt.setString(11, str);
                }

                preparedStmt.setString(12, carCondition);

                if (depreciation.isEmpty() || depreciation.charAt(0) != '"') {
                    preparedStmt.setString(13, depreciation);
                } else {
                    String str = depreciation.substring(1, depreciation.length() - 1);
                    preparedStmt.setString(13, str);
                }

                preparedStmt.setString(14, image);

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
