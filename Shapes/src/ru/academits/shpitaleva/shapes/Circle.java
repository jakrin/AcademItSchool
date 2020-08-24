package ru.academits.shpitaleva.shapes;

public class Circle implements Shapes, Comparable<Shapes> {
    private static final String shapeType = "circle";

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getShapeType() {
        return shapeType;
    }

    @Override
    public int compareTo(Shapes shapes) {
        return (int) (this.getArea() - shapes.getArea());
    }

    @Override
    public String toString() {
        return shapeType + ", radius: " + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }
}
