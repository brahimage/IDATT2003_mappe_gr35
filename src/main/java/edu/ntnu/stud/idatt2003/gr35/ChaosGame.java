package edu.ntnu.stud.idatt2003.gr35;

import edu.ntnu.stud.idatt2003.gr35.model.gameLogic.ChaosGameDescription;
import edu.ntnu.stud.idatt2003.gr35.view.ChaosCanvas;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import java.util.Random;

/**
 * Represents a chaos game that can be run with a specified number of steps.
 */
public class ChaosGame {

  private final ChaosCanvas canvas;
  private final ChaosGameDescription gameDescription;
  private final Vector2D currentPoint;
  private final Random rand;

  public ChaosGame(ChaosGameDescription gameDescription, int width, int height) {
    this.gameDescription = gameDescription;
    this.canvas = new ChaosCanvas(width, height, gameDescription.getMincoords(),
        gameDescription.getMaxcoords());
    this.currentPoint = new Vector2D(0, 0);
    this.rand = new Random();
  }

  /**
   * Returns the canvas of the chaos game.
   *
   * @return Returns the canvas of the chaos game.
   */
  public ChaosCanvas getCanvas() {
    return canvas;
  }

  /**
   * Initializes the chaos game by clearing the canvas and setting the current point to (0, 0).
   */
  public void init() {
    canvas.clear();
    currentPoint.setx0(0);
    currentPoint.setx1(0);
  }

  /**
   * Runs the ChaosGame with the specified number of steps.
   *
   * @param steps the number of steps to run the chaos game for.
   */
  public void runSteps(int steps) {

    init();

    // Get the number of transforms in the game description to use for random index generation.
    int nrOfTransforms = gameDescription.getTransforms().size();

    for (int i = 0; i < steps; i++) {
      int randomIndex = rand.nextInt(nrOfTransforms);
      Vector2D newPoint = gameDescription.getTransforms().get(randomIndex).transform(currentPoint);
      canvas.putPixel(newPoint);
      currentPoint.setx0(newPoint.getx0());
      currentPoint.setx1(newPoint.getx1());
    }
  }
}
