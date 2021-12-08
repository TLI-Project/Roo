package controllers;

import java.net.URI;
import java.net.http.HttpRequest;

public class CreditScoreController {

    public int pingCreditScoreAPI(String creditInputJson){
        var creditRequest = HttpRequest.newBuilder()
                .uri(URI.create("MCOK URI"))
                .header("Content-Type", "application/json")
                .header("x-api-key", "MOCK KEY")
                .POST(HttpRequest.BodyPublishers.ofString(creditInputJson))
                .build();
        return generateCreditScore();
    }

    private static int generateCreditScore() {
        return (int) ((Math.random() * (800 - 600)) + 600);
    }


}
