/**
  * Created by davischan on 25/6/2017.
  */
object UnifiedTypes {
  def main(args: Array[String]): Unit = {

    // Value types can be cast in the following way
    val b: Byte = 1
    val s: Short = b
    val i: Int = s
    val c: Char = 'a'
    val anotherI: Int = c
    val l:Long = i
    val f:Float = l
    val d:Double = f
    println(d)
  }
}
