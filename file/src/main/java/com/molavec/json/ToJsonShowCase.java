package com.molavec.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Para dejar más ordenado el JSON usar
 * 
 * new GsonBuilder().setPrettyPrinting().create();
 * 
 * http://www.mkyong.com/java/how-to-enable-pretty-print-json-output-gson/
 * 
 * @author angel
 *
 */
public class ToJsonShowCase {
    public static void main(String[] args) {
    	 
	DataObject obj = new DataObject();
	Gson gson = new Gson();
	Gson gsonNice = new GsonBuilder().setPrettyPrinting().create();
	
 
	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(obj);
	String jsonNice = gsonNice.toJson(obj);
 
	try {
		//write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter("resources"+File.separator+"file.json");
		writer.write(json);
		writer.close();
		
		FileWriter writerNice = new FileWriter("resources"+File.separator+"fileNice.json");
		writerNice.write(json);
		writerNice.close();
		
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
	System.out.println(json);
	System.out.println(jsonNice);
 
    }
}
