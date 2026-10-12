package day2;

/*
 * Day 2 · Lesson 2: Nested Loops
 * A loop inside a loop: for every outer step, the inner loop runs completely.
 * DSA: 2D grids, comparing every pair, and your first taste of Big-O (n loops inside n loops = n*n).
 */
public class NestedLoops {
    public static void main(String[] args) {
        // 1. Basic nested loop: outer = rows, inner = columns
        for (int station = 1; station <= 2; station++) {
            for (int pump = 1; pump <= 3; pump++) {
                System.out.print("S" + station + "-P" + pump + " ");
            }
            System.out.println();
        }
        // expected output:
        // S1-P1 S1-P2 S1-P3
        // S2-P1 S2-P2 S2-P3

        // 2. Star rectangle
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 3. Right triangle: the inner bound depends on the outer variable
        int height = 4;
        for (int row = 1; row <= height; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // *, **, ***, ****

        // 4. Centered pyramid: spaces first, then stars
        for (int row = 1; row <= height; row++) {
            System.out.print(" ".repeat(height - row));
            System.out.println("*".repeat(2 * row - 1));
        }

        // 5. Multiplication table (printf pads columns, more on Day 2 UserInput)
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // 6. Labeled break: plain `break` exits only the inner loop; a label exits both
        int[][] queues = {{20, 40}, {15, 5}, {30, 10}}; // [station][pump] minutes
        search:
        for (int s = 0; s < queues.length; s++) {
            for (int p = 0; p < queues[s].length; p++) {
                if (queues[s][p] < 10) {
                    System.out.println("Short queue found: station " + s + ", pump " + p);
                    break search;
                }
            }
        }

        // 7. Counting operations: how much work does a nested loop do?
        int n = 100;
        long ops = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ops++;
            }
        }
        System.out.println("n = " + n + ", operations = " + ops); // 10000 = n * n
        // Big-O preview: one loop over n = O(n), nested = O(n^2).
        // For n = 100_000, n^2 = 10 billion -> too slow on LeetCode. Watch for nested loops!

        // ===== Exercises =====
        // TODO 1: Print an upside-down triangle of height 5 (*****, ****, ... , *).
        // TODO 2: Print the 9x9 multiplication table, but only the lower-left half (j <= i).
        // TODO 3: Count how many operations a loop with j starting at i+1 does for n = 100.
        //         (It is every pair once: n*(n-1)/2 = 4950. Still O(n^2).)
        // TODO 4 (DSA classic): Two Sum brute force. Given int[] nums = {2, 7, 11, 15} and
        //         target = 9, use two nested loops to print the indices of two numbers that add up to target.
    }
}
