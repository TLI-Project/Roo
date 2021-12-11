package adapter;

import entities.Car;
import entities.GraphingData;
import entities.SensoJSON;

/**
 * Adapter allows GraphingData to talk to the SensoAPI by turning its data into the correctly formatted JSON.
 */
public class GraphingDataAdapter extends SensoJSON {
    private final GraphingData graphingData;
    private final int creditScore;
    private final Car chosenCar;

    /**
     * Iitialize the GraphinDataAdapter with the required information
     * @param car is the car we are trying to get loan data for.
     * @param creditScore is the credit score of the user.
     * @param data is the user's financial inputs.
     */
    public GraphingDataAdapter(Car car, int creditScore, GraphingData data) {
        this.chosenCar = car;
        this.creditScore = creditScore;
        this.graphingData = data;
    }

    /**
     * @return a JSON represenation that fits the Senso API body parameters
     */
    @Override
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
