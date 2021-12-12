package services;

import entities.GraphingData;
import gateways.CarAccessSql;
import interfaces.CarAccessInterface;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SensoReadyInfoTests {
    @Test
    public void whenGettingUserLoanRequest() throws IOException, InterruptedException {
        GraphingData graphingData = new GraphingData(1, 2000.0, 2000.0, "address",
                "postal Code", "city", "province", "dateofbirth", 123123);
        CarAccessInterface carAccessInterface = new CarAccessSql();
        SvcCarDataProcess carDataProcess = new SvcCarDataProcess();

        String test = SvcSensoReadyInfo.userCarLoanRequest(graphingData, carAccessInterface, carDataProcess);

        // can't really compare test because creditScore is random
        assertNotNull(test);
    }

}
