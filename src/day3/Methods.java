package day3;

/*
 * Day 3 · Lesson 1: Methods
 * A method = a named, reusable block of code with inputs (parameters) and an output (return value).
 * DSA: every LeetCode answer is a method. Spring: every controller/service action is a method.
 */
public class Methods {
    public static void main(String[] args) {
        // 1. Calling a void method (does something, returns nothing)
        greet("Chilonzor");

        // 2. Calling a method that returns a value
        int total = totalPrice(20, 4300);
        System.out.println("Total: " + total + " so'm"); // 86000

        // 3. Small pure helpers: same input -> same output, no side effects
        System.out.println(isEven(40));   // true
        System.out.println(max(20, 40));  // 40

        // 4. Overloading: same name, different parameter types/count
        System.out.println(max(20, 40, 15));  // 40
        System.out.println(max(4300.5, 5300.25)); // 5300.25

        // 5. Scope: a variable lives only inside the { } where it was declared
        int queue = 30;
        if (queue > 20) {
            int extra = 5; // exists only inside this if
            queue += extra;
        }
        // System.out.println(extra); // compile error: extra is out of scope
        System.out.println(queue); // 35

        // 6. Pass-by-value with a primitive: the method gets a COPY
        int price = 4300;
        tryToRaise(price);
        System.out.println("Price after tryToRaise: " + price); // 4300 (unchanged!)

        // 7. Pass-by-value with an array: the copy is of the REFERENCE, so both point to the same array
        int[] prices = {4300, 5300};
        raiseAll(prices);
        System.out.println("prices[0] after raiseAll: " + prices[0]); // 4400 (changed!)
        // DSA: that's why sorting an array inside a method changes the caller's array.

        // ===== Exercises =====
        // TODO 1: Write static boolean isShortQueue(int minutes) that returns true if minutes <= 15.
        // TODO 2: Write static double average(int a, int b) — watch out for integer division.
        // TODO 3: Overload min for (int, int) and (int, int, int). Reuse the 2-arg one inside the 3-arg one.
        // TODO 4: Write static int countDigits(int n) using the while (n > 0) loop from Day 2.
        // TODO 5 (DSA classic): Write static boolean isPrime(int n). Only check divisors up to Math.sqrt(n).
    }

    static void greet(String station) {
        System.out.println("Welcome to " + station + " gas station!");
    }

    static int totalPrice(int liters, int pricePerLiter) {
        return liters * pricePerLiter;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int max(int a, int b, int c) {
        return max(max(a, b), c); // reuse the 2-arg version
    }

    static double max(double a, double b) {
        return a > b ? a : b;
    }

    static void tryToRaise(int price) {
        price += 100; // changes only the local copy
    }

    static void raiseAll(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] += 100; // changes the shared array
        }
    }
}
