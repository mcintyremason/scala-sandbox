object CheckPalindrome {
  def main(args: Array[String]) = {
    println(checkPalindrome("abbc"))
  }

  def checkPalindrome(inputString: String): Boolean = {
      val length = inputString.length() - 1;
      var isPalindrome = true

      inputString.zipWithIndex.map { case (element, index) => 
        if (element != inputString.charAt(length - index))
          isPalindrome = false
      }

      isPalindrome
  }
}
