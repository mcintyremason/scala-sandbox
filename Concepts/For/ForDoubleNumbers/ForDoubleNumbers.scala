object ForDoubleNumbers extends App {

	val nums = Seq(1,2,3)
	val doubledNums = for (n <- nums) yield n * 2
	
	println(doubledNums)

}