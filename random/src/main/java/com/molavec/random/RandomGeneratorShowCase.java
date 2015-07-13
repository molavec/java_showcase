package com.molavec.random;

import com.molavec.random.RandomGenerator;

public class RandomGeneratorShowCase {

	public static void main(String[] args) throws Exception {
		
		System.out.println("boolean: " + RandomGenerator.nextBoolean());
		System.out.println("int: " + RandomGenerator.nextInt());
		System.out.println("float: " + RandomGenerator.nextFloat());
		System.out.println("double: " + RandomGenerator.nextDouble());
		System.out.println("long: " + RandomGenerator.nextLong());
		System.out.println("----------------------");
		System.out.println("int: " + RandomGenerator.nextInt(-11,3));
		System.out.println("float: " + RandomGenerator.nextFloat(50,100));
		System.out.println("float: " + RandomGenerator.nextFloat(0.004f,0.020f));

	}

}
