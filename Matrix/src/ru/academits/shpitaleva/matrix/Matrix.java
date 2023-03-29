package ru.academits.shpitaleva.matrix;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;
    private int matrixWidth;
    private int matrixHeight;

    public Matrix(int n, int m) {
        vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(m);
        }

        matrixWidth = m;
        matrixHeight = n;
    }

    public Matrix(Matrix matrix) {
        vectors = new Vector[matrix.matrixHeight];

        for (int i = 0; i < matrix.vectors.length; i++) {
            vectors[i] = new Vector(matrix.vectors[i]);
        }

        matrixWidth = vectors[0].getSize();
        matrixHeight = vectors.length;
    }

    public Matrix(double[][] twoDimensionalArray) {
        vectors = new Vector[twoDimensionalArray.length];

        int maxVectorSize = 0;
        for (int j = 0; j < twoDimensionalArray.length; j++) {
            if (maxVectorSize < twoDimensionalArray[j].length) {
                maxVectorSize = twoDimensionalArray[j].length;
            }
        }

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            vectors[i] = new Vector(maxVectorSize, twoDimensionalArray[i]);
        }

        matrixWidth = maxVectorSize;
        matrixHeight = twoDimensionalArray.length;
    }

    public Matrix(Vector[] vectorsArray) {
        vectors = new Vector[vectorsArray.length];

        int maxVectorSize = 0;
        for (int j = 0; j < vectorsArray.length; j++) {
            if (maxVectorSize < vectorsArray[j].getSize()) {
                maxVectorSize = vectorsArray[j].getSize();
            }
        }

        for (int i = 0; i < vectorsArray.length; i++) {
            vectors[i] = new Vector(maxVectorSize, vectorsArray[i].getComponents());
        }

        matrixWidth = vectors[0].getSize();
        matrixHeight = vectors.length;
    }

    public int[] getMatrixSize() {
        return new int[]{vectors.length, vectors[0].getSize()};
    }

    public Vector getVector(int vectorIndex) {
        if (vectorIndex < 0 || vectorIndex >= vectors.length) {
            throw new IllegalArgumentException("Vector index should be greater than 0 and less than vectors amount. Vector index is: " + vectorIndex);
        }

        return vectors[vectorIndex];
    }

    public void setVectorByIndex(int vectorIndex, Vector newVector) {
        if (vectorIndex < 0 || vectorIndex >= vectors.length) {
            throw new IllegalArgumentException("Vector index should be greater than 0 and less than vectors amount. Vector index is: " + vectorIndex);
        }

        if (newVector.getSize() != vectors[vectorIndex].getSize()) {
            throw new IllegalArgumentException("New vector size is different from matrix dimension. New vector size is: " + newVector.getSize() + " Vector size should be " + vectors[vectorIndex].getSize());
        }

        for (int i = 0; i < matrixWidth; i++) {
            vectors[vectorIndex].setComponent(i, newVector.getComponent(i));
        }
    }

    public Vector getVectorByIndex(int vectorIndex){
        if (vectorIndex < 0 || vectorIndex >= vectors.length) {
            throw new IllegalArgumentException("Vector index should be greater than 0 and less than vectors amount. Vector index is: " + vectorIndex);
        }

        return vectors[vectorIndex];
    }

    public Vector getColumnVectorByIndex(int columnIndex){
        if (columnIndex < 0 || columnIndex >= vectors[0].getSize()) {
            throw new IllegalArgumentException("Column index should be greater than 0 and less than vector's length. Column index is: " + columnIndex);
        }

        Vector column = new Vector(vectors.length);

        for (int i = 0; i < vectors.length; i++) {
            column.setComponent(i, vectors[i].getComponent(columnIndex));
        }

        return column;
    }

    public Matrix transposeMatrix(){
        Matrix transposedMatrix = new Matrix(matrixHeight, matrixWidth);

        for (int i = 0; i < matrixWidth; i++){
            //transposedMatrix.setVectorByIndex(i, this.getColumnVectorByIndex(i));
            for (int j = 0; j < matrixHeight; j++) {
                vectors[i].setComponent(j, this.getColumnVectorByIndex(i).getComponent(j));
            }
        }

        return transposedMatrix;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < vectors.length; i++) {
            vectors[i].multiply(scalar);
        }
    }

    public void toPrintMatrix() {
        for (int i = 0; i < vectors.length; i++) {
            System.out.println(vectors[i].toString());
        }
    }
}
