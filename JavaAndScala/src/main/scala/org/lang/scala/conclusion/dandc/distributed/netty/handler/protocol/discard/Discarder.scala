package org.lang.scala.conclusion.dandc.distributed.netty.handler.protocol.discard

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter

/**
 * 	This is a stand-alone class to implement Netty handler
 * 
 * 	@author VinceYuan
 */
class Discarder extends ChannelInboundHandlerAdapter {
  
  /**
   * 	This is a method that will be invoked whenever new data is received from another handler
   */
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    
    // Print information
    println("Discarder \"channelRead\" is invoked...")

    // Print the message
    val message = msg.asInstanceOf[ByteBuf]
    var byteArr = Array[Byte]()
    for (i <- 0 until message.capacity()) {
      byteArr :+= message.getByte(i)
    }
    println(s"Discarder receives message: ${new String(byteArr)}")
    
    // Discard the message: since here implements discard protocol
    if (message.release()) {
      println("The message has been discarded successfully...")
    } else {
      println("The message has failed to discard...")
    }
  }
  
  /**
   * 	This is a method that will be invoked when an exception was raised by Netty due to an I/O error or by a handler implementation due to the exception thrown while processing events
   */
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    
    // Print information and close discarder
    println("Discarder \"exceptionCaught\" is invoked...")
    cause.printStackTrace()
    ctx.close()
  }
}