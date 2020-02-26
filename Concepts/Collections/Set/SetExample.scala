/*
  https://docs.scala-lang.org/overviews/scala-book/set-class.html
  https://docs.scala-lang.org/overviews/collections-2.13/sets.html

  The Scala Set class is an iterable collection with no duplicate elements.
  Scala has both mutable and immutable Set classes.
  In this lesson we’ll show how to use the mutable class.
*/

/*
  To use a mutable Set, first import it
*/
import scala.collection.mutable.Set

object SetExample extends App {
  val set = Set[Int]()

  /*
    You add elements to a mutable Set with the +=, ++=, and add methods.
  */
  set += 1
  set += 2 += 3
  set ++= Vector(4, 5)
  println(set)

  /*
    Notice that if you try to add a value to a set that’s already in it,
      the attempt is quietly ignored
  */
  set += 2
  println(set)

  /*
    Set also has an add method that returns true if an element is added to a set,
      and false if it wasn’t added
  */
  println(s"set.add(6): ${set.add(6)}")
  println(s"set.add(5): ${set.add(5)}")
  println(set)

  /*
    You remove elements from a set using the -= and --= methods
  */
  println()
  set -= 1
  println(set)

  set -= (2, 3)
  println(set)

  set --= Array(4,5)
  println(set)

  /*
    There are more methods for working with sets, including clear and remove
  */
  println()
  set.clear()
  println(set)

  set ++= Vector(1, 2, 3, 4)
  println(set)

  println(s"set.remove(3): ${set.remove(3)}")
  println(set)

  println(s"set.remove(40): ${set.remove(40)}")
  println(set)
}