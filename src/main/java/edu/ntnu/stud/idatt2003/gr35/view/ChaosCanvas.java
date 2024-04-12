package edu.ntnu.stud.idatt2003.gr35.view;

import edu.ntnu.stud.idatt2003.gr35.model.math.Matrix2x2;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.AffineTransform2D;

/**
 * Represents a canvas for drawing points in a 2D plane.
 */
public class ChaosCanvas {

  private int[][] canvas;
  private int width;
  private int height;
  private Vector2D minCoords;
  private Vector2D maxCoords;
  private AffineTransform2D transformCoordsToIndices;

  public ChaosCanvas(int width, int height, Vector2D minCoords, Vector2D maxCoords) {

    Matrix2x2 A = new Matrix2x2(
        0,
        (width - 1) / (minCoords.getx1() - maxCoords.getx1()),
        (height - 1) / (maxCoords.getx0() - minCoords.getx0()),
        0
    );

    Vector2D b = new Vector2D(
        ((width - 1) * maxCoords.getx1()) / (maxCoords.getx1() - minCoords.getx1()),
        ((height - 1) * minCoords.getx0()) / (minCoords.getx0() - maxCoords.getx0())
    );

    this.width = width;
    this.height = height;
    this.minCoords = minCoords;
    this.maxCoords = maxCoords;
    this.transformCoordsToIndices = new AffineTransform2D(A, b);
    this.canvas = new int[width][height];
  }

  public int getPixel(Vector2D point) {
    int x0 = (int) point.getx0();
    int x1 = (int) point.getx1();
    return canvas[x0][x1];
  }

  public void putPixel(Vector2D point) {

    Vector2D v = transformCoordsToIndices.transform(point);

    int x0 = (int) v.getx0();
    int x1 = (int) v.getx1();
    canvas[x0][x1] = 1;
  }

  public int[][] getCanvasArray() {
    return canvas;
  }

  public void clear() {
    canvas = new int[width][height];
  }

  public void printCanvas() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(canvas[j][i] == 1 ? "*" : " ");
      }
      System.out.println();
    }
  }
}
