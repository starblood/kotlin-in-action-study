package com.mong.iteration

fun main() {
    val list = listOf("10", "11", "1001")
    for ((index, value) in list.withIndex()) {
        println("$index: $value")
    }
}
