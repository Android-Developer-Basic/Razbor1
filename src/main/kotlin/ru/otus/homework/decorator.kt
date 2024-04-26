package ru.otus.homework

fun main() {

    val order = mutableListOf<ReceiptItem>()
    order.add(CoffeeWithMilk())
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

open class Coffee : ReceiptItem {
    override fun getName(): String = "Coffee"
    override fun getPrice(): Double = 1.0
}

class CoffeeWithMilk : Coffee() {
    override fun getName(): String = super.getName() + " + milk"
    override fun getPrice(): Double = super.getPrice() + 0.5
}

class Tea : ReceiptItem {
    override fun getName(): String = "Tea"
    override fun getPrice(): Double = 0.5
}