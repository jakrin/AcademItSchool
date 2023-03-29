package ru.academits.shpitaleva.matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 4);
        Matrix matrix2 = new Matrix(new double[][]{{3, 2, 1}, {12, 4, 8}});

        matrix2.toPrintMatrix();
        matrix2.transposeMatrix().toPrintMatrix();
    }
}
