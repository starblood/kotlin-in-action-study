package com.mong.collection

// with default parameter values
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
): String {
    val result = StringBuilder(prefix)

    for ((index, ele) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(ele)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val list = listOf("1", "2", "3")
    println(joinToString(list, ";", "(", ")"))

    // using named arguments, we don't need to worry about arguments' order
    println(joinToString(collection = list, postfix = ")", separator = ",", prefix = "("))

    // using default arguments
    println(joinToString(list))

    // we can omit some arguments
    println(joinToString(list, prefix = "("))
}
