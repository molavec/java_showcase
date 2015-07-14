package com.molavec.basic.poo.classes;

/**
 * @mainpage
 * <p>Este un paquete que contiene ejemplos de usos básicos para
 * el manejo de clases en Java.</p>
 * <p>En los siguientes paquetes pueden apreciar el funcionamiento 
 * práctico de los siguientes conceptos:</p>
 * 
 * <ul>
 * <li>Clases</li>
 * <li>Intanciamiento de objetos</li>
 * <li>uso de métodos estáticos (static), abstractos (abstract)</li>
 * <li>Herencia: Clase padre e hijas</li>
 * <li>Implementación de interfaces.</li>
 * </ul>
 * 
 * Espero que sea de utilidad para quién las utilice.
 * 
 * @author angel
 * @mail molavec@gmail.com
 * 
 */

/**
 * Clase de prueba que sirve para entender el funcionamiento de una clase.
 * 
 * 
 * @author angel
 *
 */
public class StandardClass {
	
	//Atributos
	private String name; //declaración del atributo
	private String lastname;
	
	/**
	 * Constructor de la clase padre 
	 */
	public StandardClass(){
		//atributos inicializados con valores por defecto
		 this.name = "DEFAULT_NAME"; //ASIGNACIÓN
		 this.lastname = "DEFAULT_LASTNAME";
	} 
		
	/**
	 * Constructor de la clase padre
	 * 
	 * @param name Nombre del padre
	 * @param apellido Apellido del padre
	 */
			//parámetros
	public StandardClass (String name, String lastname) {
		//inicialización de los atributos
		this.name = name; 
		this.lastname = lastname;
	}
	
	/**
	 * se obtiene el nombre del padre
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * se obtiene el apellido del padre
	 * @return
	 */
	public String getLastName(){
		return lastname;
	}
	
	/**
	 * cambia el nombre del padre
	 * @param name
	 */
	public void changeName(String name){
		this.name = name;
	}
	
	/**
	 * cambia el nombre del padre
	 * @param name
	 */
	public void changeLastName(String lastname){
		this.lastname = lastname;
	}
	
	/**
	 * obtiene el género
	 * @return
	 */
	public static String getGender(){
		return "Male";
	} 
	
	
}
