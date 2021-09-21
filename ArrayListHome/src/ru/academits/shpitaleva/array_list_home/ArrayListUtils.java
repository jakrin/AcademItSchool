package ru.academits.shpitaleva.array_list_home;

import java.io.*;
import java.util.ArrayList;

import lombok.NonNull;

public class ArrayListUtils {
    public static ArrayList<Integer> getListWithoutDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(list.size());

        for (Integer element : list) {
            if (listWithoutDuplicates.contains(element)) {
                continue;
            }

            listWithoutDuplicates.add(element);
        }

        return listWithoutDuplicates;
    }

    public static void deleteEvenNumbersUsingIterator(ArrayList<Integer> list) {
        list.removeIf(nextNumber -> nextNumber % 2 == 0);
    }

    public static void deleteEvenNumbersUsingWhile(@NonNull ArrayList<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list argument is null");
        }

        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public static ArrayList<String> getFileStrings(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        String string;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((string = bufferedReader.readLine()) != null) {
                list.add(string);
            }
        } catch (FileNotFoundException f) {
            System.out.println(fileName + " does not exist");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
