package edu.ntnu.stud.idatt2003.gr35.model.transformations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import org.junit.jupiter.api.Test;

public class AffineTransform2DTest {
  @Test
  void testTransform() {
    Vector2D vectorTrans = new Vector2D(.25, .5);
    Matrix2x2 matrix = new Matrix2x2(0.5, 0, 0, 0.5);
    AffineTransform2D transform = new AffineTransform2D(matrix, vectorTrans);

    Vector2D vector = new Vector2D(1, 1);
    Vector2D vector2 = transform.transform(vector);
    assertEquals(0.75, vector2.getx0());
  }

  @Test
  void testTransformAsString() {
    Vector2D vectorTrans = new Vector2D(.25, .5);
    Matrix2x2 matrix = new Matrix2x2(0.5, 0, 0, 0.5);
    AffineTransform2D transform = new AffineTransform2D(matrix, vectorTrans);
    assertEquals("0.5, 0.0, 0.0, 0.5, 0.25, 0.5", transform.getTransformationAsString());
  }
}
