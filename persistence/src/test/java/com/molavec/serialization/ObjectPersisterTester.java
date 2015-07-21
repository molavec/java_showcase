package com.molavec.serialization;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.molavec.entity.Data;
import com.molavec.serialization.ObjectPersister;


public class ObjectPersisterTester {
	
	@Test
	public void serializationtest() throws IOException, ClassNotFoundException{
		Data data =  new Data(1, 1.2f, 1.3f, 1.4f);
		
		ObjectPersister<Data> objectPersister = new ObjectPersister<Data>();
		
		objectPersister.objectToFile(data, new File("dataFile.dat"));
		
		Data data2 = objectPersister.fileToObject(new File("dataFile.dat"));
		assertEquals(data2.getTime(), data.getTime());
        assertEquals(data2.getDataSensorOne(), data.getDataSensorOne(), 0);
        assertEquals(data2.getDataSensorTwo(), data.getDataSensorTwo(), 0);
        assertEquals(data2.getDataSensorThree(), data.getDataSensorThree(), 0);

		
	}
}
