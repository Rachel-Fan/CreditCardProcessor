package com.CreditCardProcessor;

public abstract class CreditCard {

	    protected String cardNumber;
	    protected String expirationDate;
	    protected String cardHolderName;

	    public CreditCard(String cardNumber, String expirationDate, String cardHolderName) {
	        this.cardNumber = cardNumber;
	        this.expirationDate = expirationDate;
	        this.cardHolderName = cardHolderName;
	    }

	    public abstract boolean isValid();
	    public abstract String getCardType();

	    // Getter methods for the fields
	    public String getCardNumber() {
	        return cardNumber;
	    }

	    public String getExpirationDate() {
	        return expirationDate;
	    }

	    public String getCardHolderName() {
	        return cardHolderName;
	    }


}
