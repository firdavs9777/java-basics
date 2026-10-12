package practice;

import java.util.*;

/*
 * Day 6 Practice: Wrappers & Generics, Lists, Maps & Sets, Stacks & Queues, Sorting  ⭐ core DSA day
 * LeetCode-style stubs: replace the placeholder `return` with your solution and check main's output.
 * Write extra classes/records (Pair, Car, Station...) as nested types below main.
 */
public class Day6Practice {
    public static void main(String[] args) {
        // ----- Wrappers and Generics -----
        wrappers1();
        wrappers2();
        // wrappers3: write `static <T> T last(List<T> list)` below, then test it here.
        wrappers4();
        System.out.println(reverseInt(123) + " " + reverseInt(-120) + " " + reverseInt(1534236469)); // 321 -21 0

        // ----- Lists -----
        lists1();
        lists2();
        System.out.println(merge(List.of(1, 4, 7), List.of(2, 3, 9)));     // [1, 2, 3, 4, 7, 9]
        System.out.println(findDisappeared(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // [5, 6]

        // ----- Maps and Sets -----
        maps1();
        maps2();
        maps3();
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}) + " " + containsDuplicate(new int[]{1, 2, 3})); // true false
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]

        // ----- Stacks and Queues -----
        System.out.println(reverseWithStack("Chilonzor")); // roznolihC
        queues2();
        queues3();
        System.out.println(isValid("([]{})") + " " + isValid("(]")); // true false
        System.out.println(kthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5

        // ----- Sorting -----
        sorting1();
        sorting2();
        sorting3();
        int[] sorted = {5, 10, 15, 20, 35, 40};
        System.out.println(binarySearch(sorted, 20) + " " + binarySearch(sorted, 7)); // 3 -1
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1, 3}, {8, 10}, {2, 6}}))); // [[1, 6], [8, 10]]
    }

    // ----- Wrappers and Generics -----

    static void wrappers1() {
        // Parse "4300" and "abc" with Integer.parseInt; catch NumberFormatException for "abc".
    }

    static void wrappers2() {
        // Write a generic `static class Pair<A, B>` below with first() and second(); store ("Chilonzor", 20).
    }

    static void wrappers4() {
        int[] queues = {20, 5, 60, 35};
        // Max AND min in one loop using Integer.MIN_VALUE / MAX_VALUE sentinels. Expected: max 60, min 5
    }

    static int reverseInt(int x) {
        return 0; // TODO LeetCode 7: return 0 on overflow (compare with Integer.MAX_VALUE / 10)
    }

    // ----- Lists -----

    static void lists1() {
        // List<String> of 5 Tashkent districts; print the one at the middle index.
    }

    static void lists2() {
        List<Integer> queues = new ArrayList<>(List.of(20, 45, 10, 60, 30));
        // Remove every queue longer than 30 with removeIf. Expected: [20, 10, 30]
    }

    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        return new ArrayList<>(); // TODO: two pointers, O(n + m), no Collections.sort
    }

    static List<Integer> findDisappeared(int[] nums) {
        return new ArrayList<>(); // TODO LeetCode 448
    }

    // ----- Maps and Sets -----

    static void maps1() {
        // Map<String, Integer> of 4 stations -> queue minutes; print the station with the shortest queue.
    }

    static void maps2() {
        // Count each character in "chilonzor" using merge(). Expected: o=2, others 1 (order may differ)
    }

    static void maps3() {
        String[] a = {"Chilonzor", "Yunusobod", "Sergeli", "Olmazor"};
        String[] b = {"Sergeli", "Mirobod", "Chilonzor"};
        // Print the districts in BOTH using retainAll. Expected: Chilonzor, Sergeli
    }

    static boolean containsDuplicate(int[] nums) {
        return false; // TODO LeetCode 217: HashSet
    }

    static int[] twoSum(int[] nums, int target) {
        return new int[0]; // TODO LeetCode 1: HashMap<value, index>, O(n)
    }

    // ----- Stacks and Queues -----

    static String reverseWithStack(String s) {
        return s; // TODO: ArrayDeque<Character> as a stack
    }

    static void queues2() {
        // One ArrayDeque of 6 cars; give them alternately to pump A and pump B. Print each pump's list.
    }

    static void queues3() {
        // record Car(String plate, int liters) below; PriorityQueue serving the MOST liters first.
    }

    static boolean isValid(String s) {
        return false; // TODO LeetCode 20: ArrayDeque stack
    }

    static int kthLargest(int[] nums, int k) {
        return 0; // TODO LeetCode 215: min-heap of size k
    }

    // ----- Sorting -----

    static void sorting1() {
        Integer[] queues = {20, 5, 60, 35};
        // Sort DESCENDING with Collections.reverseOrder(). Expected: [60, 35, 20, 5]
    }

    static void sorting2() {
        List<String> districts = new ArrayList<>(List.of("Sergeli", "Chilonzor", "Mirobod", "Olmazor", "Yashnobod"));
        // Sort by length, then alphabetically for equal lengths.
    }

    static void sorting3() {
        // record Station(String name, int queue, int price) below.
        // Sort by queue ascending, then price descending, with ONE Comparator chain.
    }

    static int binarySearch(int[] arr, int target) {
        return -1; // TODO: while (low <= high); return the index or -1
    }

    static int[][] mergeIntervals(int[][] intervals) {
        return intervals; // TODO LeetCode 56: sort by start, then merge
    }

    // ↓ Your classes and records go here ↓

    // ===== My notes =====
    //
}
