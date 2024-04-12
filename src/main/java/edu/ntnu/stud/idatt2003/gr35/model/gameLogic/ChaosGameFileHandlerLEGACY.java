package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.JuliaTransform;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Class for deconstructing and reconstructing ChaosGameDescription objects to and from files.
 * Uses 'manual' string parsing to read and write objects.
 */
public class ChaosGameFileHandlerLEGACY {
  // To be implemented
  public static void writeToFile(ChaosGameDescription description, String path) {
    ArrayList<String> lines = new ArrayList<>(){{add ("");}};
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
      Transform2D sample = description.getTransforms().get(0);
      lines.add(description.getMincoords().getx0() + ", " + description.getMincoords().getx1());
      lines.add(description.getMaxcoords().getx0() + ", " + description.getMaxcoords().getx1());
      if (sample instanceof AffineTransform2D) {
        lines.set(0, "Affine2D");
        List<Transform2D> transforms = description.getTransforms();
        for (Transform2D transform : transforms) {
          lines.add(((AffineTransform2D) transform).getTransformationAsString());
        }
      }
      else if (sample instanceof JuliaTransform) {
        lines.set(0, "Julia");
        lines.add(((JuliaTransform) sample).getPointAsString());
      }
      else {
        throw new Error("Unsupported transformation type: " + sample.getClass().getName());
      }
      for (String line : lines) {
        writer.write(line);
        writer.newLine();
      }
      writer.flush();
    } catch (Exception e) {
      System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }
  }
}