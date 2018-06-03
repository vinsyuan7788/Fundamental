package com.java.se.conclusion.timer.common;

import java.util.TimerTask;

/**
 * 	This is a class to implement timer
 * 
 * @author VinceYuan
 *
 */
public class CustomTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("My task is running...");
	}

}
