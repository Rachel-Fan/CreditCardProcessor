package com.CreditCardProcessor;

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("\nEnter the path of your directory where input files are present.\n");
        Scanner input = new Scanner(System.in); 
        
        String directoryPath = input.nextLine(); 
        
        System.out.println("Enter Input File name (with proper extension: .csv, .json or .xml): ");
        String inputFileName = input.nextLine(); 
        
        System.out.println("Enter output File name (with proper extension: .csv, .json or .xml): ");
        String outputFileName = input.nextLine();

        try {
            processFile(directoryPath, inputFileName, outputFileName);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    private static void processFile(String directoryPath, String inputFileName, String outputFileName) throws IOException {
        if (inputFileName.toLowerCase().endsWith(".csv")) {
            processCSV(directoryPath, inputFileName, outputFileName);
        } else if (inputFileName.toLowerCase().endsWith(".json")) {
            processJson(directoryPath, inputFileName, outputFileName);
        } else if (inputFileName.toLowerCase().endsWith(".xml")) {
            processXml(directoryPath, inputFileName, outputFileName);
        } else {
            throw new IllegalArgumentException("Unsupported file extension.");
        }
    }

    private static void processCSV(String directoryPath, String inputFileName, String outputFileName) {
        CSVProcessor csvProcessor = new CSVProcessor();
        try {
            csvProcessor.processFile(directoryPath, inputFileName, outputFileName);
        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        }
    }

    private static void processJson(String directoryPath, String inputFileName, String outputFileName) {
        JSONProcessor jsonProcessor = new JSONProcessor();
        try {
            jsonProcessor.processFile(directoryPath, inputFileName, outputFileName);
        } catch (Exception e) {
            System.err.println("Error processing JSON file: " + e.getMessage());
        }
    }

    private static void processXml(String directoryPath, String inputFileName, String outputFileName) {
        XMLProcessor xmlProcessor = new XMLProcessor();
        try {
            xmlProcessor.processFile(directoryPath, inputFileName, outputFileName);
        } catch (Exception e) {
            System.err.println("Error processing XML file: " + e.getMessage());
        }
    }
}
