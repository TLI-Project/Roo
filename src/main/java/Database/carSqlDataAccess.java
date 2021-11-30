package Database;

import java.sql.*;

import static constants.databaseConstants.*;

public class carSqlDataAccess implements carAccessInterface {

    public String db_url = DB_URL;
    public String db_username = DB_USERNAME;
    public String db_password = DB_PASSWORD;


    public ResultSet getCar(int id) {
        try{
            Connection conn = DriverManager.getConnection(db_url, db_username, db_password);
            Statement stmt = conn.createStatement();
            stmt.execute("USE sensoCarData");

            String getCar = "SELECT * FROM car WHERE id = '" + id + "'";
            return stmt.executeQuery(getCar);
        } catch (SQLException e) {
            System.out.println("Failed to get car");
        }
        return null;
    }

    public ResultSet getAllCars() {
        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            Statement statement = connection.createStatement();
            statement.execute("USE sensoCarData");

            String getALlCars = "SELECT * FROM car";
            return statement.executeQuery(getALlCars);
        }
        catch (SQLException e) {
            System.out.println("Failed to get all cars");
        }
        return null;
    }

}
