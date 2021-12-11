package usecases;


import entities.Car;
import entities.Feature;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Builder design pattern for creating cars from the database.
 */
public class CarDirector {

    private final ResultSet carSet;
    private final CarFeatureBuilder b;

    /**
     * Initialize the director for the CarBuilder.
     * @param cs is the result set from the database.
     */
    public CarDirector(ResultSet cs){
        this.carSet = cs;
        this.b = new CarFeatureBuilder();
    }

    /**
     * Build a car entity.
     * @return the Car object of the given car.
     * @throws SQLException e
     */
    public Car makeCarEntity() throws SQLException {
        ArrayList<Double> depreciation = makeCarDepreciation();
        HashMap<String, Feature> featureSet = makeCarFeatures();
        return new Car(carSet, featureSet, depreciation);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    private ArrayList<Double> makeCarDepreciation() throws SQLException {

        b.buildDepreciation(carSet);
        return b.getDepreciation();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    private HashMap<String, Feature> makeCarFeatures() throws SQLException {

        b.buildInterior(carSet.getString("interior"),
                carSet.getString("interiorDescription"));

        b.buildEngine(carSet.getString("engine"),
                carSet.getString("engineDescription"));

        b.buildPerformancePackage(carSet.getString("performancePackage"),
                carSet.getString("performancePackageDescription"));

        return b.getFeatureSet();
    }
}
