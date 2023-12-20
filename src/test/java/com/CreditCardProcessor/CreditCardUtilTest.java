package com.CreditCardProcessor;

import static org.junit.Assert.*;
import org.junit.Test;

public class CreditCardUtilTest {

    @Test
    public void testCreateCreditCardWithValidCardNumbers() {
        // Test creating credit cards with valid card numbers
        CreditCard visaCard = CreditCardUtil.createCreditCard("4111111111111111", "12/25", "John Doe");
        assertNotNull(visaCard);
        assertTrue(visaCard instanceof VisaCC);

        CreditCard masterCard = CreditCardUtil.createCreditCard("5212345678901234", "10/24", "Alice Smith");
        assertNotNull(masterCard);
        assertTrue(masterCard instanceof MasterCC);

        // Add similar tests for AmexCC and DiscoverCC
    }

    @Test
    public void testCreateCreditCardWithInvalidCardNumbers() {
        // Test creating credit cards with invalid card numbers
        CreditCard invalidCard = CreditCardUtil.createCreditCard("123456", "12/25", "Invalid Card");
        assertNull(invalidCard);

        // Add more tests for various invalid card numbers
    }
}
