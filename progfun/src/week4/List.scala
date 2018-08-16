package week4

import java.util.NoSuchElementException

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object UseFuncs {
  // Here's a function the creates a list consisting of one element
  def singleton[T](elem: T) = new Cons[T](elem, Nil)
  // Then we can for example make the following singletons by writing
  val ex1 = singleton[Int](1)
  val ex2 = singleton[Boolean](true)
}

object List {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, Nil))
  def apply[T]() = Nil
}

object test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty.type) = xs prepend x
}