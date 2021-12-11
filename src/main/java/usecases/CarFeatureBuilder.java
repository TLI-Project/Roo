package usecases;

import entities.Feature;
import interfaces.CarBuilderInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CarFeatureBuilder implements CarBuilderInterface {

    private final ArrayList<Double> depreciation;
    private final HashMap<String, Feature> featureSet;

    public CarFeatureBuilder() {
        this.depreciation = new ArrayList<>();
        this.featureSet = new HashMap<>();
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
        featureSet.put("interior", interiorFeature);
    }

    @Override
    public void buildEngine(String engineName, String engineDescription) {
        Feature engineFeature = new Feature(engineName, engineDescription);
        featureSet.put("engine", engineFeature);
    }

    @Override
    public void buildPerformancePackage(String performancePackageName, String perforancePackageDescription) {
        Feature performancePackageFeature =  new Feature(performancePackageName, perforancePackageDescription);
        featureSet.put("performancePackage", performancePackageFeature);
    }


    public HashMap<String, Feature> getFeatureSet() {
        return featureSet;
    }

    public ArrayList<Double> getDepreciation(){
        return depreciation;
    }
}
