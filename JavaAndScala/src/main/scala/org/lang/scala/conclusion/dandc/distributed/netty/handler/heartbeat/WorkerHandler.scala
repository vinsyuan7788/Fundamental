package org.lang.scala.conclusion.dandc.distributed.netty.handler.heartbeat

import java.util.concurrent.TimeUnit

import org.lang.scala.conclusion.dandc.distributed.netty.common.cases.HeartBeatInfo
import org.lang.scala.conclusion.dandc.distributed.netty.common.cases.WorkerRegistInfo
import org.lang.scala.conclusion.dandc.distributed.netty.common.cases.WorkerRegistered
import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker.parent.Worker

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelFuture

/**
 * 	This is a stand-alone class to implement Netty handler
 * 
 * 	@author VinceYuan
 */
class WorkerHandler extends ChannelInboundHandlerAdapter {
  
  /*	Necessary instance variables	*/
  private var worker: Worker = _
  private var workerId: String = _
  private var masterHost: String = _
  private var masterPort: Int = _
  private var workerHost: String = _
  private var workerPort: Int = _
  private var totalCores: Int = _
  private var totalMemSize: Long = _
  private var heartBeatIntervalInSec: Int = _
  
  /*	Auxiliary constructors	*/
  def this(worker: Worker) = {
    this()
    this.worker = worker
    this.workerId = worker.workerId
    this.masterHost = worker.masterHost
    this.masterPort = worker.masterPort
    this.workerHost = worker.workerHost
    this.workerPort = worker.workerPort
    this.totalCores = worker.totalCores
    this.totalMemSize = worker.totalMemSize
    this.heartBeatIntervalInSec = worker.heartBeatIntervalInSec
  }
  
  /**
   * 	This is a method that will be invoked when the channel is added or registered (to client or server)
   */
  override def channelRegistered(ctx: ChannelHandlerContext): Unit = {
    
    // Print information
    println("WorkerHandler \"channelRegistered\" is invoked...")
  }
  
  /**
   * 	This is a method that will be invoked when the channel establishes connection
   */
  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    
    // Print information
    println("WorkerHandler \"channelActive\" is invoked...")
    
    // Register to master
    ctx.writeAndFlush(WorkerRegistInfo(workerId, masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize))
  }
  
  /**
   * 	This is a method that will be invoked whenever new message is received
   */
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    
    // Print information
    println("WorkerHandler \"channelRead\" is invoked...")
    
    // Match the received message by pattern
    msg match {
      
      /*
       *  If worker receives WorkerRegistered message, update worker to registered and start heart-beat
       */
      case WorkerRegistered(masterId) => {
        worker.masterId = Some(masterId)
        if (worker.registered.compareAndSet(false, true)) println(s"If worker has been registered at ${worker.masterId.get}? ${worker.registered.get}")
        // Schedule a thread to send heart-beat message periodically
        val heartbeat = new Runnable() {
          override def run(): Unit = {
            ctx.writeAndFlush(HeartBeatInfo(workerId))
          }
        } 
        ctx.executor().scheduleAtFixedRate(heartbeat, 0, heartBeatIntervalInSec, TimeUnit.SECONDS)     
      }
      
      /*
       * 	Otherwise do nothing
       */
      case _ => {}
    }
  }
  
  /**
   * 	This is a method that will be invoked when there is any exception
   */
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    
  }
}