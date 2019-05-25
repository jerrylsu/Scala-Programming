package ch06.Rational062

/*
辅助构造器
 */

class Rational(n: Int, d: Int){                // n和d是类参数，这里也是一个主构造器， 而Java类没有参数。
  require(d != 0)                              // 前置条件，参数检查
  // 添加numer和denom字段
  val numer: Int = n
  val denom: Int = d

  // 辅助构造器的第一句必须是this(...)，调用其他构造器，但最终都会调用到该类的主构造器。即主构造器是类的单一入口。
  def this(n: Int) = this(n, 1)

  override def toString = numer + "/" + denom   // 重写java.lang.Object类的toString方法

  def add(that: Rational): Rational =
  // 为了保持Rational的不可变性，不能将传入的that对象直接加在自身， 必须创建一个新的对象返回。
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom
    )
}


object  Rational062{
  def main(args: Array[String]): Unit = {
    val res = new Rational(2)
    println(res)
  }
}
