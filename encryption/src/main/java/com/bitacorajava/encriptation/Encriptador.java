package com.bitacorajava.encriptation;

import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/**
 *
 * @author carfran
 * mail: carfrangar@gmail.com
 */

/**
 *
 * @author carfrangar
 * mail: carfrangar@gmail.com
 * Clase para la encriptación de un texto, aplicando el módulo y la clave pública
 * Resultado a lojados en un vector de Grandes enteros, utilizando el relleno paa el elemento final del vector
 */
public class Encriptador {

	/**
     * Encripta con el algoritmo RSA (asincronico)
     * utilizando como elemento de agrupamiento y relleno
     * la longitud en bits de la clave publica.
     * @param modulo - modulo de la clave
     * @param publica - llave publica
     * @param texto - texto/literal a encriptar
     * @return arreglo de grandes enteros con valores resultantes de la encriptación
     */
    public BigInteger[] encripta(BigInteger modulo, BigInteger publica, String texto){
        int bytes = publica.bitLength()/16; //cantidad de bytes que requeridos en el generador de claves
        int cs = texto.length()/bytes;
        int rem = texto.length()-cs*bytes; //remanente
        if(rem>0) cs++; //agrega un subconjunto para el remanente
        BigInteger[] bi = new BigInteger[cs];
        if(cs==1){
            //encriptar un texto de longitud menor a la longitud de la clave
            bi[0] = new BigInteger(texto.getBytes()).modPow(publica, modulo);
        }
        else{
            for(int i=0;i<cs-1;i++){
                //encriptar subcadenas de longitud igual a bytes
                //subcadena inicia cada subconjunto de bytes
                //subcadena finaliza en el inicio de cada subconjunto con una longitud de bytes
                bi[i] = new BigInteger(texto.substring(i*bytes, i*bytes+bytes).getBytes()).modPow(publica, modulo);
            }
            //encriptar subcadena remanente
            //subcadena inicia cada subconjunto de bytes
            //subcadena finaliza con el ultimo elemento del texto
            bi[cs-1] = new BigInteger(texto.substring((cs-1)*bytes, texto.length()).getBytes()).modPow(publica, modulo);
        }
        return bi;
    }
    
    
    /**
     * Encripta con el algoritmo RSA (asincronico)
     * utilizando como elemento de agrupamiento y relleno
     * la longitud en bits de la clave publica.
     * @param modulo - modulo de la clave
     * @param publica - llave publica
     * @param value - texto/literal a encriptar
     * @return arreglo de grandes enteros con valores resultantes de la encriptación
     */
    public BigInteger[] encripta(BigInteger modulo, BigInteger publica, float value){
    	ByteBuffer floatBuffer = ByteBuffer.allocate(Float.SIZE/Byte.SIZE);
    	floatBuffer.putFloat(value);
    	

        int bytes = publica.bitLength()/16; //cantidad de bytes que requeridos en el generador de claves
        int cs = (Float.SIZE/Byte.SIZE)/bytes;
        int rem =  (Float.SIZE/Byte.SIZE)-cs*bytes; //remanente
        System.out.println("cs: "+cs+" rem: "+rem+" bytes: "+bytes+" Float.SIZE: "+Float.SIZE +" Byte.SIZE: "+Byte.SIZE);
        
        if(rem>0) cs++; //agrega un subconjunto para el remanente
        BigInteger[] bi = new BigInteger[cs];
        if(cs==1){
            //encriptar un texto de longitud menor a la longitud de la clave
        	//System.out.println("dataArray: "+ new String(floatBuffer.array()));
            bi[0] = new BigInteger(floatBuffer.array()).modPow(publica, modulo);
        }
        else{
        	byte[] remBytes = new byte[4] ; 
            for(int i=0;i<cs-1;i++){
                //encriptar subcadenas de longitud igual a bytes
                //subcadena inicia cada subconjunto de bytes
                //subcadena finaliza en el inicio de cada subconjunto con una longitud de bytes
            	try{
            		floatBuffer.get(remBytes, i*bytes, i*bytes+bytes);
            	}catch(BufferUnderflowException e){
            		System.out.println("BufferUnderflowException: -->"+e.getMessage());
            		e.printStackTrace();
            	}catch(IndexOutOfBoundsException e){
            		System.out.println("IndexOutOfBoundsException: -->"+e.getMessage());
            		e.printStackTrace();
            	}catch(Exception e){
            		System.out.println("Exception: -->"+e.getMessage());
            		e.printStackTrace();
            	}
                bi[i] = new BigInteger(remBytes).modPow(publica, modulo);
            }
            //encriptar subcadena remanente
            //subcadena inicia cada subconjunto de bytes
            //subcadena finaliza con el ultimo elemento del texto
            floatBuffer.get(remBytes, (cs-1)*bytes , cs+rem );
            bi[cs-1] = new BigInteger(remBytes).modPow(publica, modulo);
        }
        return bi;
    }
}
