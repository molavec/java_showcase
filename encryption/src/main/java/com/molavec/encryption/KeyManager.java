package com.molavec.encryption;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.shiro.codec.Hex;

/**
 * Operaciones para manejar llaves de encriptación 
 * @author angel
 *
 */
public class KeyManager {

	/**
	 * Genera llaves de encriptación
	 * @param el tipo de encriptación a utilizar. Los tipos: http://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#Cipher
	 * @return SecretKey para encriptar 
	 * @throws NoSuchAlgorithmException 
	 */
	public static SecretKey generate(String type) throws NoSuchAlgorithmException{
		// create a key generator based upon the Blowfish cipher
		KeyGenerator keygenerator = KeyGenerator.getInstance(type);
		// create a key
		return keygenerator.generateKey();
	}
	
	
	/**
	 * Convierte la llave (key) a un string hexadecimal para su almacenamiento y/o visualización.
	 * @param key 
	 * @return String hexadecimal
	 */
	public static String keyToHexString(SecretKey key){
		return Hex.encodeToString(key.getEncoded());
	}
	
	/**
	 * Convierte una representación en hexadecimal de un key en un SecretKey
	 * @param hexStringKey representación en hexadecimal
	 * @param type tipo de encriptación.
	 * @return
	 */
	public static SecretKey HexToSecretKey(String hexStringKey, String type){
		
		byte[] keyBytes = Hex.decode(hexStringKey);
		
		return new SecretKeySpec(keyBytes, 0, keyBytes.length, type);
	}
}
