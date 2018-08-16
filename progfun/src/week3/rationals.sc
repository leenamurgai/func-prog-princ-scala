object rationals {

  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  x.sub(y).sub(z)                                 //> res2: Rational = -79/42
  x - y - z                                       //> res3: Rational = -79/42
  y.add(y)                                        //> res4: Rational = 10/7
  y + y                                           //> res5: Rational = 10/7
  x.less(y)                                       //> res6: Boolean = true
  x < y                                           //> res7: Boolean = true
  x.max(y)                                        //> res8: Rational = 5/7
  //val strange = new Rational(1, 0)
  //strange.add(strange)

  new Rational(2)                                 //> res9: Rational = 2/1
}

class Rational(x: Int, y: Int) {

  require(y != 0, "denom must be non-zero")
  //assert(y != 0, "denom must be non-zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  //private val g = gcd(x, y)

  def numer = x /// g
  def denom = y /// g

  def less(that: Rational) = this.numer * that.denom < that.numer * this.denom
  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  //def max(that: Rational) = if (this.less(that)) that else this
  def max(that: Rational) = if (this < that) that else this

  def add(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def neg: Rational = new Rational(-numer, denom)
  def unary_- : Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)
  def -(that: Rational) = this + -that

  override def toString = {
    val g = gcd(numer, denom)
    //numer + "/" + denom
    numer / g + "/" + denom / g
  }
}