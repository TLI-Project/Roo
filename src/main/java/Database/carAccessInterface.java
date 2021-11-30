package Database;

import java.sql.ResultSet;


/**
 * Turn Car Dataset entries into entities we can use in our application.
 */
public interface carAccessInterface {

    /**
     * Iterare through the car dataset and return all cars
     * @return a list of Car objects from the dataset by ID
     */
    public ResultSet getCar(int id);

    /**
     * @return the Car entity representation of the car.
     */
    public ResultSet getAllCars();
}
