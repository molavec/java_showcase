package com.molavec.random;

import org.apache.commons.math3.random.Well19937c;

/**
 * Genera números aleatorios utilizando la clase Well19937c del paquete
 * org.apache.commons.math3.random.
 * 
 * @author angel
 * 
 * @see org.apache.commons.math3.random.Well19937c
 * 
 */
public class RandomGenerator {

	/**
	 * Genera un booleano aleatoriamente
	 * 
	 * @return valor aleatorio
	 */
	public static boolean nextBoolean() {
		Well19937c random = new Well19937c();
		return random.nextBoolean();
	}

	/**
	 * Genera un entero aleatoriamente
	 * 
	 * @return valor aleatorio
	 */
	public static int nextInt() {
		Well19937c random = new Well19937c();
		return random.nextInt();
	}

	/**
	 * Genera un flotante aleatoriamente
	 * 
	 * @return valor aleatorio
	 */
	public static float nextFloat() {
		Well19937c random = new Well19937c();
		return random.nextFloat();
	}

	/**
	 * Genera un doble aleatoriamente
	 * 
	 * @return valor aleatorio
	 */
	public static double nextDouble() {
		Well19937c random = new Well19937c();
		return random.nextDouble();
	}

	/**
	 * Genera un long aleatoriamente
	 * 
	 * @return valor aleatorio
	 */
	public static long nextLong() {
		Well19937c random = new Well19937c();
		return random.nextLong();
	}

	/**
	 * Genera un entero aleatorio entre un máximo y un mínimo
	 * 
	 * @param min
	 *            mímino valor entero que puede obtener el valor aleatorio
	 * @param max
	 *            mávimo valor entero que se puede obtener
	 * @return valor aleatorio
	 */
	public static int nextInt(int min, int max) {
		Well19937c random = new Well19937c();
		return random.nextInt(max - min) + min;
	}

	/**
	 * Genera un flotante aleatorio entre un máximo y un mínimo entero
	 * 
	 * @param min
	 *            mímino valor entero que puede obtener el valor aleatorio
	 * @param max
	 *            mávimo valor entero que se puede obtener
	 * @return valor aleatorio
	 */
	public static float nextFloat(int min, int max) {
		Well19937c random = new Well19937c();
		int integerPart = random.nextInt(max - min) + min;
		if (integerPart == max) {
			return random.nextFloat() + integerPart - 1;
		} else {
			return random.nextFloat() + integerPart;
		}

	}

	/**
	 * Genera un flotante aleatorio entre un máximo y un mínimo flotante
	 * 
	 * @param min
	 *            mímino valor entero que puede obtener el valor aleatorio
	 * @param max
	 *            mávimo valor entero que se puede obtener
	 *            
	 * @return valor aleatorio
	 * 
	 * @throws Exception 
	 */
	public static float nextFloat(float min, float max) throws Exception {
		
		if(min==max){
	        throw new Exception("Both the numbers can not be equal");
	    }
		
		Well19937c random = new Well19937c();
		float rand = random.nextFloat();
		float highRange = Math.max(max, min);
		float lowRange = Math.min(max, min);

		float lowRand = (float) Math.floor(rand - 1);
		float highRand = (float) Math.ceil(rand + 1);

		float genRand = (highRange - lowRange)
				* ((rand - lowRand) / (highRand - lowRand)) + lowRange;
		return genRand;

	}

}
