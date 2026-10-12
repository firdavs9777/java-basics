package practice;

import java.util.Arrays;

/*
 * Day 3 Practice: Methods, Recursion, Arrays, Strings  ⭐ core DSA day
 * "Write a method" exercises come as stubs, LeetCode style: replace the placeholder
 * `return` with your solution. main already tests them; compare with the expected values.
 */
public class Day3Practice {
    public static void main(String[] args) {
        // ----- Methods -----
        System.out.println(isShortQueue(10) + " " + isShortQueue(20)); // true false
        System.out.println(average(3, 4));                              // 3.5
        System.out.println(min(5, 2) + " " + min(5, 2, 9));            // 2 2
        System.out.println(countDigits(4821));                          // 4
        System.out.println(isPrime(2) + " " + isPrime(15) + " " + isPrime(97)); // true false true

        // ----- Recursion -----
        System.out.println(sumTo(10));              // 55
        System.out.println(countDigitsRec(90210));  // 5
        System.out.println(reverse("Tashkent"));    // tnekhsaT
        System.out.println(isPalindromeRec("level") + " " + isPalindromeRec("gas")); // true false

        // ----- Arrays -----
        arrays1();
        arrays2();
        arrays3();
        System.out.println(secondLargest(new int[]{20, 40, 15, 35, 10})); // 35
        int[] nums = {1, 2, 3, 4, 5};
        reverseInPlace(nums);
        System.out.println(Arrays.toString(nums));  // [5, 4, 3, 2, 1]

        // ----- Strings -----
        System.out.println(countVowels("Tashkent is the capital")); // 7
        System.out.println(capitalize("chilonzor"));                 // Chilonzor
        System.out.println(shortestQueue("Chilonzor:20,Bodomzor:40")); // Chilonzor
        System.out.println(isAnagram("listen", "silent") + " " + isAnagram("gas", "gaz")); // true false
        System.out.println(isPalindrome("racecar") + " " + isPalindrome("benzin")); // true false
    }

    // ----- Methods -----

    static boolean isShortQueue(int minutes) {
        return false; // TODO: true if minutes <= 15
    }

    static double average(int a, int b) {
        return 0; // TODO: watch out for integer division
    }

    static int min(int a, int b) {
        return 0; // TODO
    }

    static int min(int a, int b, int c) {
        return 0; // TODO: reuse min(a, b)
    }

    static int countDigits(int n) {
        return 0; // TODO: while (n > 0) loop
    }

    static boolean isPrime(int n) {
        return false; // TODO: check divisors only up to Math.sqrt(n)
    }

    // ----- Recursion -----

    static int sumTo(int n) {
        return 0; // TODO: 1 + 2 + ... + n, recursively
    }

    static int countDigitsRec(int n) {
        return 0; // TODO: recursively
    }

    static String reverse(String s) {
        return s; // TODO: hint: reverse(s.substring(1)) + s.charAt(0)
    }

    static boolean isPalindromeRec(String s) {
        return false; // TODO: compare first and last chars, recurse on the middle
    }

    // ----- Arrays -----

    static void arrays1() {
        // Create double[] prices for 4 stations and print the average price.
    }

    static void arrays2() {
        int[] queues = {20, 40, 15, 35, 10};
        // Count how many are greater than 18. Expected: 3
    }

    static void arrays3() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // Print each row's total. Expected: 6 15 24
    }

    static int secondLargest(int[] arr) {
        return 0; // TODO: single pass, no sorting
    }

    static void reverseInPlace(int[] arr) {
        // TODO: two pointers + temp variable
    }

    // ----- Strings -----

    static int countVowels(String s) {
        return 0; // TODO
    }

    static String capitalize(String s) {
        return s; // TODO
    }

    static String shortestQueue(String data) {
        return ""; // TODO: split by "," then by ":"
    }

    static boolean isAnagram(String a, String b) {
        return false; // TODO: int[26] counter with c - 'a'
    }

    static boolean isPalindrome(String s) {
        return false; // TODO: two pointers, no StringBuilder
    }

    // ===== My notes =====
    //
}
