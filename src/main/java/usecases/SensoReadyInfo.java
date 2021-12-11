package usecases;

import adapter.GraphingDataAdapter;
import entities.Car;
import entities.GraphingData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Compatible with SensoJSONs
 */
public class SensoReadyInfo {
    public static String userCarLoanRequest(GraphingData inputData) throws IOException, InterruptedException {

        // get the user's chosen car
        CarDataProcess dbConn = new CarDataProcess();
        Car car = dbConn.getCarById(inputData.getCarId());

        // convert the inputData to the proper JSON body for the Senso API
        GraphingDataAdapter inputDataAdapter = new GraphingDataAdapter(car, inputData);
        String sensoReadyBody = inputDataAdapter.sensoReadyData();

        // format the loan request for the Senso API call
        var loanRequest = HttpRequest.newBuilder()
                .uri(URI.create(System.getenv("SENSO_URL")))
                .header("Content-Type", "application/json")
                .header("x-api-key", System.getenv("SENSO_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(sensoReadyBody))
                .build();

        // Call the senso API
        var client = HttpClient.newHttpClient();
        var response = client.send(loanRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());

        return response.body();

    }
}
