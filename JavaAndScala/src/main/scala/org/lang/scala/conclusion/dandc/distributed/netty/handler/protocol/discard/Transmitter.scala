package org.lang.scala.conclusion.dandc.distributed.netty.handler.protocol.discard

import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

/**
 * 	This is a stand-alone class to implement Netty handler
 * 
 * 	@author VinceYuan
 */
class Transmitter extends ChannelInboundHandlerAdapter {
  
  /**
   * 	This is a method that will be invoked when a connection is established (and ready to generate traffic)
   */
  override def channelActive(ctx: ChannelHandlerContext): Unit = {
    
    // Print information
    println("Transmitter \"channelActive\" is invoked...")
    
    // Write message into a byte buffer
    val message = "Hello Flink, Hello Spark!"
    val byteBuffer = ctx.alloc().buffer(4)
    byteBuffer.writeBytes(message.getBytes)
    
    // Send the byte buffer (to server or client)
    println(s"Transmitter sends message: ${message}")  
    val channelFuture = ctx.writeAndFlush(byteBuffer)
    
    // Wait until the all operation (i.e., message-sending) completes and do something
    channelFuture.addListener(new ChannelFutureListener() {
      
      /**
   		 * 	This is a method that will be invoked when the operation associated with the future has been completed.
     	 */
      override def operationComplete(future: ChannelFuture): Unit = {  
        
        // Print information and close transmitter
        println(s"""Trasmitter listener \"operationComplete\" is invoked...: if the argument \"future\" is the same as \"channelFuture\"? ${future == channelFuture}""")
        ctx.close()
      }
    })
  }
  
  /**
   * 	This is a method that will be invoked when an exception was raised by Netty due to an I/O error or by a handler implementation due to the exception thrown while processing events
   */
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    
    // Print information and close transmitter
    println("Transmitter \"exceptionCaught\" is invoked...")
    cause.printStackTrace()
    ctx.close()
  }
}