package com.molavec.basic.poo.classes;

/**
 * Clase <b>abstracta</b> que sirve de padre para un objeto que 
 * que contenga los atributos listados más aelante.
 * @author angel
 *
 */
public abstract class Integrant {
	/**
	 * nombre de un integrante
	 */
	protected String name;
	/**
	 * segundo nombre de un integrante
	 */
	protected String secondName;
	/**
	 * apellido de un integrante
	 */
	protected String lastName;
	/**
	 * segundo apellido de un integrante
	 */
	protected String secondLastName;
	
	/**
	 * edad de un integrante
	 */
	protected int age;
	
	/**
	 * Constructor sin argumentos. 
	 * Genera un objeto Integrant con todos sus atributos iguales a null. 
	 */
	public Integrant() {
		this.name = null;
		this.secondName = null;
		this.lastName = null;
		this.secondLastName= null;
		this.age = 0;
	}
	
	/**
	 * Constructor con argumentos
	 * Se deben llenar todos los datos del Integrante.
	 * 
	 * @param name
	 * @param secondName
	 * @param lastName
	 * @param secondLastName
	 * @param age
	 */
	public Integrant(	
				String name, 
				String secondName, 
				String lastName, 
				String secondLastName, 
				int age){
		this.name = name;
		this.secondName = secondName;
		this.lastName = lastName;
		this.secondLastName= secondLastName;
		this.age = age;
	}
	
	/**
	 * obtiene el nombre completo de un integrante
	 * @return Nombre completo de un integrante.
	 */
	public String getCompleteName(){
		return this.name +" "+ this.secondName +" "+ this.lastName +" "+ this.secondLastName;
	}
	
	/**
	 * método que obtiene el género de un integrante 
	 * @return género del integrante
	 */
	public abstract String getGender();
	
	/**
	 * método que define el género de un integrante.
	 * @param gender género del integrante
	 */
	public abstract void setGender(String gender);
	
	

}
