package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker.parent.Worker

/**
 * 	This is a companion class to start a worker
 * 
 * 	@author VinceYuan
 */
class WorkerTwo (

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
object WorkerTwo {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {

    /*	Master initialization	 */
    val masterHost = "localhost"
    val masterPort = 8888
    val workerHost = "localhost"
    val workerPort = 9999
    val totalCores = 2
    val totalMemSize = 1024
    
    /*	Start a master	*/
    new WorkerTwo(masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize).start()
  }
}