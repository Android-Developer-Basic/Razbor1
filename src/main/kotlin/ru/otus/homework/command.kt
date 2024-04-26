package ru.otus.homework

fun main() {
    println("=== Command Pattern ===")
    val calculator = Calculator()
    println("Initial value: ${calculator.getValue()}")
    calculator.add(5)
    println("After adding 5: ${calculator.getValue()}")
    calculator.subtract(3)
    println("After subtracting 3: ${calculator.getValue()}")
    calculator.multiply(2)
    println("After multiplying by 2: ${calculator.getValue()}")
    calculator.divide(4)
    println("After dividing by 4: ${calculator.getValue()}")
    println("=== Result ===")
    println("Result: ${calculator.getValue()}")
}

class Calculator {

    private var value = 0
    fun getValue(): Int = value

    fun undo(): Calculator {
        println("Undo???")
        return this
    }
    fun redo(): Calculator {
        println("Redo???")
        return this
    }

    fun add(operand: Int): Calculator {
        value += operand
        return this
    }
    fun subtract(operand: Int): Calculator {
        value -= operand
        return this
    }
    fun multiply(operand: Int): Calculator {
        value *= operand
        return this
    }
    fun divide(operand: Int): Calculator {
        value /= operand
        return this
    }
}