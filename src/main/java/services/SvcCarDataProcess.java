package services;

import entities.Car;
import interfaces.CarAccessInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Turn the carSet from the database into Car entities
 */
public class SvcCarDataProcess {

    /**
     * @return an array of all the Cars in the dataset
     */
    public ArrayList<Car> getAllCars(CarAccessInterface carAccess) {

        ResultSet carSet = carAccess.getAllCars();
        ArrayList<Car> cars = new ArrayList<>();

        try{
            while (carSet.next()) {
                SvcCarDirector carBuilder = new SvcCarDirector(carSet);
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
    public Car getCarById(int id, CarAccessInterface carAccess) {

        ResultSet carSet = carAccess.getCar(id);

        try{
            carSet.next();
            SvcCarDirector carBuilder = new SvcCarDirector(carSet);
            return carBuilder.makeCarEntity();
        } catch (SQLException e) {
            System.out.println("Failed to find car with that ID");
        }
        return null;
    }
}