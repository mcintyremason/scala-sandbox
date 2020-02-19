object ShapeArea extends App {
  def shapeArea(n: Int): Int = {
    val width = (n + (n - 1))
    var sideArea = 0

    if (width == 1) {
      width
    } else {
      for (i <- width - 2 to 0 by -2) {
        sideArea += i
      }
      
      ((sideArea * 2) + width)
    }
  }

  println(shapeArea(4))
}