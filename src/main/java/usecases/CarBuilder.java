package usecases;

public interface CarBuilder {


    void buildInterior(String interiorName, String interiorDescription);

    void buildEngine(String engineName, String engineDescription);

    void buildPerformancePackage(String performancePackageName, String perforancePackageDescription);

}
