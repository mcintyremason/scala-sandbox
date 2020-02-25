import scala.collection.mutable.ArrayBuffer

/*
	Enumerations are a useful tool for creating small groups of constants,
		things like the days of the week, months in a year, suits in a deck of cards, etc.,
		situations where you have a group of related, constant values.

	As shown, just declare a base trait and then extend that trait with as many case objects as needed.

	Notice how you can put all of the enumerations, a Pizza class,
		and a PizzaTest object in the same file.
	That’s a very convenient Scala feature.
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

class Pizza (
    var crustSize: CrustSize = MediumCrustSize, 
    var crustType: CrustType = RegularCrustType
) {

    // ArrayBuffer is a mutable sequence (list)
    val toppings = ArrayBuffer[Topping]()

    def addTopping(t: Topping): Unit = toppings += t
    def removeTopping(t: Topping): Unit = toppings -= t
    def removeAllToppings(): Unit = toppings.clear()

    override def toString(): String = {
        s"""
        |Crust Size: $crustSize
        |Crust Type: $crustType
        |Toppings:   $toppings
        """.stripMargin
    }
}

// a little "driver" app
object PizzaTest extends App {
   val p = new Pizza
   p.addTopping(Cheese)
   p.addTopping(Pepperoni)
   println(p)
}