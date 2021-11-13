package com.TLI2.roo;

import entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntityTests {

    /**
     * Test that construction of a User works as intended.
     */
    @Test
    public void whenCreatingUser() {
        User Christopher = new User("Christopher", "password");
        assertEquals(Christopher.getUsername(), "Christopher");
        assertEquals(Christopher.getPassword(), "password");
    }
}
