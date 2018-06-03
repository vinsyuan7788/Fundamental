package org.lang.scala.conclusion.dandc.distributed.netty.starter.heartbeat.master.parent

import java.net.InetSocketAddress
import java.util.UUID

import org.lang.scala.conclusion.dandc.distributed.netty.handler.heartbeat.MasterHandler

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.serialization.ClassResolvers
import io.netty.handler.codec.serialization.ObjectDecoder
import io.netty.handler.codec.serialization.ObjectEncoder
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelFuture

/**
 * 	This is a stand-alone class to implement a master
 * 
 * 	@author VinceYuan
 */
class Master(

    val host: String, 
    val port: Int,
    val masterId: String = UUID.randomUUID().toString(),
    val workerHeartBeatTimeoutInSec: Int = 10
    
) {
  
  /*	Necessary instance variables	*/
  private val self = this
  
  /**
   * 	This is a method to start a master
   */
  protected def start(): Unit = {

    // Define a thread pool to accept new requests for channels 
    val acceptorGroup = new NioEventLoopGroup()
    // Define a thread pool to handle accepted requests
    val workerGroup = new NioEventLoopGroup()
    
    try {
      // Get a ServerBootstrap instance to start a master
      val masterBootstrap = new ServerBootstrap()
        .group(acceptorGroup, workerGroup)
        .channel(classOf[NioServerSocketChannel])
        .option(ChannelOption.SO_BACKLOG.asInstanceOf[ChannelOption[Int]], 128)
        .childOption(ChannelOption.SO_KEEPALIVE.asInstanceOf[ChannelOption[Boolean]], true)
        // Set host and port for this master
        .localAddress(new InetSocketAddress(host, port))
        .childHandler(new ChannelInitializer[SocketChannel]() {    
          
          /**
           * 	This is a method to add (or register) Netty handlers to the master
           */
          override def initChannel(channel: SocketChannel): Unit = {
            
            // Add ObjectDecoder, ObjectEncoder, MasterHandler to master
            println("Add ObjectDecoder, ObjectEncoder, MasterHandler to master...")
            channel.pipeline().addLast(
              // Handler for object de-serialization
              new ObjectDecoder(ClassResolvers.softCachingConcurrentResolver(ClassLoader.getSystemClassLoader)),
              // Handler for object serialization
              new ObjectEncoder(),
              // Handler to process messages for master
              new MasterHandler(self)
            )
          }
        })
        
      // Bind and start to accept incoming connections
      val channelFuture = masterBootstrap.bind().sync()
      println("Master is started...")
      
      // Add a listener to master, which will be invoked when the master is started
      channelFuture.addListener(new ChannelFutureListener() {
    
        /**
     		 * 	This is a method that will be invoked when the operation associated with the future has been completed.
       	 */
        override def operationComplete(future: ChannelFuture): Unit = {
          
          // Print information and close transmitter
          println(s"""Master listener \"operationComplete\" is invoked...: if the argument \"future\" is the same as \"channelFuture\"? ${future == channelFuture}""")
        }
      })
      
      // Wait until the master socket is closed
      channelFuture.channel().closeFuture().sync()   
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      // Shutdown thread pools gracefully
      acceptorGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }
  }
}