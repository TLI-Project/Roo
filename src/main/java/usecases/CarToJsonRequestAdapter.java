package usecases;

import entities.Car;
import interfaces.CarToJsonInterface;
import org.jetbrains.annotations.NotNull;

public class CarToJsonRequestAdapter implements CarToJsonInterface {

    @Override
    public String getCarToJsonRepresentation(Car car) {
        return getJsonFormattedCar(car);
    }

    @NotNull
    private static String getJsonFormattedCar(Car car) {
        return "{\n" +
                "   \"id\": " + car.getCarId() + ",\n" +
                "   \"carModel\": \"" + car.getCarModel() + "\",\n" +
                "   \"carMake\": \"" + car.getCarMake() + "\",\n" +
                "   \"carDescription\": \"" + car.getCarDescription() + "\",\n" +
                "   \"listPrice\": " + car.getListPrice() + ",\n" +
                "   \"year\": \"" + car.getYear() + "\",\n" +
                "   \"kms\": " + car.getKms() + ",\n" +
                "   \"color\": \"" + car.getColor() + "\",\n" +
                "   \"condition\": \"" + car.getCondition() + "\",\n" +
                "   \"depreciation\": " + car.getDepreciation() + ",\n" +
                "   \"imageURL\": " + car.getImageURL() + ",\n" +
                "   \"interior\": \"" + car.getFeatures().get("interior").getName() + "\",\n" +
                "   \"interiorDescription\": \"" + car.getFeatures().get("interior").getDescription() + "\",\n" +
                "   \"engine\": \"" + car.getFeatures().get("engine").getName() + "\",\n" +
                "   \"engineDescription\": \"" + car.getFeatures().get("engine").getDescription() + "\",\n" +
                "   \"performancePackage\": \"" + car.getFeatures().get("performancePackage").getName() + "\",\n" +
                "   \"performancePackageDescription\": \"" + car.getFeatures().get("performancePackage").getDescription() + "\"\n" +
                "}";
    }
}
