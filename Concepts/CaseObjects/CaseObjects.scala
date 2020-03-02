/*
  https://docs.scala-lang.org/overviews/scala-book/case-objects.html
  
  Before we jump into case objects, we should provide a little background on “regular” Scala objects.
  As we mentioned early in this book, you use a Scala object when you want to create a singleton object.
  As the documentation states,
    “Methods and values that aren’t associated with individual instances of a class belong in singleton objects,
    denoted by using the keyword object instead of class.”
*/
/*
  "regular" object example:
*/
import java.io._
import scala.util.{Try}

object FileUtils {
  def readTextFileAsString(filename: String): Try[String] = ???
  def copyFile(srcFile: File, destFile: File): Try[Boolean] = ???
  def readFileToByteArray(file: File): Try[Array[Byte]] = ???
  def readFileToString(file: File): Try[String] = ???
  def readFileToString(file: File, encoding: String): Try[String] = ???
  def readLines(file: File, encoding: String): Try[List[String]] = ???
}

/*
  Case objects

  A case object is like an object, but just like a case class has more features than a regular class,
    a case object has more features than a regular object.
  
  Its features include:
    - It’s serializable
    - It has a default hashCode implementation
    - It has an improved toString implementation

  Because of these features, case objects are primarily used in two places (instead of regular objects):
    - When creating enumerations
    - When creating containers for “messages” that you want to pass between other objects
      (such as with the Akka actors library)
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

case class Pizza (
  crustSize: CrustSize,
  crustType: CrustType,
  toppings: Seq[Topping]
)

/*
  Using case objects as messages

  Another place where case objects come in handy is when you want to model the concept of a “message.”
  For example, imagine that you’re writing an application like Amazon’s Alexa,
    and you want to be able to pass around “speak” messages like,
      - “speak the enclosed text”
      - “stop speaking”
      - “pause”
      - “resume”
  In Scala you create singleton objects for those messages like this:
*/
/*
  Notice that StartSpeakingMessage is defined as a case class rather than a case object.
  This is because a case object can’t have any constructor parameters.
*/
case class StartSpeakingMessage(textToSpeak: String)
case object StopSpeakingMessage
case object PauseSpeakingMessage
case object ResumeSpeakingMessage

/*
  Given those messages, if Alexa was written using the Akka library, you’d find code like this in a “speak” class:
  class Speak extends Actor {
    def receive = {
      case StartSpeakingMessage(textToSpeak) =>
        // code to speak the text
      case StopSpeakingMessage =>
        // code to stop speaking
      case PauseSpeakingMessage =>
        // code to pause speaking
      case ResumeSpeakingMessage =>
        // code to resume speaking
    }
  }
*/
