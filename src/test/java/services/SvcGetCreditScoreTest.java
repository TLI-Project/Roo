package services;

import org.junit.jupiter.api.Test;

import static java.lang.Math.signum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SvcGetCreditScoreTest {

    @Test
    public void testPingCreditScoreAPI() {
        SvcGetCreditScore svcGetCreditScore = new SvcGetCreditScore();
        int test = svcGetCreditScore.pingCreditScoreAPI("inputs");
        int neg = test - 801;
        int pos  = test - 599;

        assertEquals(signum(neg), -1);
        assertEquals(signum(pos), 1);

    }
}
