package org.lang.scala.conclusion.design.observer.notifier

/**
 * 	This is an interface to implement observer pattern
 *  -- This trait serves as a notifier
 *     -- To notify observers (or whatever is observing the subject) to take action according to the change of the subject
 *  -- This trait must be implemented by observers   
 *  
 * 	@author VinceYuan
 */
trait WeatherNotifier {
  
  def takeActionAccordingToCurrentWeather(currentWeather: String): Unit
}