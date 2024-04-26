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
}