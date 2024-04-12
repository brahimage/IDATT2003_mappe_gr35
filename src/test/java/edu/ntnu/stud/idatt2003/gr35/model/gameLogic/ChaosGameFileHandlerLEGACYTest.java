package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Sign;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.JuliaTransform;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Test class for the ChaosGameFileHandlerLEGACY class.
 */
public class ChaosGameFileHandlerLEGACYTest {
  @Test
  void testSaveChaosGameDescriptionAffine() {
    // Test data for the ChaosGameDescription
    Vector2D min = new Vector2D(0, 0);
    Vector2D max = new Vector2D(1, 1);
    List<Transform2D> transforms = new ArrayList<>();
    // Add the 3 transformations that produce the Sierpinski triangle (they all have the same matrix)
    Matrix2x2 sierpinskiMatrix = new Matrix2x2(.5, 0, 0, .5);
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(0, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.5, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.25, .5)));

    ChaosGameDescription description = new ChaosGameDescription(min, max, transforms);
    ChaosGameFileHandlerLEGACY.writeToFile(description, "ChaosGames/testSierpinski.txt");
  }

  @Test
  void testSaveChaosGameDescriptionJulia() {
    // Test data for the ChaosGameDescription
    Vector2D min = new Vector2D(0, 0);
    Vector2D max = new Vector2D(1, 1);
    List<Transform2D> transforms = new ArrayList<>();
    // Add the 3 transformations that produce the Sierpinski triangle (they all have the same matrix)
    transforms.add(new JuliaTransform(new Complex(1, 2), Sign.POSITIVE));
    ChaosGameDescription description = new ChaosGameDescription(min, max, transforms);
    ChaosGameFileHandlerLEGACY.writeToFile(description, "ChaosGames/testJulia.txt");
  }
}
