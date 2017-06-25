/**
  * Created by Davis on 25-Jun-17.
  */
object CompositionWithMixins {
  def main(args: Array[String]): Unit = {
    val d = new D
    println(d.message)
    println(d.loudMessage)

    val iter = new Iter("This is a test")
    iter foreach(println)
  }

  abstract class A {
    val message: String
  }
  class B extends A {
    override val message: String = "I'm an instance of class B"
  }
  trait C extends A {
    def loudMessage = message.toUpperCase
  }
  class D extends B with C

  abstract class AbsIterator {
    type T
    def hasNext: Boolean
    def next: T
  }
  class StringIterator(s: String) extends AbsIterator {
    override type T = Char
    private var i = 0
    override def hasNext: Boolean = i < s.length

    override def next = {
      val ch = s charAt(i)
      i += 1
      ch
    }
  }
  trait RichIterator extends AbsIterator {
    def foreach(f: T => Unit): Unit = while (hasNext) f(next)
  }
  class Iter (s: String) extends StringIterator(s) with RichIterator
}
