package ru.academits.shpitaleva.shapes;

public class Square implements Shapes, Comparable<Shapes> {
    private static final String shapeType = "square";

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
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
        return shapeType + ", length of the side: " + sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Square square = (Square) o;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }
}
