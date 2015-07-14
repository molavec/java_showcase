package cl.molavec.serialization;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que permite guardar y rescatar objetos desde archivos.
 * 
 * TODO: añadir datos serializables a un archivo ya cerrado. TODO: obtener el
 * arreglo de bytes.
 * 
 * Nota: cuando se guarda a un archivo datos serializables, se agrega un
 * encabezado. Esto al parecer causa un problema cuando se quiere añadir un
 * datos a un archivo cerrado, ya que se ingresa nuevamente el encabezado lo que
 * corrompe el archivo.
 * 
 * 
 * @author angel
 * 
 * @param <T>
 *            el tipo de objeto a serializar
 * 
 */
public class ObjectPersister<T> {

	/**
	 * Rescata un objeto de tipo T desde un archivo
	 * 
	 * @param file
	 *            Archivo desde el que se rescatará el archivo
	 * @return
	 * @throws IOException
	 *             En caso de que no se encuentre el archivo
	 * @throws ClassNotFoundException
	 *             En caso de que el archivo de que no se pueda extraer el
	 *             objeto desde el archivo.
	 * 
	 *             Las causas probables pueden ser que el archivo esté corrupto
	 *             o que contenga una clase distinta a la que se quiere
	 *             rescatar.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public T fileToObject(File file) throws IOException, ClassNotFoundException {

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		T t = (T) ois.readObject();
		fis.close();
		ois.close();
		return t;

	}

	/**
	 * retorna los objetos almacenados en el archivo.
	 * 
	 * @return Lista de objetos
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<T> fileToObjects(File file) throws ClassNotFoundException,
			IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		T data = null;
		ArrayList<T> dataList = new ArrayList<T>();
		try {
			// While there is objects
			do {
				data = (T) ois.readObject();
				dataList.add(data);
				// System.out.println("se lee el dato -->" +data);
			} while (data != null);
		} catch (EOFException e1) {
			// System.out.println ("Fin de fichero");
		}
		ois.close();
		return dataList;
	}

	/**
	 * guarda un objeto en el archivo indicado.
	 * 
	 * @param obj
	 *            objeto que se desea serializar
	 * @param file
	 *            archivo en el que se guardará el archivo.
	 * @throws IOException
	 *             en caso de que no se pueda crear el archivo.
	 * 
	 * @see cl.molavec.ObjectPersister
	 * 
	 */
	public void objectToFile(T obj, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}

	/**
	 * Añade un objeto a un archivo
	 * 
	 * 
	 * @param obj
	 *            objeto que se desea serializar
	 * @param file
	 *            archivo en el que se guardará el archivo.
	 * @throws IOException
	 *             en caso de que no se pueda crear el archivo.
	 * @see cl.molavec.ObjectPersister
	 */
	public void appendObjectToFile(T obj, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file, true);
		NoHeaderObjectOutputStream oos = new NoHeaderObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}

	/**
	 * Guarda una lista de objetos en el archivo
	 * 
	 * @param dataList
	 *            lista de objetos serializables.
	 * @throws IOException
	 *             en case de que el output stream hacia el archivo tenga
	 *             problemas.
	 * @see cl.molavec.ObjectPersister
	 */
	public void objectsToFile(List<T> dataList, File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (T data : dataList) {
			oos.writeObject(data);
		}
		oos.close();
	}

	/**
	 * Esta clase permite añadir archivos datos en archivos sin colocar
	 * cabeceras
	 * 
	 * Mas info: http://www.chuidiang.com/java/ficheros/ObjetosFichero.php
	 * 
	 * @author angel
	 * 
	 */
	private class NoHeaderObjectOutputStream extends ObjectOutputStream {

		public NoHeaderObjectOutputStream(OutputStream out) throws IOException {
			super(out);
			// TODO Auto-generated constructor stub
		}

		/**
		 * método que sobreescribe la inserción de cabeceras
		 */
		@Override
		protected void writeStreamHeader() throws IOException {
			// Do nothing
		}

	}
}

