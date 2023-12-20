package com.CreditCardProcessor;

import static org.junit.Assert.*;
import org.junit.Test;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONProcessorTest {

	@Test
    public void testProcessFileWithValidInput() throws IOException {
        JSONProcessor jsonProcessor = new JSONProcessor();
        String directoryPath = "src/test/resources/"; // Adjust the path as necessary
        String inputFileName = "validInput.json";    // A JSON file with valid data
        String outputFileName = "testOutput.json";

        jsonProcessor.processFile(directoryPath, inputFileName, outputFileName);

        // Read the output file and perform assertions
        File outputFile = new File(directoryPath + outputFileName);
        assertTrue("Output file should exist", outputFile.exists());

        try (FileReader reader = new FileReader(outputFile)) {
            JsonObject rootObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray cardsArray = rootObject.getAsJsonArray("cards");
            assertNotNull("Cards array should not be null", cardsArray);

        }

	        // Clean up
	        outputFile.delete();
	    }
}



