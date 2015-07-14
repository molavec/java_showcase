package com.molavec.basic.poo;

import com.molavec.basic.poo.classes.StandardClass;


/**
 * Esta aplicación utilizará la clase Father.
 * 
 * Se crearán varios objetos de la clase Father
 * y se analizará sus comportamientos.
 * @author angel
 *
 */
public class UsingStandardClassShowCase {

	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Declaración del objeto
		StandardClass father1;
		
		//Creación o instanciamiento de objetos
		//1.- crear un objeto con valores por defecto.
		father1 = new StandardClass();
		
		
		//3.- crear un objeto con valores ingresados por parámetros. 
		StandardClass father3 = new StandardClass("Miguel", "Olave");
		
		System.out.println(father3.getName());
		
		//Análisis del comportamiento de los objetos
		System.out.println("Se obtienen los nombres...");
		System.out.println("Father 1:" + father1.getName());
		System.out.println("Father 3:" + father3.getName());
		
		

		System.out.println("Se obtienen los apellidos...");
		System.out.println("Father 1:" + father1.getLastName());
		System.out.println("Father 3:" + father3.getLastName());
		
		System.out.println("Manejo de metodos estáticos...");
		System.out.println("Get Gender: " + StandardClass.getGender());
		System.out.println("Valor Abs. de -3: " + Math.abs(-3));
		
		
	}

}
