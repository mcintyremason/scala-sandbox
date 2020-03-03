object MinimumOnStack extends App {
	def minimumOnStack(operations: Array[String]): Array[Int] = {
    var stack = Array[Int]()
    val minStack = Array[Int]()

    for (op <- operations) {
      op.split(' ')(0) match {
        case "push" => stack = op.split(' ')(1).toInt +: stack
        case "pop" => stack = stack.tail
        case "min" => minStack = minStack :+ stack.min
      }
    }

    minStack.toArray
  }

  def codeSignalMinimumOnStack(operations: Array[String]): Array[Int] = {
    var s=Array[Int]()
    var m=Array[Int]()
    for(o<-operations){
      o.split(' ')(0)match{
        case"push"=>s=o.split(' ')(1).toInt+:s
        case"pop"=>s=s.tail
        case"min"=>m=m:+s.min
      }
    }
    m.toArray
  }

  val operations = Array("push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min")
  
  minimumOnStack(operations).foreach(println)
  // codeSignalMinimumOnStack(operations).foreach(println)
}