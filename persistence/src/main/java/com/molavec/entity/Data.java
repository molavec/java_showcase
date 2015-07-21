package com.molavec.entity;

import java.io.Serializable;


/**
 * Define la estructura de un dato adquirido para manejarlo con 
 * la aplicación templogger.
 * 
 * @author angel
 *
 */
public class Data implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7406075670899045284L;
	
	private long time;
	private float dataSensorOne;
	private float dataSensorTwo;
	private float dataSensorThree;
	
	public Data(long time, float dataSensorOne, float dataSensorTwo, float dataSensorThree){
		this.time = time;
		this.dataSensorOne = dataSensorOne;
		this.dataSensorTwo = dataSensorTwo;
		this.dataSensorThree = dataSensorThree;
	}
	
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public float getDataSensorOne() {
		return dataSensorOne;
	}
	public void setDataSensorOne(float dataSensorOne) {
		this.dataSensorOne = dataSensorOne;
	}
	public float getDataSensorTwo() {
		return dataSensorTwo;
	}
	public void setDataSensorTwo(float dataSensorTwo) {
		this.dataSensorTwo = dataSensorTwo;
	}
	public float getDataSensorThree() {
		return dataSensorThree;
	}
	public void setDataSensorThree(float dataSensorThree) {
		this.dataSensorThree = dataSensorThree;
	}
	

	public String toString(){
		String string = String.format("[time: %d | dataSensorOne: %f |dataSensorTwo: %f |dataSensorThree: %f ]", 
				time, dataSensorOne, dataSensorTwo, dataSensorThree);
		return string;
	}
}
