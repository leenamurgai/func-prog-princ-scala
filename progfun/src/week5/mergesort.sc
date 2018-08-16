package week5
import math.Ordering

object mergesort {

  /*
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
        	if (x < y) x :: merge(xs1, ys)
        	else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
  val nums = List(2, -4, 5, 7, 1)
  msort(nums)
  

  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(lt), msort(snd)(lt))
    }
  }
  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apples", "oranges", "pears", "pinapple")
  
  msort(nums)((x, y) => x < y)
  msort(fruits)((x, y) => x.compareTo(y) < 0)


  def msort[T](xs: List[T])(ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst)(ord), msort(snd)(ord))
    }
  }

  val nums = List(2, -4, 5, 7, 1)
  val fruits = List("apples", "oranges", "pears", "pinapple")
  
  msort(nums)(Ordering.Int)
  msort(fruits)(Ordering.String)
  */

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruits = List("apples", "oranges", "pears", "pinapple")
                                                  //> fruits  : List[java.lang.String] = List(apples, oranges, pears, pinapple)
  
  msort(nums)                                     //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  msort(fruits)                                   //> res1: List[java.lang.String] = List(apples, oranges, pears, pinapple)

}