package com.CreditCardProcessor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;
import java.io.FileWriter;

public class XMLProcessor {

    public void processFile(String directoryPath, String inputFileName, String outputFileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document inputDoc = builder.parse(new File(directoryPath + inputFileName));
        inputDoc.getDocumentElement().normalize();

        Document outputDoc = builder.newDocument();
        Element rootElement = outputDoc.createElement("CARDS");
        outputDoc.appendChild(rootElement);

        NodeList nodeList = inputDoc.getElementsByTagName("CARD");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element originalCard = (Element) node;
                Element processedCard = processCard(originalCard, outputDoc);
                rootElement.appendChild(processedCard);
            }
        }

        // Write to file
        try (FileWriter writer = new FileWriter(directoryPath + outputFileName)) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(outputDoc);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
        }
    }

    private Element processCard(Element cardElement, Document document) {
        String cardNumber = cardElement.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();
        String cardType;
        if (cardNumber == null || cardNumber.isEmpty()) {
            cardType = "Invalid: empty/null card number";
        } else if (!cardNumber.matches("\\d+")) {
            cardType = "Invalid: non numeric characters";
        } else if (cardNumber.length() > 19) {
            cardType = "Invalid: more than 19 digits";
        } else {
            CreditCard creditCard = CreditCardUtil.createCreditCard(cardNumber, null, null);
            cardType = (creditCard != null && creditCard.isValid()) ? creditCard.getCardType() : "Invalid: Not a possible card number";
        }

        // Create new card element
        Element newCardElement = document.createElement("CARD");
        Element numberElement = document.createElement("CARD_NUMBER");
        numberElement.appendChild(document.createTextNode(cardNumber));
        Element typeElement = document.createElement("CARD_TYPE");
        typeElement.appendChild(document.createTextNode(cardType));

        newCardElement.appendChild(numberElement);
        newCardElement.appendChild(typeElement);

        return newCardElement;
    }
}
