package legacy;

// TODO: is this a type of controller?

import interfaces.ApiInputAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class getUserCarLoan {

//    /**
//     * Get request that calls the senso api with car/user pair.
//     * @param user user requesting the loan.
//     * @param car the user is interested in.
//     * @return the senso API data.
//     * @throws IOException
//     * @throws InterruptedException
//     */
//    @PostMapping("/userCarLoan")
//    public String userCarLoan(@RequestBody User user, Car car) throws IOException, InterruptedException {
//        return userCarLoanRequest(user, car);
//    }


    public static String userCarLoanRequest(Map<String, String> userInputs) throws IOException, InterruptedException {

        String inputJson = ApiInputAdapter.makeLoanInputJSON(userInputs);

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

}
