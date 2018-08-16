package week3

class Rational(x: Int, y: Int) {

  require(y != 0, "denom must be non-zero")
  //assert(y != 0, "denom must be non-zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  def numer = x / g
  def denom = y / g

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
    numer + "/" + denom
    //numer / g + "/" + denom / g
  }
}