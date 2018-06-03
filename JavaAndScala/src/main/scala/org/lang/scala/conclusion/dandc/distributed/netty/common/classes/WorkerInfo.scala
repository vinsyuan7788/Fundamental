package org.lang.scala.conclusion.dandc.distributed.netty.common.classes

/**
 * 	This is a stand-alone class to test Netty handler
 *  -- This case class contains a worker's necessary information that should be stored in master
 * 
 * 	@author VinceYuan
 */
class WorkerInfo(

    val workerId: String,
    val masterHost: String,
    val masterPort: Int,
    val workerHost: String,
    val workerPort: Int,
    val totalCores: Int,
    val totalMemSize: Long
    
) {

  var isLive = true
  var lastHeartBeatTime: Long = _
  
  override def toString() = {
    s"""
      |Worker[id=${workerId}, masterHost=${masterHost}, masterPort=${masterPort}, 
      |workerHost=${workerHost}, workerPort=${workerPort}, 
      |totalCores=${totalCores}, totalMemSize=${totalMemSize}]
    """.stripMargin.replaceAll("\n", " ").trim()
  }
}