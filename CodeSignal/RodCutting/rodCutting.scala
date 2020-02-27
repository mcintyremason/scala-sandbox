import scala.collection.mutable
object rodCutting extends App {
	def rodCutting(n: Int, v: Array[Int]): Int = {
    var revenue: Int = 0
    var values =  Seq[Int]()

    def calcRevenue(revenue: Int, length: Int, v: Array[Int]): Int = {
      var maxRev = revenue

      if (revenue < v(length)) {
        maxRev = v(length)
      } else if (revenue < (revenue + v(length))) {
        maxRev = (revenue + v(length))
      }

      maxRev
    }

    def checkRemainder(revenue: Int, currLength: Int, lengthLeft: Int, v: Array[Int]): Int = {
      var maxRev: Int = revenue
      var length = currLength
      val limit = (n - currLength)

      if (lengthLeft <= 0) {
        maxRev
      } else if (lengthLeft - length >= 0 && length != 0) {
        checkRemainder(calcRevenue(maxRev, currLength, v), length, lengthLeft - length, v)
      } else if (lengthLeft - length < 0) {
        checkRemainder(maxRev, 0, lengthLeft, v)
      } else if (lengthLeft > 0) {
        checkRemainder(calcRevenue(maxRev, currLength, v), length + 1, lengthLeft - length, v)
      } else {
        maxRev
      }
    }

    for(startLength <- n to 0 by -1) {
      values = values :+ checkRemainder(revenue, startLength, n, v)
      revenue = 0
    }

    values.max
  }
  
  val n = 4
  // val v = Array(0, 2, 4, 7, 7)
  val v = Array(0, 0, 4, 7, 1)

  println(rodCutting(n, v))
}