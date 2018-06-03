package org.lang.scala.conclusion.generics

/**
 * 	This is a stand-alone object to test variance
 *  -- There are 2 types of variance: contravariance and covariance
 *     -- Details refer to "variance" package
 * 
 *  Why variance?
 *  -- To restrict the data type SOLELY by the generics at compile-time (instead of regarding generics as an attachment of a class)
 *     -- Using generics to custom compiler's compilation rules that are out of generics
 *     
 *  To conclude variance:
 *  -- Graphically in a table: (*****)
 *     ------------------------------------
 *     |      |    Input    |   Output    | 
 *     ------------------------------------
 *     | C[T] | upper-bound | lower-bound |
 *     ------------------------------------
 *     |  T   | lower/upper | lower/upper |
 *     ------------------------------------
 *  -- Theoretically there are 4 different combinations on input and output according to generic argument expectation or requirement:
 *     -- Input generic argument is expected lower-bound, output generic argument is expected lower-bound
 *        -- Contravariance for input, covariance for output     
 *     -- Input generic argument is expected lower-bound, output generic argument is expected upper-bound
 *        -- Contravariance for input, contravariance for output
 *     -- Input generic argument is expected upper-bound, output generic argument is expected lower-bound
 *        -- Covariance for input, covariance for output
 *     -- Input generic argument is expected upper-bound, output generic argument is expected upper-bound
 *        -- Covariance for input, contravariance for output
 *  -- Practically, since the generics argument is expected to be lower-bound for both input and output
 *     -- Contravariance for input, covariance for output
 *     
 *  @author VinceYuan
 */
object TestVariance {
  
}