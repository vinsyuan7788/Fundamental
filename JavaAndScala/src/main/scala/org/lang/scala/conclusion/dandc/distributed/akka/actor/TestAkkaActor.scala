package org.lang.scala.conclusion.dandc.distributed.akka.actor

/**
 * 	This is a stand-alone object to test Akka Actor
 *  -- Since Scala 2.10, Scala actor is deprecated, the default actor for Scala becomes Akka actor
 *  -- Akka actor life cycle: constructor ---> preStart ---> receive ---> postStop
 *  -- preStart: invoked when actor is started
 *  -- receive: invoked whenever receiving new message from another actor
 *  -- postStop: invoked when actor is stop
 * 
 * 	@author VinceYuan
 */
object TestAkkaActor {
  
}