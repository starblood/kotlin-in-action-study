package com.mong

fun max(
    a: Int,
    b: Int,
): Int = if (a > b) a else b

fun valTest(): Int {
    val a: Int
    a = 10
    return a
}

fun main() {
    println(max(3, -1))
    println(valTest())
}
