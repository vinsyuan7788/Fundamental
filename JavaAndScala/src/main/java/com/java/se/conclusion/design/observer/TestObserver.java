package com.java.se.conclusion.design.observer;

import com.java.se.conclusion.design.observer.observers.Driver;
import com.java.se.conclusion.design.observer.observers.Engineer;
import com.java.se.conclusion.design.observer.subjects.WeatherStation;

/**
 * 	This is a class to test observer (or publish/subscribe) pattern
 *  -- Share the similar mechanism as Listener
 *  -- Observer pattern is typically applied in Android design, etc.
 *  
 *  Observer pattern can be extended by:
 *  -- Adding more subjects, notifiers or observers
 *  -- Abstracting the subjects and delegate the notification to its child classes
 *  -- etc.
 *  
 * @author VinceYuan
 *
 */
public class TestObserver {

	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestObserver testObserver = new TestObserver();
		testObserver.testObserver();
	}
	
	/**
	 * 	Test observer pattern
	 */
	private void testObserver() {
		
		/*	Get the subject instance and add observers	*/
		WeatherStation weatherStation = new WeatherStation();
		weatherStation.addObservers(new Driver("Tommy"));
		weatherStation.addObservers(new Driver("Baby"));
		weatherStation.addObservers(new Engineer("Vince"));
		weatherStation.addObservers(new Engineer("Micky"));
		
		/*	Invoke the method that contains the notifiers	*/
		weatherStation.startWeatherStation();
	}
}
