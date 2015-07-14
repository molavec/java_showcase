package com.bitacorajava.encriptation;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author carfran
 * mail: carfrangar@gmail.com
 * Clase para la generación de objetos contentivos de herramientas para la
 * creación de claves asincrónicas, originadas con la metodología RSA.
 *
 */

public class GeneradorClaves {
    private int longbits = 512; //longitud de bits
    private BigInteger modulo,publica,privada; //módulo,pública,privada

    /**
     * Constructor con claves de longitud 512 (por defecto)
     */
    public GeneradorClaves(){
        generarClaves();
    }

    /**
     * Constructor con claves de longitud parametrizada en bits
     * @param bits - longitud de clave
     */
    public GeneradorClaves(int bits){
        nuevaClave(bits);
    }
    
    /**
     * Genera un nuevo conjunto de claves
     * de longitud parametrizada.
     * módulo, pública y privada
     * @param bits - longitud de la nueva clave
     */
    public void renuevaClave(int bits){
        nuevaClave(bits);
    }
    
    private void nuevaClave(int bits){
        longbits = bits;
        if(longbits<64){longbits=64;}//mínimo 64 bits
        else if(longbits>1024){longbits=1024;}//maximo 1024 bits
        generarClaves();
    }

    /**
     * Genera un nuevo conjunto de claves
     * de longitud prefijada.
     * módulo, pública y privada
     */
    private void generarClaves(){
        BigInteger q, p, ffi;
        p = new BigInteger(longbits, 10, new Random()); //genera un número primo de longitud lb
        //genera un número primo de longitud lb distinto a la generación anterior
        do q = new BigInteger(longbits, 10, new Random());
            while(q.compareTo(p)==0);
        modulo = p.multiply(q);//producto de los primos
        ffi = p.subtract(BigInteger.valueOf(1));//p-1
        ffi = ffi.multiply(q.subtract(BigInteger.valueOf(1)));//(p-1)*(q-1) Euler
        //calcula un coprimo distinto de Euler y  que sea el mayor común divisor de Euler
        //asigna el resultado como variable publica
        do publica = new BigInteger(2 * longbits, new Random());
            while((publica.compareTo(ffi) != -1) ||
            		(publica.gcd(ffi).compareTo(BigInteger.valueOf(1)) != 0));
        privada = publica.modInverse(ffi);//variable privada asignada como inverso de la variable Euler
    }

    /**
     *
     * @return módulo
     */
    public BigInteger getModulo(){
    	return modulo;
    }

    /**
     *
     * @return llave pública
     */
    public BigInteger getPublica(){
    	return publica;
    }

    /**
     *
     * @return llave privada
     */
    public BigInteger getPrivada(){
    	return privada;
    }
}