object FPExamples extends App {
  println(List("foo", "bar").map(_.toUpperCase))
  println(List("foo", "bar").map(_.capitalize))
  println(List("adam", "scott").map(_.length))
  println(List(1,2,3,4,5).map(_ * 10))
  println(List(1,2,3,4,5).filter(_ > 2))
  println(List(5,1,3,11,7).takeWhile(_ < 6))
}