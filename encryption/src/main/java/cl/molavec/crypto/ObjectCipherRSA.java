package cl.molavec.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public class ObjectCipherRSA {

	/**
	 * Encripta el texto usando la clave pública
	 * 
	 * @param mensaje
	 *            Ristra que contiene el mensaje a encriptar
	 * @return El mensaje cifrado como un vector de BigIntegers
	 * @throws IOException
	 */
	public static BigInteger[] encrypt(Object object,
			BigInteger bigNumber, BigInteger publicKey) throws IOException {
		int i;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(object);
		

		byte[] temp = new byte[1];
		
		
		//-----------------------------------
		
		byte[] digitos = bos.toByteArray();
		//String s = "hola mundo";
		//byte[] digitos = s.getBytes();
		
		//System.out.println(digitos);
		
		BigInteger[] bigdigitos = new BigInteger[digitos.length];
		
//		System.out.println("digitos.length: " + digitos.length);
		
		for (i = 0; i < bigdigitos.length; i++) {
			temp[0] = digitos[i];
			//System.out.println("digitos["+i+"] - [" + digitos[i] +"]");
			temp[0] = digitos[i];
			bigdigitos[i] = new BigInteger(1,temp);
//			if(i == 0 || i == 1 || i == 2 || i == 3){
//				System.out.println("encrypt() - bigdigitos[i]: " + bigdigitos[i]);
//			}
		}

		BigInteger[] encriptado = new BigInteger[bigdigitos.length];

		
		for (i = 0; i < bigdigitos.length; i++){
			encriptado[i] = bigdigitos[i].modPow(publicKey, bigNumber);
//			if(i == 0 || i == 1|| i == 2 || i == 3){
//				System.out.println("encrypt() - encriptado[i]: " + encriptado[i]);
//			}
		}

		bos.close();
		oos.close();
		
		return (encriptado);
		
	}

	/**
	 * Desencripta el texto cifrado usando la clave privada
	 * 
	 * @param encriptado
	 *            Array de objetos BigInteger que contiene el texto cifrado que
	 *            será desencriptado
	 * @return The decrypted plaintext
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object decrypt(BigInteger[] encriptado,
			BigInteger bigNumber, BigInteger privateKey) throws IOException,
			ClassNotFoundException {
		BigInteger[] desencriptado = new BigInteger[encriptado.length];

		for (int i = 0; i < desencriptado.length; i++){
			desencriptado[i] = encriptado[i].modPow(privateKey, bigNumber);
//			if(i == 0 || i == 1 || i == 2 || i == 3){
//				System.out.println("decrypt() - encriptado[i]: " + encriptado[i]);
//				System.out.println("decrypt() - desencriptado[i]: " + desencriptado[i].intValue());
//			}
		}
		
		byte[] charArray = new byte[desencriptado.length];

//		System.out.println("desencriptado.length: " + desencriptado.length);
		
		
		for (int i = 0; i < charArray.length; i++){
			charArray[i] = (byte) (desencriptado[i].intValue());
//			System.out.println("byteArray["+ i +"] - [" + charArray[i] +"]");
//			if(i == 0 || i == 1){
//				System.out.println("byteArray["+ i +"] - [" + charArray[i] +"]");
//			}
		}

		ByteArrayInputStream inputStream = new ByteArrayInputStream(charArray);
		ObjectInputStream ois = new ObjectInputStream(inputStream);
		Object obj =  ois.readObject();
		ois.close();
		return (obj);
		
		//return null;
	}

}
