package ru.academits.shpitaleva.matrix;

public class Matrix {
    private final Vector[] vectors;
    private final int matrixWidth;
    private final int matrixHeight;

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

        for (double[] doubles : twoDimensionalArray) {
            if (maxVectorSize < doubles.length) {
                maxVectorSize = doubles.length;
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
        for (Vector vector : vectorsArray) {
            if (maxVectorSize < vector.getSize()) {
                maxVectorSize = vector.getSize();
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

    public Vector getVectorByIndex(int vectorIndex) {
        if (vectorIndex < 0 || vectorIndex >= vectors.length) {
            throw new IllegalArgumentException("Vector index should be greater than 0 and less than vectors amount. Vector index is: " + vectorIndex);
        }

        return vectors[vectorIndex];
    }

    public Vector getColumnVectorByIndex(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= vectors[0].getSize()) {
            throw new IllegalArgumentException("Column index should be greater than 0 and less than vector's length. Column index is: " + columnIndex);
        }

        Vector column = new Vector(vectors.length);

        for (int i = 0; i < vectors.length; i++) {
            column.setComponent(i, vectors[i].getComponent(columnIndex));
        }

        return column;
    }

    public void setColumnVectorByIndex(int columnIndex, Vector columnVector) {
        if (columnIndex < 0 || columnIndex >= vectors[0].getSize()) {
            throw new IllegalArgumentException("Column index should be greater than 0 and less than vector's length. Column index is: " + columnIndex);
        }

        for (int i = 0; i < vectors.length; i++) {
            vectors[i].setComponent(columnIndex, columnVector.getComponent(i));
        }
    }

    public Matrix transposeMatrix() {
        Matrix transposedMatrix = new Matrix(matrixWidth, matrixHeight);

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixHeight; j++) {
                transposedMatrix.vectors[i].setComponent(j, this.getColumnVectorByIndex(i).getComponent(j));
            }
        }

        return transposedMatrix;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector vector : vectors) {
            vector.multiply(scalar);
        }
    }

    public void toPrintMatrix() {
        System.out.println();

        for (Vector vector : vectors) {
            System.out.println(vector.toString());
        }

        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Vector vector : vectors) {
            stringBuilder.append(vector).append(",");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public Matrix removeVectorAndColumnForSquareMatrix(int vectorIndex, int columnIndex) {
        if (matrixHeight != matrixWidth) {
            throw new IllegalArgumentException("The matrix must be square.");
        }

        if (matrixHeight <= 1) {
            throw new IllegalArgumentException("The matrix dimension must be greater than 1.");
        }

        if (vectorIndex > matrixHeight || columnIndex > matrixWidth) {
            throw new IllegalArgumentException("Incorrect index.");
        }

        int n = matrixHeight - 1;
        Matrix removedVectorMatrix = new Matrix(n, matrixWidth);
        int index = 0;

        for (int i = 0; i < matrixHeight; i++) {
            if (i != vectorIndex) {
                removedVectorMatrix.setVectorByIndex(index, this.getVectorByIndex(i));
                index++;
            }
        }

        Matrix resultMatrix = new Matrix(n, n);
        index = 0;

        for (int j = 0; j < matrixHeight; j++) {
            if (j != columnIndex) {
                resultMatrix.setColumnVectorByIndex(index, removedVectorMatrix.getColumnVectorByIndex(j));
                index++;
            }
        }

        return resultMatrix;
    }

    public double calculateDeterminant() {
        if (matrixHeight != matrixWidth) {
            throw new IllegalArgumentException("The matrix must be square.");
        }

        int n = matrixHeight;

        if (n == 1) {
            return this.getVectorByIndex(0).getComponent(0);
        }

        double result = 0;
        int l = 1;

        for (int i = 0; i < n; ++i) {
            Matrix minor = this.removeVectorAndColumnForSquareMatrix(0, i);
            result += l * this.getVectorByIndex(0).getComponent(i) * minor.calculateDeterminant();
            l *= (-1);
        }

        return result;
    }

    public Vector multiplyByVector(Vector vector) {
        if (vector.getSize() != matrixWidth) {
            throw new IllegalArgumentException("The matrix width must be equal to the vector length.");
        }

        Vector resultVector = new Vector(matrixHeight);
        double resultComponent = 0;

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                resultComponent += vectors[i].getComponent(j) * vector.getComponent(j);
            }

            resultVector.setComponent(i, resultComponent);
            resultComponent = 0;
        }

        return resultVector;
    }

    public void addMatrix(Matrix matrix) {
        if (matrix.getMatrixSize()[0] != matrixHeight || matrix.getMatrixSize()[1] != matrixWidth) {
            throw new IllegalArgumentException("The matrix must have the same dimensions as the initial matrix.");
        }

        Vector resultVector = new Vector(matrixWidth);

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                resultVector.setComponent(j, this.getVectorByIndex(i).getComponent(j) + matrix.getVectorByIndex(i).getComponent(j));
            }

            this.setVectorByIndex(i, resultVector);
        }
    }

    public void subtractMatrix(Matrix matrix) {
        if (matrix.getMatrixSize()[0] != matrixHeight || matrix.getMatrixSize()[1] != matrixWidth) {
            throw new IllegalArgumentException("The matrix must have the same dimensions as the initial matrix.");
        }

        Vector resultVector = new Vector(matrixWidth);

        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                resultVector.setComponent(j, this.getVectorByIndex(i).getComponent(j) - matrix.getVectorByIndex(i).getComponent(j));
            }

            this.setVectorByIndex(i, resultVector);
        }
    }

    public static Matrix matrixSubtraction(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getMatrixSize()[0] != matrix2.getMatrixSize()[0] || matrix1.getMatrixSize()[1] != matrix2.getMatrixSize()[1]) {
            throw new IllegalArgumentException("Both matrix must have the same dimensions.");
        }

        int n = matrix1.getMatrixSize()[0];
        int m = matrix1.getMatrixSize()[1];

        Matrix resultMatrix = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix.vectors[i].setComponent(j, matrix1.getVectorByIndex(i).getComponent(j) - matrix2.getVectorByIndex(i).getComponent(j));
            }
        }

        return resultMatrix;
    }

    public static Matrix matrixAddition(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getMatrixSize()[0] != matrix2.getMatrixSize()[0] || matrix1.getMatrixSize()[1] != matrix2.getMatrixSize()[1]) {
            throw new IllegalArgumentException("Both matrix must have the same dimensions.");
        }

        int n = matrix1.getMatrixSize()[0];
        int m = matrix1.getMatrixSize()[1];

        Matrix resultMatrix = new Matrix(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix.vectors[i].setComponent(j, matrix1.getVectorByIndex(i).getComponent(j) + matrix2.getVectorByIndex(i).getComponent(j));
            }
        }

        return resultMatrix;
    }

    public static Matrix matrixMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getMatrixSize()[1] != matrix2.getMatrixSize()[0]) {
            throw new IllegalArgumentException("Matrix1 width must be equal to Matrix2 height.");
        }

        int n = matrix1.getMatrixSize()[0];
        int k = matrix2.getMatrixSize()[1];
        int m = matrix1.getMatrixSize()[1];

        Matrix resultMatrix = new Matrix(n, k);
        double resultComponent = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    resultComponent += matrix1.getVectorByIndex(i).getComponent(l) * matrix2.getColumnVectorByIndex(j).getComponent(l);
                }

                resultMatrix.vectors[i].setComponent(j, resultComponent);
                resultComponent = 0;
            }
        }

        return resultMatrix;
    }
}