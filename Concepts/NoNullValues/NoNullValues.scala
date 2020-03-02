/*
  https://docs.scala-lang.org/overviews/scala-book/no-null-values.html

  Functional programming is like writing a series of algebraic equations,
    and because you don’t use null values in algebra, you don’t use null values in FP
  Scala’s solution is to use constructs like the Option/Some/None classes.

  Key points:
    - Functional programmers don’t use null values
    - A main replacement for null values is to use the Option/Some/None classes
    - Common ways to work with Option values are match and for expressions
    - Options can be thought of as containers of one item (Some) and no items (None)
    - You can also use Options when defining constructor parameters
*/
object NoNullValues extends App {
  /*
    While this first Option/Some/None example doesn’t deal with null values,
      it’s a good way to demonstrate the Option/Some/None classes,
      so we’ll start with it.

    The idea of this function is that if a string converts to an integer,
      you return the converted Int, but if the conversion fails you return 0.
    This might be okay for some purposes, but it’s not really accurate.
    For instance, the method might have received "0",
      but it may have also received "foo" or "bar" or an infinite number of other strings. 
  */
  def toIntNoOption(s: String): Int = {
    try {
      Integer.parseInt(s.trim)
    } catch {
      case e: Exception => 0
    }
  }

  /*
    Scala’s solution to this problem is to use a trio of classes known as Option, Some, and None.
    The Some and None classes are subclasses of Option, so the solution works like this:
      - You declare that toInt returns an Option type
      - If toInt receives a string it can convert to an Int, you wrap the Int inside of a Some
      - If toInt receives a string it can’t convert, it returns a None
  */
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  /*
    Now imagine that you’re a consumer of the toInt method.
    You know that the method returns a subclass of Option[Int],
      so the question becomes, how do you work with these return types?
    There are other approaches, but these are the two main approaches,
      especially from an FP standpoint.
    There are two main answers, depending on your needs:
      - Use a match expression
      - Use a for-expression
  */
  val stringA = "1"
  val stringB = "2"
  val stringC = "3"

  toInt(stringA) match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }

  val y = for {
    a <- toInt(stringA)
    b <- toInt(stringB)
    c <- toInt(stringC)
  } yield a + b + c

  println(y)

  /*
    Using Option to replace null values
  */
  class Address (
    var street1: String,
    var street2: Option[String],
    var city: String, 
    var state: String, 
    var zip: String
  )
  
  val santa = new Address(
    "1 Main Street",
    None,
    "North Pole",
    "Alaska",
    "99705"
  )

  val santaClause = new Address(
    "123 Main Street",
    Some("Apt. 2B"),
    "Talkeetna",
    "Alaska",
    "99676"
  )

}