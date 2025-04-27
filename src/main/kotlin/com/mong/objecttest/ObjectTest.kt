package com.mong.objecttest

import com.mong.clazz.Person
import com.mong.clazz.getNameFromSocialNetwork
import java.io.File


object Payroll {
   val allEmployees = mutableListOf<Person>()

   fun calculateSalary() {
       for (person in allEmployees) {
           /* ... */
       }
   }
}


// object can inherit interface or class, but our implementation shouldn't contain any 'state'
object CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(o1: File?, o2: File?): Int {
        // kotlin style idiomatic null handling
        requireNotNull(o1) {"o1 must not be null"}
        requireNotNull(o2) {"o2 must not be null"}
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

data class PersonA(val name: String) {
    object NameComparator: Comparator<PersonA> {
        override fun compare(o1: PersonA?, o2: PersonA?): Int {
            requireNotNull(o1)
            requireNotNull(o2)
            return o1.name.compareTo(o2.name)
        }
    }
}

class MyClass {
    companion object {
        fun callMe() {
            println("Companion object called.")
        }
    }
}

// factory pattern using companion object
class User private constructor(val nickName: String) {
    companion object {
        fun newSubscribingUser(email: String): User {
            return User(email.substringBefore("@"))
        }
        fun newSocialUser(accountId: Int): User {
            return User(getNameFromSocialNetwork(accountId))
        }
    }
}

class PersonC(val name: String) {
    companion object Loader {
        fun fromJson(jsonText: String): Person {
            return Person("john")
        }
    }
}


fun main() {
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(PersonA("Paul"), PersonA("Bob"))
    println(persons.sortedWith(PersonA.NameComparator))

    MyClass.callMe()

    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val socialUser = User.newSocialUser(2)
    println(subscribingUser.nickName)
    println(socialUser.nickName)

    val person = PersonC.Loader.fromJson("""{"name": "Dmitry"}""")
    println(person)
}
