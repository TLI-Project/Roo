//package entities;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class CarTests {
//
//    @Test
//    public void whenCarCreation(){
//        Feature rustProofing = new Feature("rust proofing", 1, "it proofs rust");
//        Feature rustProof = new Feature("proof", 2, "proofs rust");
//        Map<String, Feature> testFeatures = new HashMap<String, Feature>();
//        testFeatures.put(rustProofing.getName(), rustProofing);
//        Car car = new Car("model", "make", 1, 2020, 0, testFeatures);
//
//        assertEquals(car.getCarMake(), "make");
//        assertEquals(car.getCarModel(), "model");
//        assertEquals(car.getYear(), 2020);
//        assertEquals(car.getKms(), 0);
//        assertEquals(car.getListPrice(), 1);
//        assertEquals(car.getFeatures(), testFeatures);
//
//        car.addFeatures(rustProof);
//        testFeatures.put(rustProof.getName(), rustProof);
//        assertEquals(car.getFeatures(), testFeatures);
//    }
//
//    @Test
//    public void whenExtendingEntity(){
//        Feature rustProofing = new Feature("rust proofing", 1, "it proofs rust");
//        Map<String, Feature> testFeatures = new HashMap<String, Feature>();
//        testFeatures.put(rustProofing.getName(), rustProofing);
//        Car car = new Car("model", "make", 1, 2020, 0, testFeatures);
//        assertEquals(car.getEntityStr(), "Car Model: model, Car Make: make");
//    }
//}
