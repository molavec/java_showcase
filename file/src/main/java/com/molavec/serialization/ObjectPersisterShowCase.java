package com.molavec.serialization;

import java.io.File;
import java.io.IOException;

import com.molavec.entity.Data;

public class ObjectPersisterShowCase {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//note that Data object implements Serializable
		Data data =  new Data(1, 1.2f, 1.3f, 1.4f);
		ObjectPersister<Data> objectPersister = new ObjectPersister<Data>();
		objectPersister.objectToFile(data, new File("dataFile.dat"));
		Data data2 = objectPersister.fileToObject(new File("dataFile.dat"));
		
		System.out.println("Data object before serialize" + data);
		System.out.println("Data object after serialize" + data2);
		
	}

}
