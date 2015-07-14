package com.bitacorajava.encriptation;

import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/**
 * Genera las claves de uso y desencripta el vector de grandes enteros
 * encriptados con la llave actual
 * @author carfran
 * mail: carfrangar@gmail.com
 */
public class Desencriptador extends GeneradorClaves {

    /**
     * Constructor con clave de longiud por defecto
     */
    public Desencriptador(){}
    /**
     * Constructor con clave parametrizada
     * @param Longitud de clave (bits)
     */
    public Desencriptador(int longitud){
        renuevaClave(longitud);
    }

    /**
     * Desencripta el vector de grandes enteros y agruparlos en
     * una cadena literal. Se aplica la última generación de claves
     * (módulo y privada).
     * @param data - vector de grandes enteros encriptados
     * @return - Cadena literal con los valores originales (desencriptados)
     */
    public String desencripta(BigInteger[] data){
        StringBuilder st = new StringBuilder();
        //desencripta cada uno de lo grandes enteros vectorizados
        //convertir los enteros desencriptados en un arreglo de bytes
        //crear cadenas literales con los bytes desencriptados
        for(int i =0;i<data.length;i++){
            st.append(new String(data[i].modPow(getPrivada(), getModulo()).toByteArray()));
        }
        return st.toString();
    }
    
    /**
     * Desencripta el vector de grandes enteros y agruparlos en
     * una cadena literal. Se aplica la última generación de claves
     * (módulo y privada).
     * @param data - vector de grandes enteros encriptados
     * @param modulo
     * @param privateKey
     * @return - Cadena literal con los valores originales (desencriptados)
     */
    public String desencripta(BigInteger[] data, BigInteger modulo, BigInteger privateKey){
        StringBuilder st = new StringBuilder();
        //desencripta cada uno de lo grandes enteros vectorizados
        //convertir los enteros desencriptados en un arreglo de bytes
        //crear cadenas literales con los bytes desencriptados
        for(int i =0;i<data.length;i++){
            st.append(new String(data[i].modPow( privateKey, modulo).toByteArray()));
        }
        return st.toString();
    } 
    
    /**
     * Desencripta el vector de grandes enteros y agruparlos en
     * una cadena literal. Se aplica la última generación de claves
     * (módulo y privada).
     * @param data - vector de grandes enteros encriptados
     * @param modulo
     * @param privateKey
     * @return - Cadena literal con los valores originales (desencriptados)
     */
    public float desencriptaFloat(BigInteger[] data, BigInteger modulo, BigInteger privateKey){
        ByteBuffer bb = ByteBuffer.allocate(5);
        //desencripta cada uno de lo grandes enteros vectorizados
        //convertir los enteros desencriptados en un arreglo de bytes
        //crear cadenas literales con los bytes desencriptados
        for(int i =0;i<data.length;i++){
           byte[] dataFloat = data[i].modPow( privateKey, modulo).toByteArray();
           bb.put(dataFloat);
           //System.out.println("dataArray: "+new String(dataFloat));
           //System.out.println("dataArray.size(): "+ dataFloat.length);
        }
        
        try{
        	return bb.getFloat(0);
        }catch(BufferUnderflowException e){
        	e.printStackTrace();
        	return 0;
        }
    }
    
}
