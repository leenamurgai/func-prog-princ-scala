package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if ( c == 0 ) 1
    else if (c > r/2.0) pascal(r-c,r)
    else pascal(c-1,r-1) + pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def balanceInner(left: List[Char], right: List[Char]): Boolean = {
      // cases where right is empty
      if (left.isEmpty && right.isEmpty) true
      else if (!left.isEmpty && right.isEmpty) false
      // cases where right.head is not a bracket
      else if (right.head!='(' && right.head!=')') balanceInner(left, right.tail)
      // now right.head is always a bracket
      else if (right.head=='(') balanceInner('(' :: left, right.tail)
      // now right.head is always a close bracket
      else if (left.isEmpty && right.head==')') false            
      else balanceInner(left.tail, right.tail)
    }
    balanceInner( Nil, chars )
    
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    /* 
     * coins is a list of denominations in descending order
     * this function gives the number of ways of making the amount 'money' using at least
     * one coin with the denomination coins.head
     */
    def countChangeInner(money: Int, coins: List[Int]): Int = {
      if (money<0) 0
      else if (money==0) 1
      else if (coins.isEmpty) 0
      else if (coins.head>money) countChangeInner(money, coins.tail)
      else countChangeInner(money-coins.head,coins) + countChangeInner(money,coins.tail)
    }
    
    if (money==0) 1
    else if (coins.isEmpty) 0
    else countChangeInner( money, coins.sorted.filter(_<=money).reverse.distinct )
    /* 
     * actually it turns out that it doesn't matter about the order, number of denominations
     * or if there are duplicates!!!!
     */
  }
}
