package controllers;

import com.TLI2.roo.sensoController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class inputController {

    /**
     * POST that takes a user info and returns the senso API response
     *
     * @param userData the financial information taken from the user.
     * @return the JSON given by the Senso API with the given userData.
     * @throws IOException TODO dont know why it would throw
     * @throws InterruptedException TODO dont know why it would throw
     */
    @PostMapping("/userInputs")
    public String userInputs(@RequestBody String userData) throws IOException, InterruptedException {
        return sensoController.getAPIInputs(userData);
    }
}
