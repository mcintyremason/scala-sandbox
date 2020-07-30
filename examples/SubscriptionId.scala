object SubscriptionId extends App {
 val subIdString = "D2C:BAMTECH:urn:dss:disney:orders:e19f4c0a-ee23-42a3-8139-20aa92b10b7d_1999199999999917051999000_disney"

 val splitSubIdString = subIdString.split(":")
 

 println(splitSubIdString.drop(2).mkString(":"))
}