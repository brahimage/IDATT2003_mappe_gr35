package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Sign;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.JuliaTransform;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Class for deconstructing and reconstructing ChaosGameDescription objects to and from files.
 * Uses 'manual' string parsing to read and write objects.
 */
public class ChaosGameFileHandlerLEGACY {

  /**
   * Writes a ChaosGameDescription object to a file.
   * Every line in the file contains a piece of data from the ChaosGameDescription object.
   * Every line is followed by a comment describing the data.
   *
   * @param description The ChaosGameDescription object to write to file.
   * @param path The path to the file to write to.
   */
  public static void writeToFile(ChaosGameDescription description, String path) {
    ArrayList<String> lines = new ArrayList<>(){{add ("");}}; // Reserve position 0 for the type of transform.
    ArrayList<String> comments = new ArrayList<>(){{ // Init array containing comments for each line.
        add("Type of transform");
        add("Lower left");
        add("Upper right");
    }};

    lines.add(description.getMincoords().getx0() + ", " + description.getMincoords().getx1()); // Write the min coordinates.
    lines.add(description.getMaxcoords().getx0() + ", " + description.getMaxcoords().getx1()); // Write the max coordinates.
    // The 3 standard lines have been written, now we need to write the actual transforms.

    Transform2D sample = description.getTransforms().get(0); // Get a sample transform to determine the type.
    switch (sample) {
      case AffineTransform2D ignored -> handleAffine(description, lines, comments);
      case JuliaTransform juliaTransform -> handleJulia(lines, juliaTransform, comments);
      case null, default ->
        throw new Error("Unsupported transformation type: " + sample.getClass().getName());
    }

    int longestLine = getLongestLine(lines);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
      for (int i = 0; i < lines.size(); i++) {
        writeLine(writer, lines.get(i), comments.get(i), longestLine);
      }
      writer.flush();
    } catch (Exception e) {
      System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }
  }

  /**
   * Writes a line in the output file with the specified comment.
   *
   * @param line The line to write.
   * @param comment The comment to write.
   */
  private static void writeLine(BufferedWriter writer, String line, String comment, int longestLine) {
    try {
      writer.write(line);
      for (int j = 0; j < longestLine - line.length(); j++) {
        writer.write(" ");
      }
      writer.write("   # " + comment + "\n");
    } catch (Exception e) {
      System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }
  }

  /**
   * Returns the length of the longest line in the list of lines.
   *
   * @param lines The list of lines to check.
   * @return The length of the longest line.
   */
  private static int getLongestLine(ArrayList<String> lines) {
    int longestLine = 0;
    for (String line : lines) {
      longestLine = Integer.max(longestLine, line.length());
    }
    return longestLine;
  }

  /**
   * Generates the lines and comments to save to file for a JuliaTransform.
   *
   * @param lines The list of lines to write to the file.
   * @param sample The sample transform to get the point from.
   * @param comments The list of comments to write to the file.
   */
  private static void handleJulia(ArrayList<String> lines, JuliaTransform sample,
      ArrayList<String> comments) {
    // Set appropriate type of transform.
    lines.set(0, "Julia");
    // Julia transform has only one point, so we only need to add one line.
    lines.add(sample.getPointAsString());
    // Add comment for the point.
    comments.add("Real and imaginary parts of the constant c");
  }

  /**
   * Generates the lines and comments to save to file for an AffineTransform2D.
   *
   * @param description The ChaosGameDescription object to get the transforms from.
   * @param lines The list of lines to write to the file.
   * @param comments The list of comments to write to the file.
   */
  private static void handleAffine(ChaosGameDescription description, ArrayList<String> lines,
      ArrayList<String> comments) {
    // Set appropriate type of transform.
    lines.set(0, "Affine2D");

    // Get the list of transforms.
    List<Transform2D> transforms = description.getTransforms();
    for (int i = 0; i < transforms.size(); i++) {
      // Add the transform as a line in the file.
      lines.add(((AffineTransform2D) transforms.get(i)).getTransformationAsString());
      // Construct a comment for the transform.
      comments.add(String.valueOf(i+1) + getOrdinalIndicator(i) + " transform");
    }
    // Add a more descriptive comment for the first transform.
    comments.set(3, "1st transform (a00, a01, a10, a11, b0, b1)");
  }

  /**
   * Returns a string with the ordinal indicator appended to the number,
   * i.e. "st", "nd", "rd" or "th".
   *
   * @param i The number to get the ordinal indicator of.
   * @return The ordinal indicator of the number.
   */
  private static String getOrdinalIndicator(int i) {
    if (i % 100 >= 10 && i % 100 <= 12) {
      return "th";
    }
    else {
      return switch (i % 10) {
        case 0 -> "st";
        case 1 -> "nd";
        case 2 -> "rd";
        default -> "th";
      };
    }
  }

  /**
   * Reads a ChaosGameDescription object from a file.
   * The file must be formatted as described in the writeToFile method.
   *
   * @param path The path to the file to read from.
   * @return The ChaosGameDescription object read from the file.
   */
  public static ChaosGameDescription readFromFile(String path) {
    try {
      File file = new File(path);
      Scanner scanner = new Scanner(file);

      // Initialize variables to store data
      List<Transform2D> transforms = new ArrayList<>();
      Vector2D min;
      Vector2D max;

      // Read the 3 standard lines
      String type = scanner.nextLine().split("#")[0].trim();
      String[] minCoords = scanner.nextLine().split("#")[0].split(",");
      min = new Vector2D(Double.parseDouble(minCoords[0].trim()), Double.parseDouble(minCoords[1].trim()));
      String[] maxCoords = scanner.nextLine().split("#")[0].split(",");
      max = new Vector2D(Double.parseDouble(maxCoords[0].trim()), Double.parseDouble(maxCoords[1].trim()));

      switch (type) {
        case "Affine2D" -> handleAffineRead(scanner, transforms);
        case "Julia" -> handleJuliaRead(scanner, transforms);
        default -> throw new Exception("Unsupported transformation type: " + type);
      }
      return new ChaosGameDescription(min, max, transforms);
    } catch (Exception e) {
      System.out.println("An error occurred while reading from the file: " + e.getMessage());
      return null;
    }
  }

  /**
   * Reads a Julia transform from the file and adds it to the list of transforms.
   * Julia-based chaos games only have one transform.
   *
   * @param scanner The scanner to read from.
   * @param transforms The list of transforms to add the Julia transform to.
   * @throws Exception If an error occurs while reading the Julia transform.
   */
  private static void handleJuliaRead(Scanner scanner, List<Transform2D> transforms) throws Exception {
    String[] point = scanner.nextLine().split("#")[0].split(",");
    Complex c = new Complex(Double.parseDouble(point[0].trim()), Double.parseDouble(point[1].trim()));
    transforms.add(new JuliaTransform(c, Sign.POSITIVE));
  }

  /**
   * Reads affine transforms from the file and adds them to the list of transforms.
   *
   * @param scanner The scanner to read from.
   * @param transforms The list of transforms to add the affine transforms to.
   * @throws Exception If an error occurs while reading the affine transforms.
   */
  private static void handleAffineRead(Scanner scanner, List<Transform2D> transforms) throws Exception {
    while (scanner.hasNextLine()) {
      String[] transform = scanner.nextLine().split("#")[0].split(",");
      double a00 = Double.parseDouble(transform[0].trim());
      double a01 = Double.parseDouble(transform[1].trim());
      double a10 = Double.parseDouble(transform[2].trim());
      double a11 = Double.parseDouble(transform[3].trim());
      double b0 = Double.parseDouble(transform[4].trim());
      double b1 = Double.parseDouble(transform[5].trim());
      transforms.add(new AffineTransform2D(new Matrix2x2(a00, a01, a10, a11), new Vector2D(b0, b1)));
    }
    if (transforms.isEmpty()) {
      throw new Exception("No transforms found in file.");
    }
  }
}