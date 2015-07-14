package com.molavec.basic.poo.classes;


/**
 * Esta clase sirve para probar que tipo de argumentos 
 * se pueden igresar y como las clases que implementan 
 * interfaces o son hijas son aceptadas.
 *  
 * @author angel
 *
 */
public class ArgumentsTypes {
	
	/**
	 * Esta clase acepta objetos que deriven de Integrant
	 * 
	 * @param i se pueden ingresar 
	 */
	public static void acceptIntegrantType(Integrant i){
		System.out.println(i.getCompleteName());
		System.out.println(i.getGender());
	}
	public static void acceptFamilyIntegrantType(FamilyIntegrant fi){
		System.out.println(fi.getAge());
	}
	public static void acceptBandIntegrantType(BandIntegrant bi){
		System.out.println(bi.getBandName());
	}
	public static void acceptPersonManagerType(PersonManager p){
		System.out.println(p.getLastName());
	}
	
}
