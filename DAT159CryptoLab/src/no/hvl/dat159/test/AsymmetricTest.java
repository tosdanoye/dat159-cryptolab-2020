/**
 * 
 */
package no.hvl.dat159.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.Test;

import no.hvl.dat159.crypto.Asymmetric;

/**
 * @author tdoy
 *
 */
class AsymmetricTest {

	@Test
	void test() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException {
		
		String message = "This is a sample message encrypted with RSA!";
		
		// generate key pair
		int keysize = 1024;			// 1024 bits
		KeyPairGenerator kpm = KeyPairGenerator.getInstance("RSA");
		kpm.initialize(keysize);
		KeyPair keys = kpm.generateKeyPair();
		
		PrivateKey privKey = keys.getPrivate();
		PublicKey pubKey = keys.getPublic();
		
		Asymmetric asy = new Asymmetric(Asymmetric.RSA);				// RSA
		String ciphertext = asy.encrypt(message, pubKey);				// use your public key to encrypt
		String plaintext = asy.decrypt(ciphertext, privKey);			// use your private key to decrypt
		
		System.out.println("Expected = "+message);
		System.out.println("Actual = "+plaintext);
		
		assertArrayEquals(message.getBytes(), plaintext.getBytes());  	// shows encryption/decryption works
		
	}

}
