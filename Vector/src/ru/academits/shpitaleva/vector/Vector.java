package ru.academits.shpitaleva.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Vector size should be greater than 0");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Vector size should be greater than 0");
        }

        components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(int vectorSize, double[] components) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Vector size should be greater than 0");
        }

        this.components = Arrays.copyOf(components, vectorSize);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder vectorString = new StringBuilder("{");

        for (int i = 0; i < components.length; i++) {
            if (i != components.length - 1) {
                vectorString.append(components[i]).append(", ");
            } else {
                vectorString.append(components[i]);
            }
        }

        vectorString.append("}");
        return vectorString.toString();
    }

    public void add(Vector vector) {
        if (components.length < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());

            for (int i = 0; i < components.length; i++) {
                components[i] = components[i] + vector.components[i];
            }
        } else {
            for (int i = 0; i < vector.getSize(); i++) {
                components[i] = components[i] + vector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());

            for (int i = 0; i < components.length; i++) {
                components[i] = components[i] - vector.components[i];
            }
        } else {
            for (int i = 0; i < vector.getSize(); i++) {
                components[i] = components[i] - vector.components[i];
            }
        }
    }

    public void multiply(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] = components[i] * scalar;
        }
    }

    public void rotate() {
        multiply(-1.0);
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (getSize() != vector.getSize()) {
            return false;
        }

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.add(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.subtract(vector2);

        return resultVector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minVectorSize = vector1.getSize();

        if (minVectorSize > vector2.getSize()) {
            minVectorSize = vector2.getSize();
        }

        for (int i = 0; i < minVectorSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}