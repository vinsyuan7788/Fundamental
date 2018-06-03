package org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.actor

import scala.util.Random

import org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.message.Done
import org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.message.Greet

import akka.actor.Actor

/**
 * 	This is a stand-alone class that represents an actor
 * 	-- Each actor is a thread
 * 
 * 	@author VinceYuan
 */
class Greeter extends Actor {
  
  /**
   * 	This is a method that will be invoked whenever a message is received
   */
  override def receive: Receive = {

    /*	If the message is "Greet", then handle accordingly	*/
    case Greet(greeterName) => {
      
      /*	Print the message	 */
      println(s"${greeterName}: Hello World!")
      
      /*	Sleep for a while randomly	*/
      Thread.sleep(Random.nextInt(3001))
      
      /*	Respond a message to the sender actor	 */
      sender().tell(Done, self)
    }
    
    /*	Else do not handle the message	*/
    case message: Any => {
      unhandled(message)
    }
  }
}