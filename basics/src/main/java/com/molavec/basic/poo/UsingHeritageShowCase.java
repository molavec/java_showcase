package com.molavec.basic.poo;

import com.molavec.basic.poo.classes.ArgumentsTypes;
import com.molavec.basic.poo.classes.BandIntegrant;
import com.molavec.basic.poo.classes.FamilyIntegrant;

/**
 * Programa que sirve para analizar el funcionamiento de la Herencia de
 * clases
 * @author angel
 *
 */
public class UsingHeritageShowCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * EJEMPLOS DE USO DE CONSTRUCTORES EN LA CLASE FamilyIntgrant
		 */
		//Instanciar clase Integrant
		FamilyIntegrant integrant1 = new FamilyIntegrant();
		//Ver nombre completo de integrante1
		System.out.println("Nombre completo: "+integrant1.getCompleteName());
		
		
		FamilyIntegrant integrant2 = new FamilyIntegrant("Mikol", "jack", "son", "jr", 25);
		System.out.println("Nombre completo: "+integrant2.getCompleteName());
		
		FamilyIntegrant integrant3;
		integrant3 = new FamilyIntegrant("a", "b");
		System.out.println("Nombre y Apellido: "+integrant3.getCompleteName());
		
		/*
		 * EJEMPLOS DE USO DE CLASES PADRES E INTERFACES PARA EL INGRESO
		 * DE OBJETOS
		 */
		
		//notar que: FamilyIntegrant extends Integrant implements PersonManager 
		FamilyIntegrant familyIntegrant = new FamilyIntegrant("Fred", "Steve", "Simth", "Adams", 25);
		//notar que: BandIntegrant extends Integrant 
		BandIntegrant bandIntegrant = new BandIntegrant("Mikol", "Jackson", "Simpson", "Jr", "Los Rockeros");
		
		ArgumentsTypes.acceptIntegrantType(familyIntegrant);
		ArgumentsTypes.acceptIntegrantType(bandIntegrant);
		
		ArgumentsTypes.acceptFamilyIntegrantType(familyIntegrant);
		//ArgumentsTypes.acceptFamilyIntegrantType(bandIntegrant);
		
		//ArgumentsTypes.acceptBandIntegrantType(familyIntegrant);
		ArgumentsTypes.acceptBandIntegrantType(bandIntegrant);
		
		ArgumentsTypes.acceptPersonManagerType(familyIntegrant);
		//ArgumentsTypes.acceptPersonManagerType(bandIntegrant);
	}

	
	
}
