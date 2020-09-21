/**
 * 
 */
package no.hvl.dat159.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;


/**
 * @author tdoy
 *
 */
public class Asymmetric {

	/**
	 * 
	 */
	public static final String RSA = "RSA";
	
	private Cipher cipher;
	
	public Asymmetric(String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
		
		cipher = Cipher.getInstance(algorithm);
				
	}
	
	public String encrypt(String message, PublicKey publicKey) {
		
		// implement
		
		return null;
	}
	
	public String decrypt(String ciphertext, PrivateKey privateKey) {
		
		// implement
		
		return null;
	}
	
	public String encrypt(String message, PrivateKey privateKey) {
		
		// implement
		
		return null;
	}
	
	public String decrypt(String ciphertext, PublicKey publicKey) {
		
		// implement
		
		return null;
	}

}
