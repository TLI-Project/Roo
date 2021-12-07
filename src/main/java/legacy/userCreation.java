//package postRequests;
//
//import entities.User;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RestController
//public class userCreation {
//
//    /**
//     * Create new user on User sign up for Senso Education.
//     * @param username is a unique username
//     * @param password is the password to the user's account
//     * @param fullname is the user's full name.
//     * @throws IOException
//     * @throws InterruptedException
//     */
//    @PostMapping("/createNewUser")
//    public void addNewUser(@RequestBody String username, String password, String fullname)
//            throws IOException, InterruptedException {
//        User some_ID_system = new User(username, password);
//        some_ID_system.setFullname(fullname);
//    }
//}
