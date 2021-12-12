package interfaces;

import entities.Car;

import java.util.ArrayList;

/**
 * The interface for processing car information that deals with Entities, not the database.
 */
public interface CarDataProcessingInterface {

    /**
     * @return a list of all the Car objects at the dealership.
     */
    ArrayList<Car> getAllCars();

    /**
     * @param id the id of the car you are looking for
     * @return the Car object with that given id.
     */
    Car getCarById(int id);
}
