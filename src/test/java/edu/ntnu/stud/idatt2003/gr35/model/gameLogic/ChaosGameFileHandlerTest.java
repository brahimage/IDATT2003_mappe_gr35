package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ChaosGameFileHandlerTest {
  @Test
  void testSaveAndLoadChaosDescription() throws IOException, ClassNotFoundException {
    // Test data for the ChaosGameDescription
    Vector2D min = new Vector2D(0, 0);
    Vector2D max = new Vector2D(1, 0);
    List<Transform2D> transforms = new ArrayList<Transform2D>();
    // Add the 3 transformations that produce the Sierpinski triangle (they all have the same matrix)
    Matrix2x2 sierpinskiMatrix = new Matrix2x2(.5, 0, 0, .5);
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(0, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.5, 0)));
    transforms.add(new AffineTransform2D(sierpinskiMatrix, new Vector2D(.25, .5)));

    ChaosGameDescription description = new ChaosGameDescription(min, max, transforms);
    ChaosGameFileHandler.writeToFile(description, "test.txt");
    ChaosGameDescription description2 = ChaosGameFileHandler.readFromFile("test.txt");

    // Assert that the data stored within the ChaosGameDescription object is the same after saving and loading
    assertEquals(description.getMincoords().getx0(), description2.getMincoords().getx0());
    assertEquals(description.getMincoords().getx1(), description2.getMincoords().getx1());
    assertEquals(description.getMaxcoords().getx0(), description2.getMaxcoords().getx0());
    assertEquals(description.getMaxcoords().getx1(), description2.getMaxcoords().getx1());
    assertEquals(description.getTransforms().size(), description2.getTransforms().size());
    for (int i = 0; i < description.getTransforms().size(); i++) {
      Vector2D vec0 = description.getTransforms().get(i).transform(new Vector2D(0, 0));
      Vector2D vec1 = description2.getTransforms().get(i).transform(new Vector2D(0, 0));
      assertEquals(vec0.getx0(), vec1.getx0());
      assertEquals(vec0.getx1(), vec1.getx1());
    }
  }
}
