package cl.molavec.crypto;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;




import cl.molavec.crypto.ObjectCipher;
import cl.molavec.entity.Data;
import cl.molavec.entity.DataByteBuffer;
import cl.molavec.serialization.ObjectPersister;

public class CryptoFileManager {

	private Key secretKey;

	private ObjectCipher<Data> cipher;

	private ObjectPersister<DataByteBuffer> persister;

	public CryptoFileManager() throws NoSuchAlgorithmException,
			NoSuchPaddingException {

		String hexKey = "e92a35144bb2cde61bec375b6c5d2764";
		secretKey = ObjectCipherKeyManager.HexToSecretKey(hexKey, "Blowfish");
		cipher = new ObjectCipher<Data>("Blowfish");
		persister = new ObjectPersister<DataByteBuffer>();
	
	}


	public void appendToEncriptedFile(Data data, File file)
			throws InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, IOException, NoSuchAlgorithmException,
			NoSuchPaddingException {

		// 2.- Guarda el dato encriptar
		byte[] encryptedData = cipher.encrypt(data, secretKey);

		// Guardar dentro de un objeto
		DataByteBuffer dataByteBuffer = new DataByteBuffer(encryptedData);

		// almacenar datos
		persister.appendObjectToFile(dataByteBuffer, file);
		
	}

	public List<Data> getDataFromFile(File file)
			throws ClassNotFoundException, IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {

		List<Data> dataList = new ArrayList<Data>();
		List<DataByteBuffer> dataByteBufferList = persister.fileToObjects(file);
		
		for (DataByteBuffer encryptedData : dataByteBufferList) {
			dataList.add(cipher.decrypt(encryptedData.getData(), secretKey));
		}
		
		return dataList;
		
	}

	
}
