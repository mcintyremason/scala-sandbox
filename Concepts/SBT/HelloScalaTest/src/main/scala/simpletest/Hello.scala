/*
  https://docs.scala-lang.org/overviews/scala-book/scala-build-tool-sbt.html
*/

package simpletest

object Hello extends App {
    val p = new Person("Mason McIntyre")
    println(s"Hello ${p.name}")
}

class Person(var name: String)