/*
  https://docs.scala-lang.org/overviews/scala-book/traits-interfaces.html
  
  This code declares a trait named TailWagger that states that any class that
    extends TailWagger should implement startTail and stopTail methods.
  
  Both of those methods take no input parameters and have no return value.
  
  Scala lets you create very modular code with traits.
  For example, you can break down the attributes of animals into small, logical, modular units.
*/
trait Speaker {
    def speak(): String
}

trait TailWagger {
    def startTail(): Unit
    def stopTail(): Unit
}

trait Runner {
    def startRunning(): Unit
    def stopRunning(): Unit
}

/*
  Once you have those small pieces, you can create a Dog class by extending all of them,
    and implementing the necessary methods.

  Notice that you use the extends keyword to create a class that extends a single trait

  Key points of this code:
    - Use extends to extend the first trait
    - Use with to extend subsequent traits
*/
class Dog extends Speaker with TailWagger with Runner {
    // the implemented methods

    // Speaker
    def speak(): String = "Woof!"

    // TailWagger
    def startTail(): Unit = println("tail is wagging")
    def stopTail(): Unit = println("tail is stopped")

    // Runner
    def startRunning(): Unit = println("I'm running")
    def stopRunning(): Unit = println("Stopped running")
}