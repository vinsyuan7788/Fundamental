package org.lang.scala.conclusion.dandc.distributed.netty.handler.heartbeat

import java.util.concurrent.TimeUnit

import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

import org.lang.scala.conclusion.dandc.distributed.netty.common.cases.HeartBeatInfo
import org.lang.scala.conclusion.dandc.distributed.netty.common.cases.WorkerRegistInfo
import org.lang.scala.conclusion.dandc.distributed.netty.common.cases.WorkerRegistered
import org.lang.scala.conclusion.dandc.distributed.netty.common.classes.WorkerInfo
import org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.master.parent.Master

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

/**
 * 	This is a stand-alone class to implement Netty handler
 * 
 * 	@author VinceYuan
 */
class MasterHandler extends ChannelInboundHandlerAdapter {
  
  /*	Necessary instance variables	*/
  private var master: Master = _
  private var masterId: String = _
  private var workerHeartBeatTimeoutInSec: Int = _
  private val workerMap = new HashMap[String, WorkerInfo]()
  private val workerSet = new HashSet[WorkerInfo]()
  private val checkLiveWorker = new Runnable() {     
    override def run(): Unit = {
      val currentTime = System.currentTimeMillis()
      workerSet.filter { workerInfo => (currentTime - workerInfo.lastHeartBeatTime) > workerHeartBeatTimeoutInSec * 1000 }
        .map { workerInfo => { workerMap -= workerInfo.workerId; workerSet -= workerInfo } }
      println("Live workers:\n" + workerSet.mkString("\n"))
    }
  }
  
  /*	Auxiliary constructors	*/
  def this(master: Master) = {
    this()
    this.master = master
    this.masterId = master.masterId
    this.workerHeartBeatTimeoutInSec = master.workerHeartBeatTimeoutInSec
  }
  
  /**
   * 	This is a method that will be invoked when the channel is added or registered (to client or server)
   */
  override def channelRegistered(ctx: ChannelHandlerContext): Unit = {
    
    // Print information
    println("MasterHandler \"channelRegistered\" is invoked...")
  }
  
  /**
   * 	This is a method that will be invoked when the channel establishes connection
   */
  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    
    // Print information
    println("MasterHandler \"channelActive\" is invoked...")
    
    // Schedule a thread to check live workers periodically
    ctx.executor().scheduleAtFixedRate(checkLiveWorker, 0, 10, TimeUnit.SECONDS)
  }
  
  /**
   * 	This is a method that will be invoked whenever new message is received
   */
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    
    // Print information
    println("MasterHandler \"channelRead\" is invoked...")
    
    // Match the received message by pattern
    msg match {
      
      /*
       *  When master receives WorkerRegistInfo message, record it and reply a message
       */
      case WorkerRegistInfo(workerId, masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize) => {
        workerMap.get(workerId) match {
          case Some(_) => {
            // Do nothing if the worker exists
          }
          case None => {
            val workerInfo = new WorkerInfo(workerId, masterHost, masterPort, workerHost, workerPort, totalCores, totalMemSize)
            workerMap(workerId) = workerInfo
            workerSet += workerInfo
            ctx.writeAndFlush(WorkerRegistered(masterId))
          }
        }
      }
      
      /*
       * 	When master receives HeartBeatInfo message, update the worker's lastHeartBeatTime
       */
      case HeartBeatInfo(workerId) => {
        if (workerMap.contains(workerId)) {
          val workerInfo = workerMap(workerId)
          workerInfo.lastHeartBeatTime = System.currentTimeMillis()
        }
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