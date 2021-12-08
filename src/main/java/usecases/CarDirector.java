package usecases;


import entities.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

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

        b.buildDepreciation(carSet);

        b.buildInterior(carSet.getString("interior"),
                carSet.getString("interiorDescription"));

        b.buildEngine(carSet.getString("engine"),
                carSet.getString("engineDescription"));

        b.buildPerformancePackage(carSet.getString("performancePackage"),
                carSet.getString("performancePackageDescription"));

        return b.buildCar(carSet);
    }


}
