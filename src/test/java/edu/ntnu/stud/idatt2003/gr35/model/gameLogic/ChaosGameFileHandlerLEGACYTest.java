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
  void testSaveAndLoadChaosGameDescriptionAffine() {
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

    ChaosGameDescription loadedDescription = ChaosGameFileHandlerLEGACY.readFromFile("ChaosGames/testSierpinski.txt");
    // Check that the loaded description is the same as the original
    assert loadedDescription != null;
    assert loadedDescription.getMincoords().getx0() == (description.getMincoords().getx0());
    assert loadedDescription.getMincoords().getx1() == (description.getMincoords().getx1());
    assert loadedDescription.getMaxcoords().getx0() == (description.getMaxcoords().getx0());
    assert loadedDescription.getMaxcoords().getx1() == (description.getMaxcoords().getx1());
    assert loadedDescription.getTransforms().size() == description.getTransforms().size();
    // Check that the loaded transforms are the same as the original
    for (int i = 0; i < description.getTransforms().size(); i++) {
      Transform2D originalTransform = description.getTransforms().get(i);
      Transform2D loadedTransform = loadedDescription.getTransforms().get(i);
      assert originalTransform.getClass().equals(loadedTransform.getClass());
      if (originalTransform instanceof AffineTransform2D) {
        AffineTransform2D originalAffine = (AffineTransform2D) originalTransform;
        AffineTransform2D loadedAffine = (AffineTransform2D) loadedTransform;
        assert originalAffine.getTransformationAsString().equals(loadedAffine.getTransformationAsString());
      }
    }
  }

  @Test
  void testSaveAndLoadChaosGameDescriptionJulia() {
    // Test data for the ChaosGameDescription
    Vector2D min = new Vector2D(0, 0);
    Vector2D max = new Vector2D(1, 1);
    List<Transform2D> transforms = new ArrayList<>();
    // Add the 3 transformations that produce the Sierpinski triangle (they all have the same matrix)
    transforms.add(new JuliaTransform(new Complex(1, 2), Sign.POSITIVE));
    ChaosGameDescription description = new ChaosGameDescription(min, max, transforms);
    ChaosGameFileHandlerLEGACY.writeToFile(description, "ChaosGames/testJulia.txt");

    ChaosGameDescription loadedDescription = ChaosGameFileHandlerLEGACY.readFromFile("ChaosGames/testJulia.txt");
    // Check that the loaded description is the same as the original
    assert loadedDescription != null;
    assert loadedDescription.getMincoords().getx0() == (description.getMincoords().getx0());
    assert loadedDescription.getMincoords().getx1() == (description.getMincoords().getx1());
    assert loadedDescription.getMaxcoords().getx0() == (description.getMaxcoords().getx0());
    assert loadedDescription.getMaxcoords().getx1() == (description.getMaxcoords().getx1());
    assert loadedDescription.getTransforms().size() == description.getTransforms().size();
    // Chaos games using Julia transforms only have one transform. Check that it is the same as the original
    JuliaTransform originalTransform = (JuliaTransform) description.getTransforms().get(0);
    JuliaTransform loadedTransform = (JuliaTransform) loadedDescription.getTransforms().get(0);
    assert originalTransform.getPoint().getRealPart() == loadedTransform.getPoint().getRealPart();
    assert originalTransform.getPoint().getImagPart() == loadedTransform.getPoint().getImagPart();
  }
}
