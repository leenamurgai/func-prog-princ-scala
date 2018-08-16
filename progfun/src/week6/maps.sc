package week6
/*
Map[Key, Value] extends the collection type Iterable[(Key, Value)]
Maps are both Iterables and functions
*/
object maps {
	val romanNUmerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNUmerals  : scala.collection.immutable.Map[java.lang.String,Int] = Map(
                                                  //| I -> 1, V -> 5, X -> 10)
	val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[java.lang.String,java.lan
                                                  //| g.String] = Map(US -> Washington, Switzerland -> Bern)
	"I".->(1)                                 //> res0: (java.lang.String, Int) = (I,1)
  capitalOfCountry("US")                          //> res1: java.lang.String = Washington
  //capitalOfCountry("Andorra")
	capitalOfCountry get "Andorra"            //> res2: Option[java.lang.String] = None
	capitalOfCountry get "US"                 //> res3: Option[java.lang.String] = Some(Washington)

}