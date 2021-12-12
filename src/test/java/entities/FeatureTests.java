package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureTests {

    @Test
    public void whenCreatingFeature(){
        Feature rustProofing = new Feature("rust proofing",  "it proofs rust");
        assertEquals(rustProofing.getName(), "rust proofing");
        assertEquals(rustProofing.getDescription(), "it proofs rust");
    }
}
