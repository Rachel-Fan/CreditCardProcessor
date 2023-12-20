package com.CreditCardProcessor;

public class AmexCC extends CreditCard {
    public AmexCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Check if the first digit is 3 and the second digit is either 4 or 7
        // and if the card number length is exactly 15 digits
        return (cardNumber.startsWith("34") || cardNumber.startsWith("37")) && cardNumber.length() == 15;
    }

    @Override
    public String getCardType() {
        // Return the string "Amex" as the card type
        return "Amex";
    }   
}
