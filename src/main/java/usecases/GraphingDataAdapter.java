package usecases;

import entities.Car;
import entities.GraphingData;
import interfaces.SensoJsonInterface;

/**
 * Adapter allows GraphingData to talk to the SensoAPI by turning its data into the correctly formatted JSON.
 */
public class GraphingDataAdapter implements SensoJsonInterface {
    private final GraphingData graphingData;
    private final Car chosenCar;

    /**
     * Iitialize the GraphinDataAdapter with the required information
     * @param car is the car we are trying to get loan data for.
     * @param data is the user's financial inputs.
     */
    public GraphingDataAdapter(Car car, GraphingData data) {
        this.chosenCar = car;
        this.graphingData = data;
    }

    /**
     * @return a JSON represenation that fits the Senso API body parameters
     */
    public String sensoReadyData() {
        return "{\n" +
                "   \"loanAmount\": " + graphingData.getLoanAmount() + ",\n" +
                "   \"creditScore\": " + graphingData.getCreditScore() + ",\n" +
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
