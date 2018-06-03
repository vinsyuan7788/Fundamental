package org.lang.scala.conclusion.dandc.distributed.netty.handler

/**
 * 	This is a stand-alone object to test Netty Channel handler
 *  -- Channel in-bound handler life cycle: channelRegistered ---> channelActive ---> channelRead ---> channelReadComplete ---> channelInactive ---> channelUnregistered
 *     -- If catching any exception: exceptionCaught
 *  -- channelRegistered: invoked when the handler is added (or registered) to server or client
 *  -- channelActive: invoked when a connection is established (and ready to generate traffic)
 * 	-- channelRead: invoked whenever receiving new data from another handler
 * 	-- exceptionCaught: invoked when an exception was raised by Netty due to an I/O error or by a handler implementation due to the exception thrown while processing events
 *  
 * 	@author VinceYuan
 */
object TestNettyChannelHandler {
  
}