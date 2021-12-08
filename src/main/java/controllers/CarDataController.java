package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import usecases.CarDataProcess;
import interfaces.ApiInputAdapter;
import entities.Car;
import org.springframework.web.bind.annotation.*;
import usecases.CarToJsonRequestAdapter;

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
        HashMap<Integer, String> allCarMetaData = new HashMap<Integer, String>();
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

//    const inputData = {
//        loanAmount: loanAmount,
//                monthlyBudget: monthlyBudget,
//                downPayment: downPayment,
//                address: address,
//                postalCode: postalCode,
//                city: city,
//                province: province,
//                dateOfBirth: dateOfBirth,
//                sinNumber: sinNumber
//    }

    @PutMapping("/userCarLoan")
    public String userCarLoan(@RequestBody String inputData) throws IOException, InterruptedException {
        return userCarLoanRequest(inputData);
    }


    @PostMapping("/carDepreciation")
    public ArrayList<Double> carDepreciation(@RequestBody int carId) {
        CarDataProcess carController = new CarDataProcess();
        Car car = carController.getCarById(carId);
        return car.getDepreciation();
    }

//    /**
//     * Turn a car into something that the frontend can recieve and work with.
//     * @param car is the car you want to turn into a JSON.
//     * @return a JSON representation of the car.
//     */
//    @NotNull
//    private String makeCarJSON(Car car) {
//        return getJsonFormattedCar(car);
//    }

    public static String userCarLoanRequest(String inputData) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // convert JSON string to Map
            Map<String, String> userInputs = mapper.readValue(inputData, Map.class);
            System.out.println(userInputs);

            double loanAmount = Double.parseDouble(userInputs.get("loanAmount"));
            double pytBudget = Double.parseDouble(userInputs.get("pytBudget"));
            int carId = Integer.parseInt(userInputs.get("carId"));
            double downPayment = Double.parseDouble(userInputs.get("downPayment"));


            String creditInputJson = ApiInputAdapter.makeCreditInputJSON();

            var creditRequest = HttpRequest.newBuilder()
                    .uri(URI.create("MCOK URI"))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", "MOCK KEY")
                    .POST(HttpRequest.BodyPublishers.ofString(creditInputJson))
                    .build();
            CreditScoreController csc = new CreditScoreController();
            int creditScore = csc.pingCreditScoreAPI(creditRequest);

            String loanInputJson = ApiInputAdapter.makeLoanInputJSON(loanAmount, creditScore, pytBudget, carId, downPayment);

            var loanRequest = HttpRequest.newBuilder()
                    .uri(URI.create(System.getenv("SENSO_URL")))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", System.getenv("SENSO_KEY"))
                    .POST(HttpRequest.BodyPublishers.ofString(loanInputJson))
                    .build();

            var client = HttpClient.newHttpClient();

            var response = client.send(loanRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());

            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
            return "Server Error. Car Loan request";
        }
    }


    @GetMapping("/test")
    public String test(){
        return "{\"working\": 1}";
    }

}
