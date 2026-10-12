package practice;

/*
 * Day 1 Practice: Variables, Types & Operators, Conditions, Switch & Ternary
 * How to use:
 *   1. Solve each method WITHOUT looking at the lesson first. Peek only when stuck.
 *   2. Run this file; check your output against the expected answer in the comment.
 *   3. Tick the method name off in ROADMAP.md, then commit.
 * Exercises marked "(lesson file)" are done directly inside the lesson. Git keeps the original.
 */
public class Day1Practice {
    public static void main(String[] args) {
        variables3();
        variables4();
        types1();
        types2();
        types3();
        types4();
        conditions3();
        conditions4();
        switch1();
        switch2();
        switch3();
        switch4();
    }

    // ----- Variables -----
    // Variables TODO 1 & 2 (lesson file): use or delete averagePrice; fix the "has no gas" labels.

    static void variables3() {
        // Declare `final int MAX_QUEUE = 60;` then try to reassign it. Read the error, then remove that line.
    }

    static void variables4() {
        // Use `var` for a local variable and hover it in IntelliJ to see the inferred type.
    }

    // ----- Types and Operators -----

    static void types1() {
        // Multiply 100_000 * 100_000 into a long. Why is it wrong? Fix it with 100_000L.
        // Expected after fix: 10000000000
    }

    static void types2() {
        // int minutes = 135 → print "2 h 15 min" using / and %.
    }

    static void types3() {
        // char ch = 'd' → print its position in the alphabet (a=0 ... z=25). Expected: 3
    }

    static void types4() {
        // int n = 4821 → print the sum of its first and last digit. Expected: 5
    }

    // ----- Conditions -----
    // Conditions TODO 1 & 2 (lesson file): shorten hasGas; rename queue_last to queueLast.

    static void conditions3() {
        // Leap year: divisible by 4, but not by 100 unless also by 400.
        // Test 2024 (leap), 1900 (not leap), 2000 (leap).
    }

    static void conditions4() {
        // Given int a, b, c, print the largest using only if/else. Test with 7, 19, 3 → 19
    }

    // ----- Switch and Ternary -----

    static void switch1() {
        // Ternary: print "even" or "odd" for int n = 17. Expected: odd
    }

    static void switch2() {
        // Ternary: absolute value of int x = -8 without Math.abs. Expected: 8
    }

    static void switch3() {
        // int month (1-12) → season with a switch expression. Test 1 → Winter, 7 → Summer.
    }

    static void switch4() {
        // char op ('+', '-', '*', '/') and two ints → result with a switch expression.
        // Handle division by zero inside the '/' case with yield.
    }

    // ===== My notes =====
    // Write down anything that confused you today:
    //
}
