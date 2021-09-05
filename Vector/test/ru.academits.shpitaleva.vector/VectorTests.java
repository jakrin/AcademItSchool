package ru.academits.shpitaleva.vector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VectorTests {
    @Test
    public void createVectorUsingArray() {
        double[] vectorElements = new double[] {1.0, 5.0, 6.0, 9.0, 23.0, 45.0, 3.0};
        Vector vector = new Vector(vectorElements);
        Assertions.assertEquals("{1.0, 5.0, 6.0, 9.0, 23.0, 45.0, 3.0}", vector.toString());
    }

    @Test
    public void createVectorUsingDimension() {
        Vector vector = new Vector(3);
        Assertions.assertEquals("{0.0, 0.0, 0.0}", vector.toString());
    }

    @Test
    public void createVectorUsingArrayAndDimension() {
        double[] vectorElements = new double[] {1.0, 5.0, 6.0, 9.0};
        int vectorDimension = 9;
        Vector vector = new Vector(vectorDimension, vectorElements);
        Assertions.assertEquals("{1.0, 5.0, 6.0, 9.0, 0.0, 0.0, 0.0, 0.0, 0.0}", vector.toString());
    }

    @Test
    public void createVectorUsingAnotherVector() {
        double[] vectorElements = new double[] {1.0, 5.0, 6.0, 9.0, 23.0, 45.0, 3.0};
        Vector vector = new Vector(vectorElements);
        Vector newVector = new Vector(vector);
        Assertions.assertEquals("{1.0, 5.0, 6.0, 9.0, 23.0, 45.0, 3.0}", newVector.toString());
    }

    @Test
    public void additionTest() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 9.0, 23.0, 45.0, 3.0};
        double[] vector2Elements = new double[] {11.0, 52.0, 6.4, 9.3};

        Vector vector1 = new Vector(vector1Elements);
        Vector vector2 = new Vector(vector2Elements);

        Assertions.assertEquals("{12.0, 57.0, 12.4, 18.3, 23.0, 45.0, 3.0}", vector1.add(vector2).toString());
    }

    @Test
    public void subtractionTest() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0};
        double[] vector2Elements = new double[] {11.0, 52.0, 16.5, 9.3};

        Vector vector1 = new Vector(vector1Elements);
        Vector vector2 = new Vector(vector2Elements);

        Assertions.assertEquals("{-10.0, -47.0, -10.5, -8.3, 23.0, 45.0, 3.0}", vector1.sub(vector2).toString());
    }

    @Test
    public void multiplicationTest() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0};
        Vector vector1 = new Vector(vector1Elements);

        double scalar = 2.0;

        Assertions.assertEquals("{2.0, 10.0, 12.0, 2.0, 46.0, 90.0, 6.0}", vector1.mult(scalar).toString());
    }

    @Test
    public void rotationTest() {
        double[] vectorElements = new double[] {1.0, 5.0, 6.0, -1.0, -23.0, 45.5, 3.0};
        Vector vector = new Vector(vectorElements);

        Assertions.assertEquals("{-1.0, -5.0, -6.0, 1.0, 23.0, -45.5, -3.0}", vector.rotation().toString());
    }

    @Test
    public void lengthTest() {
        double[] vectorElements = new double[] {1.0, 5.0, 6.0, -1.0, -23.0, 45.5, 3.0};
        Vector vector = new Vector(vectorElements);

        Assertions.assertEquals(7, vector.getLength());
    }

    @Test
    public void setComponentTest() {
        double[] vectorElements = new double[] {1.0, 5.0, 6.0, -1.0, -23.0, 45.5, 3.0};
        Vector vector = new Vector(vectorElements);
        vector.setComponent(4, 15.5);

        Assertions.assertEquals(15.5, vector.getComponent(4));
    }

    @Test
    public void equalsTest() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0};
        double[] vector2Elements = new double[] {11.0, 52.0, 16.5, 9.3};

        Vector vector1 = new Vector(vector1Elements);
        Vector vector2 = new Vector(vector2Elements);
        Vector vector3 = new Vector(vector1Elements);

        Assertions.assertEquals(false, vector1.equals(vector2));
        Assertions.assertEquals(true, vector1.equals(vector3));
    }

    @Test
    public void scalarProductTest() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0};
        double[] vector2Elements = new double[] {11.0, 52.0, 16.5, 9.3, 0.0, 0.0, 0.0};

        Vector vector1 = new Vector(vector1Elements);
        Vector vector2 = new Vector(vector2Elements);

        Assertions.assertEquals(379.3, Vector.scalarProduсt(vector1, vector2));
    }

    @Test
    public void addition2Test() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0};
        double[] vector2Elements = new double[] {11.0, 52.0, 16.5, 9.3, 0.0, 0.0, 0.0};

        Vector vector1 = new Vector(vector1Elements);
        Vector vector2 = new Vector(vector2Elements);

        Assertions.assertEquals("{12.0, 57.0, 22.5, 10.3, 23.0, 45.0, 3.0}", Vector.addition(vector1, vector2).toString());
    }

    @Test
    public void subtraction2Test() {
        double[] vector1Elements = new double[] {1.0, 5.0, 6.0, 1.0, 23.0, 45.0, 3.0};
        double[] vector2Elements = new double[] {11.0, 52.0, 16.5, 9.0, 0.0, 0.0, 0.0};

        Vector vector1 = new Vector(vector1Elements);
        Vector vector2 = new Vector(vector2Elements);

        Assertions.assertEquals("{-10.0, -47.0, -10.5, -8.0, 23.0, 45.0, 3.0}", Vector.subtraction(vector1, vector2).toString());
    }
}
