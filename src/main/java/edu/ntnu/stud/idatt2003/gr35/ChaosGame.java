package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescription;
import edu.ntnu.stud.idatt2003.gr35.view.ChaosCanvas;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import java.util.Random;
import java.util.Vector;

public class ChaosGame {

  private final ChaosCanvas canvas;
  private final ChaosGameDescription description;
  private final Vector2D currentPoint;
  Random random = new Random();

  public ChaosGame(ChaosGameDescription description, int width, int height) {
    this.description = description;
    this.canvas = new ChaosCanvas(width, height, description.getMincoords(), description.getMaxcoords());
    this.currentPoint = new Vector2D(0, 0);
  }

  /**
   * Returns the canvas of the chaos game.
   * @return Returns the canvas of the chaos game.
   */
  public ChaosCanvas getCanvas() {
    return canvas;
  }

  /**
   * Runs the ChaosGame with the specified number of steps.
   *
   * @param steps the number of steps to run the chaos game for.
   */
  public void runSteps(int steps) {
    Vector<Vector2D> points = new Vector<>();
    for (int i = 0; i < description.getTransforms().size(); i++) {
      points.add(new Vector2D(0, 0));
    }
    for (int i = 0; i < steps; i++) {
      int randomIndex = random.nextInt(description.getTransforms().size());
      Vector2D newPoint = description.getTransforms().get(randomIndex).transform(currentPoint);
      canvas.putPixel(newPoint);
      currentPoint.setx0(newPoint.getx0());
      currentPoint.setx1(newPoint.getx1());
    }
    //canvas.putPixel(new Vector2D(5,5));
    //canvas.printCanvas();
  }
}
