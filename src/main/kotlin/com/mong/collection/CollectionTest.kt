package com.mong.collection

fun main() {
    val set = setOf(1, 2, 3)

    val list = listOf(1, 2, 3)

    val map = mapOf(1 to 1, 2 to 2, 3 to 3)

    println(set)
    println(list)
    println(map)

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}
