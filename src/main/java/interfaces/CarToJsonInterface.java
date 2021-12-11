package interfaces;

import entities.Car;

/**
 * Compatible with frontend car displays.
 */
public interface CarToJsonInterface {

    /**
     * @return a JSON representation of the data needed for a credit score check.
     */
    String getCarToJsonRepresentation(Car car);
}
