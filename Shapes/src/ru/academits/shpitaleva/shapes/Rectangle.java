package ru.academits.shpitaleva.shapes;

public class Rectangle implements Shape {
    private static final String SHAPE_TYPE = "rectangle";

    private final double side1Length;
    private final double side2Length;

    public Rectangle(double side1Length, double side2Length) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
    }

    @Override
    public double getWidth() {
        return side1Length;
    }

    @Override
    public double getHeight() {
        return side2Length;
    }

    @Override
    public double getArea() {
        return side1Length * side2Length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1Length + side2Length);
    }

    @Override
    public String getShapeType() {
        return SHAPE_TYPE;
    }

    @Override
    public String toString() {
        return SHAPE_TYPE + ", length of the side 1: " + side1Length + ", length of the side 2: " + side2Length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return side1Length == rectangle.side1Length && side2Length == rectangle.side2Length;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(side1Length);
        hash = prime * hash + Double.hashCode(side2Length);

        return hash;
    }
}
