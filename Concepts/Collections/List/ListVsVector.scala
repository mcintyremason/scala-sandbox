object ListVsVector extends App {
  def time[R](block: => R): R = {
      val t0 = System.nanoTime()
      val result = block    // call-by-name
      val t1 = System.nanoTime()
      println("Elapsed time: " + (t1 - t0) + "ns\n")
      result
  }

  val list = List.range(0, 1000)
  val vector = Vector.range(0, 1000)
  val indexedSeq = IndexedSeq.range(0, 1000)

//   println(s"list: ${list}")
//   println(s"vector: ${vector}")
  println(s"list(1): ${list(1)}")
  time { list(1) }
  println(s"vector(1): ${vector(1)}")
  time { vector(1) }
  println(s"indexedSeq(1): ${indexedSeq(1)}")
  time { indexedSeq(1) }

  println("\n")

  println(s"list(999): ${list(999)}")
  time { list(999) }
  println(s"vector(999): ${vector(999)}")
  time { vector(999) }
  println(s"indexedSeq(999): ${indexedSeq(999)}")
  time { indexedSeq(999) }
}
