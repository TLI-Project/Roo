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
     * @param userCreationData the inputted user data (fullname, username, password).
     * @throws IOException
     * @throws InterruptedException
     */
    @PostMapping("/userCreation")
    public void userInputs(@RequestBody String[] userCreationData) throws IOException, InterruptedException {
//        try {
//            User placeholder = new User(userCreationData[1], userCreationData[2]);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
