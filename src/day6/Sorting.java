package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Day 6 · Sorting
 * Arrays.sort / Collections.sort + Comparable (the "natural" order) + Comparator (any custom order).
 * DSA: sorting first (O(n log n)) unlocks two pointers, binary search, greedy and interval problems.
 * Spring: sorting results before returning them (and Sort in Spring Data) uses the same ideas.
 */
public class Sorting {

    // Comparable = the class knows its own natural order (here: by price).
    record Station(String name, int price, int queue) implements Comparable<Station> {
        @Override
        public int compareTo(Station other) {
            return Integer.compare(this.price, other.price); // negative = this first, 0 = equal, positive = other first
        }
    }

    public static void main(String[] args) {
        // 1. Arrays.sort on primitives (ascending). Big-O: O(n log n).
        int[] prices = {5300, 4300, 4800, 4300};
        Arrays.sort(prices);
        System.out.println(Arrays.toString(prices)); // [4300, 4300, 4800, 5300]

        // 2. Arrays.sort on objects uses Comparable (String = alphabetical)
        String[] names = {"Sergeli", "Bodomzor", "Chilonzor"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names)); // [Bodomzor, Chilonzor, Sergeli]
        // Trap: Arrays.sort(int[], Collections.reverseOrder()) does NOT compile. Comparators need Integer[].

        // 3. Our own Comparable: Station sorted by price
        List<Station> stations = new ArrayList<>(List.of(
                new Station("Chilonzor", 4300, 25),
                new Station("Bodomzor", 5300, 10),
                new Station("Sergeli", 4300, 5)));
        Collections.sort(stations);
        System.out.println(stations.get(2).name()); // Bodomzor (most expensive is last)

        // 4. Comparator: sort by queue, then by name, in many ways
        stations.sort(Comparator.comparingInt(Station::queue));
        System.out.println(stations.get(0).name()); // Sergeli (queue 5)
        stations.sort(Comparator.comparingInt(Station::price).thenComparing(Station::name));
        System.out.println(stations.get(0).name()); // Chilonzor (4300, and "C" < "S")
        stations.sort(Comparator.comparingInt(Station::queue).reversed());
        System.out.println(stations.get(0).name()); // Chilonzor (queue 25, longest first)
        stations.sort((a, b) -> a.name().compareTo(b.name())); // plain lambda
        System.out.println(stations.get(0).name()); // Bodomzor

        // 5. Trap: (a, b) -> a - b can OVERFLOW and sort wrongly. Use Integer.compare(a, b).
        Integer[] big = {Integer.MAX_VALUE, -10, 0};
        Integer[] copy = big.clone();
        Arrays.sort(big, (a, b) -> a - b);                    // MAX_VALUE - (-10) overflows to negative!
        Arrays.sort(copy, (a, b) -> Integer.compare(a, b));   // always correct
        System.out.println(Arrays.toString(big));  // [2147483647, -10, 0]  <- WRONG order!
        System.out.println(Arrays.toString(copy)); // [-10, 0, 2147483647]

        // 6. Sort a 2D array by first column (the "intervals" pattern: [start, end])
        int[][] shifts = {{14, 18}, {8, 12}, {10, 16}};
        Arrays.sort(shifts, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(shifts)); // [[8, 12], [10, 16], [14, 18]]

        // 7. Binary search: array MUST be sorted first. Big-O: O(log n).
        int[] sortedPrices = {4300, 4500, 4800, 5300};
        System.out.println(Arrays.binarySearch(sortedPrices, 4800)); // 2 (index)
        System.out.println(Arrays.binarySearch(sortedPrices, 5000)); // negative = not found (-(insertPoint) - 1 = -4)

        // ===== Exercises =====
        // TODO 1: Sort an Integer[] of queue minutes in DESCENDING order with Collections.reverseOrder().
        // TODO 2: Sort a List<String> of districts by length, then alphabetically for equal lengths.
        // TODO 3: Sort stations by queue ascending, then price descending, using one Comparator chain.
        // TODO 4: Write your own binary search on int[] (while low <= high) and compare with Arrays.binarySearch.
        // TODO 5 (LeetCode 56 "Merge Intervals"): sort by start, then merge overlapping [start, end] pairs.
    }
}
