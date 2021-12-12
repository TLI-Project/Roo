package usecases;

import entities.Feature;
import interfaces.CarBuilderInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The builder in charge of making all the features in the car.
 */
public class CarFeatureBuilder implements CarBuilderInterface {

    private final ArrayList<Double> depreciation;
    private final HashMap<String, Feature> featureSet;

    /**
     * Initialize a place for the cars depreciation and features
     */
    public CarFeatureBuilder() {
        this.depreciation = new ArrayList<>();
        this.featureSet = new HashMap<>();
    }

    /**
     * Builds the car's depreciation and adds it to the depreciation array list.
     * @param cs is the ResultSet entry from the database for the given car.
     */
    @Override
    public void buildDepreciation(ResultSet cs) throws SQLException {
        for(int i = 1; i <= 10; i++ ){
            depreciation.add(cs.getDouble("d" + i));
        }
    }

    /**
     * Builds the car's interior feature.
     * @param interiorName is the name of the interior.
     * @param interiorDescription is the description of the interior.
     */
    @Override
    public void buildInterior(String interiorName, String interiorDescription) {
        Feature interiorFeature = new Feature(interiorName, interiorDescription);
        featureSet.put("interior", interiorFeature);
    }

    /**
     * Builds the car's engine feature.
     * @param engineName is the name of the engine.
     * @param engineDescription is the description of the engine (0-100km/h, horsepower, etc.)
     */
    @Override
    public void buildEngine(String engineName, String engineDescription) {
        Feature engineFeature = new Feature(engineName, engineDescription);
        featureSet.put("engine", engineFeature);
    }

    /**
     * Builds the car's performance package feature.
     * @param performancePackageName is the name of the performance package.
     * @param perforancePackageDescription is the description of what comes included in the performance package.
     */
    @Override
    public void buildPerformancePackage(String performancePackageName, String perforancePackageDescription) {
        Feature performancePackageFeature =  new Feature(performancePackageName, perforancePackageDescription);
        featureSet.put("performancePackage", performancePackageFeature);
    }

    /**
     * @return all of the car's features.
     */
    public HashMap<String, Feature> getFeatureSet() {
        return featureSet;
    }

    /**
     * @return the car's depreciation (list of 10 items representation percentage value per year).
     */
    public ArrayList<Double> getDepreciation(){
        return depreciation;
    }
}
