package org.lang.scala.conclusion.dandc.common.cases

/**
 * 	This is a case class to represent a heart-beat message from worker
 * 
 * 	@author VinceYuan
 */
case class Heartbeat(

    val id: Long,
    val freeCores: Int,
    val freeMemory: Int,
    val isLive: Boolean
 
) {
  
}