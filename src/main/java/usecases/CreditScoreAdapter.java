package usecases;

import interfaces.CreditScoreJsonInterface;

/**
 * Adapt user information to the credit score.
 */
public class CreditScoreAdapter implements CreditScoreJsonInterface {
    private final String address;
    private final String postalCode;
    private final String city;
    private final String province;
    private final String dateOfBirth;
    private final int sinNumber;

    /**
     * Initialize the Credit Score Adapter for the credit score API body.
     * @param address is the user's address.
     * @param postalCode is the user's postal code.
     * @param city is the user's city they are residing in.
     * @param province is the province the user lives in.
     * @param dateOfBirth is the date of birth of the user.
     * @param sinNumber is the social insurance number of the user.
     */
    public CreditScoreAdapter(String address, String postalCode, String city, String province,
                              String dateOfBirth, int sinNumber){
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.dateOfBirth = dateOfBirth;
        this.sinNumber = sinNumber;
    }

    /**
     * @return a JSON representation of the relevant user data needed for getting a credit score.
     */
    public String creditReadyData(){
        return "{\n" +
                "   \"address\": \"" + address + "\",\n" +
                "   \"postalCode\": \"" + postalCode + "\",\n" +
                "   \"city\": \"" + city + "\",\n" +
                "   \"province\": \"" + province + "\",\n" +
                "   \"dateOfBirth\": \"" + dateOfBirth + "\",\n" +
                "   \"sinNumber\": " + sinNumber + ",\n" +
                "}";
    }
}
