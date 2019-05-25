package ch06.Rational064

/*
带有私有字段和方法： 最大公约数
 */

class Rational(n: Int, d: Int){                // n和d是类参数，这里也是一个主构造器， 而Java类没有参数。
  require(d != 0)                              // 前置条件，参数检查

  // 类中除了方法以外所有可以直接执行的代码，均会根据先后出现次序依次编入主构造器中，所以g先执行。
  private val g = gcd(n.abs, d.abs)
  // 添加numer和denom字段
  val numer: Int = n / g
  val denom: Int = d / g

  // 辅助构造器的第一句必须是this(...)，调用其他构造器，但最终都会调用到该类的主构造器。即主构造器是类的单一入口。
  def this(n: Int) = this(n, 1)

  override def toString = numer + "/" + denom   // 重写java.lang.Object类的toString方法

  def + (that: Rational): Rational =
  // 为了保持Rational的不可变性，不能将传入的that对象直接加在自身， 必须创建一个新的对象返回。
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom
    )

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}


object Rational064{
  def main(args: Array[String]): Unit = {
    val res1 = new Rational(1, 2)
    val res2 = new Rational(3, 4)
    println(res1 + res2)
    println(res1 * res2)
  }
}
