package org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.actor

import org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.message.Done
import org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.message.Greet

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
 * 	This is a stand-alone class that represents an actor
 * 	-- Each actor is a thread
 * 
 * 	@author VinceYuan
 */
class HelloWorld extends Actor {
  
  /**
   * 	This is a method that will be invoked before the actor starts
   */
  override def preStart() = {
    
    /*	Create an actor system for greeter	*/
    val actorSystem = ActorSystem.create("Greet")
    
    /*	Create a prop instance and actor names  */
    val props = Props(classOf[Greeter])
    val greeterName1 = "Greeter1"
    val greeterName2 = "Greeter2"
    
    /*	Create greeter actors and start them	*/
    val greeter1 = actorSystem.actorOf(props, greeterName1)
    val greeter2 = actorSystem.actorOf(props, greeterName2)
    
    /*	Tell messages to greeter actors  */
    greeter1.tell(Greet(greeterName1), self)
    greeter2.tell(Greet(greeterName2), self)
  }
  
  /**
   * 	This is a method that will be invoked whenever a message is received
   */
  override def receive: Receive = {
    
    /*	If the message is "Done", then handle accordingly	 */
    case Done => {
      
      /*	Stop the sender actor	*/
      context.stop(sender())
    }
    /*	Else do not handle the message	*/
    case message: Any => {
      unhandled(message)
    }
  }
}