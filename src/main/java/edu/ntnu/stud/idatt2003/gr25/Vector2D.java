package edu.ntnu.stud.idatt2003.gr25;

public class Vector2D {
    private double x0;
    private double x1;

    public Vector2D(double x0, double x1) {
        this.x0 = x0;
        this.x1 = x1;
    }

    public double getx0() {
        return x0;
    }

    public double getx1() {
        return x1;
    }

    public Vector2D add(Vector2D other) {
        double x0 = this.x0 + other.getx0();
        double x1 = this.x1 + other.getx1();
        return new Vector2D(x0, x1);
    }

    public Vector2D substract(Vector2D other) {
        double x0 = this.x0 - other.getx0();
        double x1 = this.x1 - other.getx1();
        return new Vector2D(x0, x1);
    }
}
