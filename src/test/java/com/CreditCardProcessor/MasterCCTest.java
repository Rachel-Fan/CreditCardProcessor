package com.CreditCardProcessor;

import static org.junit.Assert.*;
import org.junit.Test;

public class MasterCCTest {

    @Test
    public void testIsValidWithValidCardNumber() {
        CreditCard masterCard = new MasterCC("5212345678901234", "12/25", "Alice Smith");
        assertTrue(masterCard.isValid());
    }

    @Test
    public void testIsValidWithInvalidCardNumber() {
        CreditCard invalidCard = new MasterCC("123456", "12/25", "Invalid Card");
        assertFalse(invalidCard.isValid());
    }

    @Test
    public void testGetCardType() {
        CreditCard masterCard = new MasterCC("5212345678901234", "12/25", "Alice Smith");
        assertEquals("MasterCard", masterCard.getCardType());
    }
}
