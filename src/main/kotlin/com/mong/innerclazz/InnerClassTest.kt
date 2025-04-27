package com.mong.innerclazz

interface MouseListener {
    fun onEnter()
    fun onClick()
}

class Button(private val listener: MouseListener) {
    fun enter() {
        listener.onEnter()
    }
    fun click() {
        listener.onClick()
    }
}


fun main() {
    // Anonymous inner classes rephrased
    // Object expressions are mostly useful when you need to override multiple methods in your anonymous object.
    var clickCount = 0
    val button = Button(object: MouseListener {
        override fun onEnter() {}
        override fun onClick() {
            clickCount++
        }
    })
    button.enter()
    button.click()

    val listener = object: MouseListener {
        override fun onEnter() {
            TODO("Not yet implemented")
        }

        override fun onClick() {
            TODO("Not yet implemented")
        }
    }
}
