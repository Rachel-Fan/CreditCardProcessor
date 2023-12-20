package com.CreditCardProcessor;

import static org.junit.Assert.*;
import org.junit.Test;

public class VisaCCTest {

    @Test
    public void testIsValidWithValidCardNumber() {
        CreditCard visaCard = new VisaCC("4111111111111111", "12/25", "John Doe");
        assertTrue(visaCard.isValid());
    }

    @Test
    public void testIsValidWithInvalidCardNumber() {
        CreditCard invalidCard = new VisaCC("123456", "12/25", "Invalid Card");
        assertFalse(invalidCard.isValid());
    }

    @Test
    public void testGetCardType() {
        CreditCard visaCard = new VisaCC("4111111111111111", "12/25", "John Doe");
        assertEquals("Visa", visaCard.getCardType());
    }
}
