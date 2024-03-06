package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Complex class.
 */
class ComplexTest {
    @Test
    @DisplayName("Test complexSqrt method")
    void testComplexSqrt() {
        Complex complex = new Complex(1, 1);
        Complex complexSqrt = complex.complexSqrt();
        System.out.println(complexSqrt.getx0());
        System.out.println(complexSqrt.getx1());
    }

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        Complex complex = new Complex(1, 1);
        Complex complex2 = new Complex(1, 1);
        Complex complex3 = complex.add(complex2);
        System.out.println(complex3.getx0());
        System.out.println(complex3.getx1());
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        Complex complex = new Complex(1, 1);
        Complex complex2 = new Complex(1, 1);
        Complex complex3 = complex.subtract(complex2);
        System.out.println(complex3.getx0());
        System.out.println(complex3.getx1());
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        Complex complex = new Complex(1, 1);
        Complex complex2 = complex.multiply(2);
        System.out.println(complex2.getx0());
        System.out.println(complex2.getx1());
    }
}
