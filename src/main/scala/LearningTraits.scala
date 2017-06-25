import scala.collection.mutable.ArrayBuffer

/**
  * Created by davischan on 25/6/2017.
  */


object LearningTraits {
  def main(args: Array[String]): Unit = {
    trait HairColor

    val iterator = new IntIterator(10)
    println(iterator.next())
    println(iterator.next())

    val dog = new Dog("Harry")
    val cat = new Cat("Sally")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name))
  }

  trait Iterator[A] {
    def hasNext: Boolean
    def next(): A
  }

  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0
    override def hasNext: Boolean = current < to
    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }

  trait Pet {
    val name: String
  }

  class Cat(val name: String) extends Pet
  class Dog(val name: String) extends Pet
}
