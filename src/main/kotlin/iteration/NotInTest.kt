package com.mong.iteration

fun isLetter(c: Char): Boolean = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char): Boolean = c !in '0'..'9'

fun main() {
    println("${isLetter('q')}")
    println("${isNotDigit('x')}")
}
