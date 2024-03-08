package edu.ntnu.stud.idatt2003.gr35.model.transformations;

import edu.ntnu.stud.idatt2003.gr35.model.math.Complex;
import edu.ntnu.stud.idatt2003.gr35.model.math.Sign;
import edu.ntnu.stud.idatt2003.gr35.model.math.Vector2D;
import java.io.Serializable;

/**
 * Represents a 2D transformation known as the Julia transformation, implementing the {@link Transform2D} interface.
 * This transformation applies a mathematical operation to each point in a 2D vector.
 */
public class JuliaTransform implements Transform2D, Serializable {
  // The serial version UID.
  private static final long serialVersionUID = 2L;
  /**
   * The complex number used in the transformation.
   */
  private Complex point;
  /**
   * The sign used in the transformation.
   */
  private Sign sign;

  public JuliaTransform (Complex point, Sign sign) {
    this.point = point;
    this.sign = sign;
  }

  /**
   * Transforms the specified 2D vector using the Julia transformation.
   *
   * @param point the 2D vector to be transformed.
   * @return the transformed 2D vector.
   */
  @Override
  public Vector2D transform(Vector2D point) {
    //Convert input Vector2D to Complex.
    Complex in = new Complex(point.getx0(), point.getx1());
    //Perform Julia transformation.
    Complex result = in.subtract(this.point).complexSqrt().multiply(sign.getValue());
    //Return result as Vector2D.
    return new Vector2D(result.getx0(), result.getx1());
  }
}