package services;

import entities.Car;
import entities.Feature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Builder design pattern director for creating cars from the database.
 */
public class SvcCarDirector {

    private final ResultSet carSet;
    private final SvcCarFeatureBuilder svcCarFeatureBuilder;

    /**
     * Initialize the director for the CarBuilder.
     * @param cs is the result set from the database.
     */
    public SvcCarDirector(ResultSet cs){
        this.carSet = cs;
        this.svcCarFeatureBuilder = new SvcCarFeatureBuilder();
    }

    /**
     * Build a car entity.
     * @return the Car object of the given car.
     */
    public Car makeCarEntity() throws SQLException {
        ArrayList<Double> depreciation = buildCarDepreciation();
        HashMap<String, Feature> featureSet = buildCarFeatures();
        return new Car(carSet, featureSet, depreciation);
    }

    /**
     * @return the newly built depreciation of the car.
     */
    private ArrayList<Double> buildCarDepreciation() throws SQLException {

        svcCarFeatureBuilder.buildDepreciation(carSet);
        return svcCarFeatureBuilder.getDepreciation();
    }

    /**
     * @return the newly built set of features of the car (interior, engine, performancePackage)
     */
    private HashMap<String, Feature> buildCarFeatures() throws SQLException {

        svcCarFeatureBuilder.buildInterior(carSet.getString("interior"),
                carSet.getString("interiorDescription"));

        svcCarFeatureBuilder.buildEngine(carSet.getString("engine"),
                carSet.getString("engineDescription"));

        svcCarFeatureBuilder.buildPerformancePackage(carSet.getString("performancePackage"),
                carSet.getString("performancePackageDescription"));

        return svcCarFeatureBuilder.getFeatureSet();
    }
}
