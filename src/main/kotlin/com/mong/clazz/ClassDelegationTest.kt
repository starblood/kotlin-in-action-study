package com.mong.clazz

import java.util.function.IntFunction

class DelegatingCollection<T>(
    innerList: Collection<T> = mutableListOf<T>()
): Collection<T> by innerList


// delegate using 'by' keyword
// Whenever you’re implementing an interface,
// you can say that you’re delegating the implementation of the interface to another object, using the by keyword.
class CountingSet<T>(
    private val innerSet: MutableCollection<T> = hashSetOf<T>()
): MutableCollection<T> by innerSet {
    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}


fun main() {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("Added ${cset.objectAdded} objects, ${cset.size} uniques")
}
