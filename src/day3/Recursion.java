package day3;

/*
 * Day 3 · Lesson 2: Recursion
 * A recursive method calls itself on a smaller problem until it hits a base case.
 * DSA: trees, DFS, backtracking, divide and conquer (merge sort) are all recursion.
 */
public class Recursion {
    public static void main(String[] args) {
        // 1. Two parts every recursion needs:
        //    base case      -> when to STOP (smallest problem, answer known)
        //    recursive case -> call yourself with a SMALLER input
        countdown(3); // 3 2 1 Go!

        // 2. Factorial: 5! = 5 * 4!  ...  1! = 1
        System.out.println("5! = " + factorial(5)); // 120
        // Trap: 13! already overflows int. That's why factorial returns long.

        // 3. Fibonacci (naive): fib(n) = fib(n-1) + fib(n-2)
        System.out.println("fib(10) = " + fib(10)); // 55
        // It is SLOW: fib(n) calls itself twice, so work roughly doubles each step (O(2^n)).
        // Try fib(45) and feel it. Later: fix it with memoization (DP) or a simple loop.

        // 4. Sum of digits: last digit + sum of the rest
        System.out.println("sumDigits(4300) = " + sumDigits(4300)); // 7

        // 5. Power: base^exp = base * base^(exp-1)
        System.out.println("power(2, 10) = " + power(2, 10)); // 1024

        // 6. How the call stack works (factorial(3)):
        //    factorial(3) waits for factorial(2)
        //      factorial(2) waits for factorial(1)
        //        factorial(1) returns 1          <- base case, stack starts unwinding
        //      factorial(2) returns 2 * 1 = 2
        //    factorial(3) returns 3 * 2 = 6
        // Each call is a "frame" on the stack holding its own n.
        traceFactorial(3, "");

        // 7. StackOverflowError: forget the base case (or never get smaller) and the stack fills up.
        //    static int broken(int n) { return broken(n - 1); }  // never stops -> StackOverflowError
        //    Even correct recursion can overflow with very deep input (~10_000+ calls).
        //    We do NOT run it here, just remember: always write the base case FIRST.

        // ===== Exercises =====
        // TODO 1: Write a recursive static int sumTo(int n) that returns 1 + 2 + ... + n.
        // TODO 2: Write a recursive static int countDigits(int n).
        // TODO 3: Write a recursive static String reverse(String s)
        //         (hint: reverse(s.substring(1)) + s.charAt(0)).
        // TODO 4 (DSA classic): Write a recursive static boolean isPalindrome(String s)
        //         that compares the first and last chars and recurses on the middle.
    }

    static void countdown(int n) {
        if (n == 0) {                 // base case
            System.out.println("Go!");
            return;
        }
        System.out.print(n + " ");
        countdown(n - 1);             // recursive case, smaller input
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static int fib(int n) {
        if (n <= 1) return n;         // fib(0) = 0, fib(1) = 1
        return fib(n - 1) + fib(n - 2);
    }

    static int sumDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumDigits(n / 10);
    }

    static long power(int base, int exp) {
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }

    static long traceFactorial(int n, String indent) {
        System.out.println(indent + "enter factorial(" + n + ")");
        long result = (n <= 1) ? 1 : n * traceFactorial(n - 1, indent + "  ");
        System.out.println(indent + "return " + result);
        return result;
    }
}
