object CenturyInYear {
  def main(args: Array[String]) = {
    println(centuryInYear(1700))
  }

  def centuryInYear(year: Int): Int = {
    var count = 1
    for(i <- 1 to year by 100) yield count += 1
    count
  }
}
