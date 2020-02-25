/*
  https://docs.scala-lang.org/overviews/scala-book/anonymous-functions.html

  In this lesson we’ll use lists like these to demonstrate a feature
    of functional programming known as anonymous functions.
  It will help to understand how these work before we demonstrate
    the most common Scala collections methods.

  The key points of this lesson are:
    - You can write anonymous functions as little snippets of code.
    - You can use them with methods on the List class like map and filter.
    - With these little snippets of code and powerful methods like those, you can create a lot of functionality with very little code.
  
    The Scala collections classes contain many methods like map and filter, and they’re a powerful way to create very expressive code.
*/

object AnonymousFunctions extends App {
  /*
    An anonymous function is like a little mini-function.
    You can create a new list by doubling each element in ints, like this

    In this example, this code is an anonymous function: _ * 2
  */
  val ints = List(1,2,3)
  val doubledInts = ints.map(_ * 2)
  println(doubledInts)

  /*
    Once you’re comfortable with Scala, this is a common way to write anonymous functions,
      but if you prefer, you can also write them using longer forms.
    
      Besides writing that code like this:
      - val doubledInts = ints.map(_ * 2)

    You can also write it like this:
  */
  val doubledIntsA = ints.map((i: Int) => i * 2)
  val doubledIntsB = ints.map(i => i * 2)

  /*
    All three lines have exactly the same meaning:
      - Double each element in ints to create a new list, doubledInts.

    The _ character in Scala is something of a wildcard character.
      - You’ll see it used in several different places.
      - In this case it’s a shorthand way of saying, “An element from the list, ints.”

    The map example shown is also the same as this Scala code:
  */
  val doubledIntsC = for (i <- ints) yield i * 2

  /*
    Another good way to show anonymous functions
      is with the filter method of the List class.
      
    Given this List:
  */
  val nums = List.range(1, 10)

  /*
    This is how you create a new list of all integers whose value is greater than 5:
  */
  val x = ints.filter(_ > 5)

  /*
    This is how you create a new list whose values are all less than 5:
  */
  val x = ints.filter(_ < 5)

  /*
    And as a little more complicated example,
      this is how you create a new list that contains only even values,
      by using the modulus operator:
  */
  val x = ints.filter(_ % 2 == 0)

}