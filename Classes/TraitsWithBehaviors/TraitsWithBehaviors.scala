/*
  A great thing about Scala traits is that you can mix multiple traits that have behaviors into classes.
  For example, here’s a combination of traits, one of which defines an abstract method,
    and the others that define concrete method implementations:
*/

trait Speaker {
  //abstract
  def speak(): String
}

trait TailWagger {
  def startTail(): Unit = println("tail is wagging")
  def stopTail(): Unit = println("tail is stopped")
}

trait Runner {
  def startRunning(): Unit = println("I'm running")
  def stopRunning(): Unit = println("Stopped running")
}

/*
  Now you can create a Dog class that extends all of those traits while providing behavior for the speak method:
*/
class Dog(name: String) extends Speaker with TailWagger with Runner {
    def speak(): String = "Woof!"
}

/*
  And here’s a Cat class:
*/
class Cat extends Speaker with TailWagger with Runner {
    def speak(): String = "Meow"
    override def startRunning(): Unit = println("Yeah ... I don't run")
    override def stopRunning(): Unit = println("No need to stop")
}

class Horse(name: String)

object TraitsWithBehaviors extends App {
  val dog = new Dog("Luna")
  val cat = new Cat

  dog.speak
  dog.startRunning()
  dog.stopRunning()
  
  println()
  cat.speak
  cat.startRunning()
  cat.stopRunning()

  /*
    As a last note, a very interesting thing you can do with traits
      that have concrete methods is mix them into classes on the fly.

    This example works because all of the methods in the TailWagger and Runner
      traits are defined (they’re not abstract).
  */
  val horse = new Horse("Spirit") with TailWagger with Runner
  println()
  horse.startTail()
  horse.startRunning()
}