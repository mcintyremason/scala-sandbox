object MakeArrayConsecutive2 extends App {
  // def makeArrayConsecutive2(statues: Array[Int]): Int = {
  //   val largest = statues.reduce((a, b) => a max b)
  //   val smallest = statues.reduce((a, b) => a min b)
  //   var missingStatues = 0
    
  //   for(i <- smallest to largest) {
  //     if (statues.indexOf(i) == -1) {
  //       missingStatues += 1
  //     }
  //   }

  //   missingStatues
  // }

  def makeArrayConsecutive2(statues: Array[Int]): Int = {
    statues.reduce((a, b) => a max b) - statues.reduce((a, b) => a min b) - statues.length + 1
  }

  val statues = Array(6, 2, 3, 8)
  println(makeArrayConsecutive2(statues))
}