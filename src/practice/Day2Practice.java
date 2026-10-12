package practice;

import java.util.Scanner;

/*
 * Day 2 Practice: Loops, Nested Loops, User Input
 * Solve without looking at the lesson first. Run and compare with the expected answers.
 * The input exercises are commented out in main so the file doesn't wait for typing.
 * Uncomment one to try it.
 */
public class Day2Practice {
    public static void main(String[] args) {
        loops1();
        loops2();
        loops3();
        loops4();
        loops5();
        nested1();
        nested2();
        nested3();
        nested4();

        // Scanner in = new Scanner(System.in);
        // input1(in);
        // input2(in);
        // input3(in);
        // input4(in);
        // in.close();
    }

    // ----- Loops -----

    static void loops1() {
        // Print 10 down to 1 with a for loop.
    }

    static void loops2() {
        // Sum all even numbers from 1 to 100. Expected: 2550
    }

    static void loops3() {
        int[] queues = {20, 40, 15, 35, 10};
        // Find the minimum and its index in ONE loop. Expected: min 10 at index 4
    }

    static void loops4() {
        int n = 1234;
        // Reverse the digits with a while loop. Expected: 4321
    }

    static void loops5() {
        // FizzBuzz 1..30: "Fizz" if divisible by 3, "Buzz" by 5, "FizzBuzz" by both, else the number.
    }

    // ----- Nested Loops -----

    static void nested1() {
        // Upside-down triangle of height 5: *****, ****, ***, **, *
    }

    static void nested2() {
        // 9x9 multiplication table, lower-left half only (j <= i).
    }

    static void nested3() {
        // Count operations of: for i in 0..n-1, for j in i+1..n-1 with n = 100. Expected: 4950
    }

    static void nested4() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // Two Sum brute force: print indices of two numbers that add up to target. Expected: 0 1
    }

    // ----- User Input -----

    static void input1(Scanner in) {
        // Ask for two ints, print sum, difference and product with printf.
    }

    static void input2(Scanner in) {
        // Ask for Celsius (double), print Fahrenheit with 1 decimal. F = C * 9 / 5 + 32
    }

    static void input3(Scanner in) {
        // Ask for an age; keep asking until it is between 0 and 120.
    }

    static void input4(Scanner in) {
        // Read n, then n numbers; print their average with %.2f.
    }

    // ===== My notes =====
    //
}
