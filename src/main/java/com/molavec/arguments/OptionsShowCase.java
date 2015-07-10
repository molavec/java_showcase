package com.molavec.arguments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Print floats semicolon separated. If you use the -t option
 * it show time, if you use the -s [SEPARATOR] it separates
 * float whit SEPARATOR char 
 * 
 * @author molavec
 *
 */

public class OptionsShowCase {

	private static boolean printTime = false;
	private static String separator = ";";
	private static boolean printHelpAndReturn = false;

	/**
	 * @param args use two arguments
	 */
	public static void main(String[] args) {
		//Content to Print
		Float[] array = {1f, 1f, 2f, 3f};
		ArrayList<Float> floatList = new ArrayList<Float>(Arrays.asList(array));
		
		digestArguments(args);
		
		if(printHelpAndReturn){
			return;
		}
		
		String s ="";
		if(printTime){
			DateFormat dateformat = new SimpleDateFormat("HH:mm:ss -"); 
			s= dateformat.format(new Date());
		}
		
		for(float f : floatList){
			s = s + f + separator;
		}
		s=s.substring(0,s.length()-1);
		System.out.println(s);
		
		
		
	}

	public static void digestArguments(String[] args){
		ArrayList<String> argList = new ArrayList<String>(Arrays.asList(args));
		if(argList.contains("-h") || args.length == 0){
			printHelpAndReturn = true;
			System.out.println(printHelp());
		}
		if(argList.contains("-t")){
			printTime = true;
			int value1 = argList.indexOf("-t");
			argList.remove(value1);
		}
		
		if(argList.contains("-s")){
			separator = argList.get(argList.indexOf("-s")+1);
			int value1 = argList.indexOf("-s");
			int value2 = argList.indexOf("-s")+1;
			argList.remove(value2);
			argList.remove(value1);
		}
	}
	
	public static String printHelp(){
		String s=  "Imprime datos. \n"
				+ "Modo de Uso: \n"
				+ "      java com.molavec.MultipleArgumentsShowCase [-t -s {SEPARADOR}]\n"
				+ "Comandos:\n"
				+ "     -h Imprime esta ayuda\n"
				+ "     -t imprime hora.\n"
				+ "     -s SEPARATOR utiliza el separador ingresado \n";
		return s;
	}
}
