/*
  https://docs.scala-lang.org/overviews/scala-book/map-class.html
  https://docs.scala-lang.org/overviews/scala-book/collections-maps.html
  https://docs.scala-lang.org/overviews/collections-2.13/maps.html

  The Map class documentation describes a Map as an iterable sequence
    that consists of pairs of keys and values.

  Scala has both mutable and immutable Map classes.
*/

// To use the mutable Map class, first import it:
// import scala.collection.mutable.Map

object MapExample extends App {
  def mapIntroduction(): Unit = {
    println("mapIntroduction:")
    /*
      Then you can create a Map like this

      To use the mutable Map class...
    */
    val states = scala.collection.mutable.Map(
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

  def commonMapMethods(): Unit = {
    /*
      We’ll demonstrate some of the most commonly used Map methods.
      In these initial examples we’ll use an immutable Map,
        and Scala also has a mutable Map class that you can modify in place.
    */
    val m = Map(
      1 -> "a", 
      2 -> "b", 
      3 -> "c",
      4 -> "d"
    )

    println("commonMapMethods:")
    println(s"\nm: ${m}")

    // How to iterate over Map elements
    for ((k,v) <- m) printf("key: %s, value: %s\n", k, v)

    // How to get the keys from a Map
    println(s"m.keys: ${m.keys}")

    // How to get the values from a Map
    println(s"m.values: ${m.values}")

    // How to test if a Map contains a value
    println(s"m.contains(3): ${m.contains(3)}")

    // How to transform Map values
    println(s"m.transform: ${m.transform((k,v) => v.toUpperCase)}")

    // How to filter a Map by its keys
    println(s"m.view.filterKeys: ${m.view.filterKeys(Set(2,3)).toMap}")

    // How to take the first two elements from a Map
    // Note that this example probably only makes sense for a sorted Map.
    println(s"m.take(2): ${m.take(2)}")

    val states = scala.collection.mutable.Map(
      "AL" -> "Alabama", 
      "AK" -> "Alaska"
    )
    println(s"states: ${states}")

    /*
      retain
      
      Retain elements by supplying a function that operates on the keys and/or values.
      Only to be used on mutable Maps
    */
    println(s"states.retain: ${states.retain((k,v) => k == "AK")}")
  }

  // mapIntroduction()
  commonMapMethods()
}