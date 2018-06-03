package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker.parent.Worker

/**
 * 	This is a companion class to start a worker
 * 
 * 	@author VinceYuan
 */
class WorkerOne (

    override val masterHost: String,
    override val masterPort: Int,
    override val workerHost: String,
    override val workerPort: Int,
    override val totalCores: Int,
    override val totalMemSize: Long
    
) extends Worker(masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize) {
  
}

/**
 * 	This is a companion object to start a worker
 * 
 * 	@author VinceYuan
 */
object WorkerOne {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {

    /*	Master initialization	 */
    val masterHost = "localhost"
    val masterPort = 8888
    val workerHost = "localhost"
    val workerPort = 7777
    val totalCores = 8
    val totalMemSize = 8192
    
    /*	Start a master	*/
    new WorkerOne(masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize).start()
  }
}