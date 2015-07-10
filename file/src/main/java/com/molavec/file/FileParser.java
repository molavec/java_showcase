package com.molavec.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class with functions to manage files.
 * @author 
 *
 */
public class FileParser {
	
	public FileParser(){}

	/**
	 * Parsea text file to String
	 * @param filename
	 * @param standardCharset (StandardCharsets.ISO_8859_1, StandardCharsets.UTF-8, etc.)
	 * @return
	 * @throws IOException
	 */
	public String parseFileToString(String filename, Charset standardCharsets) throws IOException{
		StringBuilder sb = new StringBuilder();
		Files.lines(Paths.get(filename),standardCharsets).forEach(
			(string) -> {
				sb.append(string);
				sb.append(System.lineSeparator());
				}
		);
		
		return sb.toString();
	}
	
	/**
	 * Parse Lines from text file to a list
	 * @param filename
	 * @param standardCharset (StandardCharsets.ISO_8859_1, StandardCharsets.UTF-8, etc.)
	 * @return
	 * @throws IOException
	 */
	public List<String> parseFileToList(String filename, Charset standardCharsets) throws IOException{
		ArrayList<String> stringList = new ArrayList<String>();
//		System.out.println("filename:" + filename);
		Files.lines(Paths.get(filename), standardCharsets).forEach(
			(string) -> {
				stringList.add(string);
				}
		);
		return stringList;
	}
	
	
	/**
	 * Parsea un archivo de texto a un List de flotantes. <b>Nota:</b> El 
	 * archivo debe ser de 1 columna con flotantes.
	 * @param filename
	 * @param standardCharset (StandardCharsets.ISO_8859_1, StandardCharsets.UTF-8, etc.)
	 * @return
	 * @throws IOException
	 */
	public List<Float> parseFileToFloatList(String filename, Charset standardCharsets) throws IOException{
		ArrayList<Float> floatList = new ArrayList<Float>();
//		System.out.println("filename:" + filename);
		Files.lines(Paths.get(filename), standardCharsets).forEach(
			(string) -> {
				floatList.add(Float.parseFloat(string.replace(',', '.')));
				}
		);
		return floatList;
	}
	
	
	/**
	 * parsea un String en un arraylist
	 * @param line 
	 * @param separator separador de contenido
	 * @return
	 */
	public List<String> parseString(String line, String separator){
		return new ArrayList<String>(Arrays.asList(line.split(separator)));
	}
	
	/**
	 * parsea un String en un arraylist
	 * @param line 
	 * @param separator separador de contenido
	 * @return
	 */
	public List<Float> parseFloat(String line, String separator){
		ArrayList<Float> floatList = new ArrayList<Float>();
		for(String string : line.split(separator)){
			floatList.add(Float.parseFloat(string.replace(',', '.')));
		}
		return floatList;
	}
}
