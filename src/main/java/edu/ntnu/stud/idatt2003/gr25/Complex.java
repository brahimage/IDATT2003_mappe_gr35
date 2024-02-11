package edu.ntnu.stud.idatt2003.gr25;

public class Complex extends Vector2D {

    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        super(realPart, imaginaryPart);
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
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

    public Complex sqrt() {
        double x0 = Math.sqrt(realPart);
        double x1 = Math.sqrt(imaginaryPart);
        return new Complex(x0, x1);
    }
}
