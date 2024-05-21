package edu.ntnu.stud.idatt2003.gr35.model.transformations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ntnu.stud.idatt2003.gr35.model.math.Sign;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import org.junit.jupiter.api.Test;
import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;

public class JuliaTransformTest {
  @Test
  void testTransform() {
    JuliaTransform transform = new JuliaTransform(new Complex(1, 2), Sign.POSITIVE);
    Vector2D vector = new Vector2D(1, 1);
    Vector2D vector2 = transform.transform(vector);
    assertEquals(0.7071067811865476, vector2.getx0());
  }

  @Test
  void testGetPoint() {
    JuliaTransform transform = new JuliaTransform(new Complex(1, 2), Sign.POSITIVE);
    assertEquals(transform.getPoint().getx0(), 1);
    assertEquals(transform.getPoint().getx1(), 2);
  }

  @Test
  void testGetPointAsString() {
    JuliaTransform transform = new JuliaTransform(new Complex(1, 2), Sign.POSITIVE);
    assertEquals("1.0, 2.0", transform.getPointAsString());
  }
}