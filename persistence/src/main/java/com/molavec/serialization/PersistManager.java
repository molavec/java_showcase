package com.molavec.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Se encarga guardar u obtener un arreglo de bytes
 * desde una clase serializable
 * 
 * TODO: añadir datos serializables a un archivo ya cerrado.
 * TODO: obtener el arreglo de bytes.
 * 
 * Nota: cuando se guarda a un archivo datos serializables, se agrega un 
 * encabezado. Esto al parecer causa un problema cuando se quiere añadir 
 * un datos a un archivo cerrado, ya que se ingresa nuevamente el 
 * encabezado lo que corrompe el archivo. 
 * 
 * @author molavec
 * @param <T> un tipo de objeto
 * @version 0.5
 * 
 */
public class PersistManager<T> {

	//campos asociados al archivo
	private String filename;
	private FileInputStream fis;
	private FileOutputStream fos;
	
	/**
	 * Constructor de la clase.
	 * 
	 * @param filename nombre del archivo en el que se guardaran los datos 
	 * 			serializados. 
	 * 
	 * @throws FileNotFoundException en caso de que no se pueda crear el archivo
	 */
	PersistManager(String filename) throws FileNotFoundException{
		this.filename = filename;
		fis = new FileInputStream(this.filename);
		fos = new FileOutputStream(this.filename);		
	}
	
	/**
	 * Guarda un dato serializable en un archivo
	 * @param data objeto seriablizable
	 * @throws IOException en case de que el output stream hacia el archivo tenga 
	 * problemas.
	 */
	public void saveToFile(T data) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(data);
		oos.close();
	}
	
	/**
	 * Guarda una lista de objetos en el archivo
	 * @param dataList lista de objetos serializables.
	 * @throws IOException en case de que el output stream hacia el archivo tenga 
	 * problemas.
	 */
	public void saveToFile(List<T> dataList) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(T data : dataList){
			oos.writeObject(data);
		}
		oos.close();
	}
	
	/**
	 * Retorna un objeto desde un archivo
	 * Nota: presume que debe existir un único objeto en el archivo. 
	 * 
	 * @return el objeto
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public T loadUniqueFromFile() throws ClassNotFoundException, IOException{
		ObjectInputStream ois = new ObjectInputStream(fis);
		T data = null;
		data = (T) ois.readObject();
        ois.close();
        return data;
	}
	
	/**
	 * retorna los objetos almacenados en el archivo.
	 * @return Lista de objetos
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public List<T> loadFromFile() throws ClassNotFoundException, IOException{
		 ObjectInputStream ois = new ObjectInputStream(fis);
		 T data = null;
		 ArrayList<T> dataList = new ArrayList<T>();
		 try{
			 // While there is objects
	         do{
				data = (T) ois.readObject();
				dataList.add(data);
				//System.out.println("se lee el dato -->" +data);
	         }while (data != null);
		 }catch (EOFException e1){
            //System.out.println ("Fin de fichero");
		 }
         ois.close();
         return dataList;
	}
	
	
	/**
	 * TODO: Hacer.
	 * @param entity
	 * @return
	 */
	public byte[] toByteArray(T entity){
		return null;
	}

}
