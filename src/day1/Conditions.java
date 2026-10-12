package day1;

/*
 * Day 1 · Lesson 2: Conditions
 * if / else if / else + comparison (> < >= <= == !=) + logical (&& || !) operators.
 * DSA: base cases, boundary checks and "if found, return" all use these.
 */
public class Conditions {
    public static void main(String[] args) {
        // 1. Basic if and else conditions
        boolean open = true;
        boolean hasGas = open; // TODO 1 ✅ was a 6-line if/else that just copied `open`
        if (hasGas) {
            System.out.println("Go to that station and get the gas");
        } else {
            System.out.println("Go to home hehe or find another gas station");
        }

        // 2. Comparison Operators
        int queue = 25;
        System.out.println(queue > 20); // true
        System.out.println(queue < 20); // false
        System.out.println(queue >= 20); // true
        System.out.println(queue <= 10); // false
        System.out.println(queue == 25); // true
        System.out.println(queue != 25); // false

        // 3. else if for multiple options
        if (queue <= 10) {
            System.out.println("Short queue, go now!");
        } else if (queue <= 30) {
            System.out.println("Medium queue, okay");
        } else {
            System.out.println("Long queue, try later");
        }

        // 4. Combining Options
        boolean hasGases = true;
        int queueLast = 20; // TODO 2 ✅ renamed from queue_last (camelCase)

        if (hasGases && queueLast == 20) {
            System.out.println("Perfect, go!!");
        }
        if (!hasGases || queueLast > 60) {
            System.out.println("Test Me");
        }

        // ===== Exercises =====
        // TODO 3 ✅ Leap year: divisible by 4, but not by 100 unless also by 400.
        //        Change year to 1900 (not leap) and 2000 (leap) and run again.
        int year = 2024;
        if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }

        // TODO 4 ✅ Largest of three using only if/else
        int a = 30;
        int b = 40;
        int c = 50;
        if (a >= b && a >= c) {
            System.out.println("A is the largest: " + a);
        } else if (b >= a && b >= c) {
            System.out.println("B is the largest: " + b);
        } else {
            System.out.println("C is the largest: " + c);
        }
    }
}
