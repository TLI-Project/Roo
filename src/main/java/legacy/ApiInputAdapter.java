//package interfaces;
//
//import controllers.CreditScoreController;
//import entities.GraphingData;
//import usecases.CarDataProcess;
//import entities.Car;
//
//public interface ApiInputAdapter {
//
//    /**
//     * Make a JSON representation of the relevant user and car data.
//     *
//     * @return a JSON str for the SensoAPI
//     */
//    static String makeLoanInputJSON(GraphingData userInputs) {
//
//        // get the car object
//        CarDataProcess dbConn = new CarDataProcess();
//        Car car = dbConn.getCarById(userInputs.getCarId());
//
//        // turn objects into a JSON for the credit score api
//        String creditInputJson = ApiInputAdapter.makeCreditInputJSON(userInputs);
//
//        // call the credit score API
//        CreditScoreController csc = new CreditScoreController();
//        int creditScore = csc.pingCreditScoreAPI(creditInputJson);
//
//        // return a JSON representation of the user's finances
//        return "{\n" +
//                "   \"loanAmount\": " + userInputs.getLoanAmount() + ",\n" +
//                "   \"creditScore\": " + creditScore + ",\n" +
//                "   \"pytBudget\": " + userInputs.getPytBudget() + ",\n" +
//                "   \"vehicleMake\": \"" + car.getCarMake() + "\",\n" +
//                "   \"vehicleModel\": \"" + car.getCarModel() + "\",\n" +
//                "   \"vehicleYear\": " + car.getYear() + ",\n" +
//                "   \"vehicleKms\": " + car.getKms() + ",\n" +
//                "   \"listPrice\": " + car.getListPrice() + ",\n" +
//                "   \"downpayment\": " + userInputs.getDownpayment() + "\n" +
//                "}";
//    }
//
//    /**
//     * Make a JSON representation of the relevant user data needed for getting a credit score.
//     *
//     * @param userInputs is all the user inputs from the frontend.
//     * @return a JSON string representation for the CreditScore API.
//     */
//    static String makeCreditInputJSON(GraphingData userInputs) {
//
//        return "{\n" +
//                "   \"address\": \"" + userInputs.getAddress() + "\",\n" +
//                "   \"postalCode\": \"" + userInputs.getPostalCode() + "\",\n" +
//                "   \"city\": \"" + userInputs.getCity() + "\",\n" +
//                "   \"province\": \"" + userInputs.getProvince() + "\",\n" +
//                "   \"dateOfBirth\": \"" + userInputs.getDateOfBirth() + "\",\n" +
//                "   \"sinNumber\": " + userInputs.getSinNumber() + ",\n" +
//                "}";
//    }
//}
