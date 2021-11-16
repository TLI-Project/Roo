package adapters;

import entities.Car;
import entities.Feature;
import entities.User;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputAdapterTest {

    @Test
    public void whenCreatingJSONInput(){
        User Christopher = new User("Christopher", "password");
        Christopher.setDownpayment(6);
        Christopher.setPytBudget(3);
        Christopher.setCreditScore(2);
        Christopher.setLoanAmount(1);
        Feature rustProofing = new Feature("rp", 10, "proofing rust");
        Map<String, Feature> testFeatures = new HashMap<String, Feature>();
        testFeatures.put(rustProofing.getName(), rustProofing);
        Car Beatle = new Car("model", "make", 5, 2000, 0, testFeatures);
        assertEquals(apiInputAdapter.makeInputJSON(Christopher, Beatle), "{\n" +
                "   \"loanAmount\": 1.0,\n" +
                "   \"creditScore\": 2,\n" +
                "   \"pytBudget\": 3.0,\n" +
                "   \"vehicleMake\": \"make\",\n" +
                "   \"vehicleModel\": \"model\",\n" +
                "   \"vehicleYear\": 2000,\n" +
                "   \"vehicleKms\": 0.0,\n" +
                "   \"listPrice\": 5.0,\n" +
                "   \"downpayment\": 6.0\n" +
                "}");
    }
}
