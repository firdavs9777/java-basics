package practice;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 5 Practice: Inheritance, Abstract & Interfaces, Enums  ⭐ core Spring day
 * Write your types as `static class` / `interface` / `enum` inside Day5Practice (below main).
 *
 * Done in the lesson files:
 *   Inheritance           TODO 1–3: Motorcycle, toString() in Vehicle, `extends Taxi` error
 *   AbstractAndInterfaces TODO 1–3: Payme, Card receipt, Discount lambda
 *   Enums                 TODO 1–2: add DIESEL and fix the switch, isPetrol()
 */
public class Day5Practice {
    public static void main(String[] args) {
        composition();
        shapes();
        status();
        directions();
    }

    static void composition() {
        // Write `static class Pump { String fuel; }` and a GasStation class with a Pump[] field.
        // Create "Bodomzor" with 4 pumps and print how many pumps it has.
    }

    static void shapes() {
        List<Object> placeholder = new ArrayList<>(); // replace with List<Shape>
        // DSA: `interface Shape { double area(); }` with Circle and Rectangle.
        // Put a few in a List<Shape> and print the total area.
    }

    static void status() {
        // Write `enum Status { WAITING, FUELING, PAID }` and `static Status next(Status s)`.
        // WAITING → FUELING → PAID → PAID. Print the chain.
    }

    static void directions() {
        // DSA: `enum Direction { UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1) }` with fields dRow, dCol.
        // From (2, 2) in a 5x5 grid print the 4 neighbours. Expected: (1,2) (3,2) (2,1) (2,3)
        // Bonus: from (0, 0) print only neighbours that are inside the grid.
    }

    // ↓ Your classes, interfaces and enums go here ↓

    // ===== My notes =====
    //
}
