package entities;

import usecases.CreditScoreAdapter;
import controllers.CreditScoreController;

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

    /**
     * @return the credit score given the user inputted data.
     */
    public int getCreditScore(){

        // Adapt the User's inputted information to fit the credit score API body
        CreditScoreAdapter creditDataAdapter = new CreditScoreAdapter(address, postalCode, city,
                province, dateOfBirth, sinNumber);
        String creditInputJson = creditDataAdapter.creditReadyData();

        // Call the credit score "API" and return its result
        CreditScoreController csc = new CreditScoreController();
        return csc.pingCreditScoreAPI(creditInputJson);
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

    public int getCarId(){
        return carId;
    }

}
