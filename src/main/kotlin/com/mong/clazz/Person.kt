package com.mong.clazz

// name is private
class Person(name: String)

// name is public
class Person2(val name: String)

class Person3(val name: String, var isStudent: Boolean) {
    override fun toString(): String {
        return "Person3(name='$name', isStudent=$isStudent)"
    }
}

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main() {
//    val p1 = Person("john")
    val p2 = Person2("bob")
    val p3 = Person3("terry", true)
    // println(p1.name): compile error
    println(p2.name)

    println(p3)
    p3.isStudent = false
    println(p3)

    val rec1 = Rectangle(height = 10, width = 20)
    println(rec1.isSquare)
}
