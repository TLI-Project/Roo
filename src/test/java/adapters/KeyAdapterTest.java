package adapters;

import entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyAdapterTest {

    /**
     * Test that setting an input converts the String array to a JSON formatted string for the Senso API to read.
     */
    @Test
    public void whenConvertingInputToUserAPIKey_thenSuccessfullyConverted() {
        User Christopher = new User("Christopher", "password");
        Christopher.setAPIkey(new String[]{Christopher.getUsername(), "1", "2", "3", "API-key", "5", "6"});
        assertEquals("API-key", Christopher.getAPIkey());
    }
}
