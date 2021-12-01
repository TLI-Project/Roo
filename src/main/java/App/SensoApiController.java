//package App;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.Map;
//
//
//import static getRequests.getUserCarLoan.userCarLoanRequest;
//
//@RestController
//public class SensoApiController {
//
//    /**
//     * Get request that calls the senso api with car/user pair.
//     * @return the senso API data.
//     * @throws IOException
//     * @throws InterruptedException
//     */
//    @PostMapping("/userCarLoan")
//    public String userCarLoan() throws IOException, InterruptedException {
//        return "{\"test\": working}";
////        return "{\n" +
////                "   \"id\": " + loanAmount + ",\n" +
////                "   \"carMake\": \"" + loanAmount + "\",\n" +
////                "   \"carModel\": \"" + loanAmount + "\",\n" +
////                "   \"listPrice\": " + creditScore + ",\n" +
////                "   \"year\": \"" + creditScore + "\",\n" +
////                "   \"kms\": " + creditScore + ",\n" +
////                "   \"color\": \"" + creditScore + "\",\n" +
////                "   \"depreciation\": \"" + creditScore + "\",\n" +
////                "   \"imageURL\": \"" + creditScore + "\"\n" +
////                "}";
//
////        return userCarLoanRequest(loanAmount, creditScore, pytBudget, carID, downpayment);
//    }
//}
