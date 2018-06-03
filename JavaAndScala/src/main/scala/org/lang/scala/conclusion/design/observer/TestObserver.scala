package org.lang.scala.conclusion.design.observer

import org.lang.scala.conclusion.design.observer.subject.WeatherStation
import org.lang.scala.conclusion.design.observer.observer.Driver
import org.lang.scala.conclusion.design.observer.observer.Engineer

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
 * 	@author VinceYuan
 */
object TestObserver {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    testObserver()
  }
  
  /**
   * 	This is a method to test observer pattern
   */
  private def testObserver() = {
    
		/*	Get the subject instance and add observers	*/
    val weatherStation = new WeatherStation()
    weatherStation.addObserver(new Driver("Tommy"))
    weatherStation.addObserver(new Driver("Baby"))
    weatherStation.addObserver(new Engineer("Vince"))
		weatherStation.addObserver(new Engineer("Micky"))
    
		/*	Invoke the method that contains the notifiers	*/
		weatherStation.startWorking();
  }
}