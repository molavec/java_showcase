package com.molavec.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
 
public class PropertiesWriter {

	public static void main( String[] args ){
		Properties prop = new Properties();

		try {
			//set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");

			//save properties to project root folder
			prop.store(new FileOutputStream("resources"+File.separator+"config.properties"), null);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
