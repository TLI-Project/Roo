package App;

import Database.carDataProcess;
import entities.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
public class ApiController {
    /**
     * Get request that asks for all the cars available.
     * @param test nothing necessary?
     * @return a list of all the car objects that contain their metadata.
     */
    @PostMapping("/carMetaData")
    public ArrayList<Car> carMetaData(@RequestBody int test){
        carDataProcess carController = new carDataProcess();
        return carController.getAllCars();
    }

    /**
     * Get request that asks for a certain car.
     * @param id the ID of the car you are looking for.
     * @return The car entity you are looking for
     */
    @PostMapping("/carDetails")
    public String carDetails(@RequestBody int id){
        carDataProcess carController = new carDataProcess();
        Car temp = carController.getCarById(id);
        return "{\"working\": \""+temp+"\"}";
    }

    @GetMapping("/test")
    public String test(){
        return "{\"working\": 1}";
    }

}
