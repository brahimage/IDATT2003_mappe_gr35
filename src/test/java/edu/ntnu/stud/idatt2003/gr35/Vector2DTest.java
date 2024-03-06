package edu.ntnu.stud.idatt2003.gr35;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the Vector2D class.
 */
public class Vector2DTest {
  @Test
  @DisplayName("Test add method")
  void testAdd() {
    Vector2D vector = new Vector2D(1, 1);
    Vector2D vector2 = new Vector2D(1, 1);
    Vector2D vector3 = vector.add(vector2);
    assertEquals(2, vector3.getx0());
    assertEquals(2, vector3.getx1());
  }

  @Test
  @DisplayName("Test subtract method")
  void testSubtract() {
    Vector2D vector = new Vector2D(1, 1);
    Vector2D vector2 = new Vector2D(1, 1);
    Vector2D vector3 = vector.subtract(vector2);
    assertEquals(0, vector3.getx0());
    assertEquals(0, vector3.getx1());
  }

  @Test
  @DisplayName("Test multiply method")
  void testMultiply() {
    Vector2D vector = new Vector2D(1, 1);
    Vector2D vector2 = vector.multiply(2);
    assertEquals(2, vector2.getx0());
    assertEquals(2, vector2.getx1());
  }

  @Test
  @DisplayName("Test getx0 method")
  void testGetx0() {
    Vector2D vector = new Vector2D(1, 1);
    assertEquals(1, vector.getx0());
  }

  @Test
  @DisplayName("Test getx1 method")
  void testGetx1() {
    Vector2D vector = new Vector2D(1, 1);
    assertEquals(1, vector.getx1());
  }
}
