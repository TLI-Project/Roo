package database;

import interfaces.carAccessInterface;

import java.sql.*;

import static constants.databaseConstants.*;

public class carSqlDataAccess implements carAccessInterface {

    public String db_url = DB_URL;
    public String db_username = DB_USERNAME;
    public String db_password = DB_PASSWORD;


    /**
     * Talk with the database to find the correct car.
     * @param id the ID of the car we are looking for.
     * @return the car entry from the database.
     */
    public ResultSet getCar(int id) {
        try{
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            Statement statement = connection.createStatement();
            statement.execute("USE sensoCarData");

            String getCar = "SELECT * FROM car WHERE car_id = " + id;
            ResultSet test = statement.executeQuery(getCar);
            if(test.next()){
                System.out.println(test.getString("make"));
            }
            return statement.executeQuery(getCar);
        } catch (SQLException e) {
            System.out.println("Failed to get car");
        }
        return null;
    }

    /**
     *
     * @return
     */
    public ResultSet getAllCars() {
        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            Statement statement = connection.createStatement();
            statement.execute("USE sensoCarData");

            String getAllCars = "SELECT * FROM car";

            return statement.executeQuery(getAllCars);
        }
        catch (SQLException e) {
            System.out.println("Failed to get all cars");
        }
        return null;
    }

}
