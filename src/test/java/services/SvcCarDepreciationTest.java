package services;

import gateways.CarAccessSql;
import interfaces.CarAccessInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SvcCarDepreciationTest {


    @Test
    public void getCarDepreciationTest() {
        SvcCarDepreciation svcCarDepreciation = new SvcCarDepreciation();
        SvcCarDataProcess svcCarDataProcess = new SvcCarDataProcess();
        CarAccessInterface carAccessInterface = new CarAccessSql();

        String depreciationTest = svcCarDepreciation.getCarDepreciation(1, svcCarDataProcess, carAccessInterface);
        assertEquals(depreciationTest, "{\n" +
                "   \" " + 1 + " \": " + "[0.86, 0.77, 0.71, 0.69, 0.61, 0.55, 0.47, 0.43, 0.32, 0.29]" + "\n" +
                "}");

    }
}
