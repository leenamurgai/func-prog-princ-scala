package week6

/*
Lutz Prechelt: An empirical comparison of several Programming Languages. IEEE Computer 33(10): 23-29 (2000)
Tested with Tcl, Python, Perl, Rexx, Java, C++, C.
Code size medians were ~100 loc for scripting languages and 200-300 for others
*/

//import scala.io.Source

object mnemonics {

	//val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxworks")
	//val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))
	val words = List("worda", "wordb", "wordc",
		"wordd", "worde", "wordf", "wordg", "wordh",
		"wordi", "wordj", "wordk", "wordl", "scala",
		"is", "fun")                      //> words  : List[java.lang.String] = List(worda, wordb, wordc, wordd, worde, wo
                                                  //| rdf, wordg, wordh, wordi, wordj, wordk, wordl, scala, is, fun)
	val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
                                                  //> mnem  : scala.collection.immutable.Map[Char,java.lang.String] = Map(8 -> TUV
                                                  //| , 4 -> GHI, 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
	// Inverts the mnem map to give a map from chars to nums
	val charCode: Map[Char, Char] =
		for ((digit, str) <- mnem; ltr <- str)
		yield ltr -> digit                //> charCode  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J -
                                                  //| > 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 5,
                                                  //|  B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, Z -
                                                  //| > 9, S -> 7)
	// Maps a word to the digit string which represents it
	def wordCode(word: String): String =
		word.toUpperCase map charCode     //> wordCode: (word: String)String

	wordCode("Java")                          //> res0: String = 5282
	
	// A map from a digit string to  List of words (from val words above) that can represent them
	val wordsForNum: Map[String, Seq[String]] =
		words groupBy wordCode withDefaultValue Seq()
                                                  //> wordsForNum  : Map[String,Seq[String]] = Map(96733 -> List(wordd, worde, wo
                                                  //| rdf), 96734 -> List(wordg, wordh, wordi), 386 -> List(fun), 47 -> List(is),
                                                  //|  96735 -> List(wordj, wordk, wordl), 72252 -> List(scala), 96732 -> List(wo
                                                  //| rda, wordb, wordc))
	
	// Returns all the ways to encode a number string as a List of words
	def encode(number: String): Set[List[String]] =
		if (number.isEmpty) Set(List())
		else{
			for{
				split <- 1 to number.length
				word <- wordsForNum(number take split)
				rest <- encode(number drop split)
			} yield word :: rest
		}.toSet                           //> encode: (number: String)Set[List[String]]
	
	encode("7225247386")                      //> res1: Set[List[String]] = Set(List(scala, is, fun))
	
	def translate(number: String): Set[String] =
		encode(number) map (_ mkString " ")
                                                  //> translate: (number: String)Set[String]
	
	//translate("7225247386")
	
}