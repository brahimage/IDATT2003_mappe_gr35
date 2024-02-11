package edu.ntnu.stud.idatt2003.gr25;

/**
 * Represents a 2D transformation, which is utilized by various transformations to generate fractals.
 * Implementations of this interface define operations for transforming 2D vectors.
 */
public interface Transform2D {
  /**
   * Applies the transformation to the specified 2D vector.
   *
   * @param point the 2D vector to be transformed.
   * @return the transformed 2D vector.
   */
  public Vector2D transform(Vector2D point);
}