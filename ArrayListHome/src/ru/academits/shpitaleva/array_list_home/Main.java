package ru.academits.shpitaleva.array_list_home;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        System.out.println("List without duplicates:" + ArrayListUtils.getListWithoutDuplicates(list1));

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 4, 7));
        ArrayListUtils.deleteEvenNumbersUsingWhile(list2);
        System.out.println("List without even numbers:" + list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 4, 7));
        ArrayListUtils.deleteEvenNumbersUsingIterator(list3);
        System.out.println("List without even numbers:" + list3);

        File f = new File(Objects.requireNonNull(Main.class.getResource("test_file1")).getFile());
        ArrayList<String> lines;

        try {
            lines = ArrayListUtils.getFileLines(f.getAbsolutePath());
            System.out.println(lines);
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
