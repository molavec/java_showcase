package com.molavec.properties;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader
{
	public static void main( String[] args ){
		Properties prop = new Properties();

		try {
			//load a properties file
			prop.load(new FileInputStream("resources"+File.separator+"config.properties"));

			//get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}