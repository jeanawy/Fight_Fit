package th.fight.fit.mpybackoffice.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import th.fight.fit.mpybackoffice.constant.ProjectConstant;
import th.fight.fit.mpybackoffice.formatter.LogFormatter;

public class SecurityUtil {

	private static final Logger systemLogger = Logger.getLogger(ProjectConstant.APPENDER_SYSTEM_LOG);
	private static final Logger errorLogger = Logger.getLogger(ProjectConstant.APPENDER_ERROR_LOG);
	
	public static String hashData(String plainText) throws NoSuchAlgorithmException{ 
		String HASH_CODE_ALGORITHM = "MD5";

		MessageDigest md = MessageDigest.getInstance(HASH_CODE_ALGORITHM); // SHA or MD5
		String hash = "";

		md.update(plainText.getBytes()); // Reads it all at one go. Might be better to chunk it.

		byte[] digest = md.digest();

		for (int i = 0; i < digest.length; i++)
		{
			String hex = Integer.toHexString(digest[i]);
			if (hex.length() == 1) hex = "0" + hex;
			hex = hex.substring(hex.length() - 2);
			hash += hex;
		} 

		return hash;

	}

	// Added by Ratapong W. 20151209.
	public static String encryptStringBase64(String plaintext, String keyPath) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException {
		if (plaintext != null) {
			try{
				byte[] encrypted = encryptString(plaintext, keyPath);
				return new String(encrypted, "US-ASCII");
			}catch (UnsupportedEncodingException ex){
				// Should never happen, US_ASCII is supported in all VM's
				ex.printStackTrace();
				errorLogger.error(LogFormatter.error(ex));
				errorLogger.error("ERROR : US_ASCII encoding not supported");

			}
		}

		return null;
	}

	public static String decryptStringBase64(String encrypted, String keyPath) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException  {
		if (encrypted != null){
			try {
				byte[] encryptedBytes = encrypted.getBytes("US-ASCII");
				return decryptString(encryptedBytes, keyPath);
			}catch (UnsupportedEncodingException ex) {
				// Should never happen, US_ASCII is supported in all VM's
				ex.printStackTrace();
				errorLogger.error(LogFormatter.error(ex));
				errorLogger.error("ERROR : US_ASCII encoding not supported");
				
			}
		}
		return ( null );
	}

	private static byte[] encryptString(String plaintext, String keyPath) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IOException  {
		if (plaintext != null) {
			try{
				byte[] encrypted = encrypt(plaintext.getBytes("UTF8"), keyPath);
				//                byte[] base64encrypted = Base64.encode ( encrypted );
				byte[] base64encrypted =  (new sun.misc.BASE64Encoder().encode(encrypted)).getBytes();

				return ( base64encrypted );
				// return ( encrypt ( encrypted ) );
			}catch (UnsupportedEncodingException ex){
				// Should never happen, US_ASCII is supported in all VM's
				ex.printStackTrace();
				errorLogger.error(LogFormatter.error(ex));
				errorLogger.error("ERROR : US_ASCII encoding not supported");
			}
		}
		return ( null );
	}

	private static String decryptString(byte[] rawdata, String keyPath) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException  {
		if (rawdata != null){
			try {
				//byte[] base64rawdata = Base64.decode ( rawdata );
				byte[] base64rawdata = new sun.misc.BASE64Decoder().decodeBuffer(new String(rawdata));
				byte[] decrypted = decrypt ( base64rawdata, keyPath );
				return ( new String ( decrypted, "UTF8" ) );
			}catch (UnsupportedEncodingException ex){
				// Should never happen, US_ASCII is supported in all VM's
				ex.printStackTrace();
				errorLogger.error(LogFormatter.error(ex));
				errorLogger.error("ERROR : US_ASCII encoding not supported");

			}
		}
		return ( null );
	}

	private static byte[] encrypt(byte[] data, String keyPath) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	, NoSuchAlgorithmException, IOException,NoSuchPaddingException, InvalidKeySpecException {
		Cipher encryptCipher = null;
		encryptCipher = Cipher.getInstance ("DESede/ECB/PKCS5Padding");
		//encryptCipher.init(Cipher.ENCRYPT_MODE, readKey(new File(keyFilePath)));
		encryptCipher.init(Cipher.ENCRYPT_MODE, readKey(new File(keyPath)));

		return encryptCipher !=null?encryptCipher.doFinal(data):null;
	}

	private static byte[] decrypt(byte[] data, String keyPath) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, IOException,
	NoSuchPaddingException, InvalidKeySpecException  {
		Cipher decryptCipher = null;

		decryptCipher = Cipher.getInstance ("DESede/ECB/PKCS5Padding");
		//decryptCipher.init(Cipher.DECRYPT_MODE, readKey(new File(keyFilePath)));
		decryptCipher.init(Cipher.DECRYPT_MODE, readKey(new File(keyPath)));

		return decryptCipher !=null?decryptCipher.doFinal(data):null;
	}

	private static SecretKey readKey(File f) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {        
		// Read the raw bytes from the keyfile
		DataInputStream datin = new DataInputStream(new FileInputStream(f));
		byte[] rawkey = new byte[(int) f.length()];
		datin.readFully(rawkey);
		datin.close();

		// Convert the raw bytes to a secret key like this
		DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyfactory.generateSecret(keyspec);
		return key;
	}
	
}
