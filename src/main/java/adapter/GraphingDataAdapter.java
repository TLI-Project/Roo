package adapter;

import controllers.CreditScoreController;
import entities.Car;
import entities.GraphingData;
import entities.SensoJSON;
import interfaces.ApiInputAdapter;
import usecases.CarDataProcess;

/**
 * Adapter allows GraphingData to talk to the SensoAPI by turning its data into the correctly formatted JSON.
 */
public class GraphingDataAdapter extends SensoJSON {
    private final GraphingData graphingData;

    public GraphingDataAdapter(GraphingData data) {
        this.graphingData = data;
    }

    @Override
    public String sensoReadyData() {
        // get the car object
        CarDataProcess dbConn = new CarDataProcess();
        Car car = dbConn.getCarById(graphingData.getCarId());

        // turn objects into a JSON for the credit score api
        String creditInputJson = ApiInputAdapter.makeCreditInputJSON(graphingData);

        // call the credit score API
        CreditScoreController csc = new CreditScoreController();
        int creditScore = csc.pingCreditScoreAPI(creditInputJson);

        // return a JSON representation of the user's finances
        return "{\n" +
                "   \"loanAmount\": " + graphingData.getLoanAmount() + ",\n" +
                "   \"creditScore\": " + creditScore + ",\n" +
                "   \"pytBudget\": " + graphingData.getPytBudget() + ",\n" +
                "   \"vehicleMake\": \"" + car.getCarMake() + "\",\n" +
                "   \"vehicleModel\": \"" + car.getCarModel() + "\",\n" +
                "   \"vehicleYear\": " + car.getYear() + ",\n" +
                "   \"vehicleKms\": " + car.getKms() + ",\n" +
                "   \"listPrice\": " + car.getListPrice() + ",\n" +
                "   \"downpayment\": " + graphingData.getDownpayment() + "\n" +
                "}";

    }


}
