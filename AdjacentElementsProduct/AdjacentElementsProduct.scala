object AdjacentElementsProduct {
  def main(args: Array[String]) = {
    println(adjacentElementsProduct(Array(1, 2, 3, 4, 5)))
  }

  def adjacentElementsProduct(inputArray: Array[Int]): Int = {
    var largestProduct = 0;

    inputArray.foreach { x =>
      println(x)
    }

    largestProduct
  }
}
