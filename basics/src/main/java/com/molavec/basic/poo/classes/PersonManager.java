/**
 * 
 */
package com.molavec.basic.poo.classes;

/**
 * Interfaz que define los métodos que debe tener el una clase que 
 * derive quiera manejar los datos de una clase de tipo Integrant.
 * @author angel
 *
 */
public interface PersonManager {
	
	/**
	 * obtiene el primer nombre de una persona
	 * @return
	 */
	public String getName();
	
	/**
	 * define el primer nombre de una persona
	 * @return
	 */
	public void setName(String s);
	
	/**
	 * obtiene el segundo nombre de una persona
	 * @return
	 */
	public String getSecondName();
	
	/**
	 * define el segundo nombre de una persona
	 * @return
	 */
	public void setSecondName(String s);
	
	/**
	 * obtiene el primer apellido de una persona
	 * @return
	 */
	public String getLastName();
	
	/**
	 * define el primer apellido de una persona
	 * @return
	 */
	public void setLastName(String s);
	
	/**
	 * define el primer apellido de una persona
	 * @return
	 */
	public String getSecondLastName();
	
	/**
	 * obtiene el segundo apellido de una persona
	 * @return
	 */
	public void setSecondLastName(String s);
	
	/**
	 * define el segundo apellido de una persona
	 * @return
	 */
	public int getAge();
	
	public void setAge(int age);

}