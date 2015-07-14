package cl.molavec.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.BlowfishCipherService;
import org.apache.shiro.crypto.DefaultBlockCipherService;

/**
 * Encripta usando AES o BLOWFISH
 * 
 * Utiliza apache.shiro para encriptar.
 * 
 * @author angel
 *
 */
public class DataCipher {

	public static final int AES = 1;
	public static final int BLOWFISH = 2;
	
	protected byte[] keyBytes;
	protected DefaultBlockCipherService cipher;

	
	
	public DataCipher(){
		keyBytes = 	Hex.decode("37da9fe53a83777320b96669c881e6af");
		cipher = new BlowfishCipherService();
	}
	
	public DataCipher(byte[] key){
		keyBytes = 	key;
		cipher = new BlowfishCipherService();
	}
	
	public DataCipher(int method){
		keyBytes = 	Hex.decode("37da9fe53a83777320b96669c881e6af");
		if(method == AES){
			cipher = new AesCipherService();
		}else{
			cipher = new BlowfishCipherService();
		}
	}
	
	public DataCipher(byte[] key, int method){
		keyBytes = 	key;
		if(method == AES){
			cipher = new AesCipherService();
		}else{
			cipher = new BlowfishCipherService();
		}
	}
	
	public byte[] encrypt(byte[] dataBytes){
		
		ByteArrayInputStream is = new ByteArrayInputStream(dataBytes); 
		
		ByteArrayOutputStream encryptedOutputStream = 
				new ByteArrayOutputStream();
		
		cipher.encrypt(is, encryptedOutputStream, keyBytes);
		return encryptedOutputStream.toByteArray();
	}
	
	public byte[] decrypt(byte[] dataBytes){
		
		ByteArrayInputStream is = new ByteArrayInputStream(dataBytes); 
		
		ByteArrayOutputStream decryptedOutputStream = 
				new ByteArrayOutputStream();
		
		cipher.decrypt(is, decryptedOutputStream, keyBytes);
		return decryptedOutputStream.toByteArray();
	}
	
	
	
	public byte[] encrypt(float f){
		ByteArrayOutputStream floatOutputStream = 
				new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = 
				new DataOutputStream(floatOutputStream);
		ByteArrayOutputStream encryptedOutputStream = 
				new ByteArrayOutputStream();
		try {
			dataOutputStream.writeFloat(f);
			InputStream inputStream = convertToInputStream(floatOutputStream);
			cipher.encrypt(inputStream, encryptedOutputStream, keyBytes);
			return encryptedOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public float decrytFloat(byte[]  buf) throws DataCipherException {
		
		ByteArrayInputStream inputStream = 
				new ByteArrayInputStream(buf);
		return decrytFloat(inputStream);
	
	}
	
	public float decrytFloat(InputStream inputStream) throws DataCipherException {
		
		ByteArrayOutputStream decryptedOutputStream = 
				new ByteArrayOutputStream();
		
		cipher.decrypt(inputStream, decryptedOutputStream, keyBytes);
		InputStream decryptedInputStream = convertToInputStream(decryptedOutputStream);
		DataInputStream dataInputStream = new DataInputStream(decryptedInputStream);
		try {
			return dataInputStream.readFloat();
		} catch (IOException e) {
			//e.printStackTrace();
			throw new DataCipherException("Problem to get Float from imputStream");
		}
	}
	
	public static InputStream convertToInputStream(OutputStream stream) {
		ByteArrayOutputStream ba = (ByteArrayOutputStream) stream;
		return new ByteArrayInputStream(ba.toByteArray());
	}
	
}
