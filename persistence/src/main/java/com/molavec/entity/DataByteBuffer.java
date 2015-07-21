package com.molavec.entity;

import java.io.Serializable;

public class DataByteBuffer implements Serializable{

	/**
	 * Encapsula un arreglo de byte[] en el objeto DataByteBuffer.
	 * ¿Utilidad? permite serializar varios arreglos de bytes en un archivo.
	 * 
	 * Usos: guardar datos encriptados.
	 * 
	 * @see cl.molavec.ObjectPersister
	 */
	private static final long serialVersionUID = -8580650399241087599L;
	
	private byte[] data;
	
	public DataByteBuffer(byte[] dataByteArray){
		this.setData(dataByteArray);
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
}
