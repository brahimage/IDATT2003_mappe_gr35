package edu.ntnu.stud.idatt2003.gr35;

/**
 * Represents a 2D affine transformation that implements the {@link Transform2D} interface.
 * This transformation applies a linear transformation represented by a 2x2 matrix, followed by a translation
 * represented by a 2D vector.
 */
public class AffineTransform2D implements Transform2D {

  /**
   * The 2x2 matrix representing the linear transformation.
   */
  private Matrix2x2 matrix;
  /**
   * The 2D vector representing the translation.
   */
  private Vector2D vector;

  /**
   * Constructs an AffineTransform2D object with the specified matrix and vector.
   *
   * @param matrix_in the 2x2 matrix representing the linear transformation.
   * @param vector_in the 2D vector representing the translation.
   */
  AffineTransform2D (Matrix2x2 matrix_in, Vector2D vector_in) {
    matrix = matrix_in;
    vector = vector_in;
  }

  /**
   * Transforms the specified 2D vector using this affine transformation.
   *
   * @param point the 2D vector to be transformed.
   * @return the transformed 2D vector.
   */
  @Override
  public Vector2D transform(Vector2D point) {
    // Apply the linear transformation followed by the translation
    return matrix.multiply(point).add(vector);
  }
}