package com.mong.exception

fun getPercentage(number: Int): Int {
    val percentage =
        if (number in 0..100)
            number
        else throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
    return percentage
}

fun main() {

    println(getPercentage(100))
    println(getPercentage(200))
    println(getPercentage(-1))
}
