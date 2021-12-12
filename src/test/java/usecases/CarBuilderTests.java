package usecases;

import entities.Car;
import gateways.CarSqlDataAccess;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarBuilderTests {

    CarSqlDataAccess dataConnection = new CarSqlDataAccess();
    ResultSet carSet = dataConnection.getCar(1);


    @Test
    public void whenCarBuilderModel() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getCarModel(), "GLS 450 4MATIC SUV");
    }

    @Test
    public void whenCarBuilderID() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getCarId(), 1);
    }

    @Test
    public void whenCarBuilderMake() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getCarMake(), "S-Class");
    }

    @Test
    public void whenCarBuilderKms() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getKms(), 0);
    }

    @Test
    public void whenCarBuilderListPrice() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getListPrice(), 101900);
    }

    @Test
    public void whenCarBuilderDescription() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getCarDescription(), "In an ever-more-crowded field of luxury SUVs, treat yourself to some room. The sleek, spacious GLS wraps class-leading innovations in bold yet elegant style. With a long wheelbase for more legroom and a smoother ride, the GLS lets you live large without the bulky driving experience. It's chiseled and muscular, yet polished and agile. 100% LED lighting adds to its brilliance. Widescreen displays and perhaps the industry's most advanced visual, voice and touch interfaces help the GLS feel quickly like second nature. Exquisite craftsmanship envelops you in timeless luxury. From 64 colours of ambient lighting to heated seats and armrests in the first two rows, the GLS lets everyone in on the Star treatment. Available luxuries include four ventilated and massaging seats, and 5-zone climate control. GLS wheels start at a sizable 21 inches and only go up from there, all the way to 23 inches. The GLS 580's standard AMG styling is available in the GLS 450 Sport Package. Both offer a Night Package with gloss black styling elements. The GLS offers truly luxurious seating for seven adults, standard. A 6-seater layout with power 2nd-row captain's chairs is also available. The Premium Rear Seating Package can make the rear cabin of the GLS 580 even more accommodating. Using Artificial Intelligence, MBUX can turn your words into your GLS's action. Just say 'Hey, Mercedes, it's cold in here' or 'I need a coffee,' and MBUX can warm the cabin or set the standard MB Navigation. It can even learn your habits, and new phrases. Available new ENERGIZING Comfort networks front-seat heating, ventilation and massage with ambient light and sound, to help rejuvenate your body and spirit as you drive. Ionizer-purified air can be subtly infused with fragrance. It's a sensation for every sense. A big 3,500kg towing capacity is just one of the GLS's superhuman abilities. Available tech lets it spot a traffic jam and help you negotiate it with ease. Change lanes with the tap of a turn signal. Or help protect your ears in a crash. Mercedes me connect puts a world of remote features, from starting to locking its doors to scheduling service, in a handy smartphone app. And standard augmented video can overlay your next navigation instruction on a live view of the turn itself. GLS capability has many dimensions, but they all aim to outmeasure any other large luxury SUV. Rigid standards create a flexible vehicle that's spacious yet agile. At home on a trail, with a trailer, or coddling you in its fine tailoring. Born to be an SUV, not bred from a pickup truck, the GLS independent air suspension helps the roomy third row offer first-rate comfort. The standard power second row, available to seat three or two, also helps make 3rd-row access easy. The GLS 580 Premium Rear Seating Package treats 2nd-row passengers to exclusive luxuries from headrest pillows to ventilation and a massage. The large center armrest features a wireless tablet to control a variety of rear-cabin comfort features. Both the 362-hp GLS 450 turbo inline-6 and the GLS 580's 483-hp biturbo V8 offer advanced tech and abundant torque. Now with EQ Boost electrification, their Integrated Starter-Generator can also add 21 hp, or allow gas-free coasting and lower emissions. With nine speeds, the advanced 9G-TRONIC automatic transmission offers a versatile range of ratios, for quick response and efficient, quiet cruising. Fingertip shift paddles and the modes of DYNAMIC SELECT let you take charge anytime. With standard multimode, height-adjusting AIRMATIC suspension and fully variable 4MATIC all-wheel drive, the GLS puts its best foot forward even as seasons and surfaces challenge it. Available E-ACTIVE BODY CONTROL can camera-scan the road ahead, lean into curves, and even rock the GLS 580 out of a sand trap.");
    }

    @Test
    public void whenCarBuilderYear() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getYear(), 2021);
    }

    @Test
    public void whenCarBuilderColor() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getColor(), "Black");
    }

    @Test
    public void whenCarBuilderCondition() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getCondition(), "new");
    }

    @Test
    public void whenCarBuilderImageURL() throws SQLException {
        carSet.next();
        CarDirector carBuilder = new CarDirector(carSet);
        Car testCar = carBuilder.makeCarEntity();
        assertEquals(testCar.getImageURL(), "\"https://nafta.starconnect-ce.i.daimler.com/iris/iris.jpg?COSY-EU-100-1713d0VXqaSFqtyO67PobzIr3eWsrrCsdRRzwQZQ9vZbMw3SGtlKUtsd2HTcUfp8fXGEuiRJ0l3ItOB2NQnbApjdpI5uVcZQC31CrkzNBzkm7jAymhKV5%25t%25vq4t9yLRgLyYaxPa9rH1eMrn8wsQfoiZUMNM4FnSlTg95zT6PDC7uSeWHmItsd8J3cUfiOqXGE4TSJ0lg6lOB2PS5bApeIoI5usKxQC3UvOkzNGLdm7ju6ohKV3SQ%25vqNJoyLRjSfYax4JOroYhfldTxbApPAlI5uge1QC3ACWkzN5lNm7jK6ShKVvKQ%25vqLvcyLRaGmYaxHrWrHAlGqhTWFEnlACBepl1JnwxV449pTuZkwuoQ3pE7EJxJeRB5PVsRiD4K8K5ApvGBu6&&fb=1&BKGND=12&IMGT=A27&POV=be040%2Cpzm&crop=70,100,1850,1000&width=1440&height=600\"");
    }


}
