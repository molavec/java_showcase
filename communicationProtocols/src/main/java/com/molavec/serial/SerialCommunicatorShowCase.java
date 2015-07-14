package com.molavec.serial;

import java.io.IOException;

import jssc.SerialPortException;

/**
 * Before to use this example is necessary set COM port and
 * uncomment lines in the code. 
 * 
 * @author molavec
 *
 */
public class SerialCommunicatorShowCase {

	private static String comport;

	public static void main(String[] args) throws SerialPortException, IOException {
		comport = "COM1";
		//TODO: UNCOMMENT NEXT LINES
//		SerialCommunicator serial = new SerialCommunicator(comport);
		
		//TODO: UNCOMMENT NEXT LINES
//		serial.writeBytes("hello");
		System.out.println("sending 'hello' to " + comport);
		
		//TODO: UNCOMMENT NEXT LINES
//		String response = serial.readPort();
//		System.out.println("response: " + response);
		
	}

}
