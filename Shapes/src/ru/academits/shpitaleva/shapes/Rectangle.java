package ru.academits.shpitaleva.shapes;

public class Rectangle implements Shape {
    private static final String SHAPE_TYPE = "rectangle";

    private final double widthLength;
    private final double heightLength;

    public Rectangle(double widthLength, double heightLength) {
        this.widthLength = widthLength;
        this.heightLength = heightLength;
    }

    @Override
    public double getWidth() {
        return widthLength;
    }

    @Override
    public double getHeight() {
        return heightLength;
    }

    @Override
    public double getArea() {
        return widthLength * heightLength;
    }

    @Override
    public double getPerimeter() {
        return 2 * (widthLength + heightLength);
    }

    @Override
    public String getShapeType() {
        return SHAPE_TYPE;
    }

    @Override
    public String toString() {
        return SHAPE_TYPE + ", length of the side 1: " + widthLength + ", length of the side 2: " + heightLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return widthLength == rectangle.widthLength && heightLength == rectangle.heightLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(widthLength);
        hash = prime * hash + Double.hashCode(heightLength);

        return hash;
    }
}
