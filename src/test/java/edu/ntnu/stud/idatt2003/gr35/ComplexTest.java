package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ComplexTest {
    @Nested
    @DisplayName("Positive Complex method test")
    class PositiveComplexMethodTest {

        @Test
        @DisplayName("Test complexSqrt method")
        void testComplexSqrt() {
            Complex complex = new Complex(1, 1);
            Complex complexSqrt = complex.complexSqrt();
            System.out.println(complexSqrt.getx0());
            System.out.println(complexSqrt.getx1());
        }
    }
}
