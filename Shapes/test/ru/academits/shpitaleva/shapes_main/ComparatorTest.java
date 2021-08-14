package ru.academits.shpitaleva.shapes_main;

import org.junit.jupiter.api.Test;
import ru.academits.shpitaleva.shapes.*;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    @Test
    void getMaxAreaShapeFailOnEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Utility.getMaxAreaShape(new Shape[] {});
        });
    }

    @Test
    void getSecondMaxPerimeterShapeFailOnEmptyOrUnitArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            Utility.getSecondMaxPerimeterShape(new Shape[] {});
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Utility.getSecondMaxPerimeterShape(new Shape[] {new Circle(.0)});
        });
    }

    @Test
    void getMaxAreaShapeOnUnitArray() {
        assertEquals(Utility.getMaxAreaShape(new Shape[] {new Rectangle(1.0, 1.0)}), new Rectangle(1.0, 1.0));
    }

    @Test
    void getMaxAreaShapeOnTwoElementArray() {
        assertEquals(Utility.getMaxAreaShape(new Shape[] {new Rectangle(1.0, 1.0), new Rectangle(2.0, 1.0)}), new Rectangle(2.0, 1.0));
    }

    @Test
    void getSecondMaxPerimeterShapeOnTwoElementArray() {
        assertEquals(Utility.getSecondMaxPerimeterShape(new Shape[] {new Rectangle(1.0, 1.0), new Rectangle(2.0, 1.0)}), new Rectangle(1.0, 1.0));
    }
}