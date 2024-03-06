package edu.ntnu.stud.idatt2003.gr35.model.math;

/**
 * Class representing a complex number.
 */
public class Complex extends Vector2D {

  final private double realPart;
  final private double imagPart;

  /**
   * Constructor for the Complex class. Constructs a new complex number.
   *
   * @param realPart The real part of the complex number.
   * @param imagPart The imaginary part of the complex number.
   */
  public Complex(double realPart, double imagPart) {
    super(realPart, imagPart);
    this.realPart = realPart;
    this.imagPart = imagPart;
  }

  /**
   * Finds the root of a complex number.
   *
   * @return Returns the root of the complex number as a new complex number.
   */
  public Complex complexSqrt() {
    double real =
        Math.sqrt((0.5) * (Math.sqrt(Math.pow(realPart, 2) + Math.pow(imagPart, 2)) + realPart));
    double imag = Math.signum(imagPart) *
        Math.sqrt((0.5) * (Math.sqrt(Math.pow(realPart, 2) + Math.pow(imagPart, 2)) - realPart));

    return new Complex(real, imag);
  }

  /**
   * Adds the specified complex number to this complex number.
   *
   * @param in the complex number to be added to this complex number.
   * @return a new complex number representing the sum of this complex number and the specified complex number.
   */
  public Complex add(Complex in) {
    double real = realPart + in.realPart;
    double imag = imagPart + in.imagPart;
    return new Complex(real, imag);
  }

  /**
   * Subtracts the specified complex number from this complex number.
   *
   * @param in the complex number to be subtracted from this complex number.
   * @return a new complex number representing the difference between this complex number and the specified complex number.
   */
  public Complex subtract(Complex in) {
    double real = realPart - in.realPart;
    double imag = imagPart - in.imagPart;
    return new Complex(real, imag);
  }

  /**
   * Multiplies this complex number by the specified scalar value.
   *
   * @param scaler the scalar value to multiply this complex number by.
   * @return a new complex number representing the product of this complex number and the specified scalar value.
   */
  public Complex multiply(float scaler) {
    double real = realPart * scaler;
    double imag = imagPart * scaler;
    return new Complex(real, imag);
  }
}
