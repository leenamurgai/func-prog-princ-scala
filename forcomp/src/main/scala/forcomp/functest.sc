package forcomp

object functest {

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))     //> encode: [T](xs: List[T])List[(T, Int)]

	val w = "ahfgpde gyST"                    //> w  : java.lang.String = ahfgpde gyST

	encode(w.toLowerCase.sorted.toList.filter(x => x.isLetter))
                                                  //> res0: List[(Char, Int)] = List((a,1), (d,1), (e,1), (f,1), (g,2), (h,1), (p,
                                                  //| 1), (s,1), (t,1), (y,1))
	w.toLowerCase.sorted.toList.filter(x => x.isLetter)
                                                  //> res1: List[Char] = List(a, d, e, f, g, g, h, p, s, t, y)
	w.toLowerCase.toList.filter(x => x.isLetter).groupBy((elem: Char) => elem).toList.map{case(a, b) => (a, b.length)}.sortBy{case(a, b) => a}
                                                  //> res2: List[(Char, Int)] = List((a,1), (d,1), (e,1), (f,1), (g,2), (h,1), (p,
                                                  //| 1), (s,1), (t,1), (y,1))
	
	List.fill(4)("a")                         //> res3: List[java.lang.String] = List(a, a, a, a)
	
	val letters = List("a", "b", "x", "t", "a", "y", "g", "h", "a", "x", "p", "q")
                                                  //> letters  : List[java.lang.String] = List(a, b, x, t, a, y, g, h, a, x, p, q)
                                                  //| 
	val numLeters = letters.length            //> numLeters  : Int = 12
	val all = (1 to 3).toList                 //> all  : List[Int] = List(1, 2, 3)
	
	/*
	def choose(n: Int, r: Int): List[List[Int]] = {
		val all = (1 to n).toList
		if (r == 0) Nil
		else if (r==1) (1 to r).toList.map(x => List(x))
		else ???
		}
	}
	*/

}