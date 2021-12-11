package adapter;

import entities.CreditScoreJSON;
import entities.GraphingData;

public class CreditScoreAdapter extends CreditScoreJSON {
    private final GraphingData graphingData;

    public CreditScoreAdapter(GraphingData data){
        this.graphingData = data;
    }

    /**
     * @return a JSON representation of the relevant user data needed for getting a credit score.
     */
    @Override
    public String creditReadyData(){
        return "{\n" +
                "   \"address\": \"" + graphingData.getAddress() + "\",\n" +
                "   \"postalCode\": \"" + graphingData.getPostalCode() + "\",\n" +
                "   \"city\": \"" + graphingData.getCity() + "\",\n" +
                "   \"province\": \"" + graphingData.getProvince() + "\",\n" +
                "   \"dateOfBirth\": \"" + graphingData.getDateOfBirth() + "\",\n" +
                "   \"sinNumber\": " + graphingData.getSinNumber() + ",\n" +
                "}";
    }
}
