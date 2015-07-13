package com.molavec.encryption;

import java.security.NoSuchAlgorithmException;

/**
 * Aplicación de Consola para creación de seriales
 * 
 * En caso de utilizar cambiar el serial ingresado a la 
 * variable serial al comienzo del método main. 
 * 
 * <b>Nota importante:</b>
 * Preferir la aplicación gráfica diseñada  para este efecto.
 * cl.icpdas.keygenerator.fx.main.KeyGenerator
 * 
 * @author angel
 *
 */
public class EncryptorShowCase {

	
	private static String dataToEnc;
	private static String dataEncrypted;

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		dataToEnc = "hello";
		
		Encryptor tempLoggerKeyGenerator = 
				new Encryptor(dataToEnc);
		
		dataEncrypted = tempLoggerKeyGenerator.getMd5();
		
		System.out.println("dataToEnc: " + dataToEnc);
		System.out.println("dataEncrypted: " + dataEncrypted.toUpperCase());

	}

}
