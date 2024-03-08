package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Test class for ChaosGameDescription
 */
public class ChaosGameDescriptionTest {
  @Test
  void testChaosGameDescription() {
    // Test data for the ChaosGameDescription
    Vector2D min = new Vector2D(0, 0);
    Vector2D max = new Vector2D(1, 0);
    List<Transform2D> transforms = new ArrayList<Transform2D>();
    // Add the 3 transformations that produce the Sierpinski triangle (they all have the same matrix)
    Matrix2x2 sierpinskiMatrix = new Matrix2x2(.5, 0, 0, .5);
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(0, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.5, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.25, .5)));
  }
}