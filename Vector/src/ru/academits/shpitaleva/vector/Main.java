package ru.academits.shpitaleva.vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(new double[]{1.0, 5.0, 6.0, 9.0, 23.0, 45.0, 3.0});
        Vector vector3 = new Vector(new double[]{11.0, 52.0, 6.4, 9.3});
        Vector vector4 = new Vector(new double[]{1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0});
        Vector vector5 = new Vector(5, new double[]{11.0, 52.0, 16.5, 9.3});
        Vector vector6 = new Vector(vector4);
        Vector vector7 = new Vector(new double[]{1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0});
        Vector vector8 = new Vector(new double[]{11.0, 52.0, 16.5, 9.3, 0.0, 0.0, 0.0});

        System.out.println("Vector6 is equal to vector4: " + vector6.equals(vector4));

        Vector additionResultVector = new Vector(new double[]{12.0, 57.0, 12.4, 18.3, 23.0, 45.0, 3.0});
        Vector staticAdditionResultVector = Vector.getSum(vector2, vector3);
        System.out.println("Static addition result vector is: " + staticAdditionResultVector + " Correct: " + additionResultVector.equals(staticAdditionResultVector));
        vector2.add(vector3);
        System.out.println("Addition result vector is: " + vector2.toString() + " Correct: " + additionResultVector.equals(vector2));

        Vector subtractionResultVector = new Vector(new double[]{-10.0, -47.0, -10.5, -8.3, 23.0, 45.0, 3.0});
        Vector staticSubtractionResultVector = Vector.getDifference(vector4, vector5);
        System.out.println("Static subtraction result vector is:" + staticSubtractionResultVector + " Correct: " + subtractionResultVector.equals(staticSubtractionResultVector));
        vector4.subtract(vector5);
        System.out.println("Subtraction result vector is:" + vector4.toString() + " Correct: " + subtractionResultVector.equals(vector4));

        Vector multiplicationResultVector = new Vector(new double[]{2.0, 10.0, 12.0, 2.0, 46.0, 90.0, 6.0});
        vector6.multiply(2.0);
        System.out.println("Multiplication result vector is:" + vector6.toString() + " Correct: " + multiplicationResultVector.equals(vector6));

        Vector rotationResultVector = new Vector(new double[]{-11.0, -52.0, -6.4, -9.3});
        vector3.rotate();
        System.out.println("Rotation result vector is:" + vector3.toString() + " Correct: " + rotationResultVector.equals(vector3));

        Vector setComponentResultVector = new Vector(new double[]{0.0, 0.0, 15.0, 0.0, 0.0});
        vector1.setComponent(2, 15.0);
        System.out.println("Set component result vector is:" + vector1.toString() + " Correct: " + setComponentResultVector.equals(vector1));

        System.out.println("Scalar product should be equal to 379.3" + " It's " + Vector.getScalarProduct(vector7, vector8));
    }
}
