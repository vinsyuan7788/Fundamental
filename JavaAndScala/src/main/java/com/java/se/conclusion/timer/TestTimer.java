package com.java.se.conclusion.timer;

import java.util.Date;
import java.util.Timer;

import com.java.se.conclusion.timer.common.CustomTimerTask;

/**
 * 	This is a class to test timer
 * 	-- Perform the testing of "Timer" class
 * 	-- Perform the testing of "Quartz" jars|framework
 * 
 * @author VinceYuan
 *
 */
public class TestTimer {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestTimer testTimer = new TestTimer();
		testTimer.testTimer();
		testTimer.testQuartz();
	}
	
	/**
	 * 	Test "Timer" class
	 */
	private void testTimer() {
		
		try {
			/*	Get a timer	 */
			Timer timer = new Timer();
			
			/*	Schedule a task starting at current date & repeating within 2000ms	 */
			timer.schedule(new CustomTimerTask(), new Date(), 2000);
			
			/*	Schedule a task starting after delaying 2000ms & then repeating within 2000ms	*/
//			timer.schedule(new CustomTimerTask(), 2000, 2000);
			
			/*	Schedule a task starting at 2/8/2016 00:00:00 & repeating within 24 hours	*/
//			Calendar calendar = Calendar.getInstance();
//			calendar.set(2016, 2, 8, 0, 0, 0);
//			Date date = calendar.getTime();
//			timer.schedule(new CustomTimerTask(), date, 1000*60*60*24);
			
			/*	Wait for 6s	 */
			Thread.sleep(6000);
			
			/*	Cancel the timer	*/
			timer.cancel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Test "Quartz" jars (or framework)
	 */
	private void testQuartz() {
		// Not yet tested...
	}
}
