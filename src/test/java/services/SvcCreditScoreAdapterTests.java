package services;

import entities.GraphingData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SvcCreditScoreAdapterTests {

    @Test
    public void testGetCreditReadyData() {
        GraphingData graphingData = new GraphingData(1, 2000.0, 2000.0, "address",
                "postal Code", "city", "province", "dateofbirth", 123123);

        SvcCreditScoreAdapter svcCreditScoreAdapter = new SvcCreditScoreAdapter(graphingData);

        String test = svcCreditScoreAdapter.creditReadyData();

        assertEquals(test, "{\n" +
                "   \"address\": \"address\",\n" +
                "   \"postalCode\": \"postal Code\",\n" +
                "   \"city\": \"city\",\n" +
                "   \"province\": \"province\",\n" +
                "   \"dateOfBirth\": \"dateofbirth\",\n" +
                "   \"sinNumber\": 123123,\n" +
                "}");

    }
}
