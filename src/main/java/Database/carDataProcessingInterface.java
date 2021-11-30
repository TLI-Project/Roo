package Database;

import entities.Car;

import java.util.ArrayList;

public interface carDataProcessingInterface {

    public ArrayList<Car> getAllCars();

    public Car getCarById(int id);
}
