package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A car the user can buy from the Mercedes Dealer's lot .
 */
public class Car {
    private final int carId;
    private final String carMake;
    private final String carModel;
    private final String carDescription;
    private final double listPrice;
    private final int year;
    private final double kms;
    private final String color;
    private final String condition;
    private final ArrayList<Double> depreciation;
    private final String imageURL;
    private final Map<String, Feature> features;


    /**
     * Initialize a new car from the database. There is a builder for this.
     * @param carSet is the database entry.
     * @param featureSet is a map of all the cars features.
     * @param depreciation is a list of the cars depreciation.
     * @throws SQLException exception.
     */
    public Car(ResultSet carSet, HashMap<String, Feature> featureSet,
               ArrayList<Double> depreciation) throws SQLException {
        // the 'easy' attributes
        this.carId = carSet.getInt("car_id");
        this.carModel = carSet.getString("model");
        this.carMake = carSet.getString("make");
        this.carDescription = carSet.getString("carDescription");
        this.listPrice = carSet.getDouble("listPrice");
        this.year = carSet.getInt("year");
        this.kms = carSet.getInt("kms");
        this.color = carSet.getString("color");
        this.condition = carSet.getString("carCondition");
        this.imageURL = carSet.getString("image");
        // the 'gotta make them' attributes
        this.depreciation = depreciation;
        this.features = featureSet;
    }

    /**
     * Get the car's model
     * @return a string representation of the car model.
     */
    public String getCarModel(){
        return this.carModel;
    }

    /**
     * Get the car's make.
     * @return a string representation of the car make.
     */
    public String getCarMake(){
        return this.carMake;
    }

    /**
     * Get the car's list price.
     * @return a double representing how much the car costs.
     */
    public double getListPrice(){
        return this.listPrice;
    }

    /**
     * Get the year the car was made
     * @return an integer of the year.
     */
    public int getYear(){
        return this.year;
    }

    /**
     * Get the kms on the car
     * @return double representation of kms on the car.
     */
    public double getKms(){
        return this.kms;
    }

    /**
     * @return the set of features (interior, engine, performancePackage).
     */
    public HashMap<String, Feature> getFeatures() {
        return (HashMap<String, Feature>) this.features;
    }

    /**
     * @return the string description of the car.
     */
    public String getCarDescription() {
        return this.carDescription;
    }

    /**
     * @return the color (and brief description) of the car.
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the condition (new versus used) of the car.
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @return a list of 10 items representation the percentage depreciation at each year.
     */
    public ArrayList<Double> getDepreciation() {
        return depreciation;
    }

    /**
     * @return the URL for the picture of the car.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @return the unique ID of the car.
     */
    public int getCarId() {
        return carId;
    }
}
