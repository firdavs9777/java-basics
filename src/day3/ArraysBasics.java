package day3;

import java.util.Arrays;

/*
 * Day 3 · Lesson 1: Arrays (FINAL)
 * An array = fixed-size row of boxes of the same type, accessed by index starting at 0.
 * DSA: arrays are THE most common LeetCode input. Two pointers, sliding window, prefix sums all live here.
 * (Class is named ArraysBasics so it doesn't clash with java.util.Arrays.)
 *
 * Look for "FIXED:" and "NOTE:" comments to see what changed from your version.
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

        // My practice
        int[] numbers = new int[4];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[3] = 3;                                   // index 2 skipped on purpose -> stays 0
        String[] names2 = {"Firdavs", "Tony", "Micheal"};
        System.out.println(names2);                       // [Ljava.lang.String;@... (the trap!)
        System.out.println(Arrays.toString(names2));      // NOTE: [Firdavs, Tony, Micheal]
        System.out.println(Arrays.toString(numbers));     // NOTE: [1, 2, 0, 3]

        // 2. length (a field, no parentheses!) and the last index
        System.out.println("Count: " + stations.length);                 // 3
        System.out.println("Last: " + stations[stations.length - 1]);    // Yunusobod
        // Trap: stations[3] -> ArrayIndexOutOfBoundsException. Valid indexes are 0 .. length-1.
        // Trap: arrays use .length, Strings use .length(), lists use .size(). Classic interview typo!

        // My practice
        System.out.println("Count: " + names2.length);                   // 3
        System.out.println("Count: " + numbers.length);                  // 4
        System.out.println("Last: " + names2[names2.length - 1]);        // Micheal  (FIXED: was printed twice)

        // 3. Default values: numbers 0, boolean false, objects (String) null
        boolean[] hasGas = new boolean[2];
        String[] emptyNames = new String[2];                             // FIXED: renamed so TODO 4 can use "names"
        System.out.println(hasGas[0] + " " + emptyNames[0]);             // false null
        // Trap: emptyNames[0].length() would crash with NullPointerException, there's no String there yet.

        // My practice
        boolean[] hasInfo = new boolean[3];
        String[] cities = new String[3];
        System.out.println(hasInfo[0] + " " + cities[0]);                // false null

        // 4. Changing values
        queues[2] = 25;                              // Yunusobod's queue grew
        queues[0] += 5;                              // compound assignment works on elements too
        System.out.println(Arrays.toString(queues)); // [25, 40, 25]
        // NOTE: your experiment "queues[1] += 30" changed every result below (sum, max, search...).
        //       Experiment, run, then undo it, so the comments stay true:
        // queues[1] += 30;

        // 5. Classic for (need the index) vs enhanced for (just the values)
        for (int i = 0; i < stations.length; i++) {
            System.out.println(i + ". " + stations[i] + " -> " + queues[i] + " min");
        }
        for (String s : stations) {
            System.out.print(s + " ");
        }
        System.out.println();                        // Chilonzor Bodomzor Yunusobod
        // NOTE: in your practice loop you named the String "i". Use "i" only for int indexes,
        //       a name like "station" or "s" makes it clear it's a value, not a position.
        // Trap: in a for-each, changing the loop variable does NOT change the array:
        for (int q : queues) {
            q = 0;                                    // only changes the copy "q"
        }
        System.out.println(Arrays.toString(queues)); // still [25, 40, 25]
        // Trap: printing an array directly prints a memory-like code, e.g. [I@1b6d3586
        System.out.println(queues);
        System.out.println(Arrays.toString(queues)); // [25, 40, 25]

        // 6. java.util.Arrays helpers
        int[] prices = {5300, 4300, 4800};           // FIXED: was commented out, but copyOf below needs it
        Arrays.sort(prices);                         // sorts in place, O(n log n)
        System.out.println(Arrays.toString(prices)); // [4300, 4800, 5300]
        int[] filled = new int[4];
        Arrays.fill(filled, 7);
        Arrays.fill(filled, 8);                      // fills again, overwriting the 7s
        System.out.println(Arrays.toString(filled)); // FIXED comment: [8, 8, 8, 8]
        int[] bigger = Arrays.copyOf(prices, 5);     // extra slots get 0
        System.out.println(Arrays.toString(bigger)); // [4300, 4800, 5300, 0, 0]
        int[] middle = Arrays.copyOfRange(prices, 1, 3); // from index 1 up to (not incl.) 3
        System.out.println(Arrays.toString(middle)); // [4800, 5300]

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
        // FIXED: removed "Arrays.equals(x, y);" on its own line: it calculated true and threw it away.

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

        // TODO 1: Create double[] prices = {4300.5, 5300.0, 3900.0, 4800.5} and print the average.
        //         Expected: Average: 4575.25
        double[] prices2 = {4300.5, 5300.0, 3900.0, 4800.5};
        double total = 0;                // FIXED: was int. "total += q" secretly cast to int and dropped .5s
        for (double p : prices2) {
            total += p;
        }
        System.out.println("Average: " + total / prices2.length); // FIXED: used "sum" (the queue sum!) -> 4575.25

        // TODO 2: Count how many values in {20, 40, 15, 35, 10} are greater than 18.
        //         Expected: 3
        int[] values = {20, 40, 15, 35, 10};
        int count = 0;
        for (int v : values) {
            if (v > 18) {
                count++;                 // NOTE: same as count += 1, the usual Java style
            }
        }
        System.out.println(count);       // 3

        // TODO 3: Sum every row of the 2D grid from section 11 and print each row's total.
        //         Expected: Row 0: 70, Row 1: 50
        // NOTE: reused "grid" instead of making a copy (grid_n), and camelCase instead of snake_case
        for (int row = 0; row < grid.length; row++) {
            int rowSum = 0;              // reset for every row (you got this right!)
            for (int col = 0; col < grid[row].length; col++) {
                rowSum += grid[row][col];
            }
            System.out.println("Row " + row + ": " + rowSum); // FIXED: label spacing
        }

        // TODO 4: Given String[] names = {"A", "B", "C", "D"} and int[] prices = {4300, 5300, 3900, 4800},
        //         print the cheapest station's name and price.
        //         Expected: Cheapest: C (3900)
        String[] names = {"A", "B", "C", "D"};
        int[] stationPrices = {4300, 5300, 3900, 4800};   // FIXED: renamed, "prices" exists in section 6
        int minIndex = 0;
        for (int i = 1; i < stationPrices.length; i++) {  // NOTE: can start at 1, index 0 is already the start
            if (stationPrices[i] < stationPrices[minIndex]) {
                minIndex = i;
            }
        }
        System.out.println("Cheapest: " + names[minIndex] + " (" + stationPrices[minIndex] + ")"); // Cheapest: C (3900)

        // TODO 5: Find the second largest value in {20, 40, 15, 35, 10} in a single pass (no sorting).
        //         Expected: 35
        int[] testT = {20, 40, 15, 35, 10};             // FIXED: Java style is int[] name, not int name[]
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int t : testT) {
            if (t > largest) {
                second = largest;                       // old largest becomes second
                largest = t;
            } else if (t > second && t != largest) {    // ADDED: "t != largest" handles duplicates
                second = t;
            }
        }
        System.out.println(second);                     // 35
        // NOTE: the interview question: with {40, 40, 35}, your original code returned 40,
        //       because the second 40 is "> second". If "second largest" means second DISTINCT value,
        //       the answer is 35, which "t != largest" fixes. Always ask the interviewer which they mean!

        // TODO 6 (DSA classic): Reverse int[] arr in place using two pointers and a temp variable.
        //         Expected: [5, 4, 3, 2, 1], then even length [4, 3, 2, 1]
        int[] arr = {1, 2, 3, 4, 5};
        int leftS = 0;
        int rightS = arr.length - 1;
        while (leftS < rightS) {
            int temp2 = arr[leftS];
            arr[leftS] = arr[rightS];
            arr[rightS] = temp2;
            leftS++;                                   // FIXED: without these two lines,
            rightS--;                                  //        the loop never ended (infinite loop!)
        }
        System.out.println(Arrays.toString(arr));      // ADDED: [5, 4, 3, 2, 1]

        int[] evenArr = {1, 2, 3, 4};                  // ADDED: the even-length test
        leftS = 0;
        rightS = evenArr.length - 1;
        while (leftS < rightS) {
            int temp3 = evenArr[leftS];
            evenArr[leftS] = evenArr[rightS];
            evenArr[rightS] = temp3;
            leftS++;
            rightS--;
        }
        System.out.println(Arrays.toString(evenArr));  // [4, 3, 2, 1]
        // NOTE: we wrote the same loop twice. Next lesson (methods) fixes that: write it once, call it many times.

        // TODO 7: Check if an array is sorted in increasing order.
        //         Expected: true, then false
        int[] data = {3, 7, 9, 12, 20};
        boolean sorted = true;
        for (int i = 0; i < data.length - 1; i++) {    // length - 1: data[i + 1] must stay in bounds
            if (data[i] > data[i + 1]) {
                sorted = false;
                break;
            }
        }
        System.out.println(sorted);                    // ADDED: true

        int[] data2 = {3, 9, 7};
        boolean sorted2 = true;                        // ADDED: test the second array too
        for (int i = 0; i < data2.length - 1; i++) {
            if (data2[i] > data2[i + 1]) {
                sorted2 = false;
                break;
            }
        }
        System.out.println(sorted2);                   // false

        // TODO 8: Make a REAL copy of queues, set every value in the copy to 0,
        //         and print both arrays to prove the original didn't change.
        //         Expected: original [25, 40, 25], copy [0, 0, 0]
        int[] copy = Arrays.copyOf(queues, queues.length); // FIXED: "tes." typo, and copy queues itself
        for (int i = 0; i < copy.length; i++) {
            copy[i] = 0;
        }
        System.out.println("Original: " + Arrays.toString(queues)); // [25, 40, 25]
        System.out.println("Copy: " + Arrays.toString(copy));       // [0, 0, 0]
    }
}