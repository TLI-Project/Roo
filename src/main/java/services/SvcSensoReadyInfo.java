package services;

import entities.Car;
import entities.GraphingData;
import interfaces.CarAccessInterface;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Compatible with SensoJSONs
 */
public class SvcSensoReadyInfo {

    /**
     * Returns the Senso API response given the data the user inputted from the frontend.
     * @param inputData is the data the user inputted from the frontend.
     * @return the Senso API response.
     */
    public static String userCarLoanRequest(
            GraphingData inputData,
            CarAccessInterface carAccessInterface,
            SvcCarDataProcess svcCarDataProcess
    ) throws IOException, InterruptedException {
        SvcCreditScoreAdapter svcCreditScoreAdapter = new SvcCreditScoreAdapter(inputData);

        // get the user's chosen car
        int carId = inputData.getCarId();
        Car car = svcCarDataProcess.getCarById(carId, carAccessInterface);

        // convert the inputData to the proper JSON body for the Senso API
        SvcGraphingDataAdapter inputDataAdapter = new SvcGraphingDataAdapter(car, inputData, svcCreditScoreAdapter);
        String sensoReadyBody = inputDataAdapter.sensoReadyData();

        // format the loan request for the Senso API call
        var loanRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://auto-loan-api.senso.ai/rate"))
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
