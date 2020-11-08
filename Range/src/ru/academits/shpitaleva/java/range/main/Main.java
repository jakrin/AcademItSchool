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

        printRange("Crossing. New interval is: ", new Range[]{range1.getIntersection(range2)});
        printRange("Union. New interval is: ", range1.getUnion(range2));
        printRange("Difference. New interval is: ", range1.getDifference(range2));

        printRange("Difference (1,5) - (3,7). New interval is: ", (new Range(1, 5)).getDifference(new Range(3, 7)));
        printRange("Difference (3,7) - (1,5). New interval is: ", (new Range(3, 7)).getDifference(new Range(1, 5)));
        printRange("Difference (1,3) - (1,5). New interval is: ", (new Range(1, 3)).getDifference(new Range(1, 5)));
        printRange("Difference (1,5) - (1,3). New interval is: ", (new Range(1, 5)).getDifference(new Range(1, 3)));
        printRange("Difference (3,7) - (5,7). New interval is: ", (new Range(3, 7)).getDifference(new Range(5, 7)));
        printRange("Difference (5,7) - (3,7). New interval is: ", (new Range(5, 7)).getDifference(new Range(3, 7)));
        printRange("Difference (3,5) - (1,7). New interval is: ", (new Range(3, 5)).getDifference(new Range(1, 7)));
        printRange("Difference (1,7) - (3,5). New interval is: ", (new Range(1, 7)).getDifference(new Range(3, 5)));
    }

    private static void printRange(String message, Range[] ranges) {
        System.out.print(message);
        System.out.print("[");

        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] != null) {
                System.out.print(ranges[i]);

                if (i < ranges.length - 1) {
                    System.out.print(", ");
                }
            }
        }

        System.out.println("]");
    }
}