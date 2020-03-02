/*
  A case class has all of the functionality of a regular class, and more.

  When the compiler sees the case keyword in front of a class, it generates code for you, with the following benefits:
    - Case class constructor parameters are public val fields by default,
      so accessor methods are generated for each parameter.
    - An apply method is created in the companion object of the class,
      so you don’t need to use the new keyword to create a new instance of the class.
    - An unapply method is generated, which lets you use case classes in more ways in match expressions.
    - A copy method is generated in the class.
      You may not use this feature in Scala/OOP code, but it’s used all the time in Scala/FP.
    - equals and hashCode methods are generated,
      which let you compare objects and easily use them as keys in maps.
    - A default toString method is generated, which is helpful for debugging.
*/
object CaseClasses extends App {
  /*
    unapply method

    A great thing about case classes is that they automatically generate an unapply method, so you don’t have to write one.
    To demonstrate this, imagine that you have this trait:
  */
  trait Human {
    def name: String
  }

  /*
    Then, create these case classes to extend that trait:
  */
  case class Student(name: String, year: Int) extends Human
  case class Teacher(name: String, specialty: String) extends Human

  /*
    Because those are defined as case classes
      — and a case class has a built-in unapply method
      — you can write a match expression like this:
  */
  def getPrintableString(p: Human): String = p match {
    case Student(name, year) =>
      s"$name is a student in Year $year."
    case Teacher(name, whatTheyTeach) =>
      s"$name teaches $whatTheyTeach."
  }

  val s = Student("Al", 1)
  val t = Teacher("Bob Donnan", "Mathematics")

  println("unapply:")
  println(getPrintableString(s))
  println(getPrintableString(t))

  /*
    copy method

    A case class also has an automatically-generated copy method
      that’s extremely helpful when you need to perform the process of
      1) cloning an object 
      2) updating one or more of the fields during the cloning process
    
    As shown, when you use the copy method,
      all you have to do is supply the names of the fields you want to modify during the cloning process.
    Because you never mutate data structures in FP,
      this is how you create a new instance of a class from an existing instance.
    This process can be referred to as, “update as you copy.”
  */
  case class BaseballTeam(name: String, lastWorldSeriesWin: Int)
  val cubs1908 = BaseballTeam("Chicago Cubs", 1908)
  val cubs2016 = cubs1908.copy(lastWorldSeriesWin = 2016)
  println("\ncopy:")
  println(cubs1908)
  println(cubs2016)

  /*
    equals and hashCode methods
    
    Case classes also have automatically-generated equals and hashCode methods, so instances can be compared:
  */
  case class Person(name: String, relation: String)
  val christina = Person("Christina", "niece")
  val hannah = Person("Hannah", "niece")
  println("\nequals and hashCode:")
  println(christina == hannah)

  /*
    toString methods
    
    Finally, case classes also have a good default toString method implementation,
      which at the very least is helpful when debugging code:
  */
  println("\ntoString:")
  println(christina)
}