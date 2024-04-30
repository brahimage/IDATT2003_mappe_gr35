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
  // The transformation used to convert coordinates to indices.
  private AffineTransform2D transformCoordsToIndices;

  /**
   * Constructs a new ChaosCanvas with the specified width, height, minimum coordinates, and maximum coordinates.
   *
   * @param width the width of the canvas.
   * @param height the height of the canvas.
   * @param minCoords the minimum coordinates of the canvas.
   * @param maxCoords the maximum coordinates of the canvas.
   */
  public ChaosCanvas(int width, int height, Vector2D minCoords, Vector2D maxCoords) {
    // Calculate the transformation matrix and translation vector.
    Matrix2x2 A = new Matrix2x2(
        0,
        (height - 1) / (minCoords.getx1() - maxCoords.getx1()),
        (width - 1) / (maxCoords.getx0() - minCoords.getx0()),
        0
    );
    Vector2D b = new Vector2D(
        ((height - 1) * maxCoords.getx1()) / (maxCoords.getx1() - minCoords.getx1()),
        ((width - 1) * minCoords.getx0()) / (minCoords.getx0() - maxCoords.getx0())
    );
    // Set the fields.
    this.width = width;
    this.height = height;
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;
    this.transformCoordsToIndices = new AffineTransform2D(A, b);
    this.canvas = new int[height][width];
  }

  /**
   * Returns the width of the canvas.
   *
   * @return the width.
   */
  public int getPixel(Vector2D point) {
    int x0 = (int) point.getx0();
    int x1 = (int) point.getx1();
    return canvas[x0][x1];
  }

  /**
   * Sets the pixel at the specified point to 1.
   *
   * @param point the point.
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
   * @return the canvas array.
   */
  public int[][] getCanvasArray() {
    return canvas;
  }

  /**
   * Clears the canvas. Sets all elements to 0.
   */
  public void clear() {
    canvas = new int[height][width];
  }

  /**
   * Prints the canvas to the console.
   */
  public void printCanvas() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(canvas[i][j] == 1 ? "*" : " ");
      }
      System.out.println();
    }
  }
}
