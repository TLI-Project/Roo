package services;

import gateways.CarAccessSql;
import interfaces.CarAccessInterface;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SvcCarMetaDataTests {

    @Test
    public void testGetMetaData() {
        SvcCarMetaData svcCarMetaData = new SvcCarMetaData();
        SvcCarDataProcess svcCarDataProcess = new SvcCarDataProcess();
        SvcCarToJsonRequestAdapter svcCarToJsonRequestAdapter = new SvcCarToJsonRequestAdapter();
        CarAccessInterface carAccessInterface = new CarAccessSql();

        HashMap<Integer, String> test = svcCarMetaData.getMetaData(svcCarDataProcess,
                svcCarToJsonRequestAdapter, carAccessInterface);

        assertEquals(test.get(5),"{\n" +
                "   \"id\": 5,\n" +
                "   \"carModel\": \"AMG GLA 45 4MATIC+ SUV\",\n" +
                "   \"carMake\": \"A-Class\",\n" +
                "   \"carDescription\": \"The most compact AMG SUVs pack a lot in the back, and even more under the hood: Your choice of the 302-hp GLA 35, or the most powerful 4-cylinder in production in the 382-hp GLA 45. In an old mill in 1967, two automotive engineers with a passion for motorsports began turning Mercedes-Benz sedans into winning racecars. Today, as the performance division of Mercedes-Benz, AMG continues to create victory on the track and desire on the streets of the world. Every Mercedes-AMG vehicle is the product of craftsmen, designers and engineers who live to test limits, and for a singular goal: Driving Performance. A Mercedes-AMG engine starts with the state of the art. Everything from fuel pressure to exhaust routing is developed to quicken, heighten and intensify its response, and yours. From patented processes to cut friction to a new generation of electrified performance, AMG technology is fueled by its racing success. Two 2.0L twin-scroll turbo engines let you have your AMG GLA in two strengths: mighty or almighty. The 302-hp GLA 35 can sprint to 100 in 4.9 seconds. A handcrafted 382-hp engine, the most powerful 4-cylinder in production, catapults the GLA 45 to 100 in just 4.4 seconds. The dual-clutch AMG SPEEDSHIFT 8-speed can change gears more quickly than a human. Along with a range of modes and paddle shifts, there's even a RACE START function. Rev-matched downshifts and partial ignition cutoff during upshifts benefit response, feel and sound. AMG Performance 4MATIC computes driving inputs, speed and g-forces so its electromechanical clutch packs can send torque to the tires that can use it best. Rear-axle torque-vectoring further sharpens the GLA 45's AMG Performance 4MATIC+. AMG racing know-how turns torrential power and torque into grip and control. Advanced all-wheel drive and precisely tuned chassis systems team up to deliver agile response, crisp feedback and a serious capability to deliver the fun. The double-wishbone front/multilink rear suspension combines rigidity, versatility and lightness. Standard 3-stage AMG RIDE CONTROL can adapt each wheel's damping in milliseconds. AMG DYNAMIC SELECT lets you fine-tune performance settings via a console button. Modes range from Slippery to Sport+, plus an Individual setup, as well as RACE on the GLA 45. The available AMG DRIVE UNIT adds drive-mode controls with color displays to the steering wheel. The AMG Driver's Package endows your GLA with the AMG DRIVE UNIT, 20-inch AMG Y-spoke wheels, and more. The GLA 45's AMG Track Package includes a steering wheel in grippy DINAMICA. Racing-bred AMG high-performance brakes feature silver (GLA 35) or grey (GLA 45) 4-piston front calipers clamping 350mm perforated discs. The AMG Track Package upsizes the GLA 45 to 360mm front discs and red 6-piston calipers. The digital cockpit's vivid displays, touch controls, intelligent voice assistant, and ergonomic controls intensify the bond of driver and vehicle. Power sport front seats or available AMG Performance seats support your driving moves. The flat-bottom AMG Performance steering wheel features Touch Control Buttons, shift paddles and Nappa leather trim. It's also available in grippy DINAMICA� microsuede, or a combo. You can adjust the 64-colour ambient lighting to suit your mood. Already one of the sportiest SUVs on four wheels, you get a choice of five designs as well on the GLA 35, and seven on the GLA 45. Sizes range from 19 to 21 inches, with silver and black options. Dual 10.25-inch digital displays include a central multimedia touchscreen and reconfigurable AMG instruments, readouts and menus. An available Head-Up Display projects key driving information closer to your natural line of sight. Two styling options make the bold GLA attitude even bolder. The AMG Night Package adds gloss black elements. And an Aerodynamics Package slices the wind with functional flics and a prominent rear wing.\",\n" +
                "   \"listPrice\": 63200.0,\n" +
                "   \"year\": \"2022\",\n" +
                "   \"kms\": 0.0,\n" +
                "   \"color\": \"Iridium Silver metallic\",\n" +
                "   \"condition\": \"new\",\n" +
                "   \"depreciation\": [0.82, 0.77, 0.71, 0.66, 0.59, 0.53, 0.45, 0.41, 0.34, 0.28],\n" +
                "   \"imageURL\": \"https://nafta.starconnect-ce.i.daimler.com/iris/iris.jpg?COSY-EU-100-1713d0VXqNEFqtyO67PobzIr3eWsrrCsdRRzwQZYVHZbMw3SGtleStsd2sDcUfpOyXGEundJ0l3DlOB2NSqbApjtwI5uVQzQC3qv3kzNwzwm7jZyDhKVFXM%25vq9JdyLRD3mYaxWNprH1KJdn8wv8noiZL5gM4FaSlTg9Hte6PD8%25FSeWiyhtsd4oVcUfC%25NXGEzGwJ0l70NOB2Kg5bApvklI5uL6YQC3aEWkzNHmnm7jQGIhKVPsW%25vqeu%25yLRsQmYaxUtxrH1zJ%25n8w7QboiZK%25oM4FvyjTg9wge6PDZcoSeW0eStsdBY%25cUfAyYXOc6VRjIfrH1CM1n8w5VUoiZH6IM4FNRPTg9jHH6PDePpSeWsKMtsdUvGcUfGrqXGE0nYJ0lBDtOBi1aftkV3xb15Z8cZl2rbpldCCNZkFu6pFIT9ZxexrlrKE847dvE5jCsAs4iZUa8Fm&&fb=1&BKGND=12&IMGT=A27&POV=be040%2Cpzm&crop=70,100,1850,1000&width=1440&height=600\",\n" +
                "   \"interior\": \"Climate Comfort front seats, AMG Performance front seats, MANUFAKTUR Red seat belts, AMG illuminated front door sills\",\n" +
                "   \"interiorDescription\": \"Climate Comfort seats are a luxury you'll soon consider a necessity. Three levels of heating and cooling ventilation are offered. By gently circulating air through perforations in the seat and backrest, ventilated seats help keep you cooler and your clothes drier during warmer months. Reversible fans help draw heat away for brief periods. On cold or damp days, using both the ventilation and heating together can circulate the seat heating more quickly, to help keep you warm and dry. Directly inspired by racing, the deeply contoured AMG Performance seats feature integrated head restraints and AMG badges. In addition to the customary power adjustments, the seats include power multicontour adjustment of the substantial side bolsters in the cushion and backrest, for optimal lateral support. Red seat belts make two bold statements: One for their racing-inspired style, and one asserting their role as the heart of an AMG safety philosophy that's equally important on the street and on the racetrack. AMG logos illuminate in a soft white glow as you open the front door, to welcome you into the cabin or ease your exit.\",\n" +
                "   \"engine\": \"Handcrafted AMG 2.0L inline-4 turbo\",\n" +
                "   \"engineDescription\": \"4.4 sec acceleration, 382 hp power, 354 lb-ft torque\",\n" +
                "   \"performancePackage\": \"AMG Track Package\",\n" +
                "   \"performancePackageDescription\": \"AMG Performance steering wheel in DINAMICA, AMG High-performance Composite Braking System, RACE mode\"\n" +
                "}");
    }
}
