package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/*
 * Day 7 · Exceptions
 * An exception = an object Java "throws" when something goes wrong, so you can catch and handle it.
 * DSA: you mostly avoid them (check bounds/null first), but you must read their stack traces.
 * Spring: exceptions become HTTP errors (404, 400, 500) - clean exception handling = clean APIs.
 */
public class Exceptions {

    /*
     * Hierarchy:
     *   Throwable
     *   ├── Error                (JVM problems: OutOfMemoryError, StackOverflowError - don't catch)
     *   └── Exception            (CHECKED: compiler forces you to catch or declare, e.g. IOException)
     *       └── RuntimeException (UNCHECKED: bugs, e.g. NullPointerException, ArithmeticException)
     */

    // Custom exception (used in section 5). Extends RuntimeException = unchecked (the common choice in Spring apps).
    static class NotEnoughFuelException extends RuntimeException {
        NotEnoughFuelException(String message) {
            super(message);
        }
    }

    static int fuelLeft = 30; // liters at Chilonzor station

    // `throw` creates the exception; `throws` in the signature warns callers (needed for checked ones).
    static void fillCar(int liters) throws NotEnoughFuelException {
        if (liters <= 0) {
            throw new IllegalArgumentException("Liters must be positive, got " + liters);
        }
        if (liters > fuelLeft) {
            throw new NotEnoughFuelException("Wanted " + liters + "L, only " + fuelLeft + "L left");
        }
        fuelLeft -= liters;
        System.out.println("Filled " + liters + "L, left: " + fuelLeft + "L");
    }

    public static void main(String[] args) {
        // 1. try / catch / finally. finally ALWAYS runs (good for cleanup).
        try {
            int perCar = 100 / 0; // ArithmeticException
            System.out.println(perCar);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage()); // Caught: / by zero
        } finally {
            System.out.println("finally runs no matter what");
        }

        // 2. Multiple catch blocks: the first matching one wins (put specific ones FIRST).
        String[] queues = {"20", "abc"};
        for (int i = 0; i <= 2; i++) {
            try {
                int q = Integer.parseInt(queues[i]);
                System.out.println("Queue: " + q);
            } catch (NumberFormatException e) {
                System.out.println("Not a number: " + queues[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No index " + i);
            }
        }
        // expected: Queue: 20 / Not a number: abc / No index 2

        // 3. Unchecked vs checked: catching several at once with |
        try {
            String district = null;
            System.out.println(district.length());
        } catch (NullPointerException | IllegalStateException e) {
            System.out.println("Unchecked exception: " + e.getClass().getSimpleName()); // NullPointerException
        }

        // 4. throw: our own rules in fillCar(...)
        try {
            fillCar(20);  // Filled 20L, left: 10L
            fillCar(-5);  // throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Bad input: " + e.getMessage());
        }

        // 5. Custom exception
        try {
            fillCar(50);
        } catch (NotEnoughFuelException e) {
            System.out.println("Sorry: " + e.getMessage()); // Sorry: Wanted 50L, only 10L left
        }

        // 6. try-with-resources: the resource is closed automatically (files, DB connections, Scanner).
        // IOException is CHECKED, so the compiler forces this catch.
        try (BufferedReader reader = new BufferedReader(new StringReader("Bodomzor;5300"))) {
            System.out.println("Read line: " + reader.readLine()); // Read line: Bodomzor;5300
        } catch (IOException e) {
            System.out.println("Could not read: " + e.getMessage());
        }

        // 7. Don't swallow exceptions! An empty catch hides bugs forever.
        // BAD:  catch (Exception e) { }
        // GOOD: log it, rethrow it, or handle it with a real fallback.

        // 8. Spring note: throw e.g. StationNotFoundException and a @ControllerAdvice/@ExceptionHandler
        // (or @ResponseStatus) turns it into a 404 response; uncaught ones become 500.

        // ===== Exercises =====
        // TODO 1: Make a method that returns the price at index i of int[] prices; catch the bad-index case.
        // TODO 2: Write `static int parseQueue(String s)` that throws IllegalArgumentException for
        //         negative numbers and lets NumberFormatException through. Test "15", "-3", "x".
        // TODO 3: Create a CHECKED StationClosedException (extends Exception) and see where the
        //         compiler forces you to add `throws` or try/catch.
        // TODO 4: Rethrow a low-level exception wrapped in your own: throw new NotEnoughFuelException(...)
        //         inside a catch, and pass the original as the cause (add a constructor for it).
        // TODO 5 (LeetCode 8 "String to Integer (atoi)"): implement it WITHOUT Integer.parseInt and
        //         without throwing - clamp to Integer.MIN_VALUE / MAX_VALUE on overflow.
    }
}
