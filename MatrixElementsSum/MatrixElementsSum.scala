object MatrixElementsSum extends App {
  def matrixElementsSum(matrix: Array[Array[Int]]): Int = {
    val free = 0
    var prevRooms = Array[Int]()

    matrix.zipWithIndex.map { case (element, index) => 
      // println(matrix(index)(index))
      matrix(index).zipWithIndex.map { case (element, index) => 
        // println(element)

        println(prevRooms(index) == null)

        // if(prevRooms(index))
      }
    }

    0
  }

  val matrix = Array(
    Array(0, 1, 1, 2),
    Array(0, 5, 0, 0),
    Array(2, 0, 3, 3)
  )
  
  matrixElementsSum(matrix)
}