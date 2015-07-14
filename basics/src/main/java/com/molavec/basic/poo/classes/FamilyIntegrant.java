package com.molavec.basic.poo.classes;

/**
 * Clase Hija de Intergrant y que implementa PersonManager
 * @author angel
 *
 */
public class FamilyIntegrant extends Integrant implements PersonManager{
	/**
	 * genero del integrante
	 */
	private String gender;
	
	/**
	 * Constructor sin argumentos. 
	 * Genera un objeto Integrant con todos sus atributos iguales a null. 
	 */
	public FamilyIntegrant() {
		super();
		this.gender = "undefined";
	}
	
	/**
	 * Constructor con argumentos
	 * Se deben llenar algunos de los datos del Integrante.
	 * 
	 * @param name
	 * @param lastName
	 */
	public FamilyIntegrant(String name, String lastName){
		this.name = name;
		this.lastName = lastName;
		this.gender = "undefined";
		
		
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
	public FamilyIntegrant(	
			String name, 
			String secondName, 
			String lastName, 
			String secondLastName, 
			int age){
		super(name, secondName, lastName, secondLastName, age);
		this.gender = "undefined";
	}
	
	/**
	 * obtiene el género del integrante
	 */
	public String getGender() {
		return this.gender;
	}


	/**
	 * define el género del integrante
	 */
	public void setGender(String gender) {
		this.gender = gender;
		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String s) {
		this.name = s;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String s) {
		this.secondName = s;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String s) {
		this.lastName = s;
	}

	public String getSecondLastName() {
		return this.secondLastName;
	}

	public void setSecondLastName(String s) {
		this.secondLastName = s;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
