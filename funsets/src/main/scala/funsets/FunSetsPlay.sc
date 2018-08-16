import funsets.FunSets._

object FunSetsPlay {
  val s1 = singletonSet(1)                        //> s1  : Int => Boolean = <function1>
  val s2 = singletonSet(2)                        //> s2  : Int => Boolean = <function1>
  val s3 = singletonSet(3)                        //> s3  : Int => Boolean = <function1>
  val s4 = singletonSet(4)                        //> s4  : Int => Boolean = <function1>

  val s = union(s1, (union(s2, union(s3, s4))))   //> s  : Int => Boolean = <function1>
  val thisSet = funsets.FunSets.toString(s)       //> thisSet  : String = {1,2,3,4}
  val fs = map(s, x => x*x)                       //> fs  : Int => Boolean = <function1>
  val fThisSet = funsets.FunSets.toString(fs)     //> fThisSet  : String = {1,4,9,16}
  
  val lessThanFive = forall(s, _<5)               //> lessThanFive  : Boolean = true
}