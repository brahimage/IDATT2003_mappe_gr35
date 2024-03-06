package edu.ntnu.stud.idatt2003.gr35.model.math;


/**
 * Class rerepsenting a two-dimensional vector.
 */
public class Vector2D {
    final private double x0;
    final private double x1;


    /**
     * Constructor for the Vector2D class.
     *
     * @param x0 First element of the vector.
     * @param x1 Second element of the vector.
     */
    public Vector2D(double x0, double x1) {
        this.x0 = x0;
        this.x1 = x1;
    }

    /**
     * Gets the first element of the vector.
     *
     * @return Returns x0, the first element of the vector.
     */

    public double getx0() {
        return x0;
    }

    /**
     * Gets the second element of the vector.
     *
     * @return Returns x1, the second element of the vector.
     */

    public double getx1() {
        return x1;
    }

    /**
     * Adds the specified vector to this vector.
     *
     * @param other The vector to be added to this vector.
     * @return Returns a new vector representing the sum of this vector and the specified vector.
     */

    public Vector2D add(Vector2D other) {
        double x0 = this.x0 + other.getx0();
        double x1 = this.x1 + other.getx1();
        return new Vector2D(x0, x1);
    }

    /**
     * Subtracts the specified vector from this vector.
     *
     * @param other The vector to be subtracted from this vector.
     * @return Returns a new vector representing the difference between this vector and the specified vector.
     */
    public Vector2D substract(Vector2D other) {
        double x0 = this.x0 - other.getx0();
        double x1 = this.x1 - other.getx1();
        return new Vector2D(x0, x1);
    }
}
