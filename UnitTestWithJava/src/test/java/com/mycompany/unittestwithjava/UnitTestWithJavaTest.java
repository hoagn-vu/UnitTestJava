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

    // 1. Test trường hợp cộng
    @Test
    public void testAdd() {
        // Trường hợp cơ bản
        assertEquals(5, unitTestWithJava.add(2, 3), "2 + 3 should equal 5");
        assertEquals(0, unitTestWithJava.add(-1, 1), "-1 + 1 should equal 0");

        // Giá trị biên
        assertEquals(Integer.MAX_VALUE, unitTestWithJava.add(Integer.MAX_VALUE, 0), "MAX_VALUE + 0 should equal MAX_VALUE");
        assertEquals(Integer.MIN_VALUE, unitTestWithJava.add(Integer.MIN_VALUE, 0), "MIN_VALUE + 0 should equal MIN_VALUE");

        // Trường hợp với số âm
        assertEquals(-5, unitTestWithJava.add(-2, -3), "-2 + -3 should equal -5");

        // Số lớn (overflow không xảy ra vì kiểm thử giả định không dùng long)
        assertEquals(-1, unitTestWithJava.add(Integer.MAX_VALUE, Integer.MIN_VALUE), "MAX_VALUE + MIN_VALUE should equal -1");
    }

    // 2. Test trường hợp trừ
    @Test
    public void testSubtract() {
        // Trường hợp cơ bản
        assertEquals(1, unitTestWithJava.subtract(3, 2), "3 - 2 should equal 1");
        assertEquals(-2, unitTestWithJava.subtract(-1, 1), "-1 - 1 should equal -2");

        // Giá trị biên
        assertEquals(Integer.MAX_VALUE, unitTestWithJava.subtract(Integer.MAX_VALUE, 0), "MAX_VALUE - 0 should equal MAX_VALUE");
        assertEquals(Integer.MIN_VALUE, unitTestWithJava.subtract(Integer.MIN_VALUE, 0), "MIN_VALUE - 0 should equal MIN_VALUE");

        // Trường hợp số âm
        assertEquals(-5, unitTestWithJava.subtract(-2, 3), "-2 - 3 should equal -5");
    }

    // 3. Test trường hợp nhân
    @Test
    public void testMultiply() {
        // Trường hợp cơ bản
        assertEquals(6, unitTestWithJava.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(0, unitTestWithJava.multiply(0, 5), "0 * 5 should equal 0");

        // Giá trị biên
        assertEquals(Integer.MAX_VALUE, unitTestWithJava.multiply(Integer.MAX_VALUE, 1), "MAX_VALUE * 1 should equal MAX_VALUE");
        assertEquals(0, unitTestWithJava.multiply(0, Integer.MAX_VALUE), "0 * MAX_VALUE should equal 0");
        assertEquals(0, unitTestWithJava.multiply(Integer.MIN_VALUE, 0), "MIN_VALUE * 0 should equal 0");

        // Trường hợp số âm
        assertEquals(-6, unitTestWithJava.multiply(-2, 3), "-2 * 3 should equal -6");
    }

    // 4. Test trường hợp chia
    @Test
    public void testDivide() {
        // Trường hợp cơ bản
        assertEquals(2, unitTestWithJava.divide(6, 3), "6 / 3 should equal 2");
        assertEquals(-2, unitTestWithJava.divide(-6, 3), "-6 / 3 should equal -2");

        // Trường hợp chia với số âm
        assertEquals(-2, unitTestWithJava.divide(6, -3), "6 / -3 should equal -2");
        assertEquals(2, unitTestWithJava.divide(-6, -3), "-6 / -3 should equal 2");

        // Kiểm tra ngoại lệ chia cho 0
        Exception exception = assertThrows(IllegalArgumentException.class, () -> unitTestWithJava.divide(1, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    // 5. Test hiệu năng
    @Test
    public void testPerformance() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            unitTestWithJava.add(i, i);
        }
        long endTime = System.currentTimeMillis();
        assertTrue(endTime - startTime < 1000, "Performance test failed: Operation took too long.");
    }

    // 6. Test với giá trị lớn hơn
    @Test
    public void testEdgeCases() {
        // Giá trị lớn cho cộng
        assertEquals(-1, unitTestWithJava.add(Integer.MAX_VALUE, Integer.MIN_VALUE), "MAX_VALUE + MIN_VALUE should equal -1");

        // Giá trị lớn cho nhân
        assertEquals(0, unitTestWithJava.multiply(Integer.MIN_VALUE, 0), "MIN_VALUE * 0 should equal 0");

        // Giá trị lớn cho chia
        assertEquals(1, unitTestWithJava.divide(Integer.MAX_VALUE, Integer.MAX_VALUE), "MAX_VALUE / MAX_VALUE should equal 1");
    }
}
