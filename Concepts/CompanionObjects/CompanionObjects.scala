/*
  A companion object in Scala is an object that’s declared in the same file as a class,
    and has the same name as the class

  - A companion object is an object that’s declared in the same file as a class, and has the same name as the class
  - A companion object and its class can access each other’s private members
  - A companion object’s apply method lets you create new instances of a class without using the new keyword
  - A companion object’s unapply method lets you de-construct an instance of a class into its individual components

  You rarely need to write an unapply method yourself.
  Instead, what happens is that you get apply and unapply methods for free when you
    create your classes as case classes rather than as the “regular” Scala classes you’ve seen so far. 
*/
class SomeClass {
  def printFilename() = {
    println(SomeClass.HiddenFilename)
  }
}

object SomeClass {
  private val HiddenFilename = "/tmp/foo.bar"
}

/*
  Create new instances without the new keyword

  When you define an apply method in a companion object,
    it has a special meaning to the Scala compiler.
*/
class Person {
  var name: Option[String] = None
  var age: Option[Int] = None
  override def toString = s"$name, $age"
}

/*
  You can create multiple apply methods in a companion object to provide multiple constructors.
  The following code shows how to create both one- and two-argument constructors.

  To be clear, what happens in this process is:
    1. You type something like val p = Person("Fred Flinstone")
    2. The Scala compiler sees that there is no new keyword before Person
    3. The compiler looks for an apply method in the companion object of the Person class that matches the type signature you entered
    4. If it finds an apply method, it uses it; if it doesn’t, you get a compiler error
*/
object Person {
  // a one-arg constructor
  def apply(name: Option[String]): Person = {
    var p = new Person
    p.name = name
    p
  }

  // a two-arg constructor
  def apply(name: Option[String], age: Option[Int]): Person = {
    var p = new Person
    p.name = name
    p.age = age
    p
  }

  /*
	Adding an unapply lets you de-construct object instances.
	
	unapply de-constructs the Person instance it’s given.
	In Scala, when you put an unapply method in a companion object,
    it’s said that you’ve created an extractor method,
    because you’ve created a way to extract the fields out of the object.
  */
  def unapply(p: Person): Tuple2[String, Int] = (p.name.get, p.age.get)
}

object CompanionObjects extends App {
  /*
    During the compilation process the compiler turns the code below into this code
      ex) val p = Person.apply("Fred Flinstone")

    The apply method in the companion object acts as a Factory Method,
      and Scala’s syntactic sugar lets you use the syntax shown,
      creating new class instances without using the new keyword.
  */
  val p = Person(Some("Fred Flinstone"))
  val zenMasters = List(
    Person(Some("Nansen")),
    Person(Some("Joshu"))
  )

  /*
    To test the unapply method manually, first create a new Person instance
  */
  val l = Person(Some("Lori"), Some(29))
  val result = Person.unapply(l)
  println(result)
}