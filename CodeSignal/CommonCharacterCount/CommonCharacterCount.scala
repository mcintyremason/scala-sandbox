import scala.collection.mutable.Set

object CommonCharacterCount extends App {
  def commonCharacterCount(s1: String, s2: String): Int = {
    var longestString = ""
    var shortestString = ""
    val countedChars = Set[Char]()
    var commonCharCount = 0

    if (s1.length > s2.length) {
      shortestString = s2
      longestString = s1
    } else {
      shortestString = s1
      longestString = s2
    }

    for (i <- 0 to (longestString.length - 1)) {
      if (shortestString.contains(longestString(i))) {
        if (countedChars.add(longestString(i))) {
          commonCharCount += 1
        }
      }
    }

    for (i <- 2 to shortestString.length) {
      println(shortestString.substring(0, i))
      if (longestString.contains(shortestString.substring(0, i))) {
        for(j <- 0 to countedChars.length) {
          if (!shortestString.substring(0, i).contains(countedChars(i))) {
            commonCharCount += 1
          }
        }
      }
    }

    commonCharCount
  }

  val s1 = "aabcc"
  val s2 = "adcaa"

  // val s1 = "abcdefghxyzttw"
  // val s2= "hgfedcbaabcwwt"

  println(commonCharacterCount(s1, s2))
}