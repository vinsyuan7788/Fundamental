package com.java.se.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 	This is a method to provide utility for conversion between object and bytes
 * 
 * @author VinceYuan
 *
 */
public class SerDeUtils {

	/**
	 * 	This is a method to convert an object to a byte array
	 *  -- Instance ---> ObjectOutputStream ---> ByteArrayOutputStream ---> Byte Array
	 * 
	 * @param instance
	 * @return
	 */
	public static <T> byte[] toByteArray(T object) {
		byte[] instanceBytes = null;
		try (
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		){
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			instanceBytes = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instanceBytes;
	}
	
	/**
	 * 	This is a method to convert a bytes to an object
	 * 	-- Byte Array ---> ByteArrayInputStream ---> ObjectInputStream ---> Instance
	 * 
	 * @param bytes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(byte[] bytes) {
		Object object = null;
		try (
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		) {
			object = objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) object;
	}
}
