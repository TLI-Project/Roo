package interfaces;

import database.carDataProcess;
import entities.Car;

public interface apiInputAdapter {

    /**
     * Make a JSON representation of the relevant user and car data.
     * @return a JSON str for the SensoAPI
     */
    static String makeInputJSON(double loanAmount, int creditScore, double pytBudget, int carID, double downPayment){

        carDataProcess dbConn = new carDataProcess();
        Car car = dbConn.getCarById(carID);

        return "{\n" +
                "   \"loanAmount\": " + loanAmount + ",\n" +
                "   \"creditScore\": " + creditScore + ",\n" +
                "   \"pytBudget\": " + pytBudget + ",\n" +
                "   \"vehicleMake\": \"" + car.carMake + "\",\n" +
                "   \"vehicleModel\": \"" + car.carModel + "\",\n" +
                "   \"vehicleYear\": " + car.year + ",\n" +
                "   \"vehicleKms\": " + car.kms + ",\n" +
                "   \"listPrice\": " + car.listPrice + ",\n" +
                "   \"downpayment\": " + downPayment + "\n" +
                "}";
    }


//    static String apiReadyInput(User user, Car car) {
//        return "{\n" +
//                "   \"loanAmount\": " + user.getLoanAmount() + ",\n" +
//                "   \"creditScore\": " + user.getCreditScore() + ",\n" +
//                "   \"pytBudget\": " + user.getPytBudget() + ",\n" +
//                "   \"vehicleMake\": \"" + car.carMake + "\",\n" +
//                "   \"vehicleModel\": \"" + car.carModel + "\",\n" +
//                "   \"vehicleYear\": " + car.year + ",\n" +
//                "   \"vehicleKms\": " + car.kms + ",\n" +
//                "   \"listPrice\": " + car.listPrice + ",\n" +
//                "   \"downpayment\": " + user.getDownpayment() + "\n" +
//                "}";
//    }
}
