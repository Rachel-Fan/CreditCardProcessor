package com.CreditCardProcessor;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVProcessorTest {

	@Test
	public void testProcessFileWithValidInput() throws IOException {
	    CSVProcessor processor = new CSVProcessor();
	    String directoryPath = "src/test/resources/"; // Adjust the path as necessary
	    String inputFileName = "validInput.csv";     // A CSV file with valid data
	    String outputFileName = "testOutput.csv";

	    processor.processFile(directoryPath, inputFileName, outputFileName);

	 // Read the output file and perform assertions
	    File outputFile = new File(directoryPath + outputFileName);
	    assertTrue("Output file should exist", outputFile.exists());

	    try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
	        String line;
	        List<String> lines = new ArrayList<>();
	        while ((line = reader.readLine()) != null) {
	            lines.add(line);
	        }

	        // Assuming the first line is the header
	        assertEquals("The output file should have a header", "cardNumber,cardType", lines.get(0));

	        // Add more assertions here to verify the content of the output file
	        // This can be based on the expected results for each card number in the validInput.csv
	    }

	    // Clean up
	    outputFile.delete();
		}
	
	
	@Test
	public void testProcessFileWithEmptyInput() throws IOException {
	    CSVProcessor processor = new CSVProcessor();
	    String directoryPath = "src/test/resources/";
	    String inputFileName = "emptyInput.csv"; // An empty CSV file
	    String outputFileName = "testOutput.csv";

	    processor.processFile(directoryPath, inputFileName, outputFileName);

	    File outputFile = new File(directoryPath + outputFileName);
	    assertTrue("Output file should exist even if input is empty", outputFile.exists());

	    // Verify the content of the output file
	    // Depending on your implementation, this could be an empty file or just a header
	    // Add assertions here

	    outputFile.delete(); // Clean up
}
}