package org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes

import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.parent.Doctor
import org.lang.scala.conclusion.datatype.algebraic.sum.cases.classes.enumeration.Gender

/**
 * 	This is a case class to test sum type implemented by case class
 *  -- If the case instance comes from (or the number of case instances is) the sum of values (or instances) of MULTIPLE sub-types:
 *     -- Then this case class is called sum type, e.g.:
 *        -- Doctor: Johnny + Kelley + Violet = (isRetired: Boolean) + (gender: Gender.Value, isMarried: Boolean) + (gender: Gender.Value) = 2 + (3 * 2) + 3 = 11 instances
 *        -- etc.
 *  -- More details regarding case class refer to "matching" package
 *        
 * 	@author VinceYuan
 */
case class Violet(gender: Gender.Value) extends Doctor
case class Johnny(isRetired: Boolean) extends Doctor
case class Kelley(gender: Gender.Value, isMarried: Boolean) extends Doctor
