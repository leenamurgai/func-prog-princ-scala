package patmat
import Huffman._

object HuffmanTest {

  val x = times(List('a', 'b', 'c', 'd', 'a', 'b', 'c', 'a', 'b', 'a'))
                                                  //> x  : List[(Char, Int)] = List((a,4), (b,3), (c,2), (d,1))

  makeOrderedLeafList(x)                          //> res0: List[patmat.Huffman.Leaf] = List(Leaf(d,1), Leaf(c,2), Leaf(b,3), Leaf
                                                  //| (a,4))
  val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  val t2 = Leaf('d', 4)                           //> t2  : patmat.Huffman.Leaf = Leaf(d,4)
  val t3 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
                                                  //> t3  : patmat.Huffman.Fork = Fork(Fork(Leaf(a,2),Leaf(b,3),List(a, b),5),Leaf
                                                  //| (d,4),List(a, b, d),9)

  singleton(List(t1))                             //> res1: Boolean = true
  
  combine(List(t1, t2)) == List(t3)               //> res2: Boolean = true
  until(singleton, combine) (List(t1, t2))        //> res3: List[patmat.Huffman.CodeTree] = List(Fork(Fork(Leaf(a,2),Leaf(b,3),Lis
                                                  //| t(a, b),5),Leaf(d,4),List(a, b, d),9))

  convert(t1)                                     //> res4: patmat.Huffman.CodeTable = List((a,List(0)), (b,List(1)))
  convert(t3)                                     //> res5: patmat.Huffman.CodeTable = List((a,List(0, 0)), (b,List(0, 1)), (d,Lis
                                                  //| t(1)))

  encode(t1)(List('a', 'b'))                      //> res6: List[patmat.Huffman.Bit] = List(0, 1)
  quickEncode(t1)(List('a', 'b'))                 //> res7: List[patmat.Huffman.Bit] = List(0, 1)
  decode(t1, List(0, 1))                          //> res8: List[Char] = List(a, b)

  encode(t3)(List('a', 'b', 'd'))                 //> res9: List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 1)
  quickEncode(t3)(List('a', 'b', 'd'))            //> res10: List[patmat.Huffman.Bit] = List(0, 0, 0, 1, 1)
  decode(t3, List(1, 0, 0, 1, 1))                 //> res11: List[Char] = List(d, a, d, d)
}