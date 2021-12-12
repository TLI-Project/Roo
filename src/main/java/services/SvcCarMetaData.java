package services;

import entities.Car;
import interfaces.CarAccessInterface;

import java.util.HashMap;

/**
 * Called by the carMetaData endpoint.
 */
public class SvcCarMetaData {

    /**
     * @return a map of the car metadata for keyed by the car's Id.
     */
    public HashMap<Integer, String> getMetaData(SvcCarDataProcess svcCarDataProcess,
                                                SvcCarToJsonRequestAdapter svcCarToJsonRequestAdapter,
                                                CarAccessInterface carAccessInterface) {
        HashMap<Integer, String> allCarMetaData = new HashMap<>();
        for (Car car : svcCarDataProcess.getAllCars(carAccessInterface)) {
            allCarMetaData.put(car.getCarId(), svcCarToJsonRequestAdapter.getCarToJsonRepresentation(car));
        }
        return allCarMetaData;
    }

}
