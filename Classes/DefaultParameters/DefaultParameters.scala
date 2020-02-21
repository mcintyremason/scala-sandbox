object DefaultParameters extends App {
	class Socket(var timeout: Int = 2000, var linger: Int = 3000) {
		override def toString = s"timeout: $timeout, linger: $linger"
	}

	val sockets = Array(
		new Socket(),
		new Socket(1000),
		new Socket(4000, 6000)
	)

	for(socket <- sockets) println(socket)
}