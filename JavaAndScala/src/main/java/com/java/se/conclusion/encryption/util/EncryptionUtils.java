package com.java.se.conclusion.encryption.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 	This is a class to implement encryption utility method
 * 
 * @author VinceYuan
 *
 */
public class EncryptionUtils {

	/**
	 * 	This is a method to encrypt a string by MD5
	 * @param string
	 * @return
	 */
	public static String encryptByMD5(String string) {
		
		try {
			/*	MD5 encryption	*/
			byte[] digest = MessageDigest.getInstance("MD5").digest(string.getBytes());
			
			/*	Return the encrypted string	 */
			return new BigInteger(1, digest).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*	If there is any exception, return null	*/
		return null;
	}
}
