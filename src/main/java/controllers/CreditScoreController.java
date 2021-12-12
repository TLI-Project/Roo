package controllers;

public class CreditScoreController {

    /**
     * Connect to the Credit Score "API" in order to take user's information and get a credit score between 400-800.
     * @param creditInputJson is the user's information needed for a credit score.
     * @return a credit score between 400-800.
     */
    public int pingCreditScoreAPI(String creditInputJson){

        // left here because this is how you WOULD call the creditScore API assuming we had an API.

//        var creditRequest = HttpRequest.newBuilder()
//                .uri(URI.create("MOCK URI"))
//                .header("Content-Type", "application/json")
//                .header("x-api-key", "MOCK KEY")
//                .POST(HttpRequest.BodyPublishers.ofString(creditInputJson))
//                .build();

//        var client = HttpClient.newHttpClient();

//        var response = client.send(creditRequest, HttpResponse.BodyHandlers.ofString());

        return generateCreditScore();
    }

    /**
     * @return a random number between 600-800 to "mock" a credit score API call.
     */
    private static int generateCreditScore() {
        // between 600 - 800 to make sure the Senso Rate always works but has varying values.
        // would fail with lower scores.
        return (int) ((Math.random() * (800 - 600)) + 600);
    }


}
