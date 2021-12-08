package database;

import entities.Car;
import entities.Feature;
import interfaces.CarDataProcessingInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                cars.add(carEntityCreation(carSet));
            }
        } catch (SQLException e) {
            System.out.println("Failed turning cars into objects");
        }
        return cars;
    }

    /**
     * Search the dataset for a given car
//     * @param id the unique ID of the car you are trying to find.
     * @return a Car object representation of the car with that ID.
     */
    @Override
    public Car getCarById(int id) {

        CarSqlDataAccess dataConnection = new CarSqlDataAccess();
        ResultSet carSet = dataConnection.getCar(id);

        try{
            carSet.next();
            return carEntityCreation(carSet);
        } catch (SQLException e) {
            System.out.println("Failed to find car with that ID");
        }
        return null;
    }

    /**
     * HELPER FUNCTION:
     * Turn database entry into car object.
     * @param carSet is the database entry.
     * @return Car entity
     * @throws SQLException
     */
    private Car carEntityCreation(ResultSet carSet) throws SQLException {
        int carId = carSet.getInt("car_id");
        String make = carSet.getString("make");
        String model = carSet.getString("model");
        String carDescription = carSet.getString("carDescription");
        double listPrice = carSet.getDouble("listPrice");
        int year = carSet.getInt("year");
        int kms = carSet.getInt("kms");
        String color = carSet.getString("color");
        String interior = carSet.getString("interior");
        String interiorDescription = carSet.getString("interiorDescription");
        String engine = carSet.getString("engine");
        String engineDescription = carSet.getString("engineDescription");
        String performancePackage = carSet.getString("performancePackage");
        String performancePackageDescription = carSet.getString("performancePackageDescription");
        String condition = carSet.getString("carCondition");
        double d1 = carSet.getDouble("d1");
        double d2 = carSet.getDouble("d2");
        double d3 = carSet.getDouble("d3");
        double d4 = carSet.getDouble("d4");
        double d5 = carSet.getDouble("d5");
        double d6 = carSet.getDouble("d6");
        double d7 = carSet.getDouble("d7");
        double d8 = carSet.getDouble("d8");
        double d9 = carSet.getDouble("d9");
        double d10 = carSet.getDouble("d10");
        String image = carSet.getString("image");

        return new Car(carId, make, model, carDescription, listPrice, year, kms, color, interior, interiorDescription,
                engine, engineDescription, performancePackage, performancePackageDescription, condition, d1, d2, d3,
                d4, d5, d6, d7, d8, d9, d10, image);
    }

    /**
     * HELPER FUNCTION TO HELPER:
     * Turn features into a set of features
     * @param carSet the database entry
     * @return a Set of features (engine and interior)
     * @throws SQLException
     */
    private Map<String, Feature> featureAddition(ResultSet carSet) throws SQLException {
        String interiorName = carSet.getString("interior");
        String interiorDescription = carSet.getString("interiorDescription");
        String engineName = carSet.getString("engine");
        String engineDescription = carSet.getString("engineDescription");

        Feature interiorFeature = new Feature(interiorName, interiorDescription);
        Feature engineFeature = new Feature(engineName, engineDescription);
        Map<String, Feature> Features = new HashMap<>();

        Features.put(interiorFeature.getName(), interiorFeature);
        Features.put(engineFeature.getName(), engineFeature);

        return Features;
    }
}