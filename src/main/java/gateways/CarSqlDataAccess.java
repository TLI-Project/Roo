package gateways;

import interfaces.CarAccessInterface;

import java.sql.*;

import static constants.DatabaseConstants.*;

/**
 * The gateway between the database and the backend.
 */
public class CarSqlDataAccess implements CarAccessInterface {

    /**
     * Talk with the database to find the correct car.
     * @param id the ID of the car we are looking for.
     * @return the car entry from the database.
     */
    public ResultSet getCar(int id) {
        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("USE auto_education");

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
     * Talk with the database to get all the cars in the database.
     * @return a representation of all teh cars in teh database.
     */
    public ResultSet getAllCars() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute("USE auto_education");

            String getAllCars = "SELECT * FROM car";

            return statement.executeQuery(getAllCars);
        }
        catch (SQLException e) {
            System.out.println("Failed to get all cars");
        }
        return null;
    }

}
