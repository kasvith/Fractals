package com.kasun.math;

import com.kasun.math.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by kasun on 7/14/17.
 */
class ComplexTest {
    @Test
    void getX() {
        Complex complex = new Complex(1f,2f);
        assertEquals(1f, complex.getX());
    }

    @Test
    void setX() {
        Complex complex = new Complex(0f,2f);
        complex.setX(4f);
        assertEquals(4f, complex.getX());
    }

    @Test
    void getY() {
        Complex complex = new Complex(1f,2f);
        assertEquals(2f, complex.getY());
    }

    @Test
    void setY() {
        Complex complex = new Complex(0f,2f);
        complex.setY(4f);
        assertEquals(4f, complex.getY());
    }

    @Test
    void add() {
        Complex a = new Complex(1f, 2f);
        Complex b = new Complex(3f, 4f);

        Complex c = Complex.add(a, b);
        assertEquals(c.getX(), 4f);
        assertEquals(c.getY(), 6f);
    }

    @Test
    void subtract() {
        Complex a = new Complex(1f, 2f);
        Complex b = new Complex(3f, 4f);

        Complex c = Complex.subtract(a, b);
        assertEquals(c.getX(), -2f);
        assertEquals(c.getY(), -2f);
    }

    @Test
    void multiply() {
        Complex a = new Complex(1f, 2f);
        Complex b = new Complex(3f, 4f);

        Complex c = Complex.multiply(a, b);
        assertEquals(c.getX(), -5f);
        assertEquals(c.getY(), 10f);
    }

    @Test
    void square() {
        Complex a = new Complex(1f, 2f);
        Complex b = Complex.square(a);

        assertEquals(b.getX(), -3f);
        assertEquals(b.getY(), 4f);
    }

    @Test
    void getAbsolute() {
        Complex a = new Complex(1f, 2f);
        double b = Complex.getAbsolute(a);

        assertEquals(b, Math.sqrt(5));
    }

}