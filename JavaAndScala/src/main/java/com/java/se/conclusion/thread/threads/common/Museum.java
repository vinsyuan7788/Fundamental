package com.java.se.conclusion.thread.threads.common;

/**
 * 	This is a class to implement a thread
 *  -- This class must inherit Thread class
 *  -- This class can customize instance variables and constructors
 *  
 * @author VinceYuan
 *
 */
public class Museum extends Thread {
	
	/*	Instance variables	*/
	private long millionSeconds = 0;
	
	/*	Constructors	*/
	public Museum() {};
	public Museum(long millionSeconds) {
		super();
		this.millionSeconds = millionSeconds;
	}

	/**
	 * 	Override this method to specify a job to finish
	 */
	@Override
	public void run() {
		
		try {
			/*	Job starts	*/
			System.out.println("Museum is opened...");
			
			/*	Start another thread	*/
			Thread visitor = new Thread(() -> { 
				System.out.println("A visitor is walking around....");
				System.out.println("A visitor is taking pictures..."); 
				System.out.println("A visitor is having a rest.....");
			});
			visitor.start();
			
			/*	Sleep for a while to allow other threads finish the jobs	*/
			sleep(millionSeconds);
			
			/*	Job ends	*/
			System.out.println("Museum is closed...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
