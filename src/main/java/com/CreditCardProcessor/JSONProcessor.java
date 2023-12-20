package com.CreditCardProcessor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;


public class JSONProcessor {

	public void processFile(String directoryPath, String inputFileName, String outputFileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = new FileReader(directoryPath + inputFileName)) {
            try {
                JsonObject rootObject = gson.fromJson(reader, JsonObject.class);
                JsonArray cardsArray = rootObject.getAsJsonArray("cards");
                JsonArray processedCards = new JsonArray();

                for (int i = 0; i < cardsArray.size(); i++) {
                    JsonObject cardObject = cardsArray.get(i).getAsJsonObject();
                    JsonObject processedObject = processObject(cardObject);
                    processedCards.add(processedObject);
                }

                JsonObject outputRoot = new JsonObject();
                outputRoot.add("cards", processedCards);

                try (FileWriter writer = new FileWriter(directoryPath + outputFileName)) {
                    gson.toJson(outputRoot, writer);
                }
            } catch (JsonSyntaxException e) {
                System.err.println("JSON Parsing Error: " + e.getMessage());
                // Handle the parsing error as needed
            }
        }
    }
	
	
    private JsonObject processObject(JsonObject jsonObject) {
    	JsonObject processedObject = new JsonObject();

        JsonElement cardNumberElement = jsonObject.get("cardNumber");
        if (cardNumberElement != null && cardNumberElement.isJsonPrimitive()) {
            String cardNumber = cardNumberElement.getAsString();
            processedObject.addProperty("cardNumber", cardNumber);

            // General validation checks
            if (cardNumber.isEmpty()) {
                processedObject.addProperty("cardType", "Invalid: empty/null card number");
                return processedObject;
            }
            if (!cardNumber.matches("\\d+")) {
                processedObject.addProperty("cardType", "Invalid: non-numeric characters");
                return processedObject;
            }
            if (cardNumber.length() > 19) {
                processedObject.addProperty("cardType", "Invalid: more than 19 digits");
                return processedObject;
            }

            // Use CreditCardUtil to get the correct CreditCard object
            CreditCard creditCard = CreditCardUtil.createCreditCard(cardNumber, null, null);

            // Determine card validity and type
            if (creditCard != null && creditCard.isValid()) {
                processedObject.addProperty("cardType", creditCard.getCardType());
            } else {
                processedObject.addProperty("cardType", "Invalid: Not a possible card number");
            }
        } else {
            processedObject.addProperty("cardType", "Invalid: cardNumber is null or not present");
        }

        return processedObject;
    }
}


