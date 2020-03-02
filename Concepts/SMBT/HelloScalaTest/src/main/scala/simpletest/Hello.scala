package simpletest

object Hello extends App {
    val p = new Person("Mason McIntyre")
    println(s"Hello ${p.name}")
}

class Person(var name: String)