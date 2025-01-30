package com.mong.iteration

fun main() {
    val oneToTen = 1..10
    println(oneToTen::class)
    // using method reference
    oneToTen.toList().forEach(::println)

    // using explicit lambda
    oneToTen.toList().forEach{i -> println(i)}
}