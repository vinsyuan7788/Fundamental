package org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.discard.client

import java.net.InetSocketAddress

import org.lang.scala.conclusion.dandc.distributed.netty.handler.protocol.discard.Transmitter

import io.netty.bootstrap.Bootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel

/**
 * 	This is a stand-alone class to implement a client
 * 
 * 	@author VinceYuan
 */
class Client {
  
  /**
   * 	This is a method to start a client
   */
  def start(): Unit = {
    
    // Define a thread pool to handle accepted requests
    val workerGroup = new NioEventLoopGroup()
    
    try {
      // Get a Bootstrap instance to start a client
      val bootstrap = new Bootstrap()
        .group(workerGroup)
        .channel(classOf[NioSocketChannel])
        .option(ChannelOption.SO_KEEPALIVE.asInstanceOf[ChannelOption[Boolean]], true)
        .handler(new ChannelInitializer[SocketChannel]() {
          
          /**
           * 	This is a method to add (or register) Netty handlers to the client
           */
          override def initChannel(channel: SocketChannel): Unit = {
            
            // Add transmitter to client
            println("Add transmitter to client...")
            channel.pipeline().addLast(new Transmitter())
          }
        })
        
      // Start the client
      val channelFuture = bootstrap.connect(new InetSocketAddress("localhost", 8888)).sync()
      println("Client is started...")
        
      // Wait until the connection is closed
      channelFuture.channel().closeFuture().sync()
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      workerGroup.shutdownGracefully()
    }
  }
}