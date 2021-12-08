package usecases;

import entities.Person;
import interfaces.ApiInputAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static constants.DatabaseConstants.DB_URL;

public class SensoReadyInfo {
    public static String userCarLoanRequest(Person inputData) throws IOException, InterruptedException {

        String loanInputJson = ApiInputAdapter.makeLoanInputJSON(inputData);

        var loanRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://auto-loan-api.senso.ai/rate"))
                .header("Content-Type", "application/json")
                .header("x-api-key", "AIzaSyCD_-qCdXqrvWGHN1tpe2PH6Rf8zpnTdXs")
                .POST(HttpRequest.BodyPublishers.ofString(loanInputJson))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(loanRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());

        return response.body();

    }
}
