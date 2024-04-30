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

/**
 * Factory class for creating ChaosGameDescription objects.
 * Generates ChaosGameDescription objects fill directory at program startup.
 */
public class ChaosGameDescriptionFactory {
  /**
   * Generates test files for ChaosGameDescription objects.
   */
  public static void GenerateTestFiles() {
    Vector2D minCoords = new Vector2D(0, 0);
    Vector2D maxCoords = new Vector2D(1, 1);

    // Sierpinski triangle
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
      ChaosGameFileHandler.writeToFile(description, "ChaosGames/Sierpinski.json");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // The Barnsley Fern
    transforms = new ArrayList<>();
    transforms.add(new AffineTransform2D(
        new Matrix2x2(0, 0, 0, .16),
        new Vector2D(0, 0)
    ));
    transforms.add(new AffineTransform2D(
        new Matrix2x2(.85, .04, -.04, .85),
        new Vector2D(0, 1.6)
    ));
    transforms.add(new AffineTransform2D(
        new Matrix2x2(.2, -.26, .23, .22),
        new Vector2D(0, 1.6)
    ));
    transforms.add(new AffineTransform2D(
        new Matrix2x2(-.15, .28, .26, .24),
        new Vector2D(0, .44)
    ));
    description = new ChaosGameDescription(minCoords, maxCoords, transforms);
    try {
      ChaosGameFileHandler.writeToFile(description, "ChaosGames/Barnsley.json");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // Julia transform with c = -.75+.1i
    transforms = new ArrayList<>();
    transforms.add(new JuliaTransform(new Complex(-.75, .1), Sign.POSITIVE));
    description = new ChaosGameDescription(minCoords, maxCoords, transforms);
    try {
      ChaosGameFileHandler.writeToFile(description, "ChaosGames/Julia.json");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}