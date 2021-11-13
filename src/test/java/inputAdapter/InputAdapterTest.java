package inputAdapter;

import entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputAdapterTest {

    /**
     * Test that setting an input converts the String array to a JSON formatted string for the Senso API to read.
     */
    @Test
    public void whenConvertingInputStrToInputJSON_thenSuccessfullyConverted() {
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
}
