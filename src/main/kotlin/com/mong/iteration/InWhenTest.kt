package com.mong.iteration

fun recognize(c: Char): String =
    when (c) {
        in '0'..'9' -> "It's a digit."
        in 'a'..'z', in 'A'..'Z' -> "It's a letter."
        else -> "I don't know."
    }

fun main() {
    println(recognize('3'))

    // String class implements Comparable interface, so we can compare.
    println("Kotlin" in "Java".."Scala")

    println("Kotlin" in setOf("Java", "Scala"))
}
