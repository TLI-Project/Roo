package entities;

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


    public Car(int id, String carMake, String carModel, String carDescription, double listPrice, int year,
               double kms, String color, String interior, String interiorDescription, String engine,
               String engineDescription, String performancePackage, String performancePackageDescription,
               String condition, ArrayList<Double> depreciation, String imageURL) {

        this.carId = id;
        this.carModel = carModel;
        this.carMake = carMake;
        this.carDescription = carDescription;
        this.listPrice = listPrice;
        this.year = year;
        this.kms = kms;
        this.color = color;
        this.condition = condition;
        this.depreciation = depreciation;
        this.imageURL = imageURL;
        this.features = new HashMap<String, Feature>();


        Feature interiorFeature = new Feature(interior, interiorDescription);
        Feature engineFeature = new Feature(engine, engineDescription);
        Feature performancePackageFeature = new Feature(performancePackage, performancePackageDescription);

        addFeatures(interiorFeature, engineFeature, performancePackageFeature);
    }

    public void addFeatures(Feature interiorFeature, Feature engineFeature, Feature performancePackageFeature){

        this.features.put("interior", interiorFeature);

        this.features.put("engine", engineFeature);

        this.features.put("performancePackage", performancePackageFeature);
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
