/**
 * 
 */
package no.hvl.dat159.crypto;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


/**
 * @author tdoy
 *
 */
public class DiffieHellmanKeyExchange {

	public static final String AES = "AES";
	
	private KeyPair keypair;
	private KeyAgreement keyagreement;
	
	private DHParameterSpec DHparameter;
	
	/**
	 * 
	 */
	public DiffieHellmanKeyExchange() {}
	
	/**
	 * 
	 */
	public DHParameterSpec generateDiffieHellmanParam() {
		
		// implement 
		// base generator, g (primitive root) and prime, P (1024 bits)

		
		return null; 					// return DHParameter
	}
	
	/**
	 * 
	 * @param dhparam
	 * @return pubkeybytes byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 */
	public byte[] getPublicKey(DHParameterSpec dhparam) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
		
		// implement
        
        return null;
		
	}
	
	/**
	 * 
	 * @param receivedpubkey
	 * @param dhparam
	 * @return sharedkey byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws InvalidKeyException
	 * @throws IllegalStateException
	 */
	public byte[] computeSecretKey(byte[] receivedpubkey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalStateException {
		
		KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
        
		// implement 
        
        return null;		// return key
		
	}
	
	/**
	 * 
	 * @param publickey
	 * @return dhparamspec
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 */
	public DHParameterSpec getDHParamSpec(byte[] receivedpubkey) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
       
		// implement
		
		return null;
	}
	
	public PublicKey getPublicKey(byte[] pubkeybytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		KeyFactory keyFactory = KeyFactory.getInstance("DiffieHellman");
	       
		// implement
		
		return null;
	}
	
	/**
	 * 
	 * @param sharedsecret
	 * @return SecretKeySpec object
	 */
	public SecretKeySpec getAESKey(byte[] sharedsecret) {
		
		SecretKeySpec key = new SecretKeySpec(sharedsecret, 0, 16, AES);		// create 16bytes AES key from the shared secret
		
		return key;
	}

	/**
	 * @return the dHparameter
	 */
	public DHParameterSpec getDHparameter() {
		return DHparameter;
	}
	
	
	public String encrypt(String message, Key secretkey, String alg) throws NoSuchAlgorithmException, NoSuchPaddingException {
		
		// implement
		
		return null;
	}
	
	public String decrypt(String ciphertext, Key secretkey, String alg) throws NoSuchAlgorithmException, NoSuchPaddingException {
		
		// implement
		
		return null;
	}
	

}
