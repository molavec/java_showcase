package cl.molavec.crypto;

import java.math.BigInteger;
import java.util.Random;

public class ObjectCipherRSAKeyGenerator {
	int primeSize;
	BigInteger bigNumber, prime2, prime1;
	BigInteger totient;
	BigInteger publicKey, privateKey;

	/** Constructor de la clase RSA */
	public ObjectCipherRSAKeyGenerator(int primeSize) {
		this.primeSize = primeSize;
		generatePrimeNumbers(); // Genera p y q
		generateKeys(); // Genera e y d
	}

	private void generatePrimeNumbers() {
		prime1 = new BigInteger(primeSize, 10, new Random());
		do
			prime2 = new BigInteger(primeSize, 10, new Random());
		while (prime2.compareTo(prime1) == 0);
	}

	private void generateKeys() {
		// n = p * q
		bigNumber = prime1.multiply(prime2);
		// toltient = (p-1)*(q-1)
		totient = prime1.subtract(BigInteger.valueOf(1));
		totient = totient.multiply(prime2.subtract(BigInteger.valueOf(1)));
		// Elegimos un e coprimo de y menor que n
		do
			publicKey = new BigInteger(2 * primeSize, new Random());
		while ((publicKey.compareTo(totient) != -1)
				|| (publicKey.gcd(totient).compareTo(BigInteger.valueOf(1)) != 0));
		// d = e^1 mod totient
		privateKey = publicKey.modInverse(totient);
	}

	public BigInteger getPrime1() {
		return (prime1);
	}

	public BigInteger getPrime2() {
		return (prime2);
	}

	public BigInteger getTotient() {
		return (totient);
	}

	public BigInteger getBigNumber() {
		return (bigNumber);
	}

	public BigInteger getPublicKey() {
		return (publicKey);
	}

	public BigInteger getPrivateKey() {
		return (privateKey);
	}
}
