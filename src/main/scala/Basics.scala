/**
  * Created by davischan on 25/6/2017.
  */
object Basics {
  def main(args: Array[String]): Unit = {
    // Values
    val x = 1 + 1
    println("Values: " + x)

    // Variables
    var y = 1 + 2
    println("Variables: " + y)

    // Blocks
    println("Blocks: " +
      {
        val x = 1 + 1
        x + 1
      }
    )

    // Functions
    // Anonymous functions
    //(x: Int) => x + 1

    // Named functions
    val addOne = (x: Int) => x + 1
    println("Named functions: " + addOne(1))

    // Methods
    def add(x: Int, y: Int): Int = x + y
    println("Methods: " + add(1, 2))

    // Multiple parameter lists methods
    def addThenMultiply(x: Int, y: Int)(z: Int): Int = (x + y) * z
    println("Multiple parameter lists methods: " + addThenMultiply(1, 2)(3))

    // Classes
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit =
        println(prefix + name + suffix)
    }
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Scala developer")

    // Case Classes
    case class Point(x: Int, y: Int){}
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)

    // case Classes are compared by value
    if (point ==  anotherPoint) {
      println(point + " and " + anotherPoint + " are the same")
    }

    if (point != yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are different")
    }

    // Objects
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }
    val newId: Int = IdFactory.create()
    println(newId)
    val newerId = IdFactory.create()
    println(newerId)

    // Traits
    {
      trait Greeter {
        def greet(name: String): Unit
      }
    }
    {
      trait Greeter {
        def greet(name: String): Unit =
          println("hello, " + name + "!")
      }
      class DefaultGreeter extends Greeter
      class CustomizableGreeter(prefix: String, postfix: String) extends Greeter{
        override def greet(name: String): Unit = {
          println(prefix + name + postfix)
        }
      }

      val greeter = new DefaultGreeter
      greeter.greet("Scala developer")

      val customGreeter = new CustomizableGreeter("How are you, ", "?")
      customGreeter.greet("Scala developer")
    }
  }
}
