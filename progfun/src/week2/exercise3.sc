object exercise3 {

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b)        //> product: (f: Int => Int)(a: Int, b: Int)Int

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x + y, 0)(a, b)        //> sum: (f: Int => Int)(a: Int, b: Int)Int

  // product_a^b(f:Int->Int)
  //def product(f: Int => Int)(a: Int, b: Int): Int =
  //  if (a > b) 1
  //  else f(a) * product(f)(a + 1, b)

  // sum_a^b(f:Int->Int)
  //def sum(f: Int => Int)(a: Int, b: Int): Int =
  //  if (a > b) 0
  //  else f(a) + sum(f)(a + 1, b)

  product(x => x * x)(3, 4)                       //> res0: Int = 144
  sum(x => x * x)(3, 4)                           //> res1: Int = 25

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  fact(5)                                         //> res2: Int = 120

}