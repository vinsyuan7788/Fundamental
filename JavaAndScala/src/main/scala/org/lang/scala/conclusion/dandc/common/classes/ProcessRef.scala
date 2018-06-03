package org.lang.scala.conclusion.dandc.common.classes

/**
 * 	This is a class to get the process reference by wrapping corresponding process
 * 	-- Similar to get the end-point reference by wrapping corresponding end-point (of Netty, Akka, etc.)
 *  -- This idea is widely adopted in the development of Spark, Flink, etc.
 * 
 * 	@author VinceYuan
 */
class ProcessRef(

    val process: Process
    
) {

}