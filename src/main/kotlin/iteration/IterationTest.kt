package com.mong.iteration

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun forInTest() {
    val collection = listOf("red", "green", "blue")
    for (color in collection) {
        print("$color ")
    }
}

fun main() {
    val oneToTen = 1..10
    println(oneToTen::class)
    // using method reference
    oneToTen.toList().forEach(::println)

    // using explicit lambda
    oneToTen.toList().forEach { i -> println(i) }

    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println("--------------")
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    // Buzz 98 Fizz 94 92 FizzBuzz 88 ...
    println("--------------")

    forInTest()
}
