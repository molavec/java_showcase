package net.casidiablo.rsa;

/*
 * RSA.java
 *
 * Creado 24 de octubre de 2007, 12:02 PM
 *
 */
import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 *
 * @author Casidiablo
 */
public class RSA {

	int primeSize;
    BigInteger n, prime1, prime2;
    BigInteger totient;
    BigInteger publica, privada;

    /** Constructor de la clase RSA */
    public RSA(int tamPrimo) {
        this.primeSize = tamPrimo;
        generatePrimeNumbers();             //Genera p y q
        generateKeys();             //Genera e y d
    }
    
    public void generatePrimeNumbers()
    {
        prime2 = new BigInteger(primeSize, 10, new Random());
        do prime1 = new BigInteger(primeSize, 10, new Random());
            while(prime1.compareTo(prime2)==0);
    }
    
    public void generateKeys()
    {
        // n = p * q
        n = prime2.multiply(prime1);
        // toltient = (p-1)*(q-1)
        totient = prime2.subtract(BigInteger.valueOf(1));
        totient = totient.multiply(prime1.subtract(BigInteger.valueOf(1)));
        // Elegimos un e coprimo de y menor que n
        do publica = new BigInteger(2 * primeSize, new Random());
            while((publica.compareTo(totient) != -1) || (publica.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0));
        // d = e^1 mod totient
        privada = publica.modInverse(totient);
    }
    
    /**
     * Encripta el texto usando la clave p�blica
     *
     * @param   mensaje     Ristra que contiene el mensaje a encriptar
     * @return   El mensaje cifrado como un vector de BigIntegers
     */
    public BigInteger[] encrypt(String mensaje)
    {
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];
        
        for(i=0; i<bigdigitos.length;i++){
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }
        
        BigInteger[] encriptado = new BigInteger[bigdigitos.length];
        
        for(i=0; i<bigdigitos.length; i++)
            encriptado[i] = bigdigitos[i].modPow(publica,n);
        
        return(encriptado);
    }
    
    /**
     * Desencripta el texto cifrado usando la clave privada
     *
     * @param   encriptado       Array de objetos BigInteger que contiene el texto cifrado que será desencriptado
     * @return  The decrypted plaintext
     */
    public String decrypt(BigInteger[] encriptado) {
        BigInteger[] desencriptado = new BigInteger[encriptado.length];
        
        for(int i=0; i<desencriptado.length; i++)
            desencriptado[i] = encriptado[i].modPow(privada,n);
        
        char[] charArray = new char[desencriptado.length];
        
        for(int i=0; i<charArray.length; i++)
            charArray[i] = (char) (desencriptado[i].intValue());
        
        return(new String(charArray));
    }
    
    public BigInteger damep() {return(prime2);}
    public BigInteger dameq() {return(prime1);}
    public BigInteger dametotient() {return(totient);}
    public BigInteger getNKey() {return(n);}
    public BigInteger getPublicKey() {return(publica);}
    public BigInteger getPrivateKey() {return(privada);}
}