package ru.otus.homework

fun main() {

    val order = mutableListOf<ReceiptItem>()
    order.add(CoffeeWithMilk())
    order.add(CoffeeWithMilkAndSugar())

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

open class CoffeeWithMilk : Coffee() {
    override fun getName(): String = super.getName() + " + milk"
    override fun getPrice(): Double = super.getPrice() + 0.5
}

open class CoffeeWithSugar : Coffee() {
    override fun getName(): String = super.getName() + " + sugar"
    override fun getPrice(): Double = super.getPrice() + 0.2
}

// Проблемы с наследованием!!!
// Мы не можем создать класс, который наследует CoffeeWithMilk и CoffeeWithSugar
// и добавляем сахар, повторяя класс CoffeeWithSugar
class CoffeeWithMilkAndSugar : CoffeeWithMilk() {
    override fun getName(): String = super.getName() + " + sugar"
    override fun getPrice(): Double = super.getPrice() + 0.2
}

class Tea : ReceiptItem {
    override fun getName(): String = "Tea"
    override fun getPrice(): Double = 0.5
}