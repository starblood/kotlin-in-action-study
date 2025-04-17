package com.mong.collection

fun main(args: Array<String>) {
    // varargs: spread ('*' is spread operator)
    val list = listOf(*args)
    println(list)

    // varargs: but not same as java
    val list2 = listOf(args.toList())
    println(list2)

    val map = mapOf(
        1 to "one", 7 to "seven", 53 to "fifty-three"
    )
    println(map)

    val pair = Pair("1", "111")
    println(pair)

    val map2 = mapOf(pair)
    println(map2)

    // destructuring-declaration
    val (number, name) = 1 to "one"
    println("${number}, ${name}")

    for ((index, element) in list.withIndex()) {
        println("${index}: ${element}")
    }
}
