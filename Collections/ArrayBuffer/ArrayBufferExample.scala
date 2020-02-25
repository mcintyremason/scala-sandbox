/*
  https://www.scala-lang.org/api/current/scala/collection/mutable/ArrayBuffer.html
  
  If you’re an OOP developer coming to Scala from Java,
    the ArrayBuffer class will probably be most comfortable for you,
    so we’ll demonstrate it first. It’s a mutable sequence,
    so you can use its methods to modify its contents,
    and those methods are similar to methods on Java sequences.
  To use an ArrayBuffer you must first import it:
*/

import scala.collection.mutable.ArrayBuffer

object ArrayBufferExample extends App {
	def simpleExamples: Unit = {
    println("simpleExamples called")
    
    /*
      After it’s imported into the local scope, you create an empty ArrayBuffer like this:
    */
    val ints = ArrayBuffer[Int]()
    val names = ArrayBuffer[String]()

    println(s"names: ${names}")

    /*
      Once you have an ArrayBuffer you add elements to it in a variety of ways:
    */
    ints += 1
    ints += 2
    println(s"ints: ${ints}")

    /*
      That’s just one way create an ArrayBuffer and add elements to it.
      You can also create an ArrayBuffer with initial elements like this:
    */
    val nums = ArrayBuffer(1, 2, 3)
    // add one element
    nums += 4

    // add multiple elements
    nums += 5 += 6

    // add multiple elements from another collection
    nums ++= List(7, 8, 9)

    println(s"nums: ${nums}")

    /*
      You remove elements from an ArrayBuffer with the -= and --= methods:
    */
    // remove one element
    nums -= 9

    // remove multiple elements
    nums -= 7 -= 8

    // remove multiple elements using another collection
    nums --= Array(5, 6)

    println(s"nums: ${nums}")
  }

  def otherMethods: Unit = {
    println("otherMethods called")

    val a = ArrayBuffer(1, 2, 3)         // ArrayBuffer(1, 2, 3)
    println("a:")
    println(a)
    a.append(4)                          // ArrayBuffer(1, 2, 3, 4)
    println(a)
    a.append(5, 6)                       // ArrayBuffer(1, 2, 3, 4, 5, 6)
    println(a)
    a.appendAll(Seq(7,8))                // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8)
    println(a)
    a.clear                              // ArrayBuffer()
    println(a)

    val b = ArrayBuffer(9, 10)           // ArrayBuffer(9, 10)
    println("b:")
    println(b)
    b.insert(0, 8)                       // ArrayBuffer(8, 9, 10)
    println(b)
    b.insertAll(0, Vector(4, 5, 6, 7))   // ArrayBuffer(4, 5, 6, 7, 8, 9, 10)
    println(b)
    b.prepend(3)                         // ArrayBuffer(3, 4, 5, 6, 7, 8, 9, 10)
    println(b)
    b.prepend(1, 2)                      // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(b)
    b.prependAll(Array(0))               // ArrayBuffer(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(b)

    val c = ArrayBuffer.range('a', 'h')  // ArrayBuffer(a, b, c, d, e, f, g)
    println("c:")
    println(c)
    c.remove(0)                          // ArrayBuffer(b, c, d, e, f, g)
    println(c)
    c.remove(2, 3)                       // ArrayBuffer(b, c, g)
    println(c)

    val d = ArrayBuffer.range('a', 'h')  // ArrayBuffer(a, b, c, d, e, f, g)
    println("d:")
    println(d)
    d.trimStart(2)                       // ArrayBuffer(c, d, e, f, g)
    println(d)
    d.trimEnd(2)                         // ArrayBuffer(c, d, e)
    println(d)
  }
  
  simpleExamples
  println()
  otherMethods
}