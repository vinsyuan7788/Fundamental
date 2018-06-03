package com.java.se.conclusion.design.observer.observers;

import com.java.se.conclusion.design.observer.notifiers.WeatherNotifier;

/**
 * 	This is a class to implement observer pattern
 *  -- This class serves as an observer
 *  -- This class must implement a notifier interface
 *  
 * @author VinceYuan
 *
 */
public class Engineer implements WeatherNotifier {

	/*	Instance variables	*/
	private String name;
	
	/*	Parameter constructors	*/
	public Engineer(String name) {
		this.name = name;
	}
	
	/**
	 * 	Override the method to take action according to the current weather
	 */
	@Override
	public void takeActionAccordingToCurrentWeather(String currentWeather) {
		
		/*	Take action according to the current weather	*/
		switch (currentWeather.toLowerCase()) {
		case "sunny":
			System.out.println("Engineer " + name + " can work happily.");
			break;
		case "hazy":
			System.out.println("Engineer " + name + " can work with a mask.");
			break;
		case "windy":
			System.out.println("Engineer " + name + " can work with an umbrealla.");
			break;
		case "hailing":
			System.out.println("Engineer " + name + " can work inside a car.");
			break;
		case "snowy":
			System.out.println("Engineer " + name + " can work with warm clothes.");
			break;
		default:
			break;
		}
	}
}
