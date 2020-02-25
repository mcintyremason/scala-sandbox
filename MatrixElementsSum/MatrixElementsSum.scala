object MatrixElementsSum extends App {
  def matrixElementsSum(matrix: Array[Array[Int]]): Int = {
    val numberOfFloors = matrix(0).length
    var totalCost = 0
    var isRoomSafe = Array.fill[Boolean](numberOfFloors)(true)

    for (floorIndex <- 0 to matrix.length - 1) {
      for (roomIndex <- 0 to matrix(floorIndex).length - 1) {
        if (floorIndex > 0) {
          if (matrix(floorIndex-1)(roomIndex) != 0) {
            if (matrix(floorIndex)(roomIndex) != 0 && isRoomSafe(roomIndex)) {
              totalCost += matrix(floorIndex)(roomIndex)
            } else {
              isRoomSafe(roomIndex) = false
            }
          } else {
            isRoomSafe(roomIndex) = false
          }
        } else {
          if (matrix(floorIndex)(roomIndex) != 0 && isRoomSafe(roomIndex)) {
            totalCost += matrix(floorIndex)(roomIndex)
          } else {
            isRoomSafe(roomIndex) = false
          }
        }
      }
    }
    
    totalCost
  }

  // val matrix = Array(
  //   Array(0, 1, 1, 2),
  //   Array(0, 5, 0, 0),
  //   Array(2, 0, 3, 3)
  // )

  val matrix = Array(
    Array(1, 1, 1, 0),
    Array(0, 5, 0, 1),
    Array(2, 1, 3, 10)
  )
  
  println(matrixElementsSum(matrix))
}