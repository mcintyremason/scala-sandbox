// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/masonmcintyre/repos/scala-sandbox/Play/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Thu Mar 05 12:24:53 EST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
