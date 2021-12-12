package services;


import entities.GraphingData;

/**
 * Adapt user information to the credit score.
 */
public class SvcCreditScoreAdapter {
    private final String address;
    private final String postalCode;
    private final String city;
    private final String province;
    private final String dateOfBirth;
    private final int sinNumber;

    /**
     * Initialize the Credit Score Adapter for the credit score API body.
     */
    public SvcCreditScoreAdapter(GraphingData graphingData){
        this.address = graphingData.getAddress();
        this.postalCode = graphingData.getPostalCode();
        this.city = graphingData.getCity();
        this.province = graphingData.getProvince();
        this.dateOfBirth = graphingData.getDateOfBirth();
        this.sinNumber = graphingData.getSinNumber();
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
