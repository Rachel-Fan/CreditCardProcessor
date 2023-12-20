package com.CreditCardProcessor;

import static org.junit.Assert.*;
import org.junit.Test;

public class AmexCCTest {

    @Test
    public void testIsValidWithValidCardNumber() {
        CreditCard amexCard = new AmexCC("371234567890123", "12/25", "Bob Johnson");
        assertTrue(amexCard.isValid());
    }

    @Test
    public void testIsValidWithInvalidCardNumber() {
        CreditCard invalidCard = new AmexCC("123456", "12/25", "Invalid Card");
        assertFalse(invalidCard.isValid());
    }

    @Test
    public void testGetCardType() {
        CreditCard amexCard = new AmexCC("371234567890123", "12/25", "Bob Johnson");
        assertEquals("Amex", amexCard.getCardType());
    }
}
