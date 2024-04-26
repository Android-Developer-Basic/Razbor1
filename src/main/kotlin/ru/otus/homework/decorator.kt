package ru.otus.homework

fun main() {

    val order = mutableListOf<ReceiptItem>()
    order.add(Milk(Coffee()))
    order.add(Sugar(Milk(Coffee())))
    order.add(Milk(Tea()))

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

class Milk(private val item: ReceiptItem) : ReceiptItem {
    override fun getName(): String = item.getName() + " + milk"
    override fun getPrice(): Double = item.getPrice() + 0.5
}

class Sugar(private val item: ReceiptItem) : ReceiptItem {
    override fun getName(): String = item.getName() + " + sugar"
    override fun getPrice(): Double = item.getPrice() + 0.2
}

class Tea : ReceiptItem {
    override fun getName(): String = "Tea"
    override fun getPrice(): Double = 0.5
}