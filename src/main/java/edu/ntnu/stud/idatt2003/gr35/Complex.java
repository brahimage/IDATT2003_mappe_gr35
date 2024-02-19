package edu.ntnu.stud.idatt2003.gr35;

public class Complex extends Vector2D {

    final private double real;
    final private double imag;

    public Complex(double realPart, double imaginaryPart) {
        super(realPart, imaginaryPart);
        real = realPart;
        imag = imaginaryPart;
    }

    public Complex complexSqrt() {
        double realPart = Math.sqrt((0.5) * (Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2)) + real));
        double imagPart = Math.signum(imag) * Math.sqrt((0.5) * (Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2)) - real));

        return new Complex(realPart, imagPart);
    }

    /**
     * Adds the specified complex number to this complex number.
     *
     * @param in the complex number to be added to this complex number.
     * @return a new complex number representing the sum of this complex number and the specified complex number.
     */
    public Complex add(Complex in) {
        double real = realPart + in.realPart;
        double imag = imaginaryPart + in.imaginaryPart;
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
        double imag = imaginaryPart - in.imaginaryPart;
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
        double imag = imaginaryPart * scaler;
        return new Complex(real, imag);
    }
}
