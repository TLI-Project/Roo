package controllers;

import usecases.CarDataProcess;
import entities.Car;
import org.springframework.web.bind.annotation.*;
import usecases.CarToJsonRequestAdapter;
import usecases.SensoReadyInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * All the endpoints between the frontend and the backend
 */
@RestController
public class CarDataController {

    /**
     * Get request that asks for all the cars available.
     * @return a list of all the car objects that contain their metadata.
     */
    @PostMapping("/carMetaData")
    public HashMap<Integer, String> carMetaData(){
        CarDataProcess carController = new CarDataProcess();
        HashMap<Integer, String> allCarMetaData = new HashMap<>();
        for (Car car : carController.getAllCars()){
            allCarMetaData.put(car.getCarId(), CarToJsonRequestAdapter.getJsonFormattedCar(car));
        }
        return allCarMetaData;
    }

    /**
     * Get request that asks for a certain car.
     * @param id the ID of the car you are looking for.
     * @return The car entity you are looking for.
     */
    @PostMapping("/carDetails")
    public String carDetails(@RequestBody int id){
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(id);
        return CarToJsonRequestAdapter.getJsonFormattedCar(car);
    }

    /**
     * Call the Senso API /rate endpoing with all the corresponding user information.
     * @param inputData is the users finances and car information.
     * @return json representation of the Senso API /rate calculation.
     * @throws IOException e
     * @throws InterruptedException e
     */
    @PutMapping("/userCarLoan")
    public String userCarLoan(@RequestBody String[] inputData) throws IOException, InterruptedException {
        System.out.println(Arrays.toString(inputData));
        return "{\n" +
                "   \"test\": " + 1 + "\n" +
                "}";
//        return SensoReadyInfo.userCarLoanRequest(inputData);
    }

    /**
     * Get a given car's depreciation schedule over the next 10 years.
//     * @param carId is the car whose depreciation you are looking for.
     * @return an ArrayList representaiton of car depreciation (percent value) from year 1-10 respectively.
     */
    @PostMapping("/carDepreciation")
    public String carDepreciation(@RequestBody int id) {
        CarDataProcess carController = new CarDataProcess();
//        HashMap<Integer, ArrayList<Double>> result = new HashMap<>();
        Car car = carController.getCarById(id);
//        result.put(id, car.getDepreciation());
//        for (int i = 1; i <= 4; i ++) {
//            if (carIds.get("" + i + "") != -1){
//                Car car = carController.getCarById(carIds.get("" + i + ""));
//                result.put(carIds.get("" + i + ""), car.getDepreciation());
//            }
//        }
//        return result.toString();

//        Car car = carController.getCarById(carIds);
//        return car.getDepreciation();
        return "{\n" +
                "   \"depreciation\": " + car.getDepreciation() + "\n" +
                "}";
    }


    @GetMapping("/test")
    public String test(){
        return "{\"working\": 1}";
    }

}
