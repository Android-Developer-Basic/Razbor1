package ru.otus.homework

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun testAdd() {
        val calculator = Calculator()
        calculator.add(2)
        assertEquals(2, calculator.getValue())
    }

    @Test
    fun testSubtract() {
        val calculator = Calculator()
        calculator.subtract(2)
        assertEquals(-2, calculator.getValue())
    }

    @Test
    fun testMultiply() {
        val calculator = Calculator()
        calculator.add(2).multiply(2)
        assertEquals(4, calculator.getValue())
    }

    @Test
    fun testDivide() {
        val calculator = Calculator()
        calculator.add(8).divide(2)
        assertEquals(4, calculator.getValue())
    }

    @Test
    fun testUndo() {
        val calculator = Calculator()
        calculator.add(2).undo().undo()
        assertEquals(0, calculator.getValue())
    }

    @Test
    fun testRedo() {
        val calculator = Calculator()
        calculator.add(2).undo()
        assertEquals(0, calculator.getValue())
        calculator.redo().redo()
        assertEquals(2, calculator.getValue())
    }

    @Test
    fun testHistoryRebase() {
        val calculator = Calculator()
        calculator.add(2)
        calculator.add(3)
        calculator.undo()
        calculator.add(4)
        calculator.undo().undo()
        assertEquals(0, calculator.getValue())
    }
}