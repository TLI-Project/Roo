package services;

import entities.Car;
import interfaces.CarAccessInterface;

import java.util.ArrayList;

public class SvcCarDepreciation {

    public String getCarDepreciation(int id,
                                     SvcCarDataProcess svcCarDataProcess,
                                     CarAccessInterface carAccessInterface) {
        Car car = svcCarDataProcess.getCarById(id, carAccessInterface);
        return jsonCarDepreciation(id, car.getDepreciation());
    }

    /**
     * HELPER: make a JSON representation of car depreciation for the frontend.
     * @param id is the ID of the car
     * @param depreciation is the depreciation of the car
     * @return a JSON representation of the car's depreciation
     */
    private String jsonCarDepreciation(int id, ArrayList<Double> depreciation) {
        // could this be an adapter? I guess? Is that way overkill? Yes.
        return "{\n" +
                "   \" " + id + " \": " + depreciation + "\n" +
                "}";
    }
}
