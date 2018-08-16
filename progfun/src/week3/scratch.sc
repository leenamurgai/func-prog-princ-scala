import week3.Rational
//import week3.{Rational, Hello}
//import week3._

object scratch {
  //new week3.Rational(1, 2)
  new Rational(1, 2)                              //> res0: week3.Rational = 1/2
  
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
  //error("test")
  
  val x = null                                    //> x  : Null = null
  // null is a subtype of scala.AnyRef...
  val y: String = x                               //> y  : String = null
  // ...but not scala.AnyVal
  //val z: Int = null
  if (true) 1 else false                          //> res1: AnyVal = 1
}