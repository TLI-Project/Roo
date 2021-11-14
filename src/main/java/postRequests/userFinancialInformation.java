package postRequests;

import entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class userFinancialInformation {


    @PostMapping("/userInputs")
    public void userInputs(@RequestBody User user, Map userData) {
        user.setLoanAmount((double) userData.get("loanAmount"));
        user.setCreditScore((int) userData.get("creditScore"));
        user.setPytBudget((double) userData.get("pytBudget"));
        user.setDownpayment((double) userData.get("downpayment"));
    }
}
