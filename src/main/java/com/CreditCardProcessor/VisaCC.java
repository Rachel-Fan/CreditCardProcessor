package com.CreditCardProcessor;

public class VisaCC extends CreditCard {
    public VisaCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Check if the card number starts with 4 and its length is either 13 or 16
        return cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16);
    }

    @Override
    public String getCardType() {
        // Return the string "Visa" as the card type
        return "Visa";
    }
}
