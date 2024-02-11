package edu.ntnu.stud.idatt2003.gr25;

public class Complex extends Vector2D {

    private double realPart;
    private double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        super(realPart, imaginaryPart);
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex sqrt() {
        double x0 = Math.sqrt(realPart);
        double x1 = Math.sqrt(imaginaryPart);
        return new Complex(x0, x1);
    }
}
