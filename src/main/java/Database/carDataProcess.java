package Database;

import entities.Car;
import entities.Feature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Turn the carSet from the database into Car entities
 */
public class carDataProcess implements carDataProcessingInterface {

    /**
     * @return an array of all the Cars in the dataset
     */
    @Override
    public ArrayList<Car> getAllCars() {

        carSqlDataAccess dataConnection = new carSqlDataAccess();
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

        carSqlDataAccess dataConnection = new carSqlDataAccess();
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
        int id = carSet.getInt("car_id");
        String make = carSet.getString("make");
        String model = carSet.getString("model");
        double listPrice = carSet.getDouble("listPrice");
        int year = carSet.getInt("year");
        int kms = carSet.getInt("kms");
        String color = carSet.getString("color");
        String condition = carSet.getString("carCondition");
        String depreciation = carSet.getString("depreciation");
        String image = carSet.getString("image");

        Map<String, Feature> features = featureAddition(carSet);

        return new Car(id, make, model, listPrice, year, kms, color, condition, depreciation, image, features);
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

        Features.put(interiorFeature.name, interiorFeature);
        Features.put(engineFeature.name, engineFeature);

        return Features;
    }
}