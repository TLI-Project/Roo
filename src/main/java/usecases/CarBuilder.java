package usecases;

import entities.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CarBuilder {

    void buildDepreciation(ResultSet cs) throws SQLException;

    void buildInterior(String interiorName, String interiorDescription);

    void buildEngine(String engineName, String engineDescription);

    void buildPerformancePackage(String performancePackageName, String perforancePackageDescription);

    Car buildCar(ResultSet cs) throws SQLException;
}
