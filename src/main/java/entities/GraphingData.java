package entities;

/**
 * GraphingData is all the information needed to send to the Credit Score "API" and the Senso API.
 * It is not yet compatible with the SensoReadyInfo.
 */
public class GraphingData {
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

    public GraphingData(Integer carId, Double loanAmount, Double pytBudget, Double downPayment, String address,
                        String postalCode, String city, String province, String dateOfBirth, Integer sinNumber){
        this.carId = carId;
        this.loanAmount = loanAmount;
        this.pytBudget = pytBudget;
        this.downpayment = downPayment;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.dateOfBirth = dateOfBirth;
        this.sinNumber = sinNumber;
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

    public int getCarId(){
        return carId;
    }

    public int getSinNumber(){
        return this.sinNumber;
    }


}
