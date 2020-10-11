package ru.academits.java.range;

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
        Range range2 = new Range(4.3, 23);
        Range range3 = range1.getCrossing(range2);

        if (range3 != null) {
            System.out.println("Crossing. New interval is: " + range3.getFrom() + "; " + range3.getTo());
        } else {
            System.out.println("No intersection");
        }

        Range[] rangesUnion = range1.getUnion(range2);

        int i = 0;

        System.out.println("Union. New interval is: ");

        while (i < rangesUnion.length) {
            System.out.println(rangesUnion[i].getFrom() + " ; " + rangesUnion[i].getTo());
            i++;
        }

        Range[] rangesSubtraction = range1.getSubtraction(range2);

        int j = 0;

        System.out.println("Subtraction. New interval is: ");

        while (j < rangesSubtraction.length) {
            System.out.println(rangesSubtraction[j].getFrom() + " ; " + rangesSubtraction[j].getTo());
            j++;
        }
    }
}