package com.mong.extension

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view")
fun Button.showOff() = println("I'm a button")

fun main() {
    val button: View = Button()
    button.click()

    // extension method 는 동적으로 type 이 binding 되지 않는다. compile time 에 binding
    button.showOff()
    // I'm a view, call super class.
}
