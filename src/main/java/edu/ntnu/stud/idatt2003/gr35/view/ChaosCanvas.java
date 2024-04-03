package edu.ntnu.stud.idatt2003.gr35.view;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;

/**
 * Represents a canvas for drawing points in a 2D plane.
 */
public class ChaosCanvas {

  private int[][] canvas;
  private final int width;
  private final int height;
  private final Vector2D maxCoords;
  private final Vector2D minCoords;
  private final AffineTransform2D transformCoordsToIndices;

  public ChaosCanvas(int width, int height, Vector2D maxCoords, Vector2D minCoords) {
    this.width = width;
    this.height = height;
    this.maxCoords = maxCoords;
    this.minCoords = minCoords;
    this.transformCoordsToIndices = new AffineTransform2D(
        new Matrix2x2(
            0,
            (height - 1) / (minCoords.getx1() - maxCoords.getx1()),
            (width - 1) / (maxCoords.getx0() - minCoords.getx0()),
            0
        ),

        new Vector2D(
            ((height - 1) * maxCoords.getx1()) / (maxCoords.getx1() - minCoords.getx1()),
            ((width - 1) * minCoords.getx0()) / (minCoords.getx0() - maxCoords.getx0())
        )
    );

    this.canvas = new int[width][height];

  }

  /**
   * Returns the pixel value at the specified point.
   *
   * @param point the point to get the pixel value from.
   * @return Returns the pixel value at the specified point.
   */
  public int getPixel(Vector2D point) {
    int x0 = (int) point.getx0();
    int x1 = (int) point.getx1();
    return canvas[x0][x1];
  }

  /**
   * Puts a pixel at the specified point.
   *
   * @param point the point to put the pixel at.
   */
  public void putPixel(Vector2D point) {
    int x0 = (int) point.getx0();
    int x1 = (int) point.getx1();
    canvas[x0][x1] = 1;
  }

  /**
   * Returns the canvas as a 2D array.
   *
   * @return Returns the canvas as a 2D array.
   */
  public int[][] getCanvasArray() {
    return canvas;
  }

  /**
   * Clears the canvas.
   */
  public void clear() {
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        canvas[i][j] = 0;
      }
    }
  }

  /**
   * Transforms the canvas to a 2D array.
   *
   * @return Returns the transformed canvas as a 2D array.
   */
  public int[][] transformedCanvas() {
    int[][] transformedCanvas = new int[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Vector2D point = transformCoordsToIndices.transform(new Vector2D(i, j));
        transformedCanvas[i][j] = getPixel(point);
      }
    }
    return transformedCanvas;
  }

  /**
   * Prints the canvas to the console.
   */
  public void printCanvas() {
    int[][] canvas = transformedCanvas();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(canvas[j][i] == 1 ? " * " : "   ");
      }
      System.out.println();
    }
  }
}
