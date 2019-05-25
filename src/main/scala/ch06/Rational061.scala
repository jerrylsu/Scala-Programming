package ch06.Rational061

/*
带有字段的Rational
*/

class Rational(n: Int, d: Int){                // n和d是类参数，这里也是一个主构造器， 而Java类没有参数。
  require(d != 0)                              // 前置条件，参数检查
  // 添加numer和denom字段
  val numer: Int = n
  val denom: Int = d

  override def toString = numer + "/" + denom   // 重写java.lang.Object类的toString方法

  def add(that: Rational): Rational =
    // 为了保持Rational的不可变性，不能将传入的that对象直接加在自身， 必须创建一个新的对象返回。
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom
    )

  def lessThan(that: Rational): Boolean =
    // 自引用，this指向调用当前方法的对象。当被用在构造方法里时，指向被构造的对象实例。 this可省略。
    this.numer * that.denom < this.denom * that.numer

  def max(that: Rational): Rational =
    if (this.lessThan(that)) that else this

}

object Rational061 {
  def main(args: Array[String]): Unit = {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)

    println(f"oneHalf: $oneHalf")
    println(f"twoThirds: $twoThirds")
    println(f"oneHalf.lessThan(twoThirds): ${oneHalf.lessThan(twoThirds)}")
    println(f"oneHalf.max(twoThirds): ${oneHalf.max(twoThirds)}")
  }
}
