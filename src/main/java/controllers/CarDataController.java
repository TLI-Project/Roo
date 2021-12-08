package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import usecases.CarDataProcess;
import interfaces.ApiInputAdapter;
import entities.Car;
import org.springframework.web.bind.annotation.*;
import usecases.CarToJsonRequestAdapter;
import usecases.SensoReadyInfo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
     * @return The car entity you are looking for
     */
    @PostMapping("/carDetails")
    public String carDetails(@RequestBody int id){
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(id);
        return CarToJsonRequestAdapter.getJsonFormattedCar(car);
    }

    @PutMapping("/userCarLoan")
    public String userCarLoan(@RequestBody String inputData) throws IOException, InterruptedException {
        return SensoReadyInfo.userCarLoanRequest(inputData);
    }


    @PostMapping("/carDepreciation")
    public ArrayList<Double> carDepreciation(@RequestBody int carId) {
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(carId);
        return car.getDepreciation();
    }




    @GetMapping("/test")
    public String test(){
        return "{\"working\": 1}";
    }

}
