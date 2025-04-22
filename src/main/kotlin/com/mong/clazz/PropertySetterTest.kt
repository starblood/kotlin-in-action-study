package com.mong.clazz


class User2(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println(
                """
                Address was changed for $name:
                "$field" -> "$value".
                """.trimIndent()
            )
            field = value
        }
}


fun main() {
    val user = User2("Alice")
    user.address = "New York"
}
