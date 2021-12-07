//package postRequests;
//
//// TODO: is this a type of controller?
//
//import entities.User;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//import static constants.Indexes.*;
//
//@RestController
//public class userFinancialInformation {
//
//    /**
//     * Take the finances the user input into the website and add them to their account.
//     * @param user is the user who is inputiting finances
//     * @param financialData is in the form ["loanAmount", "creditScore", "pytBudget", "downpayment"]
//     * @throws IOException
//     * @throws InterruptedException
//     */
//    @PostMapping("/addUserFinances")
//    public void addUserFinances(@RequestBody User user, String[] financialData) throws IOException, InterruptedException {
//        saveFinancesToUser(user, financialData);
//    }
//
//    /**
//     * Save the users financial information.
//     * @param user is the user who's financial information it is.
//     * @param financialData is the ysers financial data they inputted into the frontend.
//     */
//    private void saveFinancesToUser(User user, String[] financialData) {
//        user.setLoanAmount(Double.parseDouble(financialData[LOAN_INDEX]));
//        user.setCreditScore(Integer.parseInt(financialData[CREDIT_INDEX]));
//        user.setPytBudget(Double.parseDouble(financialData[PYT_INDEX]));
//        user.setDownpayment(Double.parseDouble(financialData[DOWN_INDEX]));
//    }
//
//}
