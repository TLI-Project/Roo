package controllers;

import entities.Car;
import entities.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class sensoAPIController {

    /**
     * Ping the senso API with the for a user/car pairing.
     * @param user the user looking at cars
     * @param car the car the user is looking at
     * @return the Senso response of the loan data
     * @throws IOException
     * @throws InterruptedException
     */
    public static String getUserCarLoan(User user, Car car) throws IOException, InterruptedException {

        String inputJson = user.getInputs();

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://auto-loan-api.senso.ai/rate"))
                .header("Content-Type", "application/json")
                .header("x-api-key", user.getAPIkey())
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();

        var client = HttpClient.newHttpClient();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(response.statusCode());
//        System.out.println(response.body());

        return response.body();
    }
}
