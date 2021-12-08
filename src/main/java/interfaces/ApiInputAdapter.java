package interfaces;

import database.CarDataProcess;
import entities.Car;

public interface ApiInputAdapter {

    /**
     * Make a JSON representation of the relevant user and car data.
     *
     * @return a JSON str for the SensoAPI
     */
    static String makeInputJSON(double loanAmount, int creditScore, double pytBudget, int carID, double downPayment) {

        // get the car object
        CarDataProcess dbConn = new CarDataProcess();
        Car car = dbConn.getCarById(carID);

        // return a JSON representation of the car
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
}
