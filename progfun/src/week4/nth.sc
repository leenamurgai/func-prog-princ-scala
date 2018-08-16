package week4

object nth {
  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)                      //> nth: [T](n: Int, xs: week4.List[T])T

  val list = new Cons(1, new Cons(2, new Cons(3, Nil)))
                                                  //> list  : week4.Cons[Int] = week4.Cons@332b24bc
  nth(2, list)                                    //> res0: Int = 3
  nth(4, list)                                    //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week4.nth$$anonfun$main$1.nth$1(week4.nth.scala:5)
                                                  //| 	at week4.nth$$anonfun$main$1.apply$mcV$sp(week4.nth.scala:11)
                                                  //| 	at scala.runtime.WorksheetSupport$$anonfun$$execute$1.apply$mcV$sp(Works
                                                  //| heetSupport.scala:75)
                                                  //| 	at scala.runtime.WorksheetSupport$.redirected(WorksheetSupport.scala:64)
                                                  //| 
                                                  //| 	at scala.runtime.WorksheetSupport$.$execute(WorksheetSupport.scala:74)
                                                  //| 	at week4.nth$.main(week4.nth.scala:3)
                                                  //| 	at week4.nth.main(week4.nth.scala)
}