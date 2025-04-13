package com.mong.nullable

import kotlin.random.Random

fun getRandString(): String? {
    return if (Random.nextInt() % 2 == 0) {
        null
    } else {
        "hello"
    }
}

fun main() {
    val s: String? = getRandString()
    val s2: String = ""

    println(s?.length)
    println(s2.length)
}
