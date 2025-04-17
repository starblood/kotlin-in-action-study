package com.mong.collection

import org.intellij.lang.annotations.Language

fun parsePath(path: String) {
    val directory = path.substringBeforeLast('/')
    val fullName = path.substringAfterLast('/')

    val fileName = fullName.substringBeforeLast('.')
    val extension = fullName.substringAfterLast('.')

    println("dir: $directory, name: $fileName, ext: $extension")
}

fun parsePathRegex(path: String) {
   val regex = """(.+)/(.+)\.(.+)""".toRegex()
   val matchResult: MatchResult? = regex.matchEntire(path)
   if (matchResult != null) {
       // MatchResult destructuring: oh! good!, MatchResult defines properties named 'destructured'
       val (directory, filename, extension) = matchResult.destructured
       println("Dir: $directory, name: $filename, ext: $extension")
   }
}

fun getKotlinLogo(): String {
    // remove line breaks in triple-quoted Strings
   return """
   | //
   |//
   |/ \
   """.trimIndent()
}

fun syntaxHighlighting() {
    val expectedPage = """
       <html lang="en">
           <head>
           <title>A page</title>
           </head>
       <body>
           <p>Hello, Kotlin!</p>
       </body>
       </html>
    """.trimIndent()

    // syntax highlighting in triple-quoted String
    @Language("JSON")
    val expectedObject = """
       {
           "name": "Sebastian",
           "age": 27,
           "homeTown": "Munich"
       }
    """.trimIndent()
}

class User(val id: Int, val name: String, val address: String)

// local function and extension function in Kotlin
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
               "Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    // Save user to the database
}


fun main() {
    // kotlin support dot ('.') for Regex
    println("12.345-6.A".split("\\.|-".toRegex()))
    // [12, 345, 6, A]

    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    parsePathRegex("/Users/yole/kotlin-book/chapter.adoc")

    println(getKotlinLogo())
}
