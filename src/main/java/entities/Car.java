package entities;

import java.sql.Array;
import java.util.Map;

/**
 * A car the user can buy.
 */
public class Car extends Entity{
    public final int id;
    public final String carMake;
    public final String carModel;
    public final double listPrice;
    public final int year;
    public final double kms;
    public final String color;
    public final String condition;
    public final String depreciation;
    public final String imageURL;
    public final Map<String, Feature> features;

    /**
     * Construct a new car that the user can buy.
     * @param carModel the model of the car.
     * @param carMake the make of the car.
     * @param listPrice the list price of the car.
     * @param year the year the car was made.
     * @param kms the kilometers on the car.
     * @param features a list of features the car might have.
     */
    public Car(int id, String carMake, String carModel, double listPrice, int year, double kms, String color, String condition, String depreciation, String imageURL, Map<String, Feature> features) {
        this.id = id;
        this.carModel = carModel;
        this.carMake = carMake;
        this.listPrice = listPrice;
        this.year = year;
        this.kms = kms;
        this.color = color;
        this.condition = condition;
        this.depreciation = depreciation;
        this.imageURL = imageURL;
        this.features = features;
    }

//    /**
//     * Get the different features the car has.
//     * @return a Map<Feature name, Feature obj> of all features.
//     */
//    public Map<String, Feature> getFeatures(){
//        return this.features;
//    }

    /**
     * Add a feature to the car.
     * @param newFeature the new feature you want to add.
     */
    public void addFeatures(Feature newFeature){
        features.put(newFeature.name, newFeature);
    }

//    /**
//     * Get the car's model
//     * @return a string representation of the car model.
//     */
//    public String getCarModel(){
//        return this.carModel;
//    }
//
//    /**
//     * Get the car's make.
//     * @return a string representation of the car make.
//     */
//    public String getCarMake(){
//        return this.carMake;
//    }
//
//    /**
//     * Get the car's list price.
//     * @return a double representing how much the car costs.
//     */
//    public double getListPrice(){
//        return this.listPrice;
//    }
//
//    /**
//     * Get the year the car was made
//     * @return an integer of the year.
//     */
//    public int getYear(){
//        return this.year;
//    }
//
//    /**
//     * Get the kms on the car
//     * @return double representation of kms on the car.
//     */
//    public double getKms(){
//        return this.kms;
//    }

    /**
     * Overview of the car object
     * @return String wiht car model and car make.
     */
    @Override
    public String getEntityStr() {
        return "Car Model: " + this.carModel + ", Car Make: " + this.carMake;
    }

//    public String getColor() {
//        return color;
//    }
//
//    public String getCondition() {
//        return condition;
//    }
//
//    public String getDepreciation() {
//        return depreciation;
//    }
//
//    public String getImageURL() {
//        return imageURL;
//    }
//
//    public int getId() {
//        return id;
//    }
}
