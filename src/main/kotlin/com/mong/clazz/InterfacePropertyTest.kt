package com.mong.clazz

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String): User

class SubscribingUser(val email: String): User {
    override val nickname: String
        get() = email.substringBefore("@")
}

class SocialUser(val accountId: Int): User {
    override val nickname: String = getNameFromSocialNetwork(accountId)
}

fun getNameFromSocialNetwork(accountId: Int): String = "kodee$accountId"

fun main() {
    println(PrivateUser("kodee").nickname)
    println(SubscribingUser("test@example.com").nickname)
    println(SocialUser(123).nickname)
}
