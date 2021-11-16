package adapters;

import entities.Car;
import entities.User;

public interface apiInputAdapter {

    static String makeInputJSON(User user, Car car){
        return apiReadyInput(user, car);
    }

    /**
     * Make a JSON representation of the relevant user and car data.
     * @param user the user looking to buy a car.
     * @param car the car the user is looking to buy.
     * @return a JSON str for the SensoAPI
     */
    static String apiReadyInput(User user, Car car) {
        return "{\n" +
                "   \"loanAmount\": " + user.getLoanAmount() + ",\n" +
                "   \"creditScore\": " + user.getCreditScore() + ",\n" +
                "   \"pytBudget\": " + user.getPytBudget() + ",\n" +
                "   \"vehicleMake\": \"" + car.getCarMake() + "\",\n" +
                "   \"vehicleModel\": \"" + car.getCarModel() + "\",\n" +
                "   \"vehicleYear\": " + car.getYear() + ",\n" +
                "   \"vehicleKms\": " + car.getKms() + ",\n" +
                "   \"listPrice\": " + car.getListPrice() + ",\n" +
                "   \"downpayment\": " + user.getDownpayment() + "\n" +
                "}";
    }
}
