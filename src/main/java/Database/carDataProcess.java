package Database;

import entities.Car;
import entities.Feature;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class carDataProcess implements carDataProcessingInterface {

    private Car carEntityCreation(ResultSet carSet) throws SQLException {
        int id = carSet.getInt("id");
        String make = carSet.getString("make");
        String model = carSet.getString("model");
        double listPrice = carSet.getDouble("listPrice");
        int year = carSet.getInt("year");
        int kms = carSet.getInt("kms");
        String color = carSet.getString("color");
        String condition = carSet.getString("condition");
        Array depreciation = carSet.getArray("depreciation");
        String image = carSet.getString("image");

        Map<String, Feature> features = featureAddition(carSet);

        return new Car(id, make, model, listPrice, year, kms, color, condition, depreciation, image, features);
    }

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
}