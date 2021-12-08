package usecases;

import entities.Car;
import entities.Feature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CarFeatureBuilder implements CarBuilder {

    private final ArrayList<Double> depreciation;
    private final HashMap<String, Feature> featureSet;

    public CarFeatureBuilder() {
        this.depreciation = new ArrayList<Double>();
        this.featureSet = new HashMap<String, Feature>();
    }


    @Override
    public void buildDepreciation(ResultSet cs) throws SQLException {
        for(int i = 1; i <= 10; i++ ){
            depreciation.add(cs.getDouble("d" + i));
        }
    }

    @Override
    public void buildInterior(String interiorName, String interiorDescription) {
        Feature interiorFeature = new Feature(interiorName, interiorDescription);
        featureSet.put(interiorFeature.getName(), interiorFeature);
    }

    @Override
    public void buildEngine(String engineName, String engineDescription) {
        Feature engineFeature = new Feature(engineName, engineDescription);
        featureSet.put(engineFeature.getName(), engineFeature);
    }

    @Override
    public void buildPerformancePackage(String performancePackageName, String perforancePackageDescription) {
        Feature performancePackageFeature =  new Feature(performancePackageName, perforancePackageDescription);
        featureSet.put(performancePackageFeature.getName(), performancePackageFeature);
    }

    @Override
    public Car buildCar(ResultSet cs) throws SQLException {
        return new Car(cs, featureSet, depreciation);
    }
}
