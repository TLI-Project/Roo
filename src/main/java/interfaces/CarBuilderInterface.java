package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CarBuilderInterface {

    void buildDepreciation(ResultSet cs) throws SQLException;

    void buildInterior(String interiorName, String interiorDescription);

    void buildEngine(String engineName, String engineDescription);

    void buildPerformancePackage(String performancePackageName, String perforancePackageDescription);
}
