package org.lang.scala.conclusion.datatype.algebraic.product.cases.classes

import org.lang.scala.conclusion.datatype.algebraic.product.cases.classes.enumeration.Gender

/**
 * 	This is a case class to test product type implemented by case class
 *  -- If the case instance comes from (or the number of case instances is) the product of values of MULTIPLE constructor parameters:
 *     -- Then this case class is called product type, e.g.:
 *        -- Professor: (gender: Gender.Value) * (isRetired: Boolean) = 3 * 2 = 6 instances
 *        -- etc.
 *  -- More details regarding case class refer to "matching" package
 *        
 * 	@author VinceYuan
 */
case class Professor(gender: Gender.Value, isRetired: Boolean)