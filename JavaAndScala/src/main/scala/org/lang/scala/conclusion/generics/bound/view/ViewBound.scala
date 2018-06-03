package org.lang.scala.conclusion.generics.bound.view

/**
 * 	This is a stand-alone object to test view-bound
 *  -- View-bound is a mechanism to enable the use of some type A as if it were some type B (namely type A must be viewable by type B)
 *     -- Using "<%" to specify a view-bound
 *     -- View-bound itself is mechanically implemented by implicit conversion
 *        -- Typically by implicit type conversion
 *  
 *  If type A cannot be manipulated as type B (or say type A is not viewable by type B)
 *  -- Then implicit conversion comes into picture again to ensure A is manipulatable as type B
 *     -- E.g., by defining comparison rules for A, etc.
 *  
 *  Differences between context-bound and view-bound
 *  -- The data type used with
 *     -- Context-bound must be used with type-parameter data type
 *        -- Type-parameter data type: "T : Ordering", etc.
 *     -- View-bound can be used with type-parameter or type-parameterless data type
 *        -- Type-parameter data type: T <% Ordered[T], etc.
 *        -- Type-parameterless data type: "T <% String", etc.
 *  -- The instance that actually processes logic
 *     -- Context-bound: "instance: B[T]"
 *        -- Namely an instance of another type B[T]
 *     -- View-bound: "instance: T"
 *        -- Namely still the instance of current type T
 *  -- If need to introduce extra implicits
 *     -- Context-bound: can be either implicit parameter or implicit conversion
 *        -- E.g., can assign value to "ord: Ordering[T]" or convert "T" to whatever type that can be ordered (e.g., "Ordered[T]")
 *     -- View-bound: must be implicit conversion
 *        -- E.g., must convert "T" to "Ordered[T]"
 *  
 *  Note that view-bound has been deprecated, MUST avoid using view-bound
 * 
 * 	@author VinceYuan
 */
object ViewBound {
  
  /**
   *	This is a method to test view-bound
   */
  def compareTo[T <% Ordered[T]](instance1: T, instance2: T) = {
    if (instance1 >= instance2) instance1 else instance2
  }
  
  /**
   * 	This is a method to de-sugar view-bound (or decompose view-bound to implicit conversion)
   *  -- From "implicit ord: T => Ordered[T]": view-bound is mechanically implemented by implicit type conversion "T => Ordered"
   *     -- Namely finally "T" is converted to "Ordered[T]" (no matter what is inside "ord"), hence "instance1" and "instance2 are the instances of "Ordered[T]" and can invoke "Ordered[T]"'s methods (for comparison)
   */
  def compareTo_deSugar[T](instance1: T, instance2: T)(implicit ord: T => Ordered[T]) = {
    if (instance1 >= instance2) instance1 else instance2
  }
  
  /**
   * 	This is a method to use view-bound while introducing an "Ordering[T]" instance for comparison
   */
  def compareTo_OrderedToOrdering[T <% Ordered[T]](instance1: T, instance2: T) = {
    val ord1 = Ordering.ordered[T]
    if (ord1.gteq(instance1, instance2)) instance1 else instance2
  }
}