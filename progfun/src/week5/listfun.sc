package week5

object listfun {

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apples", "oranges", "pears", "pinapple")
                                                  //> fruits  : List[java.lang.String] = List(apples, oranges, pears, pinapple)
  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  nums takeWhile (x => x > 0)                     //> res3: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

  val data = List("a", "a", "a", "b", "b", "b", "c", "d", "a", "a")
                                                  //> data  : List[java.lang.String] = List(a, a, a, b, b, b, c, d, a, a)
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  pack(data)                                      //> res6: List[List[java.lang.String]] = List(List(a, a, a), List(b, b, b), List
                                                  //| (c), List(d), List(a, a))
  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]

  encode(data)                                    //> res7: List[(java.lang.String, Int)] = List((a,3), (b,3), (c,1), (d,1), (a,2)
                                                  //| )
}