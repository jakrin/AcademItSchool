package ru.academits.shpitaleva.shapes;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static Shapes getMaxAreaShape(Shapes[] shapes) {
        Arrays.sort(shapes, Collections.reverseOrder());

        return shapes[0];
    }

    public static Shapes getSecondMaxPerimeterShape(Shapes[] shapes) {
        Arrays.sort(shapes, new ShapesPerimeterComparator());

        return shapes[1];
    }

    public static void main(String[] args) {
        Shapes[] shapes = new Shapes[8];

        shapes[0] = new Triangle(1, 1, 4, 5, 0, -2);
        shapes[1] = new Circle(5);
        shapes[2] = new Square(4);
        shapes[3] = new Rectangle(8, 11);
        shapes[4] = new Triangle(-7, 3, -4, -1, 0, 5);
        shapes[5] = new Circle(7);
        shapes[6] = new Square(14);
        shapes[7] = new Rectangle(2, 15);

        Shapes maxAreaShape = getMaxAreaShape(shapes);

        System.out.println("Max area is: " + maxAreaShape.getArea());
        System.out.println("Shape type is: " + maxAreaShape.getShapeType());
        System.out.println("Width is: " + maxAreaShape.getWidth());
        System.out.println("Height is: " + maxAreaShape.getHeight());
        System.out.println("Perimeter is: " + maxAreaShape.getPerimeter());
        System.out.println();

        System.out.println("All areas are: ");

        int i = 0;

        while (i < shapes.length) {
            System.out.println("Area is " + shapes[i].getArea());
            i++;
        }

        Shapes secondMaxPerimeterShape = getSecondMaxPerimeterShape(shapes);

        System.out.println();
        System.out.println("Second max perimeter is: " + secondMaxPerimeterShape.getPerimeter());
        System.out.println("Shape type is: " + secondMaxPerimeterShape.getShapeType());
        System.out.println("Width is: " + secondMaxPerimeterShape.getWidth());
        System.out.println("Height is: " + secondMaxPerimeterShape.getHeight());
        System.out.println();

        System.out.println("All perimeters are: ");

        int j = 0;

        while (j < shapes.length) {
            System.out.println("Perimeter is " + shapes[j].getPerimeter());
            j++;
        }
    }
}
