package edu.ntnu.stud.idatt2003.gr35.model.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the Matrix2x2 class.
 */
public class Matrix2x2Test {
@Test
  @DisplayName("Test multiply method")
  void testMultiply() {
    Matrix2x2 matrix = new Matrix2x2(1, 1, 1, 1);
    Vector2D vector = new Vector2D(1, 1);
    Vector2D vector2 = matrix.multiply(vector);
    assertEquals(2, vector2.getx0());
    assertEquals(2, vector2.getx1());
  }
}