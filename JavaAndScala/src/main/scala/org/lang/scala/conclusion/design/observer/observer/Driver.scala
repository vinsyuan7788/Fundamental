package org.lang.scala.conclusion.design.observer.observer

import org.lang.scala.conclusion.design.observer.notifier.WeatherNotifier

/**
 * 	This is a stand-alone class to implement observer pattern
 *  -- This class serves as an observer
 *  -- This class must implement a notifier trait
 *  
 * 	@author VinceYuan
 */
class Driver(

    val name: String
    
) extends WeatherNotifier {
  
  /**
   * 	This is a method to take action according to current weather
   */
  override def takeActionAccordingToCurrentWeather(currentWeather: String) = {
    
    /*	Take action according to current weather	*/
    currentWeather.toLowerCase() match {
      case "sunny" => {
        println("Driver " + name + " can work happily.")
      }
      case "hazy" => {
        println("Driver " + name + " can work with a mask.")
      }
      case "windy" => {
        println("Driver " + name + " can work with an umbrealla.") 
      }
      case "hailing" => {
        println("Driver " + name + " can work inside a car.")
      }
      case "snowy" => {
        println("Driver " + name + " can work with warm clothes.")
      }
    }
  }
}