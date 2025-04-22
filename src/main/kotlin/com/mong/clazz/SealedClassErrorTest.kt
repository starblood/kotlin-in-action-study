package com.mong.clazz

sealed class Expr1
class Num1(val value: Int) : Expr1()
class Sum1(val left: Expr1, val right: Expr1) : Expr1()
class Mul1(val left: Expr1, val right: Expr1): Expr1()

/*
fun eval(e: Expr): Int =
   when (e) {
       is Num -> e.value
       is Sum -> eval(e.right) + eval(e.left)
       // ERROR: 'when’ expression must be exhaustive,
       // add necessary 'is Mul' branch or 'else' branch instead
   }
*/

fun main() {

}
