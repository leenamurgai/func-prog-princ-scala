object HelloWorkSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = 1                                       //> x  : Int = 1
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 2
  val y = x * 3                                   //> y  : Int = 3
  y * 5                                           //> res1: Int = 15
}