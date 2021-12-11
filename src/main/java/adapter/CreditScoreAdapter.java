package adapter;

import interfaces.CreditScoreJsonInterface;

public class CreditScoreAdapter implements CreditScoreJsonInterface {
    private final String address;
    private final String postalCode;
    private final String city;
    private final String province;
    private final String dateOfBirth;
    private final int sinNumber;

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
