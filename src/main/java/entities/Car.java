package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A car the user can buy.
 */
public class Car extends Entity{
    public final int id;
    public final String carMake;
    public final String carModel;
    public final String carDescription;
    public final double listPrice;
    public final int year;
    public final double kms;
    public final String color;
    public final String condition;
    public final ArrayList<Double> depreciation;
    public final String imageURL;
    public final Map<String, Feature> features;


    public Car(int id, String carMake, String carModel, String carDescription, double listPrice, int year,
               double kms, String color, String interior, String interiorDescription, String engine,
               String engineDescription, String performancePackage, String performancePackageDescription,
               String condition, double d1, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10,
               String imageURL) {
        this.id = id;
        this.carModel = carModel;
        this.carMake = carMake;
        this.carDescription = carDescription;
        this.listPrice = listPrice;
        this.year = year;
        this.kms = kms;
        this.color = color;
        this.condition = condition;
        this.depreciation = new ArrayList<Double>();
        this.imageURL = imageURL;
        this.features = new HashMap<String, Feature>();

        makeDepreciation(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10);

        addFeatures(interior, interiorDescription, engine, engineDescription, performancePackage,
                performancePackageDescription);
    }

    private void makeDepreciation(double d1, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10){
        this.depreciation.add(d1);
        this.depreciation.add(d2);
        this.depreciation.add(d3);
        this.depreciation.add(d4);
        this.depreciation.add(d5);
        this.depreciation.add(d6);
        this.depreciation.add(d7);
        this.depreciation.add(d8);
        this.depreciation.add(d9);
        this.depreciation.add(d10);
    }



    public void addFeatures(String interior, String interiorDescription, String engine, String engineDescription,
                            String performancePackage, String performancePackageDescription){

        Feature interiorFeature = new Feature(interior, interiorDescription);
        this.features.put("interior", interiorFeature);

        Feature engineFeature = new Feature(engine, engineDescription);
        this.features.put("engine", engineFeature);

        Feature performancePackageFeature = new Feature(performancePackage, performancePackageDescription);
        this.features.put("performancePackage", performancePackageFeature);
    }

//    /**
//     * Get the different features the car has.
//     * @return a Map<Feature name, Feature obj> of all features.
//     */
//    public Map<String, Feature> getFeatures(){
//        return this.features;
//    }

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
