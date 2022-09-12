package ru.academits.shpitaleva.array_list_home;

import java.io.*;
import java.util.ArrayList;

import lombok.NonNull;

public class ArrayListUtils {
    public static ArrayList<Integer> getListWithoutDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(list.size());

        for (Integer element : list) {
            if (!listWithoutDuplicates.contains(element)) {
                listWithoutDuplicates.add(element);
            }
        }

        return listWithoutDuplicates;
    }

    public static void deleteEvenNumbersUsingIterator(ArrayList<Integer> list) {
        list.removeIf(nextNumber -> nextNumber % 2 == 0);
    }

    public static void deleteEvenNumbersUsingWhile(@NonNull ArrayList<Integer> list) {
        int i = 0;

        while (i < list.size()) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public static ArrayList<String> getFileLines(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new IOException();
        }

        return list;
    }
}
