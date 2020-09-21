package no.hvl.dat159.test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.DHParameterSpec;
import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

import no.hvl.dat159.crypto.DiffieHellmanKeyExchange;

/**
 * @author tdoy
 *
 */

class DiffieHellmanKeyExchangeTest {

	@Test
	void test() throws InvalidKeyException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeySpecException, IllegalStateException, NoSuchPaddingException {
		
		/** client generates dhparam and computes its own version of public key */
		DiffieHellmanKeyExchange clientdhke = new DiffieHellmanKeyExchange();
		clientdhke.generateDiffieHellmanParam();
		DHParameterSpec cdhparam = clientdhke.getDHparameter();
		
		byte[] cpubkey = clientdhke.getPublicKey(cdhparam);					// Client: This will be A = 2^x mod P
				
		
		// server receives client's public key and extracts the dhparam and then computes its own public key
		DiffieHellmanKeyExchange serverdhke = new DiffieHellmanKeyExchange();
		DHParameterSpec sdhparam = serverdhke.getDHParamSpec(cpubkey);		// derives the dhparam (g, P) from client's public key
		
		byte[] spubkey = serverdhke.getPublicKey(sdhparam);					// Server: This will be B = 2^y mod P
		
		
		/** Computing secret key */
		// client receives server's public key and computes secret key
		byte[] clientsecretkey = clientdhke.computeSecretKey(spubkey);		// Client: This will be secretkey = B^x mod P
		
		// server receives client's public key and computes secret key
		byte[] serversecretkey = serverdhke.computeSecretKey(cpubkey);		// Server: This will be secretkey = A^y mod P
	
		System.out.println("client's computed secret = "+DatatypeConverter.printHexBinary(clientsecretkey));
		System.out.println("server's computed secret = "+DatatypeConverter.printHexBinary(serversecretkey));
		
		assertArrayEquals(clientsecretkey, serversecretkey);
		
		/**
		 * * Further example of how to use the secret key to compute AES key - can be used independently by the client and server
		 * 
		 * String scipher = serverdhke.encrypt("Message", serverdhke.getAESKey(serversecretkey), "AES");
		 * System.out.println(scipher);
		 * String ptext = clientdhke.decrypt(scipher, clientdhke.getAESKey(clientsecretkey), "AES");
		 * System.out.println(ptext);
		 * 
		 */
		
	}

}
