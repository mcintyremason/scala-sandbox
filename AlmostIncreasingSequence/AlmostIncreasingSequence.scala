object AlmostIncreasingSequence extends App {
	def almostIncreasingSequence(sequence: Array[Int]): Boolean = {
    var isValid = true
		var outOfOrderCount = 0
    var previousElement:Option[Int] = None
    var previousElementIndex:Option[Int] = None
    var sequenceBuffer = sequence.toBuffer
    val maxValue = sequenceBuffer.reduce((a, b) => a max b)

    if(sequenceBuffer.diff(sequenceBuffer.distinct).length > 1) {
      isValid = false
    } else {
      sequenceBuffer.zipWithIndex.map { case (element, index) => 
        if (!previousElement.isEmpty) {
          println(s"Element: ${element}, Previous Element: ${previousElement.get}")
          println(1)

          if (element <= previousElement.get) {
            if (outOfOrderCount < 1) {
               if(previousElement.get == maxValue) {
                // println(s"Element: ${element}, Previous Element: ${previousElement.get}")

                sequenceBuffer.remove(previousElementIndex.get)
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
          if (((sequenceBuffer.length - 1) - sequenceBuffer.indexOf(maxValue)) > 1) {
            sequenceBuffer.remove(sequenceBuffer.indexOf(maxValue))
            outOfOrderCount += 1
          }

          if (element != maxValue) {
            previousElement = Some(element)
            previousElementIndex = Some(index)
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
  val sequence = Array(10, 1, 2, 3, 4, 5)
	println(almostIncreasingSequence(sequence))
}