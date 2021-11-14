package entities;

import java.util.Map;

/**
 * A car the user can buy.
 */
public class Car extends Entity{
    private final String carModel;
    private final String carMake;
    private final double listPrice;
    private final int year;
    private final double kms;
    private final Map<String, Feature> features;

    /**
     * Construct a new car that the user can buy.
     * @param carModel the model of the car.
     * @param carMake the make of the car.
     * @param listPrice the list price of the car.
     * @param year the year the car was made.
     * @param kms the kilometers on the car.
     * @param features a list of features the car might have.
     */
    public Car(String carModel, String carMake, double listPrice, int year, double kms, Map<String, Feature> features) {
        this.carModel = carModel;
        this.carMake = carMake;
        this.listPrice = listPrice;
        this.year = year;
        this.kms = kms;
        this.features = features;
    }

    /**
     * Get the different features the car has.
     * @return a Map<Feature name, Feature obj> of all features.
     */
    public Map<String, Feature> getFeatures(){
        return this.features;
    }

    /**
     * Add a feature to the car.
     * @param newFeature the new feature you want to add.
     */
    public void addFeatures(Feature newFeature){
        features.put(newFeature.getName(), newFeature);
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
     * Overview of the car object
     * @return String wiht car model and car make.
     */
    @Override
    public String getEntityStr() {
        return "Car Model: " + this.carModel + ", Car Make: " + this.carMake;
    }
}
