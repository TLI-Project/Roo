package services;

import entities.Car;
import gateways.CarAccessSql;
import interfaces.CarAccessInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SvcCarDataProcessTest {

    @Test
    public void testGetAllCars() {
        SvcCarDataProcess svcCarDataProcess = new SvcCarDataProcess();
        CarAccessInterface carAccessInterface = new CarAccessSql();

        ArrayList<Car> cars = svcCarDataProcess.getAllCars(carAccessInterface);

        assertEquals(cars.get(1).getCarDescription(), "More than a commanding view of the road ahead, the GLA offers a rewarding view of what's next. It not only puts more sport in compact SUVs, it puts more you. Within its nimble length, the GLA gives you more space to ride, more room to shop, stow and be spontaneous. A wide tailgate and 40/20/40 rear seats welcome your gear. A pair of 7-inch screens help keep you informed, entertained and in command. One's for gauges, one's a touchscreen. Available 10.25-inch versions let you visualize, and customize, even more. A spectrum of finishes is just the start of GLA style. The Sport Package adds sporty pedals, seats and steering wheel. Available 64-colour ambient lighting lets you choose the hues that suit your mood. Show how you roll on 18, 19 or 20-inch wheels. The Sport Package includes a chrome grille, 19-inch AMG wheels and more. Or take it the dark side with the Night Package. Even a compact Mercedes-Benz goes big on luxury. The driver seat is power with memory. Climate control is dual-zone and double-filtered. And with a standard Panoramic sunroof, even the sky feels bigger. From a tight corner of the city, to a tight corner of a back road, the GLA is agile and easy to maneuver. Turbo power and a solid stance make it quick on its feet, confident in your hands. Agility starts with a 4-wheel independent suspension. Each wheel tackles bumps on its own for composed comfort, but they're all in for crisp handling. The GLA 250's advanced engine delivers 221 turbo horses from a compact 2.0 litres. Its 258 lb-ft of torque is at your command over a wide range of rpm, for quick response anytime. The dual-clutch 8-speed is a quicker, smoother automatic, or a paddle-shifted manual on demand. With DYNAMIC SELECT, one console control calls up a range of performance profiles. Light, nimble variable-torque 4MATIC can send power from front wheels to rear based on each tire's real-time grip. A suite of available engineering features heightens off-road capability. People are talking. The Mercedes-Benz User Experience (MBUX) is truly user-friendly tech. Its natural, intuitive speech interface is easy to learn because it can learn you. Along with its own intelligent voice assistant, Apple CarPlay� and Android Auto are also available. Mercedes me connect makes ownership easy. Remote-start, lock or check your car, or book service, all from your phone. And add in-car WiFi for up to eight devices for a low monthly rate. Say 'Hey, Mercedes, it's cold in here' or 'I need a coffee,' and MBUX can control many features with its intelligent voice assistant. Among them, available MB Navigation can help you find places more easily. Advanced options help de-stress driving: Tap a turn signal to make a lane change. Adaptive cruise can help steer, slow for exits, or stop-and-go in traffic. Advanced sensors can even alert you to cross-traffic in your path.");
    }

    @Test
    public void testGetCarById() {
        SvcCarDataProcess svcCarDataProcess = new SvcCarDataProcess();
        CarAccessInterface carAccessInterface = new CarAccessSql();

        Car car = svcCarDataProcess.getCarById(5, carAccessInterface);

        assertEquals(car.getListPrice(), 63200);
    }

}
