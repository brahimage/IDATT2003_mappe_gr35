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
}
