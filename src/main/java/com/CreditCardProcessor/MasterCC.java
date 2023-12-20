package com.CreditCardProcessor;

public class MasterCC extends CreditCard {
    public MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }

    @Override
    public boolean isValid() {
        // Check if the first digit is 5 and the second digit is between 1 and 5
        // and if the card number length is exactly 16 digits
        if (cardNumber.startsWith("5")) {
            int secondDigit = Character.getNumericValue(cardNumber.charAt(1));
            return (secondDigit >= 1 && secondDigit <= 5) && cardNumber.length() == 16;
        }
        return false;
    }

    @Override
    public String getCardType() {
        // Return the string "MasterCard" as the card type
        return "MasterCard";
    }
}
