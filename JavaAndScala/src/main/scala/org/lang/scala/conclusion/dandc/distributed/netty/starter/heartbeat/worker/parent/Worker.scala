package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.worker.parent

import java.net.InetSocketAddress
import java.util.UUID
import java.util.concurrent.atomic.AtomicBoolean

import org.lang.scala.conclusion.dandc.distributed.netty.handler.heartbeat.WorkerHandler

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.serialization.ClassResolvers
import io.netty.handler.codec.serialization.ObjectDecoder
import io.netty.handler.codec.serialization.ObjectEncoder

/**
 * 	This is a stand-alone class to implement a worker
 * 
 * 	@author VinceYuan
 */
class Worker (

    val masterHost: String,
    val masterPort: Int,
    val workerHost: String,
    val workerPort: Int,
    val totalCores: Int,
    val totalMemSize: Long,
    val workerId: String = UUID.randomUUID().toString(),
    var masterId: Option[String] = None,
    val registered: AtomicBoolean = new AtomicBoolean(false),
    val heartBeatIntervalInSec: Int = 5
    
) {
  
  /*	Necessary instance variables	*/
  private val self = this
  
  /**
   * 	This is a method to start a worker
   */
  protected def start(): Unit = {
    
    // Define a thread pool to handle accepted requests
    val workerGroup = new NioEventLoopGroup()
    
    try {
      // Get a Bootstrap instance to start a worker
      val workerBootstrap = new Bootstrap()
        .group(workerGroup)
        .channel(classOf[NioSocketChannel])
        .option(ChannelOption.SO_KEEPALIVE.asInstanceOf[ChannelOption[Boolean]], true)
        // Set host and port for this worker
        .localAddress(new InetSocketAddress(workerHost, workerPort))
        .handler(new ChannelInitializer[SocketChannel]() {
          
          /**
           * 	This is a method to add (or register) Netty handlers to the worker
           */
          override def initChannel(channel: SocketChannel): Unit = {
            
            // Add ObjectDecoder, ObjectEncoder, WorkerHandler to worker
            println("Add ObjectDecoder, ObjectEncoder, WorkerHandler to worker...")
            channel.pipeline().addLast(
              // Handler for object de-serialization
              new ObjectDecoder(ClassResolvers.softCachingConcurrentResolver(ClassLoader.getSystemClassLoader)),
              // Handler for object serialization
              new ObjectEncoder(),
              // Handler to process messages for worker
              new WorkerHandler(self)
            )
          }
        })
        
      // Start the worker
      val channelFuture = workerBootstrap.connect(new InetSocketAddress(masterHost, masterPort)).sync()
      println("Worker is started...")
      
      // Add a listener to worker, which will be invoked when the worker is started
      channelFuture.addListener(new ChannelFutureListener() {
    
        /**
     		 * 	This is a method that will be invoked when the operation associated with the future has been completed.
       	 */
        override def operationComplete(future: ChannelFuture): Unit = {
          
          // Print information and close transmitter
          println(s"""Worker listener \"operationComplete\" is invoked...: if the argument \"future\" is the same as \"channelFuture\"? ${future == channelFuture}""")
        }
      })
      
      // Wait until the worker socket is closed
      channelFuture.channel().closeFuture().sync()
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      // Shutdown thread pools gracefully
      workerGroup.shutdownGracefully()
    }
  }
}