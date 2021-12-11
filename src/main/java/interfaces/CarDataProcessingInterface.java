package interfaces;

import entities.Car;

import java.util.ArrayList;

public interface CarDataProcessingInterface {

    ArrayList<Car> getAllCars();

    Car getCarById(int id);
}
