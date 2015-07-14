package cl.molavec.crypto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Generar hash md5
 * 
 * @author angel
 *
 */
public class MD5Generator {
	
	private static final String CODE = "MOLAVEC";

	/**
	 * obtiene el md5 de un string y retorna su md5 en formato hexadecimal
	 * 
	 * @param seed string a convertir
	 * @return md5 del string pasado como parámetro en formato hexadecimal
	 * @throws NoSuchAlgorithmException
	 */
	public static String stringToMd5Hex(String seed) throws NoSuchAlgorithmException{
			
		String toEnc = (seed+CODE); // Value to encrypt
		MessageDigest mdEnc = MessageDigest.getInstance("MD5"); // Encryption algorithm
		mdEnc.update(toEnc.getBytes(), 0, toEnc.length());
		
		String md5Hexadecimal = new BigInteger(1, mdEnc.digest()).toString(16).toUpperCase(); // Encrypted string
		
		return md5Hexadecimal;
			
	}
	
	/**
	 * Verifica que el md5 generado sea correcto.
	 * 
	 * Nota: el md5 debe hacer sido generado previamente por esta clase
	 * 
	 * @param msg mensaje a verificar 
	 * @param md5hex el md5 del mensaje en formato hexadecimal.
	 * @return Verdadero en caso que el md5 sea el correcto y Falso en caso contrario
	 * @throws NoSuchAlgorithmException 
	 */
	public static boolean checkMd5(String msg, String md5hex) throws NoSuchAlgorithmException{
		String md5 = stringToMd5Hex(msg);
		if(md5.equals(md5hex)){
			return true;
		}else{
			return false;
		}
	}

}
