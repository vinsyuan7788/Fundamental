package org.lang.scala.conclusion.dandc.distributed.netty.common.cases

import org.lang.scala.conclusion.dandc.distributed.netty.common.traits.RemoteMessage

/**
 * 	This is a case class to test Netty handler
 * 	-- This case class contains necessary information for heart-beat check
 *     -- Worker ---> Master
 * 
 * 	@author VinceYuan
 */
case class HeartBeatInfo(

    workerId: String

) extends RemoteMessage {
  
}