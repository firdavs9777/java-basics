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
        boolean hasGas;
        if (open) {
            hasGas = true;
        } else {
            hasGas = false;
        }
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
        int queue_last = 20;

        if (hasGases && queue_last == 20) {
            System.out.println("Perfect, go!!");
        }
        if (!hasGases || queue_last > 60) {
            System.out.println("Test Me");
        }

        // ===== Exercises =====
        // TODO 1: Section 1 can be one line: `boolean hasGas = open;`. Rewrite it.
        // TODO 2: Rename queue_last to queueLast (Java uses camelCase for variables).
        // TODO 3: Given int year, print whether it is a leap year
        //         (divisible by 4, but not by 100 unless also by 400). Test 2024, 1900, 2000.
        // TODO 4: Given three ints a, b, c, print the largest using only if/else.
    }
}
