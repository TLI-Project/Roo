package services;

import entities.Car;
import entities.GraphingData;

/**
 * Adapter allows GraphingData to talk to the SensoAPI by turning its data into the correctly formatted JSON.
 */
public class SvcGraphingDataAdapter {
    private final GraphingData graphingData;
    private final Car chosenCar;
    private final int creditScore;

    /**
     * Iitialize the GraphinDataAdapter with the required information
     * @param car is the car we are trying to get loan data for.
     * @param data is the user's financial inputs.
     */
    public SvcGraphingDataAdapter(Car car, GraphingData data, SvcCreditScoreAdapter svcCreditScoreAdapter) {
        this.chosenCar = car;
        this.graphingData = data;
        // Get credit score.
        SvcGetCreditScore svcGetCreditScore = new SvcGetCreditScore();
        String creditScoreApiInputs = svcCreditScoreAdapter.creditReadyData();
        this.creditScore = svcGetCreditScore.pingCreditScoreAPI(creditScoreApiInputs);
    }

    /**
     * @return a JSON represenation that fits the Senso API body parameters
     */
    public String sensoReadyData() {
        return "{\n" +
                "   \"loanAmount\": " + graphingData.getLoanAmount() + ",\n" +
                "   \"creditScore\": " + creditScore + ",\n" +
                "   \"pytBudget\": " + graphingData.getPytBudget() + ",\n" +
                "   \"vehicleMake\": \"" + chosenCar.getCarMake() + "\",\n" +
                "   \"vehicleModel\": \"" + chosenCar.getCarModel() + "\",\n" +
                "   \"vehicleYear\": " + chosenCar.getYear() + ",\n" +
                "   \"vehicleKms\": " + chosenCar.getKms() + ",\n" +
                "   \"listPrice\": " + chosenCar.getListPrice() + ",\n" +
                "   \"downpayment\": " + graphingData.getDownpayment() + "\n" +
                "}";

    }


}
