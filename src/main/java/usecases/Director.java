package usecases;


import entities.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Director {

    private final ResultSet carSet;
    private final CarFeatureBuilder b;
    public Director(ResultSet cs){
        this.carSet = cs;
        this.b = new CarFeatureBuilder();

    }

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
