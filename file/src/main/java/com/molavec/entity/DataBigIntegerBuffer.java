package com.molavec.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class DataBigIntegerBuffer implements Serializable{

	/**
	 * Encapsula un arreglo de byte[] en el objeto DataByteBuffer.
	 * ¿Utilidad? permite serializar varios arreglos de bytes en un archivo.
	 * 
	 * Usos: guardar datos encriptados.
	 * 
	 * @see cl.molavec.ObjectPersister
	 */
	private static final long serialVersionUID = -8580650399241087599L;
	
	private BigInteger[] data;
	
	public DataBigIntegerBuffer(BigInteger[] dataByteArray){
		this.setData(dataByteArray);
	}

	public BigInteger[] getData() {
		return data;
	}

	public void setData(BigInteger[] data) {
		this.data = data;
	}


	
	
}
