package org.lang.scala.conclusion.concurrent.multithreading.concurrent_workers.safety.mutable.volatiles.common;

/**
 * 	This is a class to test "volatile" keyword
 * 
 * 	@author VinceYuan
 */
public class ChangeNumberJava extends Thread {

	/*	Necessary instance variables	*/
	private NumberManagerJava numberManager;
	
	/*	Necessary constructors	*/
	public ChangeNumberJava(NumberManagerJava numberManager) {
		this.numberManager = numberManager;
	}
	
	/**
	 * 	This is a method to specify what exactly this thread needs to run
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		changeNumber();
	}
	
	/**
	 * 	This is a method to change the numbers
	 */
	private void changeNumber() {
		numberManager.change();
	}
}
