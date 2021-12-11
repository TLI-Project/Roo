package controllers;

import entities.GraphingData;
import usecases.CarDataProcess;
import entities.Car;
import org.springframework.web.bind.annotation.*;
import usecases.CarToJsonRequestAdapter;
import usecases.SensoReadyInfo;

import java.io.IOException;
import java.util.HashMap;

/**
 * All the endpoints between the frontend and the backend
 */
@RestController
public class CarDataController {

    /**
     * Get request that asks for all the cars available.
     *
     * @return a list of all the car objects that contain their metadata.
     */
    @PostMapping("/carMetaData")
    public HashMap<Integer, String> carMetaData() {
        CarDataProcess carController = new CarDataProcess();
        HashMap<Integer, String> allCarMetaData = new HashMap<>();
        for (Car car : carController.getAllCars()) {
            allCarMetaData.put(car.getCarId(), CarToJsonRequestAdapter.getJsonFormattedCar(car));
        }
        return allCarMetaData;
    }

    /**
     * Get request that asks for a certain car.
     *
     * @param id the ID of the car you are looking for.
     * @return The car entity you are looking for.
     */
    @PostMapping("/carDetails")
    public String carDetails(@RequestBody int id) {
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(id);
        return CarToJsonRequestAdapter.getJsonFormattedCar(car);
    }

    /**
     * Call the Senso API /rate endpoing with all the corresponding user information.
     *
     * @param inputData is the users finances and car information.
     * @return json representation of the Senso API /rate calculation.
     * @throws IOException          e
     * @throws InterruptedException e
     */
    @PostMapping(
            value = "/userCarLoan", consumes = "application/json", produces = "application/json")
    public String userCarLoan(@RequestBody GraphingData inputData) throws IOException, InterruptedException {
        System.out.println(SensoReadyInfo.userCarLoanRequest(inputData));
        return SensoReadyInfo.userCarLoanRequest(inputData);
    }
    /**
     * Get a given car's depreciation schedule over the next 10 years.
     * //     * @param carId is the car whose depreciation you are looking for.
     *
     * @return an ArrayList representaiton of car depreciation (percent value) from year 1-10 respectively.
     */
    @PostMapping("/carDepreciation")
    public String carDepreciation(@RequestBody int id) {
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(id);
        return "{\n" +
                "   \" " + id + " \": " + car.getDepreciation() + "\n" +
                "}";
    }
}