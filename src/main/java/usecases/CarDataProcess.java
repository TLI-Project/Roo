package usecases;

import gateways.CarSqlDataAccess;
import entities.Car;
import interfaces.CarDataProcessingInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Turn the carSet from the database into Car entities
 */
public class CarDataProcess implements CarDataProcessingInterface {

    /**
     * @return an array of all the Cars in the dataset
     */
    @Override
    public ArrayList<Car> getAllCars() {

        CarSqlDataAccess dataConnection = new CarSqlDataAccess();
        ResultSet carSet = dataConnection.getAllCars();

        ArrayList<Car> cars = new ArrayList<>();

        try{
            while (carSet.next()) {
                CarDirector carBuilder = new CarDirector(carSet);
                cars.add(carBuilder.makeCarEntity());
            }
        } catch (SQLException e) {
            System.out.println("Failed turning cars into objects");
        }
        return cars;
    }

    /**
     * Search the dataset for a given car
     * @param id the unique ID of the car you are trying to find.
     * @return a Car object representation of the car with that ID.
     */
    @Override
    public Car getCarById(int id) {

        CarSqlDataAccess dataConnection = new CarSqlDataAccess();
        ResultSet carSet = dataConnection.getCar(id);

        try{
            carSet.next();
            CarDirector carBuilder = new CarDirector(carSet);
            return carBuilder.makeCarEntity();
        } catch (SQLException e) {
            System.out.println("Failed to find car with that ID");
        }
        return null;
    }
}