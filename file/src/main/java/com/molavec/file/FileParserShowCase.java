package com.molavec.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Example Class that print first and second argument
 * 
 * @author molavec
 */
public class FileParserShowCase {
	
	private static String CSV_FILE = "resources"+ File.separator + "data.csv";
	
	/**
	 * @param args use two arguments
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {	
		
		FileParser parser = new FileParser();
		String text = parser.parseFileToString(CSV_FILE, StandardCharsets.UTF_8);
		System.out.println(text);
		System.out.println("----");
		
		List<String> stringList = parser.parseFileToList(CSV_FILE, StandardCharsets.UTF_8);
		System.out.println(stringList);
		System.out.println("----");
		
	}
	
	
	
}
