package org.lang.scala.conclusion.dandc.concurrent.java.structure.copyonwrite

import java.util.concurrent.CopyOnWriteArrayList

/**
 * 	This is a stand-alone object to test COW (Copy-On-Write) structure
 * 	-- COW achieves the separations of read and write
 *     -- When writing, copy another structure instance in memory
 *     -- After writing, link the reference to this new instance
 *  -- Suitable for the situation where data volume is not large and data needs to be read much more than written
 *     -- But usually COW structure is replaced by concurrent structure due to its disadvantages
 *  -- There are 2 disadvantages:
 *     -- When data volume is large, copying another instance will consume much memory and data writing will consume much time
 *     -- Data consistency cannot be guaranteed, especially when what is written or updated needs to be read instantly
 * 
 * 	@author VinceYuan
 */
object TestCopyOnWrite {

}