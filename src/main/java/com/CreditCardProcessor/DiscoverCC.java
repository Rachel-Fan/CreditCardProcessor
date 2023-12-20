package com.CreditCardProcessor;

public class DiscoverCC extends CreditCard {
    public DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Check if the card number starts with 6011 and its length is exactly 16 digits
        if (cardNumber.length() != 16) {
            return false;
        }
        return cardNumber.startsWith("6011");   
    }

    @Override
    public String getCardType() {
        // Return the string "Discover" as the card type
        return "Discover";
    }   
}
