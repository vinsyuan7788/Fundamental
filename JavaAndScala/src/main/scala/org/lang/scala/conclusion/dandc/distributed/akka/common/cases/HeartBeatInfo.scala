package org.lang.scala.conclusion.dandc.distributed.akka.common.cases

import org.lang.scala.conclusion.dandc.distributed.akka.common.traits.RemoteMessage

/**
 * 	This is a case class to test Akka actor
 * 	-- This case class contains necessary information for heart-beat check
 *     -- Worker ---> Master
 * 
 * 	@author VinceYuan
 */
case class HeartBeatInfo(

    workerId: String

) extends RemoteMessage {
  
}