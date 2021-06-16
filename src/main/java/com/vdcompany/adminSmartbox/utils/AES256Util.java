package com.vdcompany.adminSmartbox.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


/**
 * @author han, sung-ku
 * @since 2015. 4. 13.
 * @version 1.0
 */
public class AES256Util {
	static Logger logger = LoggerFactory.getLogger(AES256Util.class);
	
	
	/**
	 * @param data
	 * @param key
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) throws Exception {
		SecretKey secureKey = new SecretKeySpec(key, "AES");
		
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(iv));
		
		return c.doFinal(data);
		
	}
	
	

	/**
	 * @param encData
	 * @param key
	 * @param iv
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] encData, byte[] key, byte[] iv) throws Exception {
		SecretKey secureKey = new SecretKeySpec(key, "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(iv));
		
		return c.doFinal(encData);
	}

	/**
	 * @param id
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String generateKey(String id, String password) throws Exception {
		String MD5 = ""; 
		
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(new StringBuffer(id).append(password).toString().getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			
			MD5 = sb.toString();
			
		} catch(NoSuchAlgorithmException e){
			logger.error("NoSuchAlgorithmException"+e);
			MD5 = null; 
		}
		
		return MD5;
	}
	
	
	/**
	 * @param string
	 * @return
	 */
	public static String generateIv(String string) {
		byte[] sbyte = string.getBytes();
		StringBuilder sb = new StringBuilder();
		
		short head = 9;
		short tail = 7;
		
		if(sbyte.length >= 25 && sbyte.length <= 48) {
			Random random = new Random();
			
			boolean isS = random.nextBoolean();
			int rpos = random.nextInt(5) + 1;
			
			if(isS) {
				sb.append(new String(sbyte, 0 + rpos, head));
				sb.append(new String(sbyte, (sbyte.length - tail) - rpos, tail));
				
			} else {
				sb.append(new String(sbyte, (sbyte.length - head) - rpos, head));
				sb.append(new String(sbyte, 0 + rpos, tail));
				
			}
			
		}
		
		return sb.toString();
		
	}
	
	

	/*
	public static void main(String args[]) throws Exception {
		String key = "e16b2ab8d12314bf4efbd62020170424";
		System.out.println(" key => " + "e16b2ab8d12314bf4efbd62020170424");
		
		//"e16b2ab8d12314bf4efbd6203906ea6c"
		//"01234567890123456789012345678901"
		
		String enc = AES256.encrypt("e16b2ab8d12314bf4efbd62020170424", "hahaha");
		
		System.out.println(" enc => " + enc);
		
		System.out.println(" dec => " + AES256.decrypt(key, enc));
		
		
		// Get the KeyGenerator
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128); // 192 and 256 bits may not be available

		// Generate the secret key specs.
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		
		
		System.out.println(" enc => " + enc);
		
	}
	*/
	
	public static void main(String[] args) throws Exception {
		String key = AES256Util.generateKey("test", "testpw" + System.currentTimeMillis());
		System.out.println("key : " + key);
		String iv = AES256Util.generateIv(key);
		
		System.out.println(" key : " + key + ", iv : " + iv);
		
		
	}
	
	/*
	public static void main(String[] args) throws Exception {
		String key = AES256Util.generateKey("test", "test123");
		String iv = "rtjeroijgdofijgs";
		String data = "testtesttest";
		
		System.out.println(" key => " + key);
		
		
		byte[] enc = AES256Util.encrypt(data.getBytes(), key.getBytes(), iv.getBytes());
		
		System.out.println("enc(hex) : " + ExtendBinaryUtil.encodeHex(enc));
		
		byte[] dec = AES256Util.decrypt(enc, key.getBytes(), iv.getBytes());
		
		System.out.println("dec : " + new String(dec));
		
	}
	*/
	
	
	
	
}