/*
  https://docs.scala-lang.org/overviews/collections-2.13/maps.html

  The Map class documentation describes a Map as an iterable sequence
    that consists of pairs of keys and values.

  Scala has both mutable and immutable Map classes.
  In this lesson we’ll show how to use the mutable class.
*/

// To use the mutable Map class, first import it:
import scala.collection.mutable.Map

object MapExample extends App {
  /*
    Then you can create a Map like this
  */
  val states = Map(
    "AK" -> "Alaska",
    "IL" -> "Illinois",
    "KY" -> "Kentucky"
  )
  println(s"states: ${states}")

  /*
    Now you can add a single element to the Map with +=, like this
  */
  states += ("AL" -> "Alabama")
  println(s"states: ${states}")

  // You also add multiple elements using += (deprecated)
  // states += ("AR" -> "Arkansas", "AZ" -> "Arizona", "TN" -> "Tenessee", "PA" -> "Pennsylvania")

  /*
    You can add elements from another Map using ++=
  */
  states ++= Map(
    "AR" -> "Arkansas",
    "AZ" -> "Arizona",
    "TN" -> "Tenessee",
    "PA" -> "Pennsylvania",
    "CA" -> "California",
    "CO" -> "Colorado"
  )
  println(s"states: ${states}")

  /*
    You remove elements from a Map using -= and --= and specifying the key values,
      as shown in the following examples:
  */
  println()
  states -= "AR"
  println(s"states: ${states}")
  states -= ("AZ", "TN")
  println(s"states: ${states}")
  states --= List("AL", "KY")
  println(s"states: ${states}")

  /*
    You update Map elements by reassigning their key to a new value
  */
  println()
  states("AK") = "Alaska - A Really Big State"
  println(s"states: ${states}")

  /*
    There are several different ways to iterate over the elements in a map.

    A nice way to loop over all of the map elements is with this for loop syntax
  */
  println()
  for ((k, v) <- states) println(s"key: $k, value: $v")

  /*
    Using a match expression with the foreach method is also very readable
  */
  println()
  states.foreach {
      case(key, value) => println(s"key: $key, value: $value")
  }
}