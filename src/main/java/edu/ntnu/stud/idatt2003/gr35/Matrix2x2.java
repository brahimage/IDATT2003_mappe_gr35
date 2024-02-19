package edu.ntnu.stud.idatt2003.gr35;

public class Matrix2x2 {

    private double a00;
    private double a01;
    private double a10;
    private double a11;

    public Matrix2x2(double a00, double a01, double a10, double a11) {
        this.a00 = a00;
        this.a01 = a01;
        this.a10 = a10;
        this.a11 = a11;
    }

    public Vector2D multiply(Vector2D vector2d) {
        double x0 = a00 * vector2d.getx0() + a01 * vector2d.getx1();
        double x1 = a10 * vector2d.getx0() + a11 * vector2d.getx1();
        return new Vector2D(x0, x1);
    }

}
