package com.CreditCardProcessor;

public class CreditCardUtil {
	public static CreditCard createCreditCard(String cardNumber, String expirationDate, String cardHolderName) {
        if (!isValidGeneralCardNumber(cardNumber)) {
            return null; // or throw an exception
        }

        // Instantiate specific credit card type based on card number
        if (cardNumber.startsWith("4") ) {
            return new VisaCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("5") ) {
            return new MasterCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("34") || cardNumber.startsWith("37") ){
            return new AmexCC(cardNumber, expirationDate, cardHolderName);
        } else if (cardNumber.startsWith("6011") ) {
            return new DiscoverCC(cardNumber, expirationDate, cardHolderName);
        }

        // Add additional conditions for other card types as needed

        return null; // or throw an exception for unrecognized card type
    }

    private static boolean isValidGeneralCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{1,19}");
    }
}
