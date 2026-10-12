package day2;

import java.util.Scanner;

/*
 * Day 2 · Lesson 3: User Input and Formatting
 * Scanner reads what the user types (stdin). printf / String.format print values neatly.
 * DSA: some judges (HackerRank, Codeforces) feed input via stdin. Spring: formatting logs and messages.
 * This lesson WAITS for you to type. Run it and answer in the console.
 */
public class UserInput {
    public static void main(String[] args) {
        // 1. Create a Scanner on System.in (the keyboard)
        Scanner sc = new Scanner(System.in);

        // 2. Reading a String (one word) and an int
        System.out.print("Station name (one word): ");
        String station = sc.next();          // reads up to the next space
        System.out.print("Queue in minutes: ");
        int queue = sc.nextInt();

        // 3. Reading a double
        System.out.print("Price per liter in so'm (e.g. 4300.5): ");
        double price = sc.nextDouble();

        // 4. The nextInt + nextLine trap:
        // nextInt/nextDouble leave the Enter (newline) in the buffer.
        // A following nextLine() would read that empty leftover line immediately.
        sc.nextLine(); // eat the leftover newline
        System.out.print("Your full name (spaces allowed): ");
        String fullName = sc.nextLine();      // reads the whole line

        // 5. Input validation loop: keep asking until the value is valid
        int liters;
        while (true) {
            System.out.print("How many liters (1-100)? ");
            if (sc.hasNextInt()) {
                liters = sc.nextInt();
                if (liters >= 1 && liters <= 100) break;
                System.out.println("Out of range, try again.");
            } else {
                System.out.println("That is not a number, try again.");
                sc.next(); // throw away the bad token, otherwise we loop forever
            }
        }

        // 6. printf: %s = String, %d = integer, %.2f = double with 2 decimals, %n = new line
        double total = liters * price;
        System.out.printf("Hello %s! Station: %s, queue: %d min%n", fullName, station, queue);
        System.out.printf("%d liters x %.2f = %.2f so'm%n", liters, price, total);

        // 7. String.format: same as printf, but returns a String instead of printing
        String receipt = String.format("[%s] %d L, %.1f so'm", station, liters, total);
        System.out.println(receipt);
        System.out.printf("|%-10s|%5d|%n", "Bodomzor", 40); // - = left align, 5 = width

        // 8. Close the scanner when done (frees the resource)
        sc.close();
        // Modern way: try-with-resources closes it automatically:
        // try (Scanner in = new Scanner(System.in)) { ... }
        // Note: closing a Scanner on System.in also closes System.in, so create only one.

        // ===== Exercises =====
        // TODO 1: Ask for two ints and print their sum, difference, and product with printf.
        // TODO 2: Ask for a temperature in Celsius (double) and print Fahrenheit with 1 decimal.
        // TODO 3: Ask for an age and keep asking until it is between 0 and 120.
        // TODO 4: Read an int n, then read n numbers and print their average with %.2f.
    }
}
