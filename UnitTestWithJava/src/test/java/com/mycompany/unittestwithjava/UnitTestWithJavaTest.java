/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.unittestwithjava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hoangvu
 */
public class UnitTestWithJavaTest {

    private final UnitTestWithJava unitTestWithJava = new UnitTestWithJava();

    @Test
    public void testAdd() {
        assertEquals(5, unitTestWithJava.add(2, 3), "2 + 3 should equal 5");
        assertEquals(0, unitTestWithJava.add(-1, 1), "-1 + 1 should equal 0");
        assertEquals(Integer.MAX_VALUE, unitTestWithJava.add(Integer.MAX_VALUE, 0), "MAX_VALUE + 0 should equal MAX_VALUE");
        assertEquals(Integer.MIN_VALUE, unitTestWithJava.add(Integer.MIN_VALUE, 0), "MIN_VALUE + 0 should equal MIN_VALUE");
    }

    @Test
    public void testSubtract() {
        assertEquals(1, unitTestWithJava.subtract(3, 2), "3 - 2 should equal 1");
        assertEquals(-2, unitTestWithJava.subtract(-1, 1), "-1 - 1 should equal -2");
        assertEquals(Integer.MAX_VALUE, unitTestWithJava.subtract(Integer.MAX_VALUE, 0), "MAX_VALUE - 0 should equal MAX_VALUE");
        assertEquals(Integer.MIN_VALUE, unitTestWithJava.subtract(Integer.MIN_VALUE, 0), "MIN_VALUE - 0 should equal MIN_VALUE");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, unitTestWithJava.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(0, unitTestWithJava.multiply(0, 5), "0 * 5 should equal 0");
        assertEquals(0, unitTestWithJava.multiply(0, Integer.MAX_VALUE), "0 * MAX_VALUE should equal 0");
        assertEquals(Integer.MAX_VALUE, unitTestWithJava.multiply(Integer.MAX_VALUE, 1), "MAX_VALUE * 1 should equal MAX_VALUE");
    }

    @Test
    public void testDivide() {
        assertEquals(2, unitTestWithJava.divide(6, 3), "6 / 3 should equal 2");
        assertEquals(-2, unitTestWithJava.divide(-6, 3), "-6 / 3 should equal -2");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> unitTestWithJava.divide(1, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    void testAdditionWithNegativeNumbers() {
        assertEquals(-5, unitTestWithJava.add(-2, -3), "-2 + -3 should equal -5");
    }

    @Test
    void testMultiplicationWithNegativeAndPositiveNumbers() {
        assertEquals(-6, unitTestWithJava.multiply(-2, 3), "-2 * 3 should equal -6");
    }

    @Test
    void testDivisionByNegativeNumbers() {
        assertEquals(-2, unitTestWithJava.divide(6, -3), "6 / -3 should equal -2");
        assertEquals(2, unitTestWithJava.divide(-6, -3), "-6 / -3 should equal 2");
    }

    @Test
    void testPerformance() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            unitTestWithJava.add(i, i);
        }
        long endTime = System.currentTimeMillis();
        assertTrue(endTime - startTime < 1000, "Performance test failed: Operation took too long.");
    }

    @Test
    void testLargeNumbersAddition() {
        assertEquals(-1, unitTestWithJava.add(Integer.MAX_VALUE, Integer.MIN_VALUE), "MAX_VALUE + MIN_VALUE should equal -1");
    }

    @Test
    void testLargeNumbersMultiplication() {
        assertEquals(0, unitTestWithJava.multiply(Integer.MIN_VALUE, 0), "MIN_VALUE * 0 should equal 0");
    }
}

