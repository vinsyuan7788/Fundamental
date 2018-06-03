package org.lang.scala.conclusion.dandc.distributed.netty.starter.protocol.discard.server

import org.lang.scala.conclusion.dandc.distributed.netty.handler.protocol.discard.Discarder

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel

/**
 * 	This is a stand-alone class to implement a server
 * 
 * 	@author VinceYuan
 */
class Server {
  
  /**
   * 	This is a method to start a server
   */
  def start(): Unit = {
    
    // Define a thread pool to accept new requests for channels 
    val acceptorGroup = new NioEventLoopGroup()
    // Define a thread pool to handle accepted requests
    val workerGroup = new NioEventLoopGroup()
    
    try {
      // Get a ServerBootstrap instance to start a server
      val serverBootstrap = new ServerBootstrap()
        .group(acceptorGroup, workerGroup)
        .channel(classOf[NioServerSocketChannel])
        // option: method of AbstractBootstrap class 
        .option(ChannelOption.SO_BACKLOG.asInstanceOf[ChannelOption[Int]], 128)
        // childOption: method of ServerBootstrap class  (CHILD of AbstractBootstrap class which defines "OPTION" method, hence "childOption")
        .childOption(ChannelOption.SO_KEEPALIVE.asInstanceOf[ChannelOption[Boolean]], true)
        // childHandler: method of ServerBootstrap class (CHILD of AbstractBootstrap class which defines "HANDLER" method, hence "childHander")
        .childHandler(new ChannelInitializer[SocketChannel]() {    
          
          /**
           * 	This is a method to add (or register) Netty handlers to the server
           */
          override def initChannel(channel: SocketChannel): Unit = {
            
            // Add discarder to server
            println("Add discarder to server...")
            channel.pipeline().addLast(new Discarder())
          }
        })
     
      // Bind and start to accept incoming connections
      val channelFuture = serverBootstrap.bind(8888).sync()
      println("Server is started...")
      
      /*
       *  Wait until the server socket is closed
       *  In this example, this does not happen, but you can do that to gracefully
       *  shut down your server
       */
      channelFuture.channel().closeFuture().sync() 
    } catch {
      case t: Throwable => println(t.getMessage)
    } finally {
      workerGroup.shutdownGracefully()
      acceptorGroup.shutdownGracefully()
    }    
  }
}