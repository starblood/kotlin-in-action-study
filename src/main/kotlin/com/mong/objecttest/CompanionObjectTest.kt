package com.mong.objecttest



interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}

class Person(val name: String) {
    companion object Loader: JsonFactory<Person> {
        override fun fromJson(jsonText: String): Person {
            return Person("john")
        }
    }
}


class People(val name: String) {
    companion object {

    }
}

fun People.Companion.fromJson(jsonText: String): People {
    return People(jsonText)
}

fun main() {
    val person = Person.Loader.fromJson("han")
    println(person)

    val people = People.fromJson("john")
    println(people)
}
