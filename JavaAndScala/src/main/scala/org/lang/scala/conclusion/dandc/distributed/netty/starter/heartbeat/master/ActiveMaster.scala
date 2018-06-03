package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.master

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.master.parent.Master

/**
 * 	This is a companion class to start a master
 * 
 * 	@author VinceYuan
 */
class ActiveMaster(

    override val host: String,
    override val port: Int
    
) extends Master(host, port) {
 
}

/**
 * 	This is a companion object to start a master
 * 
 * 	@author VinceYuan
 */
object ActiveMaster {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {

    /*	Master initialization	 */
    val host = "localhost"
    val port = 8888
    
    /*	Start a master	*/
    new ActiveMaster(host, port).start()
  }
}