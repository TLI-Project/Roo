package entities;

import adapters.InputAdapter;
import adapters.KeyAdapter;

import java.util.HashMap;
import java.util.Map;

public class User extends Entity{
    /**
     * An entity representing a user of Senso Education.
     */
    private String inputs;
    private final String username;
    private final String password;
    private String APIkey;
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
     * Get the user's inputs.
     * @return an array of the users inputs.
     */
    public String getInputs() {
        return this.inputs;
    }

    /**
     * Set the user's inputs.
     * @param UserInputs is the user data from inputted into the frontend.
     */
    public void setInputs(String[] UserInputs) {
        this.inputs = InputAdapter.convertInputs(UserInputs);
    }

    /**
     * Get the API key associated with the user.
     * @return a string of the API key
     */
    public String getAPIkey(){
        return this.APIkey;
    }

    public void setAPIkey(String[] UserInputs){
        this.APIkey = KeyAdapter.convertKey(UserInputs);
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

//    /**
//     * Change the user's username.
//     * @param username a string of the new username.
//     */
//    public void setUsername(String username) {
//        this.username = username;
//    }

//    /**
//     * Change the user's password.
//     * @param password a string of the new password.
//     */
//    public void setPassword(String password) {
//        this.password = password;
//    }

    /**
     * Return a representation of the User entity
     * @return String with the username and password combo
     */
    @Override
    public String getEntityStr() {
        return "Username: " + this.username + ", Password: " + this.password;
    }
}
