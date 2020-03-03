/*
  https://docs.scala-lang.org/overviews/scala-book/futures.html
  https://www.scala-lang.org/api/current/scala/concurrent/Future$.html

  The following application (App) provides an introduction to using multiple futures.
  It shows several key points about how to work with futures:
    - How to create futures
    - How to combine multiple futures in a for expression to obtain a single result
    - How to work with that result once you have it
*/

/*
  A potentially slow-running method

  First, imagine you have a method that accesses a web service to get the current price of a stock.
  Because it’s a web service it can be slow to return, and even fail.
  As a result, you create a method to run as a Future.
  It takes a stock symbol as an input parameter and returns the stock price as a Double inside a Future,
    so its signature looks like this:
  
  def getStockPrice(stockSymbol: String): Future[Double] = ???
*/
package futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object MultipleFutures extends App {
    // use this to determine the “delta time” below
    val startTime = currentTime

    // (a) create three futures
    val aaplFuture = getStockPrice("AAPL")
    val amznFuture = getStockPrice("AMZN")
    val googFuture = getStockPrice("GOOG")

    // (b) get a combined result in a for-expression
    val result: Future[(Double, Double, Double)] = for {
        aapl <- aaplFuture
        amzn <- amznFuture
        goog <- googFuture
    } yield (aapl, amzn, goog)
    println(s"after for:         ${deltaTime(startTime)}")
    
    // (c) do whatever you need to do with the results
    println(s"before onComplete: ${deltaTime(startTime)}")
    result.onComplete {
        case Success(x) => {
            val totalTime = deltaTime(startTime)
            println(s"In Success case, time delta: ${totalTime}")
            println(s"The stock prices are: $x")
        }
        case Failure(e) => e.printStackTrace
    }
    println(s"after onComplete:  ${deltaTime(startTime)}")

    // important for a short parallel demo: you need to keep
    // the jvm’s main thread alive
    val sleepTime = 5000
    println(s"start sleep(${sleepTime}): ${deltaTime(startTime)}")
    sleep(sleepTime)

    println("after sleep")

    def sleep(time: Long): Unit = Thread.sleep(time)

    /*
      To keep this tutorial simple we won’t access a real web service,
        so we’ll mock up a method that has a random run time before returning a result.
      That method sleeps a random time up to 3000 ms, and also returns a random stock price.
      Notice how simple it is to create a method that runs as a Future:
        Just pass a block of code into the Future constructor to create the method body.

      Mock webservie
    */
    def getStockPrice(stockSymbol: String): Future[Double] = Future {
        val r = scala.util.Random
        val randomSleepTime = r.nextInt(3000)
        println(s"For $stockSymbol, sleep time is $randomSleepTime")
        val randomPrice = r.nextDouble * 1000
        sleep(randomSleepTime)
        randomPrice
    }

    def currentTime = System.currentTimeMillis()
    def deltaTime(t0: Long) = currentTime - t0

}