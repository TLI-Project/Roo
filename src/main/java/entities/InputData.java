package entities;


public class InputData extends Entity {
    public final int carId;
    public final double loanAmount;
    public final double pytBudget;
    public final double downpayment;
    private final String address;
    private final String postalCode;
    private final String city;
    private final String province;
    private final String dateOfBirth;
    private final int sinNumber;
    private final int creditScore;

    public <JsonObject> InputData(String inputData){

        this.carId = carId;
        this.loanAmount = loanAmount;
        this.pytBudget = pytBudget;
        this.downpayment = downpayment;
        this.address = ;
        this.postalCode = ;
        this.city = ;
        this.province = ;
        this.dateOfBirth = ;
        this.sinNumber = ;
        this.creditScore = generateCreditScore();
    }

    private int generateCreditScore() {
        return (int) ((Math.random() * (800 - 600)) + 600);
    }

    public int getCreditScore() {
        return creditScore;
    }

    @Override
    public String getEntityStr() {
        return null;
    }
}
