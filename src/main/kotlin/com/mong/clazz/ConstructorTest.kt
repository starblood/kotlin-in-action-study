package com.mong.clazz

import java.net.URI


class Foo private constructor(private val name: String)

open class Downloader {
    // secondary constructor
    constructor(url: String?) {

    }
    // secondary constructor
    constructor(uri: URI?) {

    }
}

fun main() {

}
