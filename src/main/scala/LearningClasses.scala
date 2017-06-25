/**
  * Created by davischan on 25/6/2017.
  */
object LearningClasses {
  def main(args: Array[String]): Unit = {
    class User
    val user1 = new User

    class Point(var x:Int, var y: Int) {
      def move(dx: Int, dy: Int): Unit = {
        x = x + dx
        y = y + dy
      }

      override def toString: String =
        s"($x, $y)"
    }

    val point1 = new Point(2, 3)
    println(point1.x)
    println(point1)

    // Constructors
    {
      class Point {
        private var _x = 0
        private var _y = 0
        private val bound = 100

        def x =_x
        def x_= (newValue: Int): Unit = {
          if (newValue < bound) _x = newValue else printWarning
        }

        def y =_y
        def y_= (newValue: Int): Unit = {
          if (newValue < bound) _y = newValue else printWarning
        }

        private def printWarning = println(("WARNING: Out of bounds"))
      }

      val point1 = new Point
      point1.x = 99
      point1.y = 101
    }

    // constructor parameters can be values
//    class Point(val x: Int, val y: Int)
//    val point = new Point(1, 2)
//    point.x = 3 // <-- does not complie

    // parameters without val and var are private values
  }
}
