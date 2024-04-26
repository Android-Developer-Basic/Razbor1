package ru.otus.homework

fun main() {

    val order = mutableListOf<ReceiptItem>()
    order.add(Coffee() + Milk)
    order.add(Coffee() + Milk + Sugar)
    order.add(Tea() + Milk)

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

    operator fun plus(factory: DecoratorFactory): ReceiptItem = factory.decorate(this)
}

interface DecoratorFactory {
    fun decorate(item: ReceiptItem): ReceiptItem
}

open class Coffee : ReceiptItem {
    override fun getName(): String = "Coffee"
    override fun getPrice(): Double = 1.0
}

class Milk(private val item: ReceiptItem) : ReceiptItem {
    override fun getName(): String = item.getName() + " + milk"
    override fun getPrice(): Double = item.getPrice() + 0.5

    companion object : DecoratorFactory {
        override fun decorate(item: ReceiptItem): ReceiptItem = Milk(item)
    }
}

class Sugar(private val item: ReceiptItem) : ReceiptItem {
    override fun getName(): String = item.getName() + " + sugar"
    override fun getPrice(): Double = item.getPrice() + 0.2

    companion object : DecoratorFactory {
        override fun decorate(item: ReceiptItem): ReceiptItem = Sugar(item)
    }
}

class Tea : ReceiptItem {
    override fun getName(): String = "Tea"
    override fun getPrice(): Double = 0.5
}