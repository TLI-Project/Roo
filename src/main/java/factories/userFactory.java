package factories;

import entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class userFactory {
    /**TODO Anna
     * Create a new user when they sign up for Senso Education.
     * @throws IOException
     * @throws InterruptedException
     */
    @PostMapping("/userCreation")
    public void userInputs(@RequestBody String username, String password, String fullname) throws IOException, InterruptedException {
        User TODO = new User(username, password);
    }
}
