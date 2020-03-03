/*
  https://docs.scala-lang.org/overviews/scala-book/futures.html
  https://www.scala-lang.org/api/current/scala/concurrent/Future$.html

  Here’s a description of Future from its Scaladoc:
  “A Future represents a value which may or may not currently be available,
    but will be available at some point,
    or an exception if that value could not be made available.”
*/
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object FuturesExplained extends App {
  /*
    Thinking in futures

    To help demonstrate this,
      in single-threaded programming you bind the result of a function call to a variable like this:
  */
  def aShortRunningTask(): Int = 42
  val x = aShortRunningTask

  /*
    When you’re working with a Future, the assignment process looks similar.
    But because aLongRunningTask takes an indeterminate amount of time to return,
      the value in x may or may not be currently available,
      but it will be available at some point (in the future).
  */
  def aLongRunningTask(): Future[Int] = ???
  // val y = aLongRunningTask

  /*
    Another important point to know about futures is that they’re intended as a one-shot,
      “Handle this relatively slow computation on some other thread,
      and call me back with a result when you’re done” construct.
    (As a point of comparison,
      Akka actors are intended to run for a long time and respond to many requests during their lifetime,
      but each future you create is intended to be run only once.)
    
    Tip:
      If you’re just starting to work with futures and find the name Future to be confusing in the following examples,
      replace it with the name ConcurrentResult, which might be easier to understand initially.
  */

  /*
    A Scala Future is used to create a temporary pocket of concurrency that you use for one-shot needs.
    You typically use it when you need to call an algorithm that runs an indeterminate amount of time
      — such as calling a web service or executing a long-running algorithm
      — so you therefore want to run it off of the main thread
    
    For example, here’s a future that sleeps for ten seconds and then returns the value 42:
  */
  val a = Future { Thread.sleep(5*1000); 42 }
  val b = a.map(_ * 2)
  println(b)
  Thread.sleep(5*1000)

  /*
    Notice that the 84 you expect is wrapped in a Success,
      which is further wrapped in a Future.
    
    This is a key point to know:
      - The value in a Future is always an instance of one of the Try types: Success or Failure.
    Therefore, when working with the result of a future, use the usual Try-handling techniques,
      or one of the other Future callback methods.
  */
  println(b)

  /*
    One commonly used callback method is onComplete,
      which takes a partial function in which you should handle the Success and Failure cases, like this:
  */
  a.onComplete {
    case Success(value) => println(s"Got the callback, value = $value")
    case Failure(e) => e.printStackTrace
  }
}