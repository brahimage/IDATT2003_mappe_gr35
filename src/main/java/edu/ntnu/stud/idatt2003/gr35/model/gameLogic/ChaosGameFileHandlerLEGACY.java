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
  public static void writeToFile(ChaosGameDescription description, String path) {
    ArrayList<String> lines = new ArrayList<>(){{add ("");}};
    ArrayList<String> comments = new ArrayList<>(){{
        add("Type of transform");
        add("Lower left");
        add("Upper right");
    }};
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
      Transform2D sample = description.getTransforms().get(0);
      lines.add(description.getMincoords().getx0() + ", " + description.getMincoords().getx1());
      lines.add(description.getMaxcoords().getx0() + ", " + description.getMaxcoords().getx1());
      if (sample instanceof AffineTransform2D) {
        lines.set(0, "Affine2D");
        List<Transform2D> transforms = description.getTransforms();
        for (int i = 0; i < transforms.size(); i++) {
          lines.add(((AffineTransform2D) transforms.get(i)).getTransformationAsString());
          String comment = String.valueOf(i+1);
          if (i >= 10 && i <= 12) {
            comment += "th";
          }
          else {
            switch (i % 10) {
              case 0 -> comment += "st";
              case 1 -> comment += "nd";
              case 2 -> comment += "rd";
              default -> comment += "th";
            }
          }
          comment += " transform";
          comments.add(comment);
        }
        comments.set(3, "1st transform (a00, a01, a10, a11, b0, b1)");
      }
      else if (sample instanceof JuliaTransform) {
        lines.set(0, "Julia");
        lines.add(((JuliaTransform) sample).getPointAsString());
        comments.add("Real and imaginary parts of the constant c");
      }
      else {
        throw new Error("Unsupported transformation type: " + sample.getClass().getName());
      }
      int longestLine = 0;
      for (String line : lines) {
        longestLine = Integer.max(longestLine, line.length());
      }
      for (int i = 0; i < lines.size(); i++) {
        String line = lines.get(i);
        String comment = comments.get(i);
        writer.write(line);
        for (int j = 0; j < longestLine - line.length(); j++) {
          writer.write(" ");
        }
        writer.write("   # " + comment);
        writer.newLine();
      }
      writer.flush();
    } catch (Exception e) {
      System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }
  }
}