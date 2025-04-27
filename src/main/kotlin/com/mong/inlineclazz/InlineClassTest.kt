package com.mong.inlineclazz



fun addExpense(expense: Int) {
    // USD Dollars
}

class UsdCent(val amount: Int)
fun addExpenseV2(expense: UsdCent) {
    // save as USD cent
}

@JvmInline
value class UsdCentV3(val amount: Int)
fun addExpenseV3(expense: UsdCentV3) {

}

interface PrettyPrintable {
    fun prettyPrint()
}

// inline value class can implements interface, not class
@JvmInline
value class UsdCentV4(val amount: Int): PrettyPrintable {
    val salesTax get() = amount * 0.06
    override fun prettyPrint() {
        println("$amount")
    }
}

fun main() {
    // Japanese YEN, problem: currency unit
    addExpense(200)

    // classical walkaround use class, problem: addExpenseV2 crate object everytime it called
    // this makes garbage collection a lot (performance issue)
    addExpenseV2(UsdCent(147))

    // They allow you to introduce a layer of type safety without compromising performance.
    // This small change avoids the needless instantiation of objects without giving up on the type safety provided by your UsdCent wrapper type.
    // At run time, instances of UsdCent will be represented as the wrapped property.
    addExpenseV3(UsdCentV3(147))

    val expense = UsdCentV4(1_99)
    println(expense.salesTax)
    expense.prettyPrint()
}
