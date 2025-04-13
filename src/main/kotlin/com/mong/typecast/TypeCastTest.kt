package com.mong.typecast

fun main() {
    fun modify(value: Any) {
        if (value is String) {
            println(value.uppercase())
        }
    }

    modify("hello")
}
