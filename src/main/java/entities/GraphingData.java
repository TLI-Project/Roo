package entities;

import services.SvcCreditScoreAdapter;
import services.SvcGetCreditScore;

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

    /**
     * Initialize a GraphingData data set with all the users inputted information from the frontend.
     */
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

//    /**
//     * @return the credit score given the user inputted data.
//     */
//    public int getCreditScore(){
//
//        // Adapt the User's inputted information to fit the credit score API body
//        SvcCreditScoreAdapter creditDataAdapter = new SvcCreditScoreAdapter(address, postalCode, city,
//                province, dateOfBirth, sinNumber);
//        String creditInputJson = creditDataAdapter.creditReadyData();
//
//        // Call the credit score "API" and return its result
//        SvcGetCreditScore csc = new SvcGetCreditScore();
//        return csc.pingCreditScoreAPI(creditInputJson);
//    }

    /**
     * @return the user loan amount.
     */
    public double getLoanAmount(){
        // could probably calculate this later if we added together the list price of the car, price of each feature,
        // and subtracted their downpayment.
        return this.loanAmount;
    }

    /**
     * @return the user paymeny budget.
     */
    public double getPytBudget(){
        return this.pytBudget;
    }

    /**
     * @return the user's downpayment
     */
    public double getDownpayment(){
        return this.downpayment;
    }

    /**
     * @return the car ID for this graphing data set.
     */
    public int getCarId(){
        return carId;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getSinNumber() {
        return sinNumber;
    }
}
