package App;

import Database.carDataProcess;
import entities.Car;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class CarDataController {
    /**
     * Get request that asks for all the cars available.
     * @return a list of all the car objects that contain their metadata.
     */
    @PostMapping("/carMetaData")
    public HashMap<Integer, String> carMetaData(){
        carDataProcess carController = new carDataProcess();
        HashMap<Integer, String> allCarMetaData = new HashMap<Integer, String>();
        for (Car car : carController.getAllCars()){
            allCarMetaData.put(car.id, makeCarJSON(car));
        }
        return allCarMetaData;
    }

    /**
     * Get request that asks for a certain car.
     * @param id the ID of the car you are looking for.
     * @return The car entity you are looking for
     */
    @PostMapping("/carDetails")
    public String carDetails(@RequestBody int id){
        carDataProcess carController = new carDataProcess();
        Car car = carController.getCarById(id);
        return makeCarJSON(car);
    }

    @PostMapping("/userCarLoan")
    public String userCarLoan(){
        carDataProcess carController = new carDataProcess();
        Car car = carController.getCarById(1);
        return makeCarJSON(car);
    }

    /**
     * Turn a car into something that the frontend can recieve and work with.
     * @param car is the car you want to turn into a JSON.
     * @return a JSON representation of the car.
     */
    @NotNull
    private String makeCarJSON(Car car) {
        return "{\n" +
                "   \"id\": " + car.id + ",\n" +
                "   \"carMake\": \"" + car.carMake + "\",\n" +
                "   \"carModel\": \"" + car.carModel + "\",\n" +
                "   \"listPrice\": " + car.listPrice + ",\n" +
                "   \"year\": \"" + car.year + "\",\n" +
                "   \"kms\": " + car.kms + ",\n" +
                "   \"color\": \"" + car.color + "\",\n" +
                "   \"depreciation\": \"" + car.listPrice + "\",\n" +
                "   \"imageURL\": \"" + car.imageURL + "\"\n" +
                "}";
    }

    @GetMapping("/test")
    public String test(){
        return "{\"working\": 1}";
    }

}
