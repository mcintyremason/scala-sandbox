/*
  https://docs.scala-lang.org/overviews/scala-book/classes-aux-constructors.html
*/

object AuxillaryConstructors extends App {
	val DefaultCrustSize = 12
	val DefaultCrustType = "THIN"
	
	// the primary constructor
	class Pizza (var crustSize: Int, var crustType: String) {
	
		// one-arg auxiliary constructor
		def this(crustSize: Int) {
			this(crustSize, DefaultCrustType)
		}
	
		// one-arg auxiliary constructor
		def this(crustType: String) {
			this(DefaultCrustSize, crustType)
		}
	
		// zero-arg auxiliary constructor
		def this() {
			this(DefaultCrustSize, DefaultCrustType)
		}
	
		override def toString = s"A $crustSize inch pizza with a $crustType crust"
	
	}

	val pizzas = Array(
		new Pizza(DefaultCrustSize, DefaultCrustType),
		new Pizza(DefaultCrustSize),
		new Pizza(DefaultCrustType),
		new Pizza
	)

	for(pizza <- pizzas) println(pizza)
}