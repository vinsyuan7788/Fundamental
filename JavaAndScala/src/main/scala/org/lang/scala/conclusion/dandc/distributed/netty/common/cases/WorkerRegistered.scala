package org.lang.scala.conclusion.dandc.distributed.netty.common.cases

import org.lang.scala.conclusion.dandc.distributed.netty.common.traits.RemoteMessage

/**
 * 	This is a case class to test Netty handler
 * 	-- This case class signifies the worker has been registered to master successfully
 *     -- Master ---> Worker
 * 
 * 	@author VinceYuan
 */
case class WorkerRegistered(

    val masterId: String
    
) extends RemoteMessage {
  
}