package com.molavec.serial;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jssc.SerialPort;
import jssc.SerialPortException;


/**
 * This class simplifies communication with serials.
 * 
 *  TODO: convert in a interface.
 * 
 * @author angel
 *
 */
public class SerialCommunicator {

	static Logger log = LoggerFactory.getLogger(SerialCommunicator.class);
	private SerialPort serialPort;

	public SerialCommunicator(String portName) throws SerialPortException {
		
		serialPort = new SerialPort(portName);
		serialPort.openPort();// Open serial port
		serialPort.setParams(
				SerialPort.BAUDRATE_57600, 
				SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1, 
				SerialPort.PARITY_NONE
				);
	}

	public void writeBytes(String command) throws SerialPortException {
		byte[] commandByteArray = (command + "\r").getBytes();
		serialPort.writeBytes(commandByteArray);// Write data to port
	}

	public String readPort() throws SerialPortException, IOException {
		byte[] respByteArray = serialPort.readBytes(serialPort
				.getInputBufferBytesCount());

		ByteArrayInputStream byteBufferResp = new ByteArrayInputStream(
				respByteArray);

		InputStreamReader inputStreamReader = new InputStreamReader(
				byteBufferResp);

		BufferedReader reader = new BufferedReader(inputStreamReader);
		String resp = reader.readLine();
		
		return resp;

	}
	
	public void closePort() throws SerialPortException {
		serialPort.closePort();// Close serial port
	}
}
