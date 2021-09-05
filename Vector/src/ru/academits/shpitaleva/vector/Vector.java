package ru.academits.shpitaleva.vector;

import java.math.BigDecimal;
import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(double[] components) {
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int n) {
        if (n > 0) {
            components = new double[n];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(int n, double[] components) {
        if (n > 0) {
            this.components = new double[n];
            System.arraycopy(components,0, this.components, 0, components.length);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getSize() {
        return components.length;
    }

    public String toString() {
        String vectorToString = "{";

        for(int i = 0; i < components.length; i++) {
            if (i != components.length - 1) {
                vectorToString += components[i] + ", ";
            } else {
                vectorToString += components[i];
            }
        }

        vectorToString += "}";
        return vectorToString;
    }

    public Vector add(Vector vector) {
        int resultVectorDimension = getSize();
        int minDimension;

        Vector resultVector;

        if (getSize() == vector.getSize()) {
            resultVector = new Vector(resultVectorDimension);

            for (int i = 0; i < resultVectorDimension; i++) {
                resultVector.components[i] = components[i] + vector.components[i];
            }
        } else if (getSize() > vector.getSize()) {
            resultVector = new Vector(resultVectorDimension);

            minDimension = vector.getSize();

            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = components[i] + vector.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = components[j];
            }
        } else {
            resultVectorDimension = vector.getSize();
            resultVector = new Vector(resultVectorDimension);

            minDimension = getSize();
            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = components[i] + vector.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = vector.components[j];
            }
        }

        return resultVector;
    }

    public Vector sub(Vector vector) {
        int resultVectorDimension = 1;
        int minDimension;

        Vector resultVector;

        if (this.getSize() == vector.getSize()) {
            resultVectorDimension = this.getSize();
            resultVector = new Vector(resultVectorDimension);

            for (int i = 0; i < resultVectorDimension; i++) {
                resultVector.components[i] = this.components[i] - vector.components[i];
            }
        } else if (this.getSize() > vector.getSize()) {
            resultVectorDimension = this.getSize();
            resultVector = new Vector(resultVectorDimension);

            minDimension = vector.getSize();

            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = this.components[i] - vector.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = this.components[j];
            }
        } else {
            resultVectorDimension = vector.getSize();
            resultVector = new Vector(resultVectorDimension);

            minDimension = this.getSize();
            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = this.components[i] - vector.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = - vector.components[j];
            }
        }

        return resultVector;
    }

    public Vector mult(double scalar) {
        Vector resultVector = new Vector(getSize());

        for (int i = 0; i < getSize(); i++) {
            resultVector.components[i] = components[i] * scalar;
        }

        return resultVector;
    }

    public Vector rotation() {
        return mult(-1.0);
    }

    public int getLength() {
        return components.length;
    }

    public double getComponent(int index) {
        return components[index - 1];
    }

    public void setComponent(int index, double component) {
        components[index - 1] = component;
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

        for (int i = 0; i < getSize(); i++) {
            if (components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        for (int i = 0; i < getSize(); i++) {
            hash = prime * hash + Double.hashCode(components[i]);
        }

        return hash;
    }

    public static Vector addition(Vector vector1, Vector vector2) {
        int resultVectorDimension = vector1.getSize();
        int minDimension;

        Vector resultVector;

        if (vector1.getSize() == vector2.getSize()) {
            resultVector = new Vector(resultVectorDimension);

            for (int i = 0; i < resultVectorDimension; i++) {
                resultVector.components[i] = vector1.components[i] + vector2.components[i];
            }
        } else if (vector1.getSize() > vector2.getSize()) {
            resultVector = new Vector(resultVectorDimension);

            minDimension = vector2.getSize();

            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = vector1.components[i] + vector2.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = vector1.components[j];
            }
        } else {
            resultVectorDimension = vector2.getSize();
            resultVector = new Vector(resultVectorDimension);

            minDimension = vector1.getSize();
            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = vector1.components[i] + vector2.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = vector2.components[j];
            }
        }

        return resultVector;
    }

    public static Vector subtraction(Vector vector1, Vector vector2) {
        int resultVectorDimension = vector1.getSize();
        int minDimension;

        Vector resultVector;

        if (vector1.getSize() == vector2.getSize()) {
            resultVector = new Vector(resultVectorDimension);

            for (int i = 0; i < resultVectorDimension; i++) {
                resultVector.components[i] = vector1.components[i] - vector2.components[i];
            }
        } else if (vector1.getSize() > vector2.getSize()) {
            resultVector = new Vector(resultVectorDimension);

            minDimension = vector2.getSize();

            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = vector1.components[i] - vector2.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = vector1.components[j];
            }
        } else {
            resultVectorDimension = vector2.getSize();
            resultVector = new Vector(resultVectorDimension);

            minDimension = vector1.getSize();
            for (int i = 0; i < minDimension; i++) {
                resultVector.components[i] = vector1.components[i] - vector2.components[i];
            }
            for (int j = minDimension; j < resultVectorDimension; j++) {
                resultVector.components[j] = - vector2.components[j];
            }
        }

        return resultVector;
    }

    public static double scalarProduсt(Vector vector1, Vector vector2) {
        if (vector1.getSize() != vector2.getSize()) {
            throw new IllegalArgumentException();
        }

        double scalarProduсt = 0;

        for (int i = 0; i < vector1.getSize(); i++) {
            scalarProduсt += vector1.components[i] * vector2.components[i];
        }

        return scalarProduсt;
    }
}
