package week4

object exprs {

  def show(e: Expr): String = e match {
    case Number(x) => x.toString
    case Sum(l, r) => show(l) + " + " + show(r)
    case Var(e) => e
    case Prod(Sum(l1, r1), Sum(l2, r2)) => "(" + show(Sum(l1, r1)) + ") * (" + show(Sum(l2, r2)) + ")"
    case Prod(Sum(l1, r1), r) => "(" + show(Sum(l1, r1)) + ") * " + show(r)
    case Prod(l, Sum(l2, r2)) => show(l) + " * (" + show(Sum(l2, r2)) + ")"
    case Prod(l, r) => show(l) + " * " + show(r)
  }                                               //> show: (e: week4.Expr)String

show(Sum(Number(1), Number(44)))                  //> res0: String = 1 + 44
show( Sum( Prod(Number(2), Var("x")) , Var("y"))) //> res1: String = 2 * x + y
show( Prod( Sum(Number(2), Var("x")) , Var("y"))) //> res2: String = (2 + x) * y

}