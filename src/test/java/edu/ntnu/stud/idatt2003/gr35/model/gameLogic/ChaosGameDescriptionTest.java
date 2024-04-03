package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Sign;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.JuliaTransform;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.io.IOException;
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
    List<Transform2D> transforms = new ArrayList<>();
    // Add the 3 transformations that produce the Sierpinski triangle (they all have the same matrix)
    Matrix2x2 sierpinskiMatrix = new Matrix2x2(.5, 0, 0, .5);
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(0, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.5, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.25, .5)));
  }

  @Test
  public void GenerateTestFiles() {
    // Generate a chaos game description for the Sierpinski triangle stored as a file
    Vector2D minCoords = new Vector2D(0, 0);
    Vector2D maxCoords = new Vector2D(1, 0);
    List<Transform2D> transforms = new ArrayList<>();
    transforms.add(new AffineTransform2D(
        new Matrix2x2(.5, 0, 0, .5),
        new Vector2D(0, 0)
    ));
    transforms.add(new AffineTransform2D(
        new Matrix2x2(.5, 0, 0, .5),
        new Vector2D(.5, 0)
    ));
    transforms.add(new AffineTransform2D(
        new Matrix2x2(.5, 0, 0, .5),
        new Vector2D(.25, .5)
    ));
    ChaosGameDescription description = new ChaosGameDescription(minCoords, maxCoords, transforms);
    try {
      ChaosGameFileHandler.writeToFile(description, "ChaosGames/sierpinski.json");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // Generate a chaos game description for julia transform with c = -.75+.1i stored as a file
    transforms = new ArrayList<>();
    transforms.add(new JuliaTransform(new Complex(-.75, .1), Sign.POSITIVE));
    ChaosGameDescription juliaDescription = new ChaosGameDescription(minCoords, maxCoords, transforms);
    try {
      ChaosGameFileHandler.writeToFile(juliaDescription, "ChaosGames/julia.json");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}