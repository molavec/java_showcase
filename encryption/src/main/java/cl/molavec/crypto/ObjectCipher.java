package cl.molavec.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


/**
 * Clase simplificada para la encriptación de Objetos
 * 
 * Hace uso de la clase javax.crypto.Cipher
 * 
 * Modo: de uso:
 * 
 * // create a key generator based upon the Blowfish cipher
		KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
		
		// create a key
		SecretKey secretkey = keygenerator.generateKey();
        
        // create a cipher based upon Blowfish
        ObjectCipher<Data> objectCipher = new ObjectCipher<Data>("Blowfish");
        
        Data data =  new Data(1, 1.2f, 1.3f, 1.4f);
        
        byte[] encrytedData = objectCipher.encrypt(data, secretkey);
        
        System.out.println("Encrytep Object: " + new String(encrytedData));
        
        Data decrytedData = objectCipher.decrypt(encrytedData, secretkey);
        
        String s = String.format("time: %d - one: %f - two: %f - three: %f ", 
        		decrytedData.getTime(),
        		decrytedData.getDataSensorOne(),
        		decrytedData.getDataSensorTwo(),
        		decrytedData.getDataSensorThree()
        		);
        
        System.out.println(s);
 * 
 * @author angel
 *
 * @param <T>
 */
public class ObjectCipher<T>  {
	
	Cipher cipher;

	/**
	 * Constructor que genera una instancia de la clase Cipher
	 * utilizando Cipher.getInstance(cipherMode);
	 * 
	 * 
	 * @param cipherMode
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public ObjectCipher(String cipherMode) throws NoSuchAlgorithmException, NoSuchPaddingException{
		cipher = Cipher.getInstance(cipherMode);
	}
	
	
	/**
	 * Encrypta el objeto utilizando  una llave generada con la clase
	 * KeyGenerator.
	 * 
	 * Ejemplo:
	 * // create a key generator based upon the Blowfish cipher
		KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");
		
		// create a key
		SecretKey secretkey = keygenerator.generateKey();
        
        
	 * @param obj
	 * @param secretkey
	 * @return
	 * @throws InvalidKeyException
	 * @throws IOException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] encrypt(T obj, Key secretkey) throws  InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException{
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		oos.close();
		
		cipher.init(Cipher.ENCRYPT_MODE, secretkey);
		return  cipher.doFinal(bos.toByteArray());
		
	}
	
	/**
	 * Desencripta un arreglo de bytes en la clase indicada por <T>
	 * 
	 * @param encryptData
	 * @param secretkey
	 * @return
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public T decrypt(byte[] encryptData, Key secretkey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, ClassNotFoundException{
		
		cipher.init(Cipher.DECRYPT_MODE, secretkey);
		
		byte[] decryptedByteArray= cipher.doFinal(encryptData);
		ByteArrayInputStream inputStream = 
				new ByteArrayInputStream(decryptedByteArray);
		ObjectInputStream ois = new ObjectInputStream(inputStream);
		@SuppressWarnings("unchecked")
		T obj = (T) ois.readObject();
		ois.close();
		
		return  obj;
	}
}
