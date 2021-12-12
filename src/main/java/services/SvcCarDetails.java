package services;

import entities.Car;
import interfaces.CarAccessInterface;

/**
 * For use by the carDetails endpoint.
 */
public class SvcCarDetails {

    /**
     * @return the a JSON representing the details of the car with the given ID.
     */
    public String getCarDetails(int id, SvcCarDataProcess svcCarDataProcess,
                                CarAccessInterface carAccessInterface,
                                SvcCarToJsonRequestAdapter svcCarToJsonRequestAdapter) {
        Car car = svcCarDataProcess.getCarById(id, carAccessInterface);
        return svcCarToJsonRequestAdapter.getCarToJsonRepresentation(car);
    }
}
