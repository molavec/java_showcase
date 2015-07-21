package com.molavec.properties;

import java.io.IOException;
import java.util.Properties;


/**
 * For non-static method use:
 * prop.load(getClass().getClassLoader().getResourceAsStream("config.properties");));
 * @author angel
 *
 */
public class PropertiesLoaderFromClassPath{

	public static void main( String[] args ){
		Properties prop = new Properties();
		try {
			
			//For non-static method use:
			//prop.load(getClass().getClassLoader().getResourceAsStream("config.properties");));
			
			//load a properties file from class path, inside static method
			prop.load(PropertiesLoaderFromClassPath.class.getClassLoader().getResourceAsStream("config.properties"));

			//get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}