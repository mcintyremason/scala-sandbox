import scala.collection.mutable.ListBuffer

object AllLongestStrings extends App {
  def allLongestStrings(inputArray: Array[String]): Array[String] = {
    var longestStrings = new ListBuffer[String]()
    var longestStringLength = 0

    for (string <- inputArray) {
      if (string.length() > longestStringLength) {
        if (longestStrings.isEmpty) {
          longestStringLength = string.length()
          longestStrings += string
        } else {
          longestStrings.clear()
          longestStringLength = string.length()
          longestStrings += string
        }
      } else if (string.length() == longestStringLength) {
        longestStrings += string
      }
    }

    longestStrings.toArray
  }

  val inputArray = Array("aba", "aa", "ad", "vcd", "aba")

  println(allLongestStrings(inputArray))
}