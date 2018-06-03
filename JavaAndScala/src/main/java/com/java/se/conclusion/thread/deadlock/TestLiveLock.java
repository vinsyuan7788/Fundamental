package com.java.se.conclusion.thread.deadlock;

/**
 * 	This is a class to test live lock
 * 
 * @author VinceYuan
 *
 */
public class TestLiveLock {

	/* Necessary instance variables */
	private String str1 = "Java";
	private String str2 = "Unix";
	private Thread thread;
	private Thread liveLockThread;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestLiveLock testLiveLock = new TestLiveLock();
		testLiveLock.testPreparation();
		testLiveLock.testLiveLock();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		thread = new Thread("Thread") {
			
			/*	Forever wait the mutex str1 and str2 subsequently	*/
			public void run() {
	            while(true){
	                synchronized(str1){
	                    synchronized(str2){
	                        System.out.println(this.getName() + ": " + (str1 + str2));
	                    }
	                }
	            }
			}
		};
		liveLockThread = new Thread("Thread for Livelock") {
			
			/*	Forever wait the mutex str1 and str2 subsequently	*/
			public void run() {
	            while(true){
	                synchronized(str1){
	                    synchronized(str2){
	                        System.out.println(this.getName() + ": " + (str1 + str2));
	                    }
	                }
	            }
			}
		};
	}
	
	/**
	 * 	Test live lock
	 */
	private void testLiveLock() {
		try {
			thread.start();
			liveLockThread.start();
			thread.join();
			liveLockThread.join();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
