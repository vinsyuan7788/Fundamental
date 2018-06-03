package com.java.se.conclusion.encryption;

import com.java.se.conclusion.encryption.util.EncryptionUtils;

/**
 * 	This is a class to test encryption
 * 
 * @author VinceYuan
 *
 */
public class TestEncryption {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestEncryption testEncryption = new TestEncryption();
		testEncryption.testMD5();
	}
	
	/**
	 * 	Test MD5
	 */
	private void testMD5() {
	
		/*	Initialize a string	*/
		String string = "Hello World!";
		
		/*	Do the encryption	*/
		System.out.println("The original string: " + string);
		System.out.println("The encrypted string: " + EncryptionUtils.encryptByMD5(string));
	}
}
