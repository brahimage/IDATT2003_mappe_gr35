package edu.ntnu.stud.idatt2003.gr35.model.gameLogic;

import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import edu.ntnu.stud.idatt2003.gr35.model.transformations.Transform2D;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a description of a chaos game that can be serialized and deserialized.
 */
public class ChaosGameDescription implements Serializable {
  // The serial version UID.
  private static final long serialVersionUID = 1L;
  // The minimum coordinates of the chaos game visualization (top left corner).
  private Vector2D mincoords;
  // The maximum coordinates of the chaos game visualization (bottom right corner).
  private Vector2D maxcoords;
  // The list of transformations that are part of the chaos game.
  private List<Transform2D> transforms;

  /**
   * Creates a new chaos game description with the specified minimum and maximum coordinates and
   * list of transformations.
   *
   * @param mincoords the minimum coordinates of the chaos game.
   * @param maxcoords the maximum coordinates of the chaos game.
   * @param transforms the list of transformations that are part of the chaos game.
   */
  public ChaosGameDescription(Vector2D mincoords, Vector2D maxcoords, List<Transform2D> transforms) {
    this.mincoords = mincoords;
    this.maxcoords = maxcoords;
    this.transforms = transforms;
  }

  /**
   * Returns the minimum coordinates of the chaos game.
   *
   * @return the minimum coordinates.
   */
  public Vector2D getMincoords() {
    return mincoords;
  }

  /**
   * Returns the maximum coordinates of the chaos game.
   *
   * @return the maximum coordinates.
   */
  public Vector2D getMaxcoords() {
    return maxcoords;
  }

  /**
   * Returns the list of transformations that are part of the chaos game.
   *
   * @return the list of transformations.
   */
  public List<Transform2D> getTransforms() {
    return transforms;
  }
}
