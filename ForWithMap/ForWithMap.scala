object ForWithMap extends App {

	val ratings = Map(
		"Star Wars - A New Hope" -> 4.8,
		"1917" -> 4.2,
		"Snakes on a Plane" -> 2.0
	)

	// for example
	for((name, rating) <- ratings) println(s"Movie: $name, Rating: $rating")

	// foreach example
	// ratings.foreach {
	// 	case(movie, rating) => println(s"key: $movie, value: $rating")
	// }
}