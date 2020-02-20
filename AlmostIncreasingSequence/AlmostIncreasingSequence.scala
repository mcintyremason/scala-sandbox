object AlmostIncreasingSequence extends App {
	def almostIncreasingSequence(sequence: Array[Int]): Boolean = {
    var isValid = true
		var outOfOrderCount = 0
    var previousElement:Option[Int] = None
    var previousElementIndex:Option[Int] = None
    var previousPreviousElement: Option[Int] = None
    var sequenceBuffer = sequence.toBuffer
    val maxValue = sequenceBuffer.reduce((a, b) => a max b)
    val minValue = sequenceBuffer.reduce((a, b) => a min b)

    if(sequenceBuffer.diff(sequenceBuffer.distinct).length > 1) {
      isValid = false
    } else {
      sequenceBuffer.zipWithIndex.map { case (element, index) => 
        if (!previousElement.isEmpty) {
          if (element <= previousElement.get) {
            if (outOfOrderCount < 1) {
              if(minValue == element) {
                sequenceBuffer.remove(index)
                outOfOrderCount += 1
              } else if (previousElement.get == maxValue) {
                if(element <= sequenceBuffer(previousElementIndex.get - 1)) {
                  isValid = false
                } else {
                  sequenceBuffer.remove(previousElementIndex.get)
                }
                previousElement = Some(element)
                previousElementIndex = Some(index)
              } else {
                sequenceBuffer.remove(index)
              }
              outOfOrderCount += 1
            } else {
              isValid = false
            }
          } else {
            previousElement = Some(element)
            previousElementIndex = Some(index)
          }
        } else {
          if (element != maxValue) {
            previousElement = Some(element)
            previousElementIndex = Some(index)
          } else {
            outOfOrderCount += 1
          }
        }
      }
    }

    isValid
	}

	// val sequence = Array(1, 2, 5, 3, 6)
	// val sequence = Array(1, 2, 5, 3, 6, 1)
  // val sequence = Array(1, 2, 1, 2, 2)
  // val sequence = Array(1, 2, 3, 4, 99, 5, 6)
  // val sequence = Array(40, 50, 60, 10, 20, 30)
  // val sequence = Array(10, 1, 2, 3, 4, 5)
  val sequence = Array(3, 5, 67, 98, 3)
	println(almostIncreasingSequence(sequence))
}