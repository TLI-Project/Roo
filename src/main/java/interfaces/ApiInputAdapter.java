package interfaces;

import controllers.CreditScoreController;
import usecases.CarDataProcess;
import entities.Car;

import java.util.Map;

public interface ApiInputAdapter {

    /**
     * Make a JSON representation of the relevant user and car data.
     *
     * @return a JSON str for the SensoAPI
     */
    static String makeLoanInputJSON(Map<String, String> userInputs) {

        // get values from userInputs
        double loanAmount = Double.parseDouble(userInputs.get("loanAmount"));
        double pytBudget = Double.parseDouble(userInputs.get("pytBudget"));
        int carId = Integer.parseInt(userInputs.get("carId"));
        double downPayment = Double.parseDouble(userInputs.get("downPayment"));

        // get the car object
        CarDataProcess dbConn = new CarDataProcess();
        Car car = dbConn.getCarById(carId);

        // turn objects into a JSON for the credit score api
        String creditInputJson = ApiInputAdapter.makeCreditInputJSON(userInputs);

        // call the credit score API
        CreditScoreController csc = new CreditScoreController();
        int creditScore = csc.pingCreditScoreAPI(creditInputJson);

        // return a JSON representation of the user's finances
        return "{\n" +
                "   \"loanAmount\": " + loanAmount + ",\n" +
                "   \"creditScore\": " + creditScore + ",\n" +
                "   \"pytBudget\": " + pytBudget + ",\n" +
                "   \"vehicleMake\": \"" + car.getCarMake() + "\",\n" +
                "   \"vehicleModel\": \"" + car.getCarModel() + "\",\n" +
                "   \"vehicleYear\": " + car.getYear() + ",\n" +
                "   \"vehicleKms\": " + car.getKms() + ",\n" +
                "   \"listPrice\": " + car.getListPrice() + ",\n" +
                "   \"downpayment\": " + downPayment + "\n" +
                "}";
    }

    /**
     * Make a JSON representation of the relevant user data needed for getting a credit score.
     *
     * @param userInputs is all the user inputs from the frontend.
     * @return a JSON string representation for the CreditScore API.
     */
    static String makeCreditInputJSON(Map<String, String> userInputs) {

        String address = userInputs.get("address");
        String postalCode = userInputs.get("postalCode");
        String city = userInputs.get("city");
        String province = userInputs.get("province");
        String dateOfBirth = userInputs.get("dateOfBirth");
        int sinNumber = Integer.parseInt(userInputs.get("sinNumber"));

        return "{\n" +
                "   \"address\": \"" + address + "\",\n" +
                "   \"postalCode\": \"" + postalCode + "\",\n" +
                "   \"city\": \"" + city + "\",\n" +
                "   \"province\": \"" + province + "\",\n" +
                "   \"dateOfBirth\": \"" + dateOfBirth + "\",\n" +
                "   \"sinNumber\": " + sinNumber + ",\n" +
                "}";
    }
}
