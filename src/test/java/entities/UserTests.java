package entities;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    /**
     * Test that construction of a User works as intended.
     */
    @Test
    public void whenCreatingUser() {
        User Christopher = new User("Christopher", "password");
        assertEquals(Christopher.getUsername(), "Christopher");
        assertEquals(Christopher.getPassword(), "password");
    }

    @Test
    public void whenSettingUserInputs(){
        User Christopher = new User("Christopher", "password");
        Christopher.setInputs(new String[]{Christopher.getUsername(), "1", "2", "3", "API-key", "5", "6"});
        assertEquals(Christopher.getInputs(), "{\n" +
                "   \"loanAmount\": 1,\n" +
                "   \"creditScore\": 2,\n" +
                "   \"pytBudget\": 3,\n" +
                "   \"vehicleMake\": \"Honda\",\n" +
                "   \"vehicleModel\": \"Civic\",\n" +
                "   \"vehicleYear\": 2021,\n" +
                "   \"vehicleKms\": 1000,\n" +
                "   \"listPrice\": 5,\n" +
                "   \"downpayment\": 6\n" +
                "}");
    }

    @Test
    public void whenSettingAPIKey(){
        User Christopher = new User("Christopher", "Password");
        Christopher.setAPIkey(new String[]{Christopher.getUsername(), "1", "2", "3", "API-key", "5", "6"});
        assertEquals(Christopher.getAPIkey(), "API-key");
    }

    @Test
    public void whenSettingLoanOptions(){
        String[] installments = {"installment1", "installment2"};
        LoanResponse testLR = new LoanResponse(1, 2, 3, 4,
                5, 6, installments);
        Feature rustProofing = new Feature("rust proofing", 1, "it proofs rust");
        Map<String, Feature> testFeatures = new HashMap<String, Feature>();
        testFeatures.put(rustProofing.getName(), rustProofing);
        Car testCar = new Car("model", "make", 10, 2021, 0, testFeatures);
        User Christopher = new User("Christopher", "Password");
        Christopher.setLoanOptions(testCar, testLR);
        Map<Car, LoanResponse> actualLO = new HashMap<>();
        actualLO.put(testCar, testLR);
        assertEquals(Christopher.getLoanOptions(), actualLO);
    }

    @Test
    public void whenExtendingEntity(){
        User Christopher = new User("Christopher", "password");
        assertEquals(Christopher.getEntityStr(), "Username: Christopher, Password: password");
    }
}
