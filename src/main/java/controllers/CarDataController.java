package controllers;

import entities.GraphingData;
import interfaces.CarToJsonInterface;
import usecases.CarDataProcess;
import entities.Car;
import org.springframework.web.bind.annotation.*;
import usecases.CarToJsonRequestAdapter;
import usecases.SensoReadyInfo;

import java.io.IOException;
import java.util.ArrayList;
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
        CarToJsonInterface carToJson = new CarToJsonRequestAdapter();
        for (Car car : carController.getAllCars()) {
            allCarMetaData.put(car.getCarId(), carToJson.getCarToJsonRepresentation(car));
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
        CarToJsonInterface carToJson = new CarToJsonRequestAdapter();
        return carToJson.getCarToJsonRepresentation(car);
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
        return jsonCarDepreciation(id, car.getDepreciation());
    }

    /**
     * HELPER: make a JSON representation of car depreciation for the frontend.
     * @param id is the ID of the car
     * @param depreciation is the depreciation of the car
     * @return a JSON representation of the car's depreciation
     */
    private String jsonCarDepreciation(int id, ArrayList<Double> depreciation) {
        // could this be an adapter? I guess? Is that way overkill? Yes.
        return "{\n" +
                "   \" " + id + " \": " + depreciation + "\n" +
                "}";
    }
}