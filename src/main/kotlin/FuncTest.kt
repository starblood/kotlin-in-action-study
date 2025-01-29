package com.mong

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun val_test(): Int {
    val a: Int
    a = 10
    return a
}

fun main() {
    println(max(3, -1))
    println(val_test())
}
