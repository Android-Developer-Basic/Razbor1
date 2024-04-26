package ru.otus.homework

import java.util.LinkedList

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

    private var history: List<Command> = emptyList()
    private var historyPointer = 0
    private fun addCommand(command: Command) {
        history = history + command.apply { execute() }
        historyPointer++
    }

    private var value = 0
    fun getValue(): Int {
        return value
    }

    fun undo(): Calculator {
        history.getOrNull(--historyPointer)?.undo()
        return this
    }
    fun redo(): Calculator {
        history.getOrNull(historyPointer++)?.execute()
        return this
    }

    fun add(operand: Int): Calculator = apply {
        addCommand(AddCommand(operand))
    }
    fun subtract(operand: Int): Calculator = apply {
        addCommand(SubtractCommand(operand))
    }
    fun multiply(operand: Int): Calculator = apply {
        addCommand(MultiplyCommand(operand))
    }
    fun divide(operand: Int): Calculator = apply {
        addCommand(DivideCommand(operand))
    }

    interface Command {
        fun execute()
        fun undo()
    }

    private inner class AddCommand(private val operand: Int) : Command {
        override fun execute() {
            value += operand
        }
        override fun undo() {
            value -= operand
        }
    }

    private inner class SubtractCommand(private val operand: Int) : Command {
        override fun execute() {
            value -= operand
        }
        override fun undo() {
            value += operand
        }
    }

    private inner class MultiplyCommand(private val operand: Int) : Command {
        override fun execute() {
            value *= operand
        }
        override fun undo() {
            value /= operand
        }
    }

    private inner class DivideCommand(private val operand: Int) : Command {
        override fun execute() {
            value /= operand
        }
        override fun undo() {
            value *= operand
        }
    }
}