object AdjacentElementsProduct {
  def main(args: Array[String]) = {
    println(adjacentElementsProduct(Array(1, 2, 3, 4, 5)))
    // println(adjacentElementsProduct(Array(-23, 4, -3, 8, -12)))
  }

  def adjacentElementsProduct(inputArray: Array[Int]): Int = {
    var largestProduct:Option[Int] = None;
    var lastElement:Option[Int] = None

    inputArray.foreach { x =>
      if (largestProduct.isEmpty && !lastElement.isEmpty) {
        largestProduct = Some(lastElement.get * x)
      } else if (!lastElement.isEmpty && (x * lastElement.get > largestProduct.get)) {
        largestProduct = Some(x * lastElement.get)
      }
      
      lastElement = Some(x)
    }

    largestProduct.get
  }
}
