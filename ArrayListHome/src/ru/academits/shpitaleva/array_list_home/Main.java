package ru.academits.shpitaleva.array_list_home;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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

        File f = new File(Main.class.getResource("test_file1").getFile());
        ArrayList<String> strings = ArrayListUtils.getFileStrings(f.getAbsolutePath());
        System.out.println(strings);
    }
}
