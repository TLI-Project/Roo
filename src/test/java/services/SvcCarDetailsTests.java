package services;

import gateways.CarAccessSql;
import interfaces.CarAccessInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SvcCarDetailsTests {

    @Test
    public void getCarDetailsTests() {
        SvcCarDetails svcCarDetails = new SvcCarDetails();
        SvcCarDataProcess svcCarDataProcess = new SvcCarDataProcess();
        CarAccessInterface carAccessInterface = new CarAccessSql();
        SvcCarToJsonRequestAdapter svcCarToJsonRequestAdapter = new SvcCarToJsonRequestAdapter();

        String t = svcCarDetails.getCarDetails(10, svcCarDataProcess, carAccessInterface, svcCarToJsonRequestAdapter);

        assertEquals(t, "{\n" +
                "   \"id\": 10,\n" +
                "   \"carModel\": \"Mercedes-AMG G 63 SUV\",\n" +
                "   \"carMake\": \"G-Class\",\n" +
                "   \"carDescription\": \"What makes an icon iconic? When it follows only its own moral compass. When design is shaped by its capability. When its sense of adventure is unwavering. And when it's forever timeless, and ready for what's next. Modern components carry character that defies aging. Time-proven, beloved door handles feel bank-vault precise. And lead to a spacious, state-of-the-art, and artfully furnished cabin. Exquisitely crafted, almost entirely by hand, the G advances without abandoning its principles. Appointments range from natural woods to 64-colour LED ambient lighting. Paint and trim options offer over a million possible combinations. Familiar details march forward. Classic round headlamps integrate active LED technology. The sunroof is heat-rejecting glass. And the roomiest G yet is more manoeuvrable, off-road or in town. The cabin offers generous space for your buddies, belongings, even your beverages. Options include a huge range of hand-fitted leathers and a 'hot stone' massage. Acoustic glass and 3-zone climate control are standard. Dozens of gloss and matte paints, numerous 19- and 20-inch wheels, and a range of styling options start your G-Class adventure as it's crafted. Where you take it is up to you. After four decades of conquering terrain on every continent, the G-Class journey advances. Along with its signature 4-wheel drive and three lockable differentials, virtually every measure of its off-road ability, from climbing to fording depth, is exceptional. An independent double-wishbone front suspension, rigid rear axle and electric power steering sharpen on-road precision, off-road capability and comfort anywhere. Multimode damping is available. Generating 416 hp and 450 lb-ft of torque, the advanced biturbo V8 can rush you to 100 in 5.9 seconds. Along with numerous racing-derived features, it can seamlessly deactivate cylinders to save fuel. The sporty, smooth 9-speed transmission teams with a 2-speed transfer case for one of the industry's widest gear spans. DYNAMIC SELECT drive modes let you fine-tune the G's performance. Within the timeless body is a state-of-the-art cockpit, with dual 12.3-inch displays, intuitive steering-wheel Touch Controls, and voice control for the navigation, audio and numerous comfort features. Suit your mood, or start a new one: Multizone LED ambient lighting lets you choose among 64 colours, with themes featuring two, five, or even slowly changing hues. Classically shaped, highly advanced MULTIBEAM LED headlamps adapt to darkness, curves and vehicles ahead. LED Daytime Running Lamps encircle them. Vehicle lighting inside and out is 100% LED. Standard driver assists include Active Brake Assist, Blind Spot Assist, Active Lane Keeping Assist, Active Distance Assist DISTRONIC cruise control, and Traffic Sign Assist. Mercedes me connect puts a world of remote features, from starting to door-locking to scheduling service, in a handy smartphone app. You can also add in-car WiFi for a low monthly rate.\",\n" +
                "   \"listPrice\": 211900.0,\n" +
                "   \"year\": \"2021\",\n" +
                "   \"kms\": 0.0,\n" +
                "   \"color\": \"G manufaktur Diamond White metallic\",\n" +
                "   \"condition\": \"new\",\n" +
                "   \"depreciation\": [0.92, 0.9, 0.83, 0.74, 0.71, 0.64, 0.6, 0.53, 0.47, 0.63],\n" +
                "   \"imageURL\": \"https://nafta.starconnect-ce.i.daimler.com/iris/iris.jpg?COSY-EU-100-1713d0VXqbWFqtyO67PobzIr3eWsrrCsdRRzwQZYkpZbMw3SGtByStsdB%25ycJtTjqNbdYax4jhrH1sg%25n8wFIyoiZ9J1M4FDPwTg9Wek6PDwPNSeWZnjtsdF%25QcUf9c6XGEDBdJ0lIHxOB2QTnbApkfyI5ug6DQC3PQrkzN5Sum7jocShKVftt%25vqESkyLR%25K6YaxhrxrH1lMrn8w2Q3oiZpQYM4FunQTg9FYn6PDt7pSeWyGhtsLV79MOuljcVnHjawUdhcfWF002ROxEnfxXr1RjijhWh5DvaAFCDGp04U4aLRg7vxb&&fb=1&BKGND=13&IMGT=A27&POV=be040%2Cpzm&crop=70,100,1850,1000&width=1440&height=600\",\n" +
                "   \"interior\": \"AMG Performance steering wheel in Nappa/DINAMICA, AMG Performance steering wheel in Black Piano Lacquer/leather, AMG Performance steering wheel in DINAMICA/Carbon Fibre, AMG DRIVE UNIT, Red seat belts\",\n" +
                "   \"interiorDescription\": \"Hand-sewn Black Nappa leather teams with racing-inspired DINAMICA side grips to enhance the feeling of rewarding control and responsive connection of the AMG Performance steering wheel. Hand-sewn, embossed Nappa leather side grips are accented with hand-finished G manufaktur Black Piano Lacquer to complement the matching cabin trim options. A Nappa leather 12 o'clock band is a luxuriously racy touch. Racing-inspired DINAMICA microsuede side grips are paired with carbon fibre inserts at the top and flattened bottom of the AMG Performance steering wheel. It's an ideal complement to the AMG Carbon Fibre or G manufaktur Black Piano Lacquer cabin trim. A DINAMICA 12 o'clock band asserts the attention to detail in its design. A set of controls on the AMG steering wheels lets you adjust performance settings quickly and easily, with integrated colour displays to confirm your selection. The left switches can be assigned to functions such as the Manual shift mode, the damping modes of AMG RIDE CONTROL, the 3-stage ESP, and the AMG Performance Exhaust System. The right round control knob selects and displays the driving mode of AMG DYNAMIC SELECT. Red seat belts make two bold statements: One for their racing-inspired style, and one asserting their role as the heart of an AMG safety philosophy that's equally important on the street and on the racetrack. They're available to complement the Black leather upholstery in combination with the Night or Sport Package.\",\n" +
                "   \"engine\": \"Handcrafted AMG 4.0L V8 biturbo\",\n" +
                "   \"engineDescription\": \"4.5 sec acceleration, 577 hp power, 627 lb-ft torque\",\n" +
                "   \"performancePackage\": \"AMG Trail Package\",\n" +
                "   \"performancePackageDescription\": \"Off-road optimized AMG RIDE CONTROL suspension, Rear mud flaps, All-season floor mats, 20-inch AMG 5-twin-spoke wheels, matte black\"\n" +
                "}");
    }
}
