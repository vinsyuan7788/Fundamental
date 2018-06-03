package com.java.se.conclusion.design.factory.singleton;

/**
 * 	This is a class to implement lazy singleton factory pattern
 * 	-- Declare a private, static and Object-typed reference
 *  -- Declare a public and static getter to get this unique object:
 *     -- Double-checked locking pattern is used in this pattern
 *     
 * @author VinceYuan
 *
 */
public class LazySingletonFactory {

	/**
	 * 	Declare a private, static and Object-typed reference
	 */
	private static volatile Object INSTANCE;
	
	/**
	 * 	Declare a public and static getter to get this unique object: this should be used on or after J2SE 5.0
	 *	-- If the object is not instantiated, then create an instance
	 *	-- If the object has been instantiated, then directly return the instance
	 * @param clazz
	 * @return
	 */
	public static Object getInstance(Class<?> clazz) {
		
		/*	If the object is not instantiated, then create an instance	 */
		if (INSTANCE == null || INSTANCE.equals(null)) {
			/**
			 * 	Here is double-checked locking pattern
			 *  -- Make sure there is always only one thread accessing the resource in this synchronized block
			 *  -- Once the instance is created, this synchronized block will never be accessed
			 */
			synchronized (LazySingletonFactory.class) {
				if (INSTANCE == null || INSTANCE.equals(null)) {
					try {
						INSTANCE = clazz.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		/*	Return the instance	 */
		return INSTANCE;
	}
}
