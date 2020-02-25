/*
  https://docs.scala-lang.org/overviews/scala-book/traits-abstract-mixins.html

  You can also add real, working methods to triats and use them like abstract classes,
    or more accurately, as mixins.
*/
trait Pet {
  // concrete implementation of a speak method
  def speak = println("Yo")
  // abstract
  def comeToMaster(): Unit
}

/*
  When a class extends a trait, each defined method must be implemented,
    so here’s a class that extends Pet and defines comeToMaster.
*/
class Dog(name: String) extends Pet {
    def comeToMaster(): Unit = println("Woo-hoo, I'm coming!")
    override def toString = s"${name} the dog!"
}

/*
  A class can also override a method that’s defined in a trait.
*/
class Cat(name: String) extends Pet {
    // override 'speak'
    override def speak(): Unit = println("meow")
    def comeToMaster(): Unit = println("That's not gonna happen.")
    override def toString = s"${name} the cat!"
}

object TraitsAsAbstractClasses extends App {
  val dog = new Dog("Luna")
  val cat = new Cat("Charlie")

  println(dog.toString())
  dog.speak
  dog.comeToMaster()
  println()
  println(cat.toString())
  cat.speak
  cat.comeToMaster()
}