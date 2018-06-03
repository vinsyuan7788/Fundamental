package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.immutable.finals.common;

/**
 * 	This is a class to simulate the management of instances of all types
 * 
 * @author VinceYuan
 *
 */
public class InstanceManager {

	/*	Here are String-typed instances	 */
	private final String USERNAME= "Vince";
	private final String PASSWORD = "Vince";
	
	/**
	 * 	Here are the getters for final instances
	 * 	-- Final variables are not allowed to assign corresponding setters
	 * 
	 * @return
	 */
	public String getUSERNAME() {
		return USERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
}
