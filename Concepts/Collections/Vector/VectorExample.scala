/*
  https://docs.scala-lang.org/overviews/scala-book/vector-class.html
  https://www.scala-lang.org/api/current/scala/collection/immutable/Vector.html

  The Vector class is an indexed, immutable sequence.
  The “indexed” part of the description means that you can access
    Vector elements very rapidly by their index value,
    such as accessing listOfPeople(999999).

  In general, except for the difference that Vector is indexed and List is not,
    the two classes work the same, so we’ll run through these examples quickly.
*/

class Person(name: String) {
  override def toString(): String = name
}

object VectorExample extends App {
  // Here are a few ways you can create a Vector
  val nums = Vector(1, 2, 3, 4, 5)
  val strings = Vector("one", "two")
  val peeps = Vector(
    new Person("Bert"),
    new Person("Ernie"),
    new Person("Grover")
  )

  /*
    Because Vector is immutable, you can’t add new elements to it.
    Instead you create a new sequence by appending or prepending elements to an existing Vector
  */
  val a = Vector(1,2,3)
  println(s"a: ${a}")
  val b = a :+ 4
  println(s"b: ${b}")
  val c = a ++ Vector(4, 5)
  println(s"c: ${c}")
  val d = 0 +: a
  println(s"d: ${d}")

  /*
    Finally, you loop over elements in a Vector just like you do with an ArrayBuffer or List
  */
  for (peep <- peeps) println(peep.toString())
}