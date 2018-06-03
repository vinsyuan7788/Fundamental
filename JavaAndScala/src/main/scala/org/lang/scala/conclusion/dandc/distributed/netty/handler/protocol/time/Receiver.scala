package org.lang.scala.conclusion.dandc.distributed.netty.handler.protocol.time

import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelHandlerContext
import io.netty.buffer.ByteBuf
import java.util.Date

/**
 * 	This is a stand-alone class to implement Netty handler
 * 
 * 	@author VinceYuan
 */
class Receiver extends ChannelInboundHandlerAdapter {
  
  /**
   * 	This is a method that will be invoked whenever new data is received from another handler
   */
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    
    // Print information
    println("Receiver \"channelRead\" is invoked...")
    
    // Get the received message as a byte buffer
    val message = msg.asInstanceOf[ByteBuf]
    
    try {
      // Print the receive message
      val currentTimeMillis = (message.readUnsignedInt() - 2208988800L) * 1000L
      println(s"Receiver receives message: ${new Date(currentTimeMillis)}")
      
      // Close receiver
      ctx.close()
    } catch {
      case t: Throwable => t.printStackTrace()
    } finally {
      // Release the data in the byte buffer
      message.release()
    }
  }
  
  /**
   * 	This is a method that will be invoked when an exception was raised by Netty due to an I/O error or by a handler implementation due to the exception thrown while processing events
   */
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    
    // Print information and close receiver
    println("Receiver \"exceptionCaught\" is invoked...")
    cause.printStackTrace()
    ctx.close()
  }
}