package practice;

import java.util.HashSet;

/*
 * Day 4 Practice: Classes & Objects, Encapsulation, Static & Records
 * Write your classes as `static class` / `record` inside Day4Practice (below main).
 *
 * Done in the lesson files:
 *   ClassesAndObjects TODO 1–3: add `open`, add a chained constructor, isCheaperThan()
 *   Encapsulation     TODO 1–2: add isOpen/setOpen, reject prices above 20000
 *   StaticAndRecords  TODO 1–2: add totalCost(); remove hashCode() and explain the set size
 */
public class Day4Practice {
    public static void main(String[] args) {
        classes4();
        classes5();
        bankCard();
        intStack();
        payment();
        uniqueCars();
    }

    static void classes4() {
        // Make an array of 3 GasStation objects (write a small class below) and
        // print the one with the shortest queue.
    }

    static void classes5() {
        // DSA: write `static class ListNode { int val; ListNode next; }` below with a constructor,
        // build 1 -> 2 -> 3 and print it with a while loop (stop when node == null).
        // Expected: 1 -> 2 -> 3
    }

    static void bankCard() {
        // Write class BankCard below: private balance, deposit(int), pay(int).
        // pay must refuse (throw or return false) when the balance is too small. Test both cases.
    }

    static void intStack() {
        // DSA: write `static class IntStack` below with a private int[] and private int size,
        // public push(int), pop(), isEmpty(). pop() on an empty stack throws.
        // Test: push 1, 2, 3 → pop three times → 3 2 1, then a 4th pop throws (catch it).
    }

    static void payment() {
        // Write `record Payment(String method, int amountSom)` below that rejects amountSom <= 0.
    }

    static void uniqueCars() {
        HashSet<String> placeholder = new HashSet<>(); // replace with HashSet<Car>
        // DSA: write `record Car(String plate, int liters)` below. Add 5 cars (some duplicates)
        // to a HashSet and print how many unique cars came.
    }

    // ↓ Your classes and records go here ↓

    // ===== My notes =====
    //
}
