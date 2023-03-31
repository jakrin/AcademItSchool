package ru.academits.shpitaleva.matrix;

public class Main {
    public static void main(String[] args) {
        // Verify zero matrix constructor
        Matrix matrix1 = new Matrix(4, 4);
        matrix1.toPrintMatrix();
        System.out.println("Determinant: " + matrix1.calculateDeterminant());

        // Verify transposition method and determinant calculation
        System.out.println("------------");
        Matrix matrix2 = new Matrix(new double[][]{{3, 2, 1}, {12, 4, 8}, {7, 8, 9}});
        matrix2.toPrintMatrix();
        matrix2.transposeMatrix().toPrintMatrix();
        System.out.println("Determinant: " + matrix2.calculateDeterminant());

        Matrix matrix3 = new Matrix(new double[][]{{-3, 25}, {112, -84}});
        matrix3.toPrintMatrix();
        System.out.println("Determinant: " + matrix3.calculateDeterminant());

        Matrix matrix4 = new Matrix(1, 1);
        matrix4.setColumnVectorByIndex(0, new Vector(new double[]{5}));
        matrix4.toPrintMatrix();
        System.out.println("Determinant: " + matrix4.calculateDeterminant());

        // Verify toString method
        System.out.println("------------");
        System.out.println();
        System.out.println(matrix2.toString());
        System.out.println(matrix3.toString());

        // Verify multiplication by vector
        System.out.println("------------");
        Matrix matrix5 = new Matrix(new double[][]{{3, 2, -21, 5}, {12, 4, 8, -4}, {7, 8, 9, -3}});
        Vector vector1 = new Vector(new double[]{2, -7, 10, 15});
        matrix5.toPrintMatrix();
        System.out.println("Vector:");
        System.out.println(vector1.toString());
        System.out.println("Multiplication result: " + matrix5.multiplyByVector(vector1));

        // Verify matrix addition
        System.out.println("------------");
        Matrix matrix6 = new Matrix(new double[][]{{-3, 2}, {1, -14}});
        matrix6.toPrintMatrix();
        Matrix matrix7 = new Matrix(new double[][]{{0, 25}, {10, -9}});
        matrix7.toPrintMatrix();
        System.out.println("Static addition method result:");
        Matrix.matrixAddition(matrix6, matrix7).toPrintMatrix();
        System.out.println("Addition result:");
        matrix6.addMatrix(matrix7);
        matrix6.toPrintMatrix();

        // Verify matrix subtraction
        System.out.println("------------");
        Matrix matrix8 = new Matrix(new double[][]{{-31, 20}, {10, 14}});
        matrix8.toPrintMatrix();
        Matrix matrix9 = new Matrix(new double[][]{{-11, 15}, {10, -9}});
        matrix9.toPrintMatrix();
        System.out.println("Static subtraction method result:");
        Matrix.matrixSubtraction(matrix8, matrix9).toPrintMatrix();
        System.out.println("Subtraction result:");
        matrix8.subtractMatrix(matrix9);
        matrix8.toPrintMatrix();

        // Verify matrix multiplication
        System.out.println("------------");
        Matrix matrix10 = new Matrix(new double[][]{{2, 1}, {-3, 0}, {4, -1}});
        matrix10.toPrintMatrix();
        Matrix matrix11 = new Matrix(new double[][]{{5, -1, 6}, {-3, 0, 7}});
        matrix11.toPrintMatrix();
        System.out.println("Multiplication result:");
        Matrix.matrixMultiplication(matrix10, matrix11).toPrintMatrix();
    }
}
