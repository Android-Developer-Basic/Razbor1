package ru.otus.homework

fun main() {

    val order = mutableListOf<ReceiptItem>()
    order.add(Coffee())
    order.add(Tea())

    println("Thank you!")
    var total = 0.0
    order.forEach {
        println("${it.getName()} - ${it.getPrice()}")
        total += it.getPrice()
    }
    println("Total: $total")
}

interface ReceiptItem {
    fun getName(): String
    fun getPrice(): Double
}

class Coffee : ReceiptItem {
    override fun getName(): String = "Coffee"
    override fun getPrice(): Double = 1.0
}

class Tea : ReceiptItem {
    override fun getName(): String = "Tea"
    override fun getPrice(): Double = 0.5
}