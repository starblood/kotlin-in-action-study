package com.mong.exception

fun getPercentage(number: Int): Int {
    return require(number in 0 .. 100) {
        "A percentage value must be between 0 and 100: $number"
    }.let { number }
}

fun main() {
    println(getPercentage(100))
    println(getPercentage(200))
    println(getPercentage(-1))
}
