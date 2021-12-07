//package Controller;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
///**
// * Everything needed to talk to the Senso API.
// */
//public class sensoController {
//    /**
//     * The function that actually pings the API /rate calculation.
//     * @param inputs is in the form [username, loanAmount, creditScore, pytBudget, API key]
//     * @return the JSON output from the /rate calculation
//     * @throws IOException TODO
//     * @throws InterruptedException TODO
//     */
//    public static String getAPI(String[] inputs) throws IOException, InterruptedException {
//
//        String inputJson = getInputJson(inputs);
//
//        var request = HttpRequest.newBuilder()
//                .uri(URI.create(System.getenv("SENSO_URL")))
//                .header("Content-Type", "application/json")
//                .header("x-api-key", System.getenv("SENSO_KEY"))
//                .POST(HttpRequest.BodyPublishers.ofString(inputJson))
//                .build();
//
//        var client = HttpClient.newHttpClient();
//
//        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.statusCode());
//        System.out.println(response.body());
//
//        return response.body();
//    }
//
//    /**
//     * Ping the Senso API with the given inputs passed through
//     *
//     * @param inputs taken from the User Data
//     * @return the Senso API json
//     * @throws IOException TODO dont know why this is
//     * @throws InterruptedException TODO dont know why this is
//     */
//    public static String getAPIInputs(String inputs) throws IOException, InterruptedException {
//
//        var request = HttpRequest.newBuilder()
//                .uri(URI.create(System.getenv("SENSO_URL")))
//                .header("Content-Type", "application/json")
//                .header("x-api-key", System.getenv("SENSO_KEY"))
//                .POST(HttpRequest.BodyPublishers.ofString(inputs))
//                .build();
//
//        var client = HttpClient.newHttpClient();
//
//        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        System.out.println(response.statusCode());
//        System.out.println(response.body());
//
//        return response.body();
//    }
//
//    /**
//     * Turn the user inputs into a format that the Senso API call can carry out.
//     *
//     * @param inputs represent the users financial data.
//     * @return a JSON file that the Senso API can handle.
//     */
//    private static String getInputJson(String[] inputs) {
//        return "{\n" +
//                "   \"loanAmount\": " + inputs[1] + ",\n" +
//                "   \"creditScore\": " + inputs[2] + ",\n" +
//                "   \"pytBudget\": " + inputs[3] + ",\n" +
//                "   \"vehicleMake\": \"Honda\",\n" +
//                "   \"vehicleModel\": \"Civic\",\n" +
//                "   \"vehicleYear\": 2021,\n" +
//                "   \"vehicleKms\": 1000,\n" +
//                "   \"listPrice\": " + inputs[5] + ",\n" +
//                "   \"downpayment\": " + inputs[6] + "\n" +
//                "}";
//    }
//
//    /**
//     * Make a fake set of inputs for the Senso API for testing.
//     * @return a string array of all the differnt inputs and API key.
//     * TODO make the API key not hard coded? Security risk.
//     */
//    public static String[] mockInputs(){
//        return new String[]{"w", "6000", "790", "900", "AIzaSyCD_-qCdXqrvWGHN1tpe2PH6Rf8zpnTdXs", "12000", "6000"};
//    }
//}
