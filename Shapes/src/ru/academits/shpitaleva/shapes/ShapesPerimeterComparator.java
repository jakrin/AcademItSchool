package ru.academits.shpitaleva.shapes;

import java.util.Comparator;

public class ShapesPerimeterComparator implements Comparator<Shapes> {
    @Override
    public int compare(Shapes shape1, Shapes shape2) {
        return (int) (shape2.getPerimeter() - shape1.getPerimeter());
    }
}
