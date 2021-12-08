package database;

import entities.Car;
import interfaces.CarDataProcessingInterface;
import usecases.Director;

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
                Director carBuilder = new Director(carSet);
                cars.add(carBuilder.makeCarEntity());
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
            Director carBuilder = new Director(carSet);
            return carBuilder.makeCarEntity();
        } catch (SQLException e) {
            System.out.println("Failed to find car with that ID");
        }
        return null;
    }

//    /**
//     * HELPER FUNCTION:
//     * Turn database entry into car object.
//     * @param carSet is the database entry.
//     * @return Car entity
//     * @throws SQLException
//     */
//    private Car carEntityCreation(ResultSet carSet) throws SQLException {
//        int carId = carSet.getInt("car_id");
//        String make = carSet.getString("make");
//        String model = carSet.getString("model");
//        String carDescription = carSet.getString("carDescription");
//        double listPrice = carSet.getDouble("listPrice");
//        int year = carSet.getInt("year");
//        int kms = carSet.getInt("kms");
//        String color = carSet.getString("color");
//        String interior = carSet.getString("interior");
//        String interiorDescription = carSet.getString("interiorDescription");
//        String engine = carSet.getString("engine");
//        String engineDescription = carSet.getString("engineDescription");
//        String performancePackage = carSet.getString("performancePackage");
//        String performancePackageDescription = carSet.getString("performancePackageDescription");
//        String condition = carSet.getString("carCondition");
//        String image = carSet.getString("image");
//
//        // feature builder
////
////        return new Car(carId, make, model, carDescription, listPrice, year, kms, color, interior, interiorDescription,
////                engine, engineDescription, performancePackage, performancePackageDescription, condition, depreciation,
////                image);
//    }

//    @NotNull
//    private ArrayList<Double> cumulateDepreciation(ResultSet carSet) throws SQLException {
//        ArrayList<Double> depreciation = new ArrayList<>();
//        for(int i = 1; i <= 10; i++ ){
//            depreciation.add(carSet.getDouble("d" + i));
//        }
//        return depreciation;
//    }

//    /**
//     * HELPER FUNCTION TO HELPER:
//     * Turn features into a set of features
//     * @param carSet the database entry
//     * @return a Set of features (engine and interior)
//     * @throws SQLException
//     */
//    private Map<String, Feature> featureAddition(ResultSet carSet) throws SQLException {
//        String interiorName = carSet.getString("interior");
//        String interiorDescription = carSet.getString("interiorDescription");
//        String engineName = carSet.getString("engine");
//        String engineDescription = carSet.getString("engineDescription");
//
//        Feature interiorFeature = new Feature(interiorName, interiorDescription);
//        Feature engineFeature = new Feature(engineName, engineDescription);
//        Map<String, Feature> Features = new HashMap<>();
//
//        Features.put(interiorFeature.getName(), interiorFeature);
//        Features.put(engineFeature.getName(), engineFeature);
//
//        return Features;
//    }
}