package com.CreditCardProcessor;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class XMLProcessorTest {

    @Test
    public void testProcessFileWithValidInput() throws Exception {
        XMLProcessor xmlProcessor = new XMLProcessor();
        String directoryPath = "src/test/resources/"; // Adjust the path as necessary
        String inputFileName = "validInput.xml";      // A valid XML input file
        String outputFileName = "testOutput.xml";

        xmlProcessor.processFile(directoryPath, inputFileName, outputFileName);

        // Read the output file and perform assertions
        File outputFile = new File(directoryPath + outputFileName);
        assertTrue("Output file should exist", outputFile.exists());

        // Additional assertions as needed
        try (FileReader reader = new FileReader(outputFile)) {
            // You can parse the output XML here and make assertions
            // Example:
            // - Use an XML parsing library (e.g., DOM or JAXB) to parse the XML
            // - Verify the structure and content of the processed XML
            // - Assert specific elements and values in the output XML
        }

        // Clean up
        outputFile.delete();
    }
}
