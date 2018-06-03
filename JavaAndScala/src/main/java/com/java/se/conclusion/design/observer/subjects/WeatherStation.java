package com.java.se.conclusion.design.observer.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.java.se.conclusion.design.observer.notifiers.WeatherNotifier;

/**
 * 	This is a class to implement observer pattern
 *  -- This class serves as a subject (that needs to be observed)
 *  
 *  To implement the observer pattern:
 * 	-- Offer a notifier interface for notification 
 *  -- Maintain a private reference list of all observers that implements the offered interface: IOP and polymorphism
 * 	-- Offer a public add and a public delete method to add and delete observers respectively
 *  -- Notify all observers actively through notifiers if there is any change of the subject
 *  
 * @author VinceYuan
 *
 */
public class WeatherStation {

	/*	Instance variables	*/
	private String[] weathers = {"Sunny", "Hazy", "Windy", "Hailing", "Snowy"};
	public String currentWeather;
	
	/**
	 * 	This is a reference list of all observers that implements the offered interface: IOP and polymorphism
	 */
	private List<WeatherNotifier> weatherNotifiers = new ArrayList<>();
	
	/**
	 * 	This is a method to add an observer
	 * @param weatherNotifier
	 */
	public void addObservers(WeatherNotifier weatherNotifier) {
		weatherNotifiers.add(weatherNotifier);
	}
	
	/**
	 * 	This is a method to remove an observer
	 * @param weatherNotifier
	 */
	public void deleteObservers(WeatherNotifier weatherNotifier) {
		weatherNotifiers.remove(weatherNotifier);
	}
	
	/*	This is a method to start the weather station	*/
	public void startWeatherStation() {
		
		/*	Loop to make sure weather station is always working	 */
		while (true) {
			try {
				/*	Update the current weather randomly	 */
				currentWeather = weathers[(int) (Math.random() * weathers.length)];
				System.out.println("Current weather: " + currentWeather);
				
				/**
				 * 	Notify all observers actively through notifiers if there is any change of the subject
				 * 	-- Here is actually a method polymorphism (or equivalent to callback in JavaScript), hence 1st way is equivalent to 2nd way
				 */
				for (WeatherNotifier weatherNotifier : weatherNotifiers) {
//					weatherNotifier.takeActionAccordingToCurrentWeather(currentWeather);	// 1st way
					takeActionAccordingToCurrentWeather(currentWeather, weatherNotifier);	// 2nd way
				}
				
				/*	Wait 1 to 1.5 seconds randomly	*/
				Thread.sleep(new Random().nextInt(501) + 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 	This is a (optional) callback method
	 * 	-- The callback here is just for the demonstration of use of callback
	 *  -- Practically this is unnecessary
	 *  
	 * @param currentWeather
	 * @param weatherNotifier
	 */
	private void takeActionAccordingToCurrentWeather(String currentWeather, WeatherNotifier weatherNotifier) {
		weatherNotifier.takeActionAccordingToCurrentWeather(currentWeather);
	}
}
