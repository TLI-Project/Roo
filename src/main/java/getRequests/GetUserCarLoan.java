package getRequests;

import controllers.sensoAPIController;
import entities.Car;
import entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public class GetUserCarLoan {

    /**
     * Get request that calls the senso api with car/user pair.
     * @param user user requesting the loan.
     * @param car the user is interested in.
     * @return the senso API data.
     * @throws IOException
     * @throws InterruptedException
     */
    @PostMapping("/userCarLoan")
    public String useCarLoan(@RequestBody User user, Car car) throws IOException, InterruptedException {
        return sensoAPIController.getUserCarLoan(user, car);
    }
}
