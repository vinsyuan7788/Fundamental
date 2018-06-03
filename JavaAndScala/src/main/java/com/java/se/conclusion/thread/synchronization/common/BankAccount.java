package com.java.se.conclusion.thread.synchronization.common;

/**
 * 	This is a class to implement synchronization
 *  -- Using synchronized method
 *  
 * @author VinceYuan
 *
 */
public class BankAccount implements Runnable {
	
	/*	This is the sharable resource for all possible threads	*/
	private static int currentDeposit = 5000;
	
	/*	Specify what current thread does: just specify and not invoke it	 */
	@Override
	public void run() {
		try {
			getMoney();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**	
	 * 	Synchronized method to resolve thread safety
	 * 	-- For static method: the mutex is "BankAccount.class" (unique and sharable) by default and unchangably
	 * 	-- For instance method: the mutex is the object that "this" keyword refers to (not unique and unsharable) by default and unchangably
	 */
	private static synchronized void getMoney () throws Exception {
		
		while (true) {
			if (currentDeposit > 0) {
				System.out.println(Thread.currentThread().getName() + " withdrawn 100 bucks");
				currentDeposit -= 100;
			} else {
				System.out.println("Current deposit has become 0");
				break;
			}
		}
	}
}
