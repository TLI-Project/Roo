package entities;

import java.util.HashMap;
import java.util.Map;

public class User extends Entity{
    /**
     * An entity representing a user of Senso Education.
     */
    private double loanAmount;
    private int creditScore;
    private double pytBudget;
    private double downpayment;
    private final String username;
    private final String password;
    private final Map<Car, LoanResponse> loanOptions;

    /**
     * Initialize a new user with the give username/password combo.
     * @param username is what the user is named
     * @param password is the password to the user's account
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.loanOptions = new HashMap<>();
    }

    /**
     * Get the loan amount the user is willing to pay.
     * @return loan amount.
     */
    public double getLoanAmount(){
        return this.loanAmount;
    }

    /**
     * Set the user's loan amount.
     * @param loanAmount loan amount input by user.
     */
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * Get the credit score of the user.
     * @return the user's credit score (0 - 800)
     */
    public int getCreditScore(){
        return this.creditScore;
    }

    /**
     * TODO make this happen 'fake' automatically
     * @param creditScore the user's credit score.
     */
    public void setCreditScore(int creditScore){
        this.creditScore = creditScore;
    }

    /**
     * Get the monthly payment budget the user is comftorable paying.
     * @return monthly payment budget
     */
    public double getPytBudget(){
        return this.pytBudget;
    }

    /**
     * Set the user's payment budget
     * @param pytBudget monthly payment budget.
     */
    public void setPytBudget(double pytBudget){
        this.pytBudget = pytBudget;
    }

    /**
     * Get the money the user is willing to pay up front for a car.
     * @return the down payment
     */
    public double getDownpayment(){
        return this.downpayment;
    }

    /**
     * Set the user's downpayment.
     * @param downpayment the user's downpayment.
     */
    public void setDownpayment(double downpayment){
        this.downpayment = downpayment;
    }

    /**
     * Add a car/loan pair into the users interested loans.
     * @param car is the car the user is interested in.
     * @param sensoApiResponse is their loan response for that given car.
     */
    public void setLoanOptions(Car car, LoanResponse sensoApiResponse){
        loanOptions.put(car, sensoApiResponse);
    }

    /**
     * Get the user's loan response
     * @return a map of all the car/loan pairs for the given user
     */
    public Map<Car, LoanResponse> getLoanOptions(){
        return this.loanOptions;
    }
    /**
     * Get the user's name.
     * @return a string of the inputted username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the user's password
     * @return a string of the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return a representation of the User entity
     * @return String with the username and password combo
     */
    @Override
    public String getEntityStr() {
        return "Username: " + this.username + ", Password: " + this.password;
    }
}
