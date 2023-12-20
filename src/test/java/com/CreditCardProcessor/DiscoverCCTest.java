package com.CreditCardProcessor;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiscoverCCTest {

    @Test
    public void testIsValidWithValidCardNumber() {
        CreditCard discoverCard = new DiscoverCC("6011123456781234", "12/25", "Eve Adams");
        assertTrue(discoverCard.isValid());
    }

    @Test
    public void testIsValidWithInvalidCardNumber() {
        CreditCard invalidCard = new DiscoverCC("123456", "12/25", "Invalid Card");
        assertFalse(invalidCard.isValid());
    }

    @Test
    public void testGetCardType() {
        CreditCard discoverCard = new DiscoverCC("6011123456781234", "12/25", "Eve Adams");
        assertEquals("Discover", discoverCard.getCardType());
    }
}
