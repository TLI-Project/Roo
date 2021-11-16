package entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureTests {

    @Test
    public void whenCreatingFeature(){
        Feature rustProofing = new Feature("rust proofing", 1, "it proofs rust");
        assertEquals(rustProofing.getName(), "rust proofing");
        assertEquals(rustProofing.getPrice(), 1);
        assertEquals(rustProofing.getDescription(), "it proofs rust");
    }

    @Test
    public void whenExtendingEntity(){
        Feature rustProofing = new Feature("rust proofing", 1, "it proofs rust");
        assertEquals(rustProofing.getEntityStr(), "Name: rust proofing, Description: it proofs rust");
    }
}
