/*
  https://docs.scala-lang.org/overviews/scala-book/functional-error-handling.html

  Because functional programming is like algebra, there are no null values or exceptions.
  But of course you can still have exceptions when you try to access servers that are down or files that are missing,
    so what can you do? This lesson demonstrates the techniques of functional error handling in Scala.
*/

/*
  Option/Some/None
  
  We already demonstrated one of the techniques to handle errors in Scala:
    The trio of classes named Option, Some, and None.
  Instead of writing a method like toInt to throw an exception or return a null value,
    you declare that the method returns an Option, in this case an Option[Int]:

  These approaches were discussed in the “No Null Values” lesson, so we won’t repeat that discussion here.
*/
import scala.util.{Try,Success,Failure}

object FunctionalErrorHandling extends App {
  def optionToInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  def callOptionToInt(): Unit = {
    val stringA = "1"
    val stringB = "2"
    val stringC = "3"

    optionToInt(stringA) match {
      case Some(i) => println(i)
      case None => println("That didn't work.")
    }

    val y = for {
      a <- optionToInt(stringA)
      b <- optionToInt(stringB)
      c <- optionToInt(stringC)
    } yield a + b + c

    println(y)
  }

  /*
    Try/Success/Failure

    Another trio of classes named Try, Success, and Failure work just like Option, Some, and None,
      but with two nice features:
      - Try makes it very simple to catch exceptions
      - Failure contains the exception message
  */
  def tryToInt(s: String): Try[Int] = Try(Integer.parseInt(s.trim))
  def callTryToInt(): Unit = {
    val stringA = "1"
    val stringB = "2"
    val stringC = "3"

    tryToInt(stringA) match {
      case Success(i) => println(i)
      case Failure(s) => println(s"Failed. Reason: $s")
    }

    val y = for {
      a <- tryToInt(stringA)
      b <- tryToInt(stringB)
      c <- tryToInt(stringC)
    } yield a + b + c

    println(y)
  }

  callOptionToInt()
  val a = tryToInt("1")
  val b = tryToInt("boo")
  callTryToInt()
}