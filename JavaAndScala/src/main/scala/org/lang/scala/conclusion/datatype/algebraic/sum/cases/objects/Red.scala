package org.lang.scala.conclusion.datatype.algebraic.sum.cases.objects

import org.lang.scala.conclusion.datatype.algebraic.sum.cases.objects.parent.TrafficLight

/**
 * 	This is a case object to test sum type implemented by case object
 *  -- If the case instance comes from (or the number of case instances is) the sum of values (or instances) of MULTIPLE sub-types:
 *     -- Then this case object is called sum type, e.g.:
 *        -- Doctor: Red + Yellow + Green = 1 + 1 + 1 = 3 instances
 *        -- etc.
 *  -- More details regarding case object refer to "matching" package
 *  
 *  @author VinceYuan
 */
case object Red extends TrafficLight
case object Yellow extends TrafficLight
case object Green extends TrafficLight