package edu.ntnu.stud.idatt2003.gr35.view;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;

import static java.lang.Math.abs;

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
  // Scaler values used to transform coordinates to indices.
  private double horizontalScaler;
  private double verticalScaler;

  /**
   * Constructs a ChaosCanvas object with the specified width, height, minimum coordinates, and maximum coordinates.
   *
   * @param width The width of the canvas.
   * @param height The height of the canvas.
   * @param minCoords The minimum coordinates of the canvas.
   * @param maxCoords The maximum coordinates of the canvas.
   */
  public ChaosCanvas(int width, int height, Vector2D minCoords, Vector2D maxCoords) {
    // Set the fields.
    this.width = width;
    this.height = height;
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;
    this.horizontalScaler = (width - 1) / abs(maxCoords.getx0() - minCoords.getx0());
    this.verticalScaler = (height - 1) / abs(maxCoords.getx1() - minCoords.getx1());
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

  public Vector2D transformCoordsToIndices(Vector2D point) {
    double x0 = (point.getx0() + abs(minCoords.getx0())) * horizontalScaler;
    double x1 = (point.getx1() + abs(minCoords.getx1())) * verticalScaler;
    return new Vector2D(x0, x1);
  }

  /**
   * Puts a pixel at the specified point (sets value to 1).
   *
   * @param point The point to put the pixel at.
   * @return The index of the pixel in the canvas array.
   */
  public Vector2D putPixel(Vector2D point) {
    Vector2D v = transformCoordsToIndices(point);
    if (verifyIndices(v)) {
      int x0 = (int) v.getx0();
      int x1 = (int) v.getx1();
      canvas[x0][x1] = 1;
      return new Vector2D(x0, x1);
    } else {
      return new Vector2D(-1, -1);
    }
  }

  public boolean verifyIndices(Vector2D pos) {
    return pos.getx0() >= 0 && pos.getx0() < width && pos.getx1() >= 0 && pos.getx1() < height;
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
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        System.out.print(canvas[i][j] == 1 ? "*" : " ");
      }
      System.out.println();
    }
  }
}
