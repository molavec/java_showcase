package com.molavec.basic.poo.classes;

/**
 * Clase Hija de Intergrant
 * @author angel
 *
 */
public  class BandIntegrant extends Integrant{
	
	/**
	 * nombre de la banda
	 */
	private String bandName;
	/**
	 * genero del integrante
	 */
	private String gender;
	
	/**
	 * Constructor con argumentos
	 * Se deben llenar todos los datos del Integrante.
	 * 
	 * @param name
	 * @param secondName
	 * @param lastName
	 * @param secondLastName
	 * @param bandName
	 */
	public BandIntegrant(
			String name, 
			String secondName, 
			String lastName, 
			String secondLastName, 
			String bandName
			){
		super(name, secondName, lastName, secondLastName, 0);
		this.bandName = bandName;
		
		this.gender = "undefined";
	}
	
	/**
	 * obtiene el nombre de la banda
	 * @return nombre de la banda
	 */
	public String getBandName(){
		return this.bandName;
	}
	
	/**
	 * define el nombre de la banda
	 * @param bandName nombre de la banda.
	 */
	public void changeBand(String bandName){
		this.bandName  = bandName;
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

}
