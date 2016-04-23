package com.sqa.jf.data;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class BasicReadFileTest {
	public static ArrayList<Object> tests = new ArrayList<Object>();
	public static StringBuilder testString = new StringBuilder();

	public static void main(String[] args) {
		// The name of the file to open.
		// String fileNameOld = "temp.txt";
		String fileName = "temp.json";
		// String fileNameMac = "/Users/Jean/Desktop/temp.json";
		//// String fileName = "../../../Desktop/temp.json";

		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// TODO Evalaute the line
				gatherDataString(line);
			}
			evaluateDataString();
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		displayTests();
	}

	private static void displayTests() {
		System.out.println(testString.toString());

	}

	private static void evaluateDataString() {

		String myString = testString.toString();

		String pattern = "(\")(\\d+)(\")";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(myString);

		while (m.find()) {
			System.out.println("Found value: " + m.group(2));
		}
	}

	private static void gatherDataString(String line) {
		testString.append(line);
	}
}
