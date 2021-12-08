package usecases;

import com.fasterxml.jackson.databind.ObjectMapper;
import interfaces.ApiInputAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class SensoReadyInfo {
    public static String userCarLoanRequest(String inputData) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // convert JSON string to Map
            Map<String, String> userInputs = mapper.readValue(inputData, Map.class);
            System.out.println(userInputs);

            String loanInputJson = ApiInputAdapter.makeLoanInputJSON(userInputs);

            var loanRequest = HttpRequest.newBuilder()
                    .uri(URI.create(System.getenv("SENSO_URL")))
                    .header("Content-Type", "application/json")
                    .header("x-api-key", System.getenv("SENSO_KEY"))
                    .POST(HttpRequest.BodyPublishers.ofString(loanInputJson))
                    .build();

            var client = HttpClient.newHttpClient();

            var response = client.send(loanRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());

            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
            return "Server Error. Car Loan request";
        }
    }
}
