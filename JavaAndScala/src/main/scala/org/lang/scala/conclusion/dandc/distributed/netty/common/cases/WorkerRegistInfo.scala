package org.lang.scala.conclusion.dandc.distributed.netty.common.cases

import org.lang.scala.conclusion.dandc.distributed.netty.common.traits.RemoteMessage

/**
 * 	This is a case class to test Netty handler
 * 	-- This case class contains a worker's necessary information that needs to inform master
 *     -- Worker ---> Master
 * 
 * 	@author VinceYuan
 */
case class WorkerRegistInfo(
    
    workerId: String, 
    masterHost: String,
    masterPort: Int,
    workerHost: String,
    workerPort: Int,
    totalCores: Int,
    totalMemSize: Long
    
) extends RemoteMessage {
  
}