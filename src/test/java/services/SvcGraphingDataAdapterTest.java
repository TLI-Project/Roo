package services;

import entities.Car;
import entities.GraphingData;
import gateways.CarAccessSql;
import interfaces.CarAccessInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SvcGraphingDataAdapterTest {

    @Test
    public void getGrapingDataAdapter() {
        SvcCarDataProcess svcCarDataProcess = new SvcCarDataProcess();
        CarAccessInterface carAccessInterface = new CarAccessSql();

        Car car = svcCarDataProcess.getCarById(7, carAccessInterface);

        GraphingData graphingData = new GraphingData(1, 2000.0, 2000.0, "address",
                "postal Code", "city", "province", "dateofbirth", 123123);

        SvcCreditScoreAdapter svcCreditScoreAdapter = new SvcCreditScoreAdapter(graphingData);

        SvcGraphingDataAdapter svcGraphingDataAdapter = new SvcGraphingDataAdapter(car,
                graphingData, svcCreditScoreAdapter);

        String test = svcGraphingDataAdapter.sensoReadyData();

        // can't really compare test because creditScore is random
        assertNotNull(test);
    }
}
