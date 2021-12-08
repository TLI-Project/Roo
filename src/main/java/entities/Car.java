package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A car the user can buy.
 */
public class Car extends Entity{
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


    public Car(ResultSet carSet, HashMap<String, Feature> featureSet, ArrayList<Double> depreciation) throws SQLException {
        this.carId = carSet.getInt("car_id");
        this.carModel = carSet.getString("model");
        this.carMake = carSet.getString("make");
        this.carDescription = carSet.getString("carDescription");
        this.listPrice = carSet.getDouble("listPrice");
        this.year = carSet.getInt("year");
        this.kms = carSet.getInt("kms");
        this.color = carSet.getString("color");
        this.condition = carSet.getString("carCondition");
        this.depreciation = depreciation;
        this.imageURL = carSet.getString("image");
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

    public HashMap<String, Feature> getFeatures() {
        return (HashMap<String, Feature>) this.features;
    }

    public String getCarDescription() {
        return this.carDescription;
    }

    public String getColor() {
        return color;
    }

    public String getCondition() {
        return condition;
    }

    public ArrayList<Double> getDepreciation() {
        return depreciation;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getCarId() {
        return carId;
    }

    /**
     * Overview of the car object
     * @return String wiht car model and car make.
     */
    @Override
    public String getEntityStr() {
        return "Car Model: " + this.carModel + ", Car Make: " + this.carMake;
    }


}
