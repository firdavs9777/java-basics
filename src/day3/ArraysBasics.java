package day3;

import java.util.Arrays;

/*
 * Day 3 · Lesson 1: Arrays
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
        // Size is fixed forever once created. Need to grow? Use ArrayList (collections lesson).

        // 2. length (a field, no parentheses!) and the last index
        System.out.println("Count: " + stations.length);                 // 3
        System.out.println("Last: " + stations[stations.length - 1]);    // Yunusobod
        // Trap: stations[3] -> ArrayIndexOutOfBoundsException. Valid indexes are 0 .. length-1.
        // Trap: arrays use .length, Strings use .length(), lists use .size(). Classic interview typo!

        // 3. Default values: numbers 0, boolean false, objects (String) null
        boolean[] hasGas = new boolean[2];
        String[] names = new String[2];
        System.out.println(hasGas[0] + " " + names[0]); // false null
        // Trap: names[0].length() would crash with NullPointerException, there's no String there yet.

        // 4. Changing values
        queues[2] = 25;                              // Yunusobod's queue grew
        queues[0] += 5;                              // compound assignment works on elements too
        System.out.println(Arrays.toString(queues)); // [25, 40, 25]

        // 5. Classic for (need the index) vs enhanced for (just the values)
        for (int i = 0; i < stations.length; i++) {
            System.out.println(i + ". " + stations[i] + " -> " + queues[i] + " min");
        }
        for (String s : stations) {
            System.out.print(s + " ");
        }
        System.out.println();
        // Trap: in a for-each, changing the loop variable does NOT change the array:
        for (int q : queues) {
            q = 0;                                    // only changes the copy "q"
        }
        System.out.println(Arrays.toString(queues)); // still [25, 40, 25]
        // Trap: printing an array directly prints a memory-like code, e.g. [I@1b6d3586
        System.out.println(queues);
        System.out.println(Arrays.toString(queues)); // [25, 40, 25]

        // 6. java.util.Arrays helpers
        int[] prices = {5300, 4300, 4800};
        Arrays.sort(prices);                                 // sorts in place, O(n log n)
        System.out.println(Arrays.toString(prices));         // [4300, 4800, 5300]
        int[] filled = new int[4];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled));         // [7, 7, 7, 7]
        int[] bigger = Arrays.copyOf(prices, 5);             // extra slots get 0
        System.out.println(Arrays.toString(bigger));         // [4300, 4800, 5300, 0, 0]
        int[] middle = Arrays.copyOfRange(prices, 1, 3);     // from index 1 up to (not incl.) 3
        System.out.println(Arrays.toString(middle));         // [4800, 5300]

        // 7. BIG TRAP: arrays are references. "=" does NOT copy!
        int[] a = {1, 2, 3};
        int[] b = a;                     // b points to the SAME array as a
        b[0] = 99;
        System.out.println(a[0]);        // 99 (a changed too!)
        int[] c = Arrays.copyOf(a, a.length);  // a real, independent copy
        c[0] = 5;
        System.out.println(a[0] + " " + c[0]); // 99 5

        // 8. Comparing arrays: == checks "same object", not "same values"
        int[] x = {1, 2};
        int[] y = {1, 2};
        System.out.println(x == y);              // false
        System.out.println(Arrays.equals(x, y)); // true

        // 9. Sum, max, min, average
        int sum = 0;
        int max = queues[0];
        int min = queues[0];
        for (int q : queues) {
            sum += q;
            if (q > max) max = q;
            if (q < min) min = q;
        }
        System.out.println("Sum: " + sum + ", max: " + max + ", min: " + min); // 90, 40, 25
        System.out.println("Average: " + (double) sum / queues.length);       // 30.0

        // 10. Linear search: find the index of a value, -1 if not found
        int target = 40;
        int foundAt = -1;
        for (int i = 0; i < queues.length; i++) {
            if (queues[i] == target) {
                foundAt = i;
                break;                   // stop at the first match
            }
        }
        System.out.println("Found " + target + " at index " + foundAt); // 1

        // 11. 2D arrays: grid[row][col], e.g. queue minutes per [station][pump]
        int[][] grid = {
                {20, 40, 10},
                {15, 5, 30}
        };
        System.out.println("rows=" + grid.length + " cols=" + grid[0].length); // 2, 3
        System.out.println(grid[1][2]); // 30
        System.out.println(Arrays.deepToString(grid)); // [[20, 40, 10], [15, 5, 30]]
        for (int row = 0; row < grid.length; row++) {           // nested loop: rows outside,
            for (int col = 0; col < grid[row].length; col++) {  // columns inside
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        // 20 40 10
        // 15 5 30

        // 12. Swapping two elements needs a temporary variable
        int[] pair = {7, 9};
        int temp = pair[0];
        pair[0] = pair[1];
        pair[1] = temp;
        System.out.println(Arrays.toString(pair)); // [9, 7]
        // Without temp: pair[0] = pair[1] makes both 9, and the 7 is lost forever.

        // 13. Two-pointer preview: one index from the left, one from the right, moving inward
        int[] nums = {1, 2, 3, 4, 5};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            System.out.println("pair: " + nums[left] + " & " + nums[right]);
            left++;
            right--;
        }
        // pair: 1 & 5, pair: 2 & 4 (the middle 3 has no partner)

        // 14. Prefix sum preview: running total, used in many LeetCode problems
        int[] daily = {3, 1, 4, 1, 5};
        int[] running = new int[daily.length];
        running[0] = daily[0];
        for (int i = 1; i < daily.length; i++) {
            running[i] = running[i - 1] + daily[i];
        }
        System.out.println(Arrays.toString(running)); // [3, 4, 8, 9, 14]

        // ===== Exercises =====
        // Rules: write each one yourself, run it, and compare with the expected output before pasting.

        // TODO 1: Create double[] prices = {4300.5, 5300.0, 3900.0, 4800.5} and print the average.
        //         Expected: Average: 4575.25

        // TODO 2: Count how many values in {20, 40, 15, 35, 10} are greater than 18.
        //         Expected: 3

        // TODO 3: Sum every row of the 2D grid from section 11 and print each row's total.
        //         Expected: Row 0: 70, Row 1: 50

        // TODO 4: Given String[] names = {"A", "B", "C", "D"} and int[] prices = {4300, 5300, 3900, 4800},
        //         print the cheapest station's name and price.
        //         Expected: Cheapest: C (3900)
        //         Hint: track the INDEX of the minimum, then use it for both arrays.

        // TODO 5: Find the second largest value in {20, 40, 15, 35, 10} in a single pass (no sorting).
        //         Expected: 35
        //         Hint: keep two variables, largest and second. When you find a new largest,
        //               the old largest becomes second.

        // TODO 6 (DSA classic): Reverse int[] arr = {1, 2, 3, 4, 5} in place using two pointers
        //         and a temp variable (combine sections 12 and 13). No second array!
        //         Expected: [5, 4, 3, 2, 1]
        //         Then test with an even length {1, 2, 3, 4}. Expected: [4, 3, 2, 1]

        // TODO 7: Check if int[] data = {3, 7, 9, 12, 20} is sorted in increasing order.
        //         Then test with {3, 9, 7}.
        //         Expected: true, then false
        //         Hint: compare data[i] with data[i + 1]. Where must the loop stop to avoid going out of bounds?

        // TODO 8: Make a REAL copy of queues, set every value in the copy to 0,
        //         and print both arrays to prove the original didn't change.
        //         Expected: original [25, 40, 25], copy [0, 0, 0]
    }
}