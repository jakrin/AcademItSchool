package ru.academits.shpitaleva.java.range.main;

import ru.academits.shpitaleva.java.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(3.5, 100.8);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Length of the interval is: " + range.getLength());

        System.out.println("Please, input a number:");
        double userNumber = scanner.nextDouble();

        if (range.isInside(userNumber)) {
            System.out.println("The number is inside the interval");
        } else {
            System.out.println("The number is outside the interval");
        }

        Range range1 = new Range(-2.5, 10.8);
        Range range2 = new Range(14.3, 23);

        printInterval("Crossing. New interval is: ", new Range[]{range1.getIntersection(range2)});

        printInterval("Union. New interval is: ", range1.getUnion(range2));

        printInterval("Difference. New interval is: ", range1.getDifference(range2));
    }

    private static void printInterval(String message, Range[] intervals) {
        int i = 0;

        System.out.println(message);
        System.out.print("[");

        for (Range range :
                intervals) {
            if (range != null) {
                System.out.print(range);
                if (i++ != intervals.length - 1) {
                    System.out.print(", ");
                }
            }
        }

        System.out.println("]");
    }
}