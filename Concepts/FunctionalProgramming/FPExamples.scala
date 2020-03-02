/*
  A first feature Scala offers to help you write functional code is the ability to write pure functions.
  In Functional Programming, a pure function like this:
    - The function’s output depends only on its input variables
    - It doesn’t mutate any hidden state
    - It doesn’t have any “back doors”:
      It doesn’t read data from the outside world (including the console, web services, databases, files, etc.),
      or write data to the outside world
    - Any time you call a pure function with the same input value(s), you’ll always get the same result.

  Write the core of your application using pure functions,
    and then write an impure “wrapper” around that core to interact with the outside world.
  If you like food analogies,
    this is like putting a layer of impure icing on top of a pure cake.

  A pure function is a function that depends only on its declared inputs and its internal algorithm to produce its output.
  It does not read any other values from “the outside world”
    — the world outside of the function’s scope
    — it does not modify any values in the outside world
*/

object FPExamples extends App {
  /*
    Even though double is defined as a method, Scala lets you treat it as a function.
  */
  def double(i: Int): Int = i * 2

  def sum(list: List[Int]): Int = list match {
      case Nil => 0
      case head :: tail => head + sum(tail)
  }

  println(List(1, 2, 3, 4).map(double))
  println(sum(List(1, 2, 3, 4)))

  /*
    If you like technical terms,
      a function that takes another function as an input parameter is known as a Higher-Order Function (HOF). 
  */
  println(List("foo", "bar").map(_.toUpperCase))
  println(List("foo", "bar").map(_.capitalize))
  println(List("adam", "scott").map(_.length))
  println(List(1,2,3,4,5).map(_ * 10))
  println(List(1,2,3,4,5).filter(_ > 2))
  println(List(5,1,3,11,7).takeWhile(_ < 6))
}