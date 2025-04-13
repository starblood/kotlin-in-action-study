package com.mong.smartcast

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

fun evalRight(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return evalRight(e.right) + evalRight(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalLeft(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return evalLeft(e.left) + evalLeft(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval(e: Expr): Int {
    if (e is Num) {
        return e.value
    } else if (e is Sum) {
        return eval(e.left) + eval(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }
}

fun evalConcise(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalConcise(e.left) + evalConcise(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun evalWithWhen(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalWithWhen(e.left) + evalWithWhen(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println("1 - ${evalRight(Sum(Sum(Num(1), Num(2)), Num(4)))}")
    println("2 - ${evalLeft(Sum(Sum(Num(1), Num(2)), Num(4)))}")
    println("3 - ${eval(Sum(Sum(Num(1), Num(2)), Num(4)))}")
    println("4 - ${evalConcise(Sum(Sum(Num(1), Num(2)), Num(4)))}")
    println("5 - ${evalWithWhen(Sum(Sum(Num(1), Num(2)), Num(4)))}")
}
