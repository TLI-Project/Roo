package interfaces;

import java.sql.ResultSet;


/**
 * Turn Car Dataset entries into entities we can use in our application.
 */
public interface CarAccessInterface {

    /**
     * @return a Car object from the dataset by ID
     */
    ResultSet getCar(int id);

    /**
     * @return the Car entity representation of each car.
     */
    ResultSet getAllCars();
}
