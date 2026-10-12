package day2;

/*
 * Day 2 · Lesson 1: Loops
 * A loop repeats code. for = known count, while = until a condition changes, do-while = at least once.
 * DSA: almost every array/string problem is "loop over items and track something" (sum, count, max).
 */
public class Loops {
    public static void main(String[] args) {
        // 1. for loop: start; condition; step
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // 1 2 3 4 5
        // Off-by-one trap: i < 5 gives 1..4, i <= 5 gives 1..5. Check your bounds!

        // 2. while loop: repeat while condition is true
        int queue = 30;
        while (queue > 0) {
            queue -= 8; // each car takes 8 minutes off the queue
        }
        System.out.println("Queue after loop: " + queue); // -2
        // Trap: if the condition never becomes false, the loop runs forever.

        // 3. do-while: body runs at least once, condition checked after
        int tries = 0;
        do {
            tries++;
            System.out.println("Checking Chilonzor station, try " + tries);
        } while (tries < 2);

        // 4. break (stop the loop) and continue (skip to the next round)
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // skip even numbers
            if (i > 7) break;         // stop completely after 7
            System.out.print(i + " ");
        }
        System.out.println(); // 1 3 5 7

        // 5. Which loop? for = you know how many times. while = you don't (e.g. digits, input).
        //    do-while = must run once first (menus, "ask again" input).

        // 6. Sum and count pattern
        int[] waits = {20, 40, 15, 35, 10}; // minutes at 5 stations (arrays come on Day 3)
        int sum = 0;
        int shortCount = 0;
        for (int w : waits) {
            sum += w;
            if (w <= 20) shortCount++;
        }
        System.out.println("Total: " + sum + ", short queues: " + shortCount); // 120, 3
        System.out.println("Average: " + (double) sum / waits.length);        // 24.0

        // 7. Max-tracking pattern: start with the first item, not 0 (what if all are negative?)
        int maxWait = waits[0];
        for (int i = 1; i < waits.length; i++) {
            if (waits[i] > maxWait) maxWait = waits[i];
        }
        System.out.println("Longest queue: " + maxWait); // 40

        // 8. Digit-by-digit loop: % 10 gets the last digit, / 10 removes it
        int n = 4300;
        int digitSum = 0;
        int digitCount = 0;
        while (n > 0) {
            digitSum += n % 10;
            digitCount++;
            n /= 10;
        }
        System.out.println("Digits: " + digitCount + ", sum: " + digitSum); // 4, 7
        // Trap: for n = 0 this loop runs zero times, so 0 is counted as 0 digits.

        // ===== Exercises =====
        // TODO 1: Print all numbers from 10 down to 1 with a for loop.
        // TODO 2: Sum all even numbers from 1 to 100 (answer: 2550).
        // TODO 3: Find the minimum and its index in {20, 40, 15, 35, 10} in one loop.
        // TODO 4: Reverse the digits of int n = 1234 into 4321 using a while loop.
        // TODO 5 (DSA classic): FizzBuzz. For 1..30 print "Fizz" if divisible by 3,
        //         "Buzz" if by 5, "FizzBuzz" if by both, otherwise the number.
    }
}
