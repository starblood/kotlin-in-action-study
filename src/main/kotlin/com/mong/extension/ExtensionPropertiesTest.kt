package com.mong.extension


val String.lastChar: Char
    get() = this[length - 1]

var StringBuilder.lastChar: Char
    get() = this[length -1]
    set(value) {
        this.setCharAt(length - 1, value)
    }

fun main() {
    val sb = StringBuilder()
    sb.append("abc")
    println(sb.lastChar)

    sb.lastChar = '!'
    println(sb)
}
