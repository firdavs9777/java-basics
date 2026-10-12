package day3;

import java.util.Arrays;

/*
 * Day 3 · Lesson 3: Arrays
 * An array = fixed-size row of boxes of the same type, accessed by index starting at 0.
 * DSA: arrays are THE most common LeetCode input. Two pointers, sliding window, prefix sums all live here.
 * (Class is named ArraysBasics so it doesn't clash with java.util.Arrays.)
 */
public class ArraysBasics {
    public static void main(String[] args) {
        // 1. Declare, create, initialize
        int[] queues = new int[3];               // [0, 0, 0]
        queues[0] = 20;
        queues[1] = 40;
        queues[2] = 15;
        String[] stations = {"Chilonzor", "Bodomzor", "Yunusobod"}; // literal
        System.out.println(stations[1] + ": " + queues[1] + " min"); // Bodomzor: 40 min

        // 2. length (a field, no parentheses!) and the last index
        System.out.println("Count: " + stations.length);                 // 3
        System.out.println("Last: " + stations[stations.length - 1]);    // Yunusobod
        // Trap: stations[3] -> ArrayIndexOutOfBoundsException. Valid indexes are 0 .. length-1.

        // 3. Default values: numbers 0, boolean false, objects (String) null
        boolean[] hasGas = new boolean[2];
        String[] names = new String[2];
        System.out.println(hasGas[0] + " " + names[0]); // false null

        // 4. Classic for (need the index) vs enhanced for (just the values)
        for (int i = 0; i < stations.length; i++) {
            System.out.println(i + ". " + stations[i] + " -> " + queues[i] + " min");
        }
        for (String s : stations) {
            System.out.print(s + " ");
        }
        System.out.println();
        // Trap: printing an array directly prints a memory-like code, e.g. [I@1b6d3586
        System.out.println(queues);
        System.out.println(Arrays.toString(queues)); // [20, 40, 15]

        // 5. java.util.Arrays helpers
        int[] prices = {5300, 4300, 4800};
        Arrays.sort(prices);                                 // sorts in place, O(n log n)
        System.out.println(Arrays.toString(prices));         // [4300, 4800, 5300]
        int[] filled = new int[4];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled));         // [7, 7, 7, 7]
        int[] bigger = Arrays.copyOf(prices, 5);             // extra slots get 0
        System.out.println(Arrays.toString(bigger));         // [4300, 4800, 5300, 0, 0]

        // 6. Sum and max
        int sum = 0;
        int max = queues[0];
        for (int q : queues) {
            sum += q;
            if (q > max) max = q;
        }
        System.out.println("Sum: " + sum + ", max: " + max); // 75, 40

        // 7. 2D arrays: grid[row][col], e.g. queue minutes per [station][pump]
        int[][] grid = {
                {20, 40, 10},
                {15, 5, 30}
        };
        System.out.println("rows=" + grid.length + " cols=" + grid[0].length); // 2, 3
        System.out.println(grid[1][2]); // 30
        System.out.println(Arrays.deepToString(grid)); // [[20, 40, 10], [15, 5, 30]]

        // 8. Two-pointer preview: one index from the left, one from the right, moving inward
        int[] nums = {1, 2, 3, 4, 5};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            System.out.println("pair: " + nums[left] + " & " + nums[right]);
            left++;
            right--;
        }
        // pair: 1 & 5, pair: 2 & 4 (the middle 3 has no partner)

        // ===== Exercises =====
        // TODO 1: Create double[] prices for 4 stations and print the average price.
        // TODO 2: Count how many values in {20, 40, 15, 35, 10} are greater than 18.
        // TODO 3: Sum every row of the 2D grid above and print each row's total.
        // TODO 4: Find the second largest value in an int[] in a single pass (no sorting).
        // TODO 5 (DSA classic): Reverse an int[] in place using two pointers and a temp variable.
    }
}
