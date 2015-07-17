package com.molavec.logger;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Genera un log periodico
 * 
 * @author angel
 *
 */
public class LoggerGenerator {

	private static Logger log = LoggerFactory
			.getLogger(LoggerGenerator.class);
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		log.info("mensaje info");
		log.debug("mensaje debug");
		
	}

}
