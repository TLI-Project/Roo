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
    public void whenSettersAndGetters() {
        User Christopher = new User("Christopher", "password");
        Christopher.setDownpayment(1000);
        Christopher.setPytBudget(400);
        Christopher.setCreditScore(780);
        Christopher.setLoanAmount(20000);

        assertEquals(Christopher.getDownpayment(), 1000);
        assertEquals(Christopher.getPytBudget(), 400);
        assertEquals(Christopher.getCreditScore(), 780);
        assertEquals(Christopher.getLoanAmount(), 20000);
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
