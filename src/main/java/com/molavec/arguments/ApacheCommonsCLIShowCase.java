package com.molavec.arguments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * 
 * Print floats semicolon separated. If you use the -t option
 * it show time, if you use the -s [SEPARATOR] it separates
 * float whit SEPARATOR char
 * 
 * @author molavec
 *
 */
public class ApacheCommonsCLIShowCase {
	private static String separator = ";";

	/**
	 * @param args use two arguments
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		//Content to Print
		Float[] array = {1f, 1f, 2f, 3f};
		ArrayList<Float> floatList = new ArrayList<Float>(Arrays.asList(array));
		
		// create Options object
		Options options = new Options();

		// help option
		options.addOption("h", false, "display help");
		
		// add time option
		options.addOption("t", false, "display current time");
		
		// option with argument
		Option separatorOption   = Option.builder("s")
                .hasArg()
                .longOpt("separator-char")
                .desc("separator used to separate floats")
                .build();

		// add option with argument
		options.addOption(separatorOption);
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse( options, args);
		
		if(cmd.hasOption("h")){
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "ApacheCommonsCLIShowCase", options );
		}
		// automatically generate the help statement
		
				
		String s ="";
		if(cmd.hasOption("t")){
			DateFormat dateformat = new SimpleDateFormat("HH:mm:ss - "); 
			s= dateformat.format(new Date());
		}
		
		
		for(float f : floatList){
			if(cmd.hasOption("s")){
				s = s + f + cmd.getOptionValue( "s" );
			}else{
				s = s + f + separator;
			}
		}
		
		
		s=s.substring(0,s.length()-1);
		System.out.println(s);
		
	}

}
