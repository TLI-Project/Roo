//package interfaces;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * All the functions needed to build a car.
// */
//public interface CarBuilderInterface {
//
//    /**
//     * Create a list of the last 10 years of depreciation of a given car.
//     * @param cs is the ResultSet entry from the database for the given car.
//     */
//    void buildDepreciation(ResultSet cs) throws SQLException;
//
//    /**
//     * Create the interior feature of a given car.
//     * @param interiorName is the name of the interior.
//     * @param interiorDescription is the description of the interior.
//     */
//    void buildInterior(String interiorName, String interiorDescription);
//
//    /**
//     * Create the engine feature of a given car.
//     * @param engineName is the name of the engine.
//     * @param engineDescription is the description of the engine (0-100km/h, horsepower, etc.)
//     */
//    void buildEngine(String engineName, String engineDescription);
//
//    /**
//     * Create the performance package of a given car.
//     * @param performancePackageName is the name of the performance package.
//     * @param perforancePackageDescription is the description of what comes included in the performance package.
//     */
//    void buildPerformancePackage(String performancePackageName, String perforancePackageDescription);
//}
