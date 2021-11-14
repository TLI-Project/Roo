package adapters;

public interface InputAdapter {

    public static String convertInputs(String[] inputs) {
        return  convertStrtoJson(inputs);
    }

    private static String convertStrtoJson(String[] inputs){
        return "{\n" +
                "   \"loanAmount\": " + inputs[1] + ",\n" +
                "   \"creditScore\": " + inputs[2] + ",\n" +
                "   \"pytBudget\": " + inputs[3] + ",\n" +
                "   \"vehicleMake\": \"Honda\",\n" +
                "   \"vehicleModel\": \"Civic\",\n" +
                "   \"vehicleYear\": 2021,\n" +
                "   \"vehicleKms\": 1000,\n" +
                "   \"listPrice\": " + inputs[5] + ",\n" +
                "   \"downpayment\": " + inputs[6] + "\n" +
                "}";
    }
}
