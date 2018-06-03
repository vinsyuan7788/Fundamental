package com.java.se.conclusion.design.observer.notifiers;

/**
 * 	This is an interface to implement observer pattern
 *  -- This interface serves as a notifier
 *     -- To notify observers (or whatever is observing the subject) to take action according to the change of the subject
 *  -- This interface must be implemented by observers   
 *  
 * @author VinceYuan
 *
 */
public interface WeatherNotifier {

	public void takeActionAccordingToCurrentWeather(String currentWeather);
}
