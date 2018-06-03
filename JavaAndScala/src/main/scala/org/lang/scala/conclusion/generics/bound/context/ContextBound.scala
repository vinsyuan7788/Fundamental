package org.lang.scala.conclusion.generics.bound.context

/**
 * 	This is a stand-alone object to test context-bound
 *  -- Context-bound is a mechanism to enable the use of some type A as if it were some type B (namely type A must be viewable by type B)
 *     -- Using ":" to specify a view-bound
 *     -- Context-bound itself is mechanically implemented by implicit conversion
 *        -- Typically by implicit parameter
 *  -- Context-bound REQUIRES a parameterized type
 *     -- Namely for type B, it MUST be B[T] (such as Ordering[T], etc) instead of B alone (such as String, etc.)
 *  
 *  If type A cannot be manipulated by the methods of type B
 *  -- Then implicit conversion comes into picture again to ensure A can be manipulatable by B
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
 * 	@author VinceYuan
 */
object ContextBound {
  
  /**
   * 	This is a method to test context-bound
   */
  def compareTo[T : Ordering](instance1: T, instance2: T) = {
    val ord = implicitly[Ordering[T]]    // Here can be "val ord = Ordering[T]" instead
    if (ord.gteq(instance1, instance2)) instance1 else instance2
  }
  
  /**
   * 	This is a method to de-sugar context-bound (or decompose context-bound to implicit conversion)
   * -- From "implicit ord: Ordering[T]": context-bound is mechanically implemented by an implicit value of type "Ordering[T]"
   *    -- Namely "ord", as an argument, is an instance of "Ordering[T]", hence can directly "ord" to invoke its method (for comparison)
   */
  def compareTo_deSugar[T](instance1: T, instance2: T)(implicit ord: Ordering[T]) = {
    if (ord.gteq(instance1, instance2)) instance1 else instance2
  }
  
  /**
   * 	This is a method to use context-bound while converting "T" from "Ordering[T]" to "Ordered[T]" for comparison
   */
  def compareTo_OrderingToOrdered[T: Ordering](instance1: T, instance2: T) = {
    import Ordered.orderingToOrdered
    if (instance1 > instance2) instance1 else instance2
  }
}