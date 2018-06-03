package org.lang.scala.conclusion.dandc.distributed.akka.actor.heartbeat.parent.traits

/**
 * 	This is a trait to retrieve master for both master and worker
 * 
 * 	@author VinceYuan
 */
trait MasterRetriever {
  
  /**
   * 	This is a method to be overridden by sub-classes to get master URL
   */
  def getMasterClassName(): String
}