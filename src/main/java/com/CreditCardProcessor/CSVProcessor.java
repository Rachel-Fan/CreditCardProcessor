package com.CreditCardProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {
    
    public void processFile(String directoryPath, String inputFileName, String outputFileName) throws IOException {
        // List to hold processed lines
        List<String> processedLines = new ArrayList<>();
        processedLines.add("cardNumber,cardType"); // Header

        try (BufferedReader reader = new BufferedReader(new FileReader(directoryPath + inputFileName))) {
            String line;
            boolean isFirstLine = true; // Flag to skip the first line (header)

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the first line
                    continue;
                }
                String processedLine = processLine(line);
                if (processedLine != null) {
                    processedLines.add(processedLine);
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directoryPath + outputFileName))) {
            for (String processedLine : processedLines) {
                writer.write(processedLine);
                writer.newLine();
            }
        }
    }

    private String processLine(String line) {
        // Split the line into components
        String[] components = line.split(",");
        if (components.length >= 1) {
            String cardNumber = components[0].trim();

            // General validation checks
            if (cardNumber.isEmpty()) {
                return cardNumber + ",Invalid: empty/null card number";
            }
            if (!cardNumber.matches("\\d+")) {
                return cardNumber + ",Invalid: non numeric characters";
            }
            if (cardNumber.length() > 19) {
                return cardNumber + ",Invalid: more than 19 digits";
            }

            // Use CreditCardUtil to get the correct CreditCard object
            CreditCard creditCard = CreditCardUtil.createCreditCard(cardNumber, null, null);

            // Determine card validity and type
            if (creditCard != null && creditCard.isValid()) {
                return cardNumber + "," + creditCard.getCardType();
            } else {
                return cardNumber + ",Invalid: Not a possible card number";
            }
        }
        return null; // Skip lines with insufficient data
    }
}
