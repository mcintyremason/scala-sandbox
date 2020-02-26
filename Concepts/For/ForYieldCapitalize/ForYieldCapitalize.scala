object ForYieldCapitalize extends App {
	val names = List("_adam", "_david", "_frank")

	// val capNames = for (name <- names) yield {
    // 	val nameWithoutUnderscore = name.drop(1)
    // 	val capName = nameWithoutUnderscore.capitalize
	// 	capName
	// }

	val capNames = for (name <- names) yield { name.drop(1).capitalize }

	println(capNames)
}