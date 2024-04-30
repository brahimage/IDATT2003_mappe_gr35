package edu.ntnu.stud.idatt2003.gr35.view;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;

/**
 * Represents a canvas for drawing points in a 2D plane.
 */
public class ChaosCanvas {
  // The canvas array. Each element is either 0 or 1.
  private int[][] canvas;
  // The width and height of the canvas.
  private int width;
  private int height;
  // The minimum and maximum coordinates of the canvas.
  private Vector2D minCoords;
  private Vector2D maxCoords;
  // The affine transformation that transforms coordinates to indices in the canvas array.
  private AffineTransform2D transformCoordsToIndices;

  /**
   * Constructs a ChaosCanvas object with the specified width, height, minimum coordinates, and maximum coordinates.
   *
   * @param width The width of the canvas.
   * @param height The height of the canvas.
   * @param minCoords The minimum coordinates of the canvas.
   * @param maxCoords The maximum coordinates of the canvas.
   */
  public ChaosCanvas(int width, int height, Vector2D minCoords, Vector2D maxCoords) {
    // Calculate the affine transformation matrix for the affine transformation.
    Matrix2x2 A = new Matrix2x2(
        0,
        (width - 1) / (minCoords.getx1() - maxCoords.getx1()),
        (height - 1) / (maxCoords.getx0() - minCoords.getx0()),
        0
    );
    // Calculate the translation vector for the affine transformation.
    Vector2D b = new Vector2D(
        ((width - 1) * maxCoords.getx1()) / (maxCoords.getx1() - minCoords.getx1()),
        ((height - 1) * minCoords.getx0()) / (minCoords.getx0() - maxCoords.getx0())
    );
    // Set the fields.
    this.width = width;
    this.height = height;
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;
    this.transformCoordsToIndices = new AffineTransform2D(A, b);
    this.canvas = new int[width][height];
  }

  /**
   * Returns the pixel value at the specified point.
   *
   * @param point The point to get the pixel value for.
   * @return The pixel value at the specified point (0 or 1).
   */
  public int getPixel(Vector2D point) {
    int x0 = (int) point.getx0();
    int x1 = (int) point.getx1();
    return canvas[x0][x1];
  }

  /**
   * Puts a pixel at the specified point (sets value to 1).
   *
   * @param point The point to put the pixel at.
   */
  public void putPixel(Vector2D point) {
    Vector2D v = transformCoordsToIndices.transform(point);
    int x0 = (int) v.getx0();
    int x1 = (int) v.getx1();
    canvas[x0][x1] = 1;
  }

  /**
   * Returns the canvas array.
   *
   * @return The canvas array.
   */
  public int[][] getCanvasArray() {
    return canvas;
  }

  /**
   * Clears the canvas (sets all values to 0).
   */
  public void clear() {
    canvas = new int[width][height];
  }

  /**
   * Prints the canvas to the console.
   */
  public void printCanvas() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(canvas[j][i] == 1 ? "*" : " ");
      }
      System.out.println();
    }
  }
}
