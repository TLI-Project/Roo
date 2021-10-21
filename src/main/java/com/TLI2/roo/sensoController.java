package com.TLI2.roo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class sensoController {
    public static String getAPI(String[] inputs) throws IOException, InterruptedException {

        // Initialize a string array to store all the user inputs
        // [0] = name, [1] = loanAmount, [2] = creditScore, [3] = pytBudget
        // Make the JSON file with the user inputs.
        String inputJson = "{\n" +
                "   \"loanAmount\": " + inputs[1] + ",\n" +
                "   \"creditScore\": " + inputs[2] + ",\n" +
                "   \"pytBudget\": " + inputs[3] + ",\n" +
                "   \"vehicleMake\": \"Honda\",\n" +
                "   \"vehicleModel\": \"Civic\",\n" +
                "   \"vehicleYear\": 2021,\n" +
                "   \"vehicleKms\": 1000\n" +
                "}";

        // Create a /rate request to the Senso API with the API key given and the input JSON file
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://auto-loan-api.senso.ai/rate"))
                .header("Content-Type", "application/json")
                .header("x-api-key", inputs[4])
                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
                .build();

        // use the client to send the request
        var client = HttpClient.newHttpClient();
        // save API response
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // output the response:
        System.out.println(response.statusCode());
        System.out.println(response.body());
        return response.body();
    }


    public static String[] mockInputs(){
        return new String[]{"winnie", "10000", "780", "400", "AIzaSyCD_-qCdXqrvWGHN1tpe2PH6Rf8zpnTdXs"};
    }
}
