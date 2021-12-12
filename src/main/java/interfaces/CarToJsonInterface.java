package interfaces;

import entities.Car;

/**
 * Compatible with frontend car displays.
 */
public interface CarToJsonInterface {

    String getCarToJsonRepresentation(Car car);
}
