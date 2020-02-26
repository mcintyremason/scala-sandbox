/*
  https://docs.scala-lang.org/overviews/scala-book/tuples.html

	A tuple is a neat class that gives you a simple way to store
    heterogeneous (different) items in the same container.

  Tuples aren’t collections
  Technically, Scala 2.x tuples aren’t collections classes,
    they’re just a convenient little container.
  Because they aren’t a collection, they don’t have methods like map, filter, etc.
*/

object Tuples extends App {
  class Person(var name: String)

  /*
    Instead of having to create an ad-hoc class to store things in, like this
  */
  class SomeThings(i: Int, s: String, p: Person)

  /*
    You can just create a tuple like this
  */
  val t = (3, "Three", new Person("Al"))

  /*
    As shown, just put some elements inside parentheses, and you have a tuple.
    Scala tuples can contain between two and 22 items,
      and they’re useful for those times when you just need to combine a few things together,
      and don’t want the baggage of having to define a class, especially when that class feels a little “artificial” or phony

    There are a few ways to access tuple elements.
    One approach is to access them by element number,
      where the number is preceded by an underscore
  */
  println(s"t._1: ${t._1}")
  println(s"t._2: ${t._2}")
  println(s"t._3: ${t._3}")

  /*
    Another cool approach is to access them like this:
  */
  val (x, y, z) = t
  println(s"x: ${x}")
  println(s"y: ${y}")
  println(s"z: ${z}")

  /*
    A place where this is nice is when you want to return multiple values from a method.
  */
  def getStockInfo = {
    // other code here ...
    // this is a Tuple3
    ("NFLX", 100.00, 101.00)
  }

  /*
    Now you can call that method and assign variable names to the return values:
  */
  val (symbol, currentPrice, bidPrice) = getStockInfo
  println(s"symbol: ${symbol}")
  println(s"currentPrice: ${currentPrice}")
  println(s"bidPrice: ${bidPrice}")
}