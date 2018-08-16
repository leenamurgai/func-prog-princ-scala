package week6

object session {

  val xs = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)    //> xs  : Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)

  val s = "Hello World"                           //> s  : java.lang.String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  val pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s flatMap (c => List('.', c))                   //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res6: Int = 45
  xs.max                                          //> res7: Int = 9
  
  val n = 3                                       //> n  : Int = 3
  val m = 2                                       //> m  : Int = 2
  val l = 2                                       //> l  : Int = 2
  
  (1 to n).map(x => 2 * x)                        //> res8: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6)
  (1 to m).flatMap(x => (1 to n).map(y => (x, y)))//> res9: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (2,1), (2,2), (2,3))
  (1 to m).map(x => (1 to n).map(y => (x, y))).flatten
                                                  //> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,
                                                  //| 2), (1,3), (2,1), (2,2), (2,3))
  
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  	//(xs zip ys).map(xy => xy._1 * xy._2).sum
  	(xs zip ys).map{ case (x, y) => x * y }.sum
                                                  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
  
  val u = Vector(1., 2., 3.)                      //> u  : scala.collection.immutable.Vector[Double] = Vector(1.0, 2.0, 3.0)
  val v = Vector(1., 3., 5.)                      //> v  : scala.collection.immutable.Vector[Double] = Vector(1.0, 3.0, 5.0)
  scalarProduct(u, v)                             //> res11: Double = 22.0
  
}