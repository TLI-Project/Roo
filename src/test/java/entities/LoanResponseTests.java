//package entities;
//
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class LoanResponseTests {

//    @Test
//    public void creatingLoanResponse(){
//        String[] installments = {"installment1", "installment2"};
//        LoanResponse testLR = new LoanResponse(1, 2, 3, 4,
//                5, 6, installments);
//        assertEquals(testLR.getAmount(), 1);
//        assertEquals(testLR.getInterestSum(), 2);
//        assertEquals(testLR.getCapitalSum(), 3);
//        assertEquals(testLR.getSum(), 4);
//        assertEquals(testLR.getTerm(), 5);
//        assertEquals(testLR.getInterestRate(), 6);
//        assertEquals(testLR.getInstallments(), installments);
//    }
//
//    @Test
//    public void whenExtendingEntity(){
//        String[] installments = {"installment1", "installment2"};
//        LoanResponse testLR = new LoanResponse(1, 2, 3, 4,
//                5, 6, installments);
//        assertEquals(testLR.getEntityStr(), "Sum for LoanResponse: 4.0");
//    }
//}
