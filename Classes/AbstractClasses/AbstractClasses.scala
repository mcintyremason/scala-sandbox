/*
  https://docs.scala-lang.org/overviews/scala-book/abstract-classes.html

  Scala also has a concept of an abstract class that is similar to Java’s abstract class.
  But because traits are so powerful, you rarely need to use an abstract class.
  In fact, you only need to use an abstract class when:
    - You want to create a base class that requires constructor arguments
    - Your Scala code will be called from Java code

  Regarding the first reason, Scala traits don’t allow constructor parameters.
  Therefore, you need to use an abstract class whenever a base behavior must have constructor parameters.
*/
abstract class Pet (name: String) {
  // concrete implementation
  def speak(): Unit = println("Yo")
  // abstract method
  def comeToMaster(): Unit
}

/*
  Given that abstract Pet class, you can define a Dog class like this..
  One thing to notice is how the name constructor parameter
    is passed from the Dog class constructor to the Pet constructor:
*/
class Dog(name: String) extends Pet(name) {
    override def speak() = println(s"My name is $name")
    def comeToMaster() = println("Here I come!")
}

object AbstractClasses extends App {
  val dog = new Dog("Fido")
  dog.speak
}
