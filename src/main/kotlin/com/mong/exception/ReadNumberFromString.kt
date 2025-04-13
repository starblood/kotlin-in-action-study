package com.mong.exception

import java.io.BufferedReader
import java.io.StringReader

fun readNumber2(reader: BufferedReader): Int {
    return Integer.parseInt(reader.readLine())
}

fun readNumber3(reader: BufferedReader): Int? {
    return try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
}

fun test1() {
    val reader = BufferedReader(StringReader("10"))
    println(readNumber2(reader))
    reader.close()
}

fun test2() {
    val reader = BufferedReader(StringReader("100"))
    println(readNumber3(reader))
    reader.close()
}

fun test3() {
    val reader = BufferedReader(StringReader("z"))
    println(readNumber3(reader))
    reader.close()
}

fun main() {
    test1()
    test2()
    test3()
}
