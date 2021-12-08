package interfaces;

import entities.Car;

import java.util.ArrayList;

public interface CarDataProcessingInterface {

    public ArrayList<Car> getAllCars();

    public Car getCarById(int id);
}
