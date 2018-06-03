package org.lang.scala.conclusion.dandc.distributed.akka.common.cases

import org.lang.scala.conclusion.dandc.distributed.akka.common.traits.RemoteMessage

/**
 * 	This is a case class to test Akka actor
 *  -- This case class contains necessary information that master replies to a worker
 *     -- Master ---> Worker
 * 
 * 	@author VinceYuan
 */
case class WorkerRegistered(

    masterId: String,
    masterUrl: String

) extends RemoteMessage {
  
}