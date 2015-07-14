package com.molavec.basic.poo.classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InitStaticVars {

	public static void main( String[] args ){
		Properties prop = new Properties();

		try {
			
			System.out.println("--> static Values before get properties:");
			System.out.println(StaticValues.value1);
			System.out.println(StaticValues.value2);
			System.out.println(StaticValues.value3);
			
			//load a properties file
			prop.load(new FileInputStream("vars.properties"));
			
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
