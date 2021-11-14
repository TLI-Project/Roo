package entities;

import java.util.Map;

public class Car extends Entity{
    private final String carModel;
    private final String carMake;
    private final double listPrice;
    private final int year;
    private final double kms;
    private final Map<String, Feature> features;

    public Car(String carModel, String carMake, double listPrice, int year, double kms, Map<String, Feature> features) {
        this.carModel = carModel;
        this.carMake = carMake;
        this.listPrice = listPrice;
        this.year = year;
        this.kms = kms;
        this.features = features;
    }

    public Map<String, Feature> getFeatures(){
        return this.features;
    }

    public void addFeatures(Feature newFeature){
        features.put(newFeature.getName(), newFeature);
    }

    public String getCarModel(){
        return this.carModel;
    }

    public String getCarMake(){
        return this.carMake;
    }

    public double getListPrice(){
        return this.listPrice;
    }

    public int getYear(){
        return this.year;
    }

    public double getKms(){
        return this.kms;
    }

    @Override
    public String getEntityStr() {
        return "Car Model: " + this.carModel + ", Car Make: " + this.carMake;
    }
}
