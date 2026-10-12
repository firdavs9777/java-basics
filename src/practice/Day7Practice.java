package practice;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
 * Day 7 Practice: Exceptions, Lambdas & Streams
 * After this file, build the mini project: day7/GasStationApp.java (it uses the whole week).
 */
public class Day7Practice {
    record Station(String name, String district, int queue, int price) {}

    static final List<Station> STATIONS = List.of(
            new Station("Chilonzor-1", "Chilonzor", 20, 4300),
            new Station("Bodomzor", "Yunusobod", 40, 5300),
            new Station("Sergeli Gas", "Sergeli", 5, 4100),
            new Station("Chilonzor-2", "Chilonzor", 12, 4500)
    );

    public static void main(String[] args) {
        // ----- Exceptions -----
        exceptions1();
        exceptions2();
        exceptions3();
        exceptions4();
        System.out.println(myAtoi("  -42") + " " + myAtoi("4193 with words") + " " + myAtoi("99999999999")); // -42 4193 2147483647

        // ----- Lambdas and Streams -----
        streams1();
        streams2();
        streams3();
        streams4();
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}))); // [4, 0, 1, 1, 3]
    }

    // ----- Exceptions -----

    static void exceptions1() {
        int[] prices = {4300, 5300, 4100};
        // Write a method that returns prices[i]; catch the bad-index case (try i = 5).
    }

    static void exceptions2() {
        // Write `static int parseQueue(String s)` below: throws IllegalArgumentException for negatives,
        // lets NumberFormatException through. Test "15", "-3", "x" and catch each here.
    }

    static void exceptions3() {
        // Create a CHECKED `static class StationClosedException extends Exception` below.
        // Throw it from a method and see where the compiler forces `throws` or try/catch.
    }

    static void exceptions4() {
        // Catch a low-level exception and rethrow it wrapped in your own exception,
        // passing the original as the cause. Print getCause() when you catch the wrapper.
    }

    static int myAtoi(String s) {
        return 0; // TODO LeetCode 8: no Integer.parseInt, no throwing, clamp on overflow
    }

    // ----- Lambdas and Streams (use STATIONS above) -----

    static void streams1() {
        // Predicate<Station> hasShortQueue (< 15 min) and Function<Station, String> label.
        // Print labels of all short-queue stations.
    }

    static void streams2() {
        // AVERAGE price with streams (mapToInt(...).average()). Expected: 4550.0
    }

    static void streams3() {
        // Group stations by district and COUNT them (Collectors.counting()). Expected: Chilonzor=2, ...
    }

    static void streams4() {
        // Names of the 2 shortest queues: once with a stream, once with a plain for-loop.
        // Expected: [Sergeli Gas, Chilonzor-2]. Which version is easier to read?
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        return new int[0]; // TODO LeetCode 1365: solve with streams AND with a counting array
    }

    // ↓ Your helper methods and exception classes go here ↓

    // ===== My notes =====
    //
}
