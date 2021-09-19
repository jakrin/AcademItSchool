package ru.academits.shpitaleva.array_list_home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListUtilsTests {
    @Test
    public void filterDuplicatesTest() {
        ArrayList<Integer> list = new ArrayList<Integer> (Arrays.asList(1, 5, 2, 1, 3, 5));
        Assertions.assertEquals(new ArrayList<Integer> (Arrays.asList(1, 5, 2, 3)), ArrayListUtils.filterDuplicates(list));
    }

    @Test
    public void filterEvenNumbersTest() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 1, 3, 5, 4, 7));
        Assertions.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 5, 1, 3, 5, 7)), ArrayListUtils.filterEvenNumbers(list));
    }

    @Test
    public void filterEvenNumbers1Test() {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 1, 3, 5, 4, 7));
        Assertions.assertEquals(new ArrayList<Integer>(Arrays.asList(1, 5, 1, 3, 5, 7)), ArrayListUtils.filterEvenNumbers1(list));
    }

    @Test
    public void filterEvenNumbers1DontAcceptNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ArrayListUtils.filterEvenNumbers1(null);
        });
    }

    @Test
    public void readFileTest() throws IOException {
        File f = new File(getClass().getClassLoader().getResource("test_file").getFile());
        ArrayList<String> strings = ArrayListUtils.readFile(f.getAbsolutePath());
        Assertions.assertEquals(Arrays.asList("1", "2", "3", "qwe", "rty"), strings);
    }
}
