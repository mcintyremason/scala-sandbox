/*
  https://docs.scala-lang.org/overviews/scala-book/collections-methods.html
  https://docs.scala-lang.org/overviews/collections-2.13/seqs.html

  Note: The methods don’t mutate the collection

  As a very important note, none of these methods mutate the collection that they’re called on.
  They all work in a functional style, so they return a new collection with the modified results.
*/

object SequenceMethods extends App {
  // The following examples will use these lists:
  val nums: List[Int] = (1 to 10).toList
  val names: List[String] = List("joel", "ed", "chris", "maurice")

  def mapExamples(): Unit = {
    /*
    map
    
    The map method steps through each element in the existing list,
    applying the algorithm you supply to each element, one at a time;
    it then returns a new list with all of the modified elements.
    */
    println("\nmap:")

    val doubles = nums.map(_ * 2)
    println(s"doubles: ${doubles}")

    val capNames = names.map(_.capitalize)
    println(s"capNames: ${capNames}")

    /*
      It’s perfectly legal (and very common) to use map to return a list
        with a different type (List[Boolean]) from the original type (List[Int]).
    */
    val lessThanFive = nums.map(_ < 5)
    println(s"lessThanFive: ${lessThanFive}")
  }

  def filterExamples(): Unit = {
    /*
    filter
    
    The filter method creates a new, filtered list from the given list
    */
    println("\nfilter:")

    val lessThanFive = nums.filter(_ < 5)
    println(s"lessThanFive: ${lessThanFive}")

    val evens = nums.filter(_ % 2 == 0)
    println(s"evens: ${evens}")

    val shortNames = names.filter(_.length <= 4)
    println(s"shortNames: ${shortNames}")
  }

  def foreachExamples(): Unit = {
    /*
      foreach

      The foreach method is used to loop over all elements in a collection.
      foreach is used for side-effects, such as printing information.
    */
    println("\nforeach:")

    println("names.foreach(println):")
    names.foreach(println)

    /*
      The nums list is a little long, so you may not want to print out all of those elements.
      But a great thing about Scala’s approach is that you can chain methods together to solve problems like this.
    */
    println("nums.filter(_ < 4).foreach(println):")
    nums.filter(_ < 4).foreach(println)
  }

  def headExamples(): Unit = {
    /*
      head

      The head method comes from Lisp and functional programming languages.
      It’s used to print the first element (the head element) of a list.
    */
    println("\nhead:")
    
    println(s"nums.head: ${nums.head}")
    println(s"names.head: ${names.head}")

    /*
      Because a String is a sequence of characters, you can also treat it like a list.
    */
    println(s"'foo'.head: ${"foo".head}")
    println(s"'bar'.head: ${"bar".head}")

    /*
      head is a great method to work with, but as a word of caution
        it can also throw an exception when called on an empty collection.
      
      Uncomment the code below to view the exception.
    */
    // val emptyList = List[Int]()
    // println(s"emptyList.head: ${emptyList.head}")
  }

  def tailExamples(): Unit = {
    /*
      tail

      The tail method also comes from Lisp and functional programming languages.
      It’s used to print every element in a list after the head element.
    */
    println("\ntail:")
    
    println(s"nums.tail: ${nums.tail}")
    println(s"names.tail: ${names.tail}")

    /*
      Just like head, tail also works on strings
    */
    println(s"'foo'.tail: ${"foo".tail}")
    println(s"'bar'.tail: ${"bar".tail}")

    /*
      Note that like head,
        tail will also throw an exception when called on an empty collection
      
      Uncomment the code below to view the exception.
    */
    // val emptyList = List[Int]()
    // println(s"emptyList.tail: ${emptyList.tail}")
  }

  def takeAndTakeWhileExamples(): Unit = {
    /*
      take, takeWhile
      
      The take and takeWhile methods give you a nice way of taking
        the elements out of a list that you want to create a new list.
    */
    println("\ntake:")
    println(s"nums.take(1): ${nums.take(1)}")
    println(s"nums.take(2): ${nums.take(5)}")
    println(s"names.take(1): ${names.take(1)}")
    println(s"names.take(2): ${names.take(2)}")

    println("\ntakeWhile:")
    println(s"nums.takeWhile(_ < 5): ${nums.takeWhile(_ < 5)}")
    println(s"names.takeWhile(_.length < 5): ${names.takeWhile(_.length < 5)}")
  }

  def dropAndDropWhileExamples(): Unit = {
    /*
      drop, dropWhile

      drop and dropWhile are essentially the opposite of take and takeWhile.
    */
    println("\ndrop:")
    println(s"nums.drop(1): ${nums.drop(1)}")
    println(s"nums.drop(5): ${nums.drop(5)}")
    println(s"names.drop(1): ${names.drop(1)}")
    println(s"names.drop(2): ${names.drop(2)}")

    println("\ndropWhile:")
    println(s"nums.dropWhile(_ < 5): ${nums.dropWhile(_ < 5)}")
    println(s"names.dropWhile(_ != 'chris'): ${names.dropWhile(_ != "chris")}")
  }

  def reduceExamples(): Unit = {
    /*
      When you hear the term, “map reduce,” the “reduce” part refers to methods like reduce.
      It takes a function (or anonymous function) and applies that function to successive elements in the list.

      The best way to explain reduce is to create a little helper method you can pass into it.

      An important part to know about reduce is that 
        it’s used to reduce a collection down to a single value.
    */
    def sum(x: Int, y: Int): Int = {
      val theSum = x + y
      println(s"received $x and $y, their sum is $theSum")
      theSum
    }

    println("\nreduce:")
    println(s"nums.reduce(sum): ${nums.reduce(sum)}")

    /*
      Once you get used to reduce, you’ll write a “sum” algorithm like this:
    */
    println(s"nums.reduce(_ + _): ${nums.reduce(_ + _)}")

    /*
      Similarly, this is what a “product” algorithm looks like:
    */
    println(s"nums.reduce(_ * _): ${nums.reduce(_ * _)}")
  }

  println(s"nums: ${nums}")
  println(s"names: ${names}")
  
  // mapExamples()
  // filterExamples()
  // foreachExamples()
  // headExamples()
  // tailExamples()
  // takeAndTakeWhileExamples()
  // dropAndDropWhileExamples()
  reduceExamples()
}