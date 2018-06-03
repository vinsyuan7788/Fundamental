package org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka

import org.lang.scala.conclusion.concurrent.multithreading.pipelined_module.akka.common.actor.HelloWorld

import akka.actor.ActorSystem
import akka.actor.Props

/**
 * 	This is a stand-alone object to test Akka actor
 * 	-- Each Akka actor is a thread
 * 
 * 	@author VinceYuan
 */
object TestAkkaActor {
  
  /**
   * 	This is a main method for execution
   * 	-- To see the correct result, make sure there is only 1 method running each time
   */
  def main(args: Array[String]): Unit = {
    testActor()
  }
  
  /**
   * 	This is a method to test actor
   */
  private def testActor(): Unit = {
    
    /*	Create an actor system	*/
    val actorSystem = ActorSystem.create("HelloWorld")
    
    /*	Create a prop instance	*/
    val props = Props(classOf[HelloWorld])
    
    /*	Create actors and start them	*/
    val helloWorld = actorSystem.actorOf(props, "HelloWorld")
  }
}