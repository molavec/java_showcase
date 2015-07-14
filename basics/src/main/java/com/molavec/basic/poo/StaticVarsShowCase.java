package com.molavec.basic.poo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.molavec.basic.poo.classes.AnotherClassUsingStatic;
import com.molavec.basic.poo.classes.StaticValues;


/**
 * Example about how to static values
 *  
 * @author molavec
 *
 */

public class StaticVarsShowCase {

	public static void main( String[] args ){
		Properties prop = new Properties();

		try {
			
			System.out.println("--> static Values before get properties:");
			System.out.println(StaticValues.value1);
			System.out.println(StaticValues.value2);
			System.out.println(StaticValues.value3);
			
			//load a properties file
			prop.load(new FileInputStream("resources"+File.separator+"vars.properties"));
			
			//get the property value and print it out
			StaticValues.value1 = prop.getProperty("value1");
			StaticValues.value2 = Integer.parseInt(prop.getProperty("value2"));
			StaticValues.value3 = Float.parseFloat(prop.getProperty("value3"));

			System.out.println("--> static Values after get properties:");
			System.out.println(StaticValues.value1);
			System.out.println(StaticValues.value2);
			System.out.println(StaticValues.value3);
			
			
			System.out.println("--> static Values from AnotherClassUsingStatic:");
			AnotherClassUsingStatic ob = new AnotherClassUsingStatic();
			System.out.println(ob.getValue1());
			System.out.println(ob.getValue2());
			System.out.println(ob.getValue3());
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
