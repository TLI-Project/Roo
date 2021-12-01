package App;

import Controller.sensoController;
import Database.carDataProcess;
import adapters.apiInputAdapter;
import entities.Car;
import entities.InputData;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
public class CarDataController {
    /**
     * Get request that asks for all the cars available.
     * @return a list of all the car objects that contain their metadata.
     */
    @PostMapping("/carMetaData")
    public HashMap<Integer, String> carMetaData(){
        carDataProcess carController = new carDataProcess();
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
        carDataProcess carController = new carDataProcess();
        Car car = carController.getCarById(id);
        return makeCarJSON(car);
    }

    @PutMapping("/userCarLoan")
    public String userCarLoan(@RequestBody InputData inputData) throws IOException, InterruptedException {
//        System.out.println(inputData.loanAmount);
//        System.out.println(inputData.creditScore);
//        System.out.println(inputData.pytBudget);
//        System.out.println(inputData.downpayment);
        return userCarLoanRequest(inputData.loanAmount, inputData.creditScore, inputData.pytBudget, inputData.id, inputData.downpayment);
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
                "   \"carMake\": \"" + car.carMake + "\",\n" +
                "   \"carModel\": \"" + car.carModel + "\",\n" +
                "   \"listPrice\": " + car.listPrice + ",\n" +
                "   \"year\": \"" + car.year + "\",\n" +
                "   \"kms\": " + car.kms + ",\n" +
                "   \"color\": \"" + car.color + "\",\n" +
                "   \"depreciation\": \"" + car.listPrice + "\",\n" +
                "   \"imageURL\": \"" + car.imageURL + "\"\n" +
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
