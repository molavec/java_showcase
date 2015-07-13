package com.molavec.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 * Use java.security.* to encrypt
 * 
 * TODO: encrypt with other methods
 * TODO: use a correct method to add a salt
 * TODO: convert Encryptor in an interface, if is posible to use another Encryptor method
 * 
 * @author molavec
 *
 */
public class Encryptor {
	private String toEnc;
	private MessageDigest mdEnc;
	
	/**
	 * Constructor
	 * 
	 * @param seed serial del Equipo
	 * @throws NoSuchAlgorithmException
	 */
	public Encryptor(String seed) throws NoSuchAlgorithmException{
		toEnc = seed; // Value to encrypt
	}
	

	/**
	 * Obtiene el serial que debe ser ingresado en la aplicación
	 * @return primera encriptación
	 * @throws NoSuchAlgorithmException 
	 */
	public String getMd5() throws NoSuchAlgorithmException{
		mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
		mdEnc.update(toEnc.getBytes(), 0, toEnc.length());
		return new BigInteger(1, mdEnc.digest()).toString(16).toUpperCase(); // Encrypted string
	}
	
}
