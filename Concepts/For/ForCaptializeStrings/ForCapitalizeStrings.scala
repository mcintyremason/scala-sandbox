object ForCapitalizeStrings extends App {
	
	val names = List("adam", "david", "frank")
	val ucNames = for (name <- names) yield name.capitalize

	for(name <- ucNames) println(name)

}