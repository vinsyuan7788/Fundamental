package org.lang.scala.conclusion.design.observer.subject

import scala.collection.mutable.ListBuffer
import scala.util.Random

import org.lang.scala.conclusion.design.observer.notifier.WeatherNotifier

/**
 * 	This is a stand-alone class to implement observer pattern
 *  -- This class serves as a subject (that needs to be observed)
 *  
 *  To implement observer pattern
 *  -- Need to maintain a data structure to store all observers (which extend notifiers)
 *     -- The data structure can be List, Array, ListBuffer, etc.
 *     -- Need to provide necessary methods to add or remove observers
 *  -- Need to notify all observers whenever need to notify them
 *     -- E.g., if there is any change of the subject
 *  
 * 	@author VinceYuan
 */
class WeatherStation {
  
  /*	instance variables that provides all possible weather	*/
  private val weathers = Array("Sunny", "Hazy", "Windy", "Hailing", "Snowy")
  
  /**
   * 	instance variable	that contain all observers that need to observe this subject
   */
  private val observers = ListBuffer[WeatherNotifier]()
  
  /**
   * 	Here are the methods to add and remove an observer
   */
  def addObserver(observer: WeatherNotifier): Unit = {
    observers += observer
  }
  def removeObserver(observer: WeatherNotifier): Unit = {
    observers -= observer
  }
  
  /**
   * 	This is a method to start the weather station
   */
  def startWorking() = {
    
    /*	Loop forever	*/
    while (true) {
      
      /*	Get current weather	 */
      val currentWeather = weathers(Random.nextInt(weathers.length))
      println(s"Current weather: ${currentWeather}")
      
      /**	
       * 	Notify each observer
       *  -- Since each observe need to know (the change of) current weather
       */
      observers.foreach(observer => {
        observer.takeActionAccordingToCurrentWeather(currentWeather)
      })
      
      /*	Current thread sleeps for 1 to 1.5 second	 */
      Thread.sleep(1000 + Random.nextInt(501))
    }
  }
}