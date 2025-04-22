package com.mong.clazz


sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

fun eval(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
    }


fun main() {
    val num1 = Num(3)
    val num2 = Num(2)
    val sum = Sum(num1, num2)

    println("${eval(sum)}")
}
