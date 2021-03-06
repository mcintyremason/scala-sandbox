/*
  https://docs.scala-lang.org/overviews/scala-book/oop-pizza-example.html
  
  The example shows code you might write for an order-entry system for a pizza store.
*/

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onions extends Topping

sealed trait CrustSize
case object SmallCrustSize extends CrustSize
case object MediumCrustSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType extends CrustType
case object ThickCrustType extends CrustType

/*
  Given those enumerations, you can now start to create a few pizza-related classes for an order-entry system.

  For the most part an OOP Pizza class needs a few methods to add and remove toppings,
    and adjust the crust size and type

  Note that this is a perfectly legal method.
  The ??? syntax is often used as a teaching tool,
    and sometimes you use it as a method-sketching tool to say,
    “This is what my method signature looks like, but I don’t want to write the method body yet.”
  A great thing for those times is that this code compiles.
*/
import scala.collection.mutable.ArrayBuffer

class Pizza (
  var crustSize: CrustSize,
  var crustType: CrustType,
  val toppings: ArrayBuffer[Topping]
) {
  def addTopping(t: Topping): Unit = toppings += t
  def removeTopping(t: Topping): Unit = toppings -= t
  def removeAllToppings(): Unit = toppings.clear()
  def getPrice(
    toppingsPrices: Map[Topping, Int],
    crustSizePrices: Map[CrustSize, Int],
    crustTypePrices: Map[CrustType, Int]
  ): Int = ???
}

/*
  An Order class, where an Order consists of a mutable list of pizzas and a Customer.
*/
class Order (
  var pizzas: ArrayBuffer[Pizza],
  var customer: Customer
) {
	def addPizza(p: Pizza): Unit = pizzas += p
  def removePizza(p: Pizza): Unit = pizzas -= p

  // need to implement these
  def getBasePrice(): Int = ???
  def getTaxes(): Int = ???
	def getTotalPrice(): Int = ???
	def printOrder(): Unit = {
    println(s"Name: ${customer.name}")
    println(s"Phone Number: ${customer.phone}")
    println()

		for (pizza <- pizzas) {
			println(s"crustSize: ${pizza.crustSize}")
      println(s"crustType: ${pizza.crustType}")
      println("Toppings:")
      for (topping <- pizza.toppings) println(topping)
      println()
		}
	}
}

class Customer (
  var name: String,
  var phone: String,
  var address: Address
)

class Address (
  var street1: String,
  var street2: String,
  var city: String,
  var state: String,
  var zipCode: String
)

object OOPPizzaExample extends App {
  val p1 = new Pizza (
    MediumCrustSize,
    ThinCrustType,
    ArrayBuffer(Cheese)
  )

  val p2 = new Pizza (
    LargeCrustSize,
    ThinCrustType,
    ArrayBuffer(Cheese, Pepperoni, Sausage)
  )

  val address = new Address (
    "123 Main Street",
    "Apt. 1",
    "Talkeetna",
    "Alaska",
    "99676"
  )

  val customer = new Customer (
    "Alvin Alexander",
    "907-555-1212",
    address
  )

  val order = new Order(
    ArrayBuffer(p1, p2),
    customer
  )

  order.addPizza(
    new Pizza (
      SmallCrustSize,
      ThinCrustType,
      ArrayBuffer(Cheese, Mushrooms)
    )
  )

  // print the order
  order.printOrder

}
