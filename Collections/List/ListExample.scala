/*
  https://www.scala-lang.org/api/current/scala/collection/immutable/List.html

  The List class is a linear, immutable sequence.
  All this means is that it’s a linked-list that you can’t modify.
  Any time you want to add or remove List elements, you create a new List from an existing List.
*/

object ListExample extends App {
  // This is how you create an initial List.
  val ints: List[Int] = List(1, 2, 3)

  /*
    Because List is immutable, you can’t add new elements to it.
    Instead you create a new list by prepending or appending elements to an existing List.
  
    For instance, given this List:
  */
  val a = List(1,2,3)
  println(s"a: ${a}")

  // You prepend elements to a List like this:
  val b = 0 +: a
  println(s"b: ${b}")

  // and this:
  val c = List(-1, 0) ++: a
  println(s"c: ${c}")

  /*
    You can also append elements to a List, but because List is a singly-linked list,
      you should really only prepend elements to it;
      appending elements to it is a relatively slow operation,
      especially when you work with large sequences.

    Tip: If you want to prepend and append elements to an immutable sequence, use Vector instead.

    Because List is a linked-list class, you shouldn’t try to access the
      elements of large lists by their index value.
    For instance, if you have a List with one million elements in it,
      accessing an element like myList(999999) will take a long time.
    If you want to access elements like this, use a Vector or ArrayBuffer instead.
  */

  /*
    These days, IDEs help us out tremendously, but one way to remember those method names
      is to think that the : character represents the side that the sequence is on,
      so when you use +: you know that the list needs to be on the right, like this:
  */
  val d = 0 +: a
  println(s"d: ${d}")
  val e = a :+ 4
  println(s"e: ${e}")

  /*
    How to loop over lists
    We showed how to loop over lists earlier in this book,
      but it’s worth showing the syntax again.

    A great thing about this approach is that it works with all sequence classes,
      including ArrayBuffer, List, Seq, Vector, etc.

    Given a List like this:
  */
  val names: List[String] = List("Joel", "Chris", "Ed")

  // You can print each string like this:
  println()
  println("names:")
  for (name <- names) println(name)

  /*
    If you’re interested in a little bit of history,
      the List class is very similar to the List class from the Lisp programming language.
    This works because a List is a singly-linked list that ends with the Nil element.

    Indeed, you can also create a list this way:
  */
  val list = 1 :: 2 :: 3 :: Nil
  println()
  println("Lisp-like list:")
  for (value <- list) println(value)
}
