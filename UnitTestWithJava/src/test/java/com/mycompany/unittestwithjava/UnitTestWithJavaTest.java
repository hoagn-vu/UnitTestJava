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
    }

    @Test
    public void testSubtract() {
        assertEquals(1, unitTestWithJava.subtract(3, 2), "3 - 2 should equal 1");
        assertEquals(-2, unitTestWithJava.subtract(-1, 1), "-1 - 1 should equal -2");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, unitTestWithJava.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(0, unitTestWithJava.multiply(0, 5), "0 * 5 should equal 0");
    }

    @Test
    public void testDivide() {
        assertEquals(2, unitTestWithJava.divide(6, 3), "6 / 3 should equal 2");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> unitTestWithJava.divide(1, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
