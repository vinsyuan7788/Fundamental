package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat

import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.master.ActiveMaster

/**
 * 	This is a stand-alone object to start masters
 * 
 * 	@author VinceYuan
 */
object MasterStarter {
  
  /**
   * 	This is a main method for execution
   */
  def main(args: Array[String]): Unit = {
    ActiveMaster.main(args)
  }
}