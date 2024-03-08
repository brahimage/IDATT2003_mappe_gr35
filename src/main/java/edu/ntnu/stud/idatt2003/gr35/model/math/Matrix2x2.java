package edu.ntnu.stud.idatt2003.gr35.model.math;

import java.io.Serializable;

public class Matrix2x2 implements Serializable {
    // The serial version UID.
    private static final long serialVersionUID = 2L;

    // The elements of the matrix
    private double a00;
    private double a01;
    private double a10;
    private double a11;

    /**
     * Constructor for the Matrix2x2 class.
     *
     * @param a00 The element in the first row and first column.
     * @param a01 The element in the first row and second column.
     * @param a10 The element in the second row and first column.
     * @param a11 The element in the second row and second column.
     */
    public Matrix2x2(double a00, double a01, double a10, double a11) {
        this.a00 = a00;
        this.a01 = a01;
        this.a10 = a10;
        this.a11 = a11;
    }

    /**
     * Method for calculating the determinant of the matrix.
     *¬
     * @param vector2d The vector to multiply with the matrix.
     * @return Returns the vector result of the multiplication.
     */
    public Vector2D multiply(Vector2D vector2d) {
        double x0 = a00 * vector2d.getx0() + a01 * vector2d.getx1();
        double x1 = a10 * vector2d.getx0() + a11 * vector2d.getx1();
        return new Vector2D(x0, x1);
    }
}
