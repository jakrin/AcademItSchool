package ru.academits.shpitaleva.arrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.NonNull;

public class ArrayListUtils {
    public static ArrayList<Integer> filterDuplicates(final ArrayList<Integer> list) {
        ArrayList<Integer> filteredList = new ArrayList<>();

        for (Integer element : list) {
            boolean isUnique = true;
            for (Integer uniqueElement : filteredList) {
                if (element.equals(uniqueElement)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }

    public static ArrayList<Integer> filterEvenNumbers(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Integer nextNumber = iterator.next();
            if (nextNumber % 2 == 0) {
                iterator.remove();
            }
        }

        return list;
    }

    public static ArrayList<Integer> filterEvenNumbers1(@NonNull ArrayList<Integer> list) {
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

        return list;
    }

    public static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(fileName);
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (bufferedReader.ready()) {
            list.add(bufferedReader.readLine());
        }

        return list;
    }
}
