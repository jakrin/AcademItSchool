package ru.academits.shpitaleva.shapes_main;

import ru.academits.shpitaleva.shapes.Shape;

import java.util.Arrays;

public class Utility {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes.length < 1) {
            throw new IllegalArgumentException("Shapes array should have at least one element");
        }

        Arrays.sort(shapes, new ShapesAreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes.length < 2) {
            throw new IllegalArgumentException("Shapes array should have at least two elements");
        }

        Arrays.sort(shapes, new ShapesPerimeterComparator());
        return shapes[shapes.length - 2];
    }
}
