package org.lang.scala.conclusion.design.observer.observer

import org.lang.scala.conclusion.design.observer.notifier.WeatherNotifier

/**
 * 	This is a stand-alone class to implement observer pattern
 *  -- This class serves as an observer
 *  -- This class must implement a notifier trait
 *  
 * 	@author VinceYuan
 */
class Engineer(

    val name: String

) extends WeatherNotifier {
  
  /**
   * 	This is a method to take action according to current weather
   */
  override def takeActionAccordingToCurrentWeather(currentWeather: String) = {
    
    /*	Take action according to the current weather	*/
    currentWeather.toLowerCase() match {
      case "sunny" => {
        println("Engineer " + name + " can work happily.")
      }
      case "hazy" => {
        println("Engineer " + name + " can work with a mask.")
      }
      case "windy" => {
        println("Engineer " + name + " can work with an umbrealla.") 
      }
      case "hailing" => {
        println("Engineer " + name + " can work inside a car.")
      }
      case "snowy" => {
        println("Engineer " + name + " can work with warm clothes.")
      }
    }
  }
}