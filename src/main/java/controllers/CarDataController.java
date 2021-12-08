package controllers;

import database.CarDataProcess;
import interfaces.apiInputAdapter;
import entities.Car;
import entities.InputData;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CarDataController {
    /**
     * Get request that asks for all the cars available.
     * @return a list of all the car objects that contain their metadata.
     */
    @PostMapping("/carMetaData")
    public HashMap<Integer, String> carMetaData(){
        CarDataProcess carController = new CarDataProcess();
        HashMap<Integer, String> allCarMetaData = new HashMap<Integer, String>();
        for (Car car : carController.getAllCars()){
            allCarMetaData.put(car.id, makeCarJSON(car));
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
        return makeCarJSON(car);
    }


    @PutMapping("/userCarLoan")
    public String userCarLoan(@RequestBody InputData inputData) throws IOException, InterruptedException {
        return userCarLoanRequest(inputData.loanAmount, inputData.getCreditScore(), inputData.pytBudget,
                inputData.carId, inputData.downpayment);
    }


    @PostMapping("/carDepreciation")
    public ArrayList<Double> carDepreciation(@RequestBody int carId) {
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(carId);
        return car.depreciation;
    }

    /**
     * Turn a car into something that the frontend can recieve and work with.
     * @param car is the car you want to turn into a JSON.
     * @return a JSON representation of the car.
     */
    @NotNull
    private String makeCarJSON(Car car) {
        return "{\n" +
                "   \"id\": " + car.id + ",\n" +
                "   \"carModel\": \"" + car.carModel + "\",\n" +
                "   \"carMake\": \"" + car.carMake + "\",\n" +
                "   \"carDescription\": \"" + car.carDescription + "\",\n" +
                "   \"listPrice\": " + car.listPrice + ",\n" +
                "   \"year\": \"" + car.year + "\",\n" +
                "   \"kms\": " + car.kms + ",\n" +
                "   \"color\": \"" + car.color + "\",\n" +
                "   \"condition\": \"" + car.condition + "\",\n" +
                "   \"depreciation\": " + car.depreciation + ",\n" +
                "   \"imageURL\": \"" + car.imageURL + "\"\n" +
                "   \"interior\": \"" + car.features.get("interior").getName() + "\"\n" +
                "   \"interiorDescription\": \"" + car.features.get("interior").getDescription() + "\"\n" +
                "   \"engine\": \"" + car.features.get("engine").getName() + "\"\n" +
                "   \"engineDescription\": \"" + car.features.get("engine").getDescription() + "\"\n" +
                "   \"performancePackage\": \"" + car.features.get("performancePackage").getName() + "\"\n" +
                "   \"performancePackageDescription\": \"" + car.features.get("performancePackage").getDescription() + "\"\n" +
                "}";
    }

    public static String userCarLoanRequest(double loanAmount, int creditScore, double pytBudget, int carID, double downPayment) throws IOException, InterruptedException {

        String inputJson = apiInputAdapter.makeInputJSON(loanAmount, creditScore, pytBudget, carID, downPayment);

        var request = HttpRequest.newBuilder()
                .uri(URI.create(System.getenv("SENSO_URL")))
                .header("Content-Type", "application/json")
                .header("x-api-key", System.getenv("SENSO_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

        return response.body();
    }

    @GetMapping("/test")
    public String test(){
        return "{\"working\": 1}";
    }

}
