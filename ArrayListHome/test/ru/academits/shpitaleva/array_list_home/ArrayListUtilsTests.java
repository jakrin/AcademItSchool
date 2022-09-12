package ru.academits.shpitaleva.array_list_home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ArrayListUtilsTests {
    @Test
    public void filterDuplicatesTest() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(1, 5, 2, 3)), ArrayListUtils.getListWithoutDuplicates(list));
    }

    @Test
    public void filterEvenNumbersTest() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 4, 7));
        ArrayListUtils.deleteEvenNumbersUsingWhile(list);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(1, 5, 1, 3, 5, 7)), list);
    }

    @Test
    public void filterEvenNumbers1Test() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 4, 7));
        ArrayListUtils.deleteEvenNumbersUsingIterator(list);
        Assertions.assertEquals(new ArrayList<>(Arrays.asList(1, 5, 1, 3, 5, 7)), list);
    }

    @Test
    public void filterEvenNumbers1DontAcceptNullTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ArrayListUtils.deleteEvenNumbersUsingIterator(null));
    }

    @Test
    public void readFileTest() throws IOException {
        File f = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("ru/academits/shpitaleva/array_list_home/test_file1")).getFile());
        ArrayList<String> strings = ArrayListUtils.getFileLines(f.getAbsolutePath());
        Assertions.assertEquals(Arrays.asList("1", "2", "3", "qwe", "rty"), strings);
    }
}
