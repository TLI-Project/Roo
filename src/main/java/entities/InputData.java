package entities;


public class InputData extends Entity {
    private final int carId;
    private final double loanAmount;
    private final double pytBudget;
    private final double downpayment;
    private final String address;
    private final String postalCode;
    private final String city;
    private final String province;
    private final String dateOfBirth;
    private final int sinNumber;
    private final int creditScore;

    public <JsonObject> InputData(String inputData){

        this.carId = 0;
        this.loanAmount = 0;
        this.pytBudget = 0;
        this.downpayment = 0;
        this.address = null;
        this.postalCode = null;
        this.city = null;
        this.province = null;
        this.dateOfBirth = null;
        this.sinNumber = 0;
        this.creditScore = generateCreditScore();
    }

    private int generateCreditScore() {
        return (int) ((Math.random() * (800 - 600)) + 600);
    }

    public double getLoanAmount(){
        return this.loanAmount;
    }

    public double getPytBudget(){
        return this.pytBudget;
    }

    public double getDownpayment(){
        return this.downpayment;
    }

    public String getAddress(){
        return this.address;
    }

    public String getPostalCode(){
        return this.postalCode;
    }

    public String getCity(){
        return this.city;
    }

    public String getProvince(){
        return this.province;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public int getCreditScore() {
        return creditScore;
    }
    
    public int getCarId(){
        return carId;
    }

    public int getSinNumber(){
        return this.sinNumber;
    }

    @Override
    public String getEntityStr() {
        return null;
    }
}
