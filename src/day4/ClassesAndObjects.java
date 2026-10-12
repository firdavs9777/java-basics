package day4;

/*
 * Day 4 · Lesson 1: Classes and Objects
 * A class = a blueprint (what fields + methods exist). An object = one real thing built from it with `new`.
 * DSA: every node is a tiny class, e.g. `class Node { int val; Node next; }`.
 * Spring: every bean Spring creates for you is just an object of one of your classes.
 */
public class ClassesAndObjects {

    // A class nested inside our lesson class. `static` lets main() use it without a ClassesAndObjects object.
    static class GasStation {
        String name;      // fields = the data every station has
        int queueMinutes;
        int pricePerLiter;

        // Default (no-arg) constructor. Chains to the bigger one with this(...) — must be the FIRST line.
        GasStation() {
            this("Unknown", 0, 0);
        }

        // Overloaded constructor: same name, different parameters.
        GasStation(String name) {
            this(name, 0, 4300);
        }

        // Parameterized constructor. `this.name` = the field, `name` = the parameter.
        GasStation(String name, int queueMinutes, int pricePerLiter) {
            this.name = name;
            this.queueMinutes = queueMinutes;
            this.pricePerLiter = pricePerLiter;
        }

        // A method works on THIS object's fields.
        int costFor(int liters) {
            return liters * pricePerLiter;
        }

        void addCar() {
            queueMinutes += 5; // each car adds ~5 minutes
        }

        // Without this, println prints something like day4.ClassesAndObjects$GasStation@1b6d3586
        @Override
        public String toString() {
            return name + " (queue " + queueMinutes + " min, " + pricePerLiter + " so'm/L)";
        }
    }

    public static void main(String[] args) {
        // 1. Class vs object: one blueprint, many objects, each with its own field values
        GasStation chilonzor = new GasStation("Chilonzor", 20, 4300);
        GasStation bodomzor = new GasStation("Bodomzor", 40, 5300);
        System.out.println(chilonzor); // Chilonzor (queue 20 min, 4300 so'm/L)
        System.out.println(bodomzor);  // Bodomzor (queue 40 min, 5300 so'm/L)

        // 2. Constructors: default, overloaded, chained with this(...)
        GasStation unknown = new GasStation();
        GasStation yunusobod = new GasStation("Yunusobod");
        System.out.println(unknown);   // Unknown (queue 0 min, 0 so'm/L)
        System.out.println(yunusobod); // Yunusobod (queue 0 min, 4300 so'm/L)

        // 3. Methods on objects: called with objectName.method()
        System.out.println("20 L at Chilonzor: " + chilonzor.costFor(20) + " so'm"); // 86000 so'm
        chilonzor.addCar();
        System.out.println("Chilonzor queue now: " + chilonzor.queueMinutes); // 25

        // 4. References: a variable holds an ARROW to the object, not the object itself
        GasStation sameStation = chilonzor; // no `new` -> no new object, just a second arrow
        sameStation.queueMinutes = 60;
        System.out.println(chilonzor.queueMinutes); // 60  <- trap: changing one "copy" changed both!
        System.out.println(sameStation == chilonzor); // true (same object)

        // 5. == on objects compares arrows, not contents
        GasStation a = new GasStation("Bodomzor", 40, 5300);
        System.out.println(a == bodomzor); // false: two different objects with equal data (equals() is Day 4 Lesson 3)

        // 6. null = an arrow pointing nowhere. Calling a method on it -> NullPointerException
        GasStation closed = null;
        try {
            closed.addCar();
        } catch (NullPointerException e) {
            System.out.println("NPE caught: closed station is null");
        }
        if (closed != null) { // the usual fix: check before using
            closed.addCar();
        }

        // ===== Exercises =====
        // TODO 1: Add a field `boolean open` to GasStation and print it in toString().
        // TODO 2: Add a constructor GasStation(String name, int pricePerLiter) that chains with this(...).
        // TODO 3: Add a method `boolean isCheaperThan(GasStation other)` and compare Chilonzor and Bodomzor.
        // TODO 4: Make an array of 3 GasStation objects and print the one with the shortest queue.
        // TODO 5 (DSA): Write `static class ListNode { int val; ListNode next; }` with a constructor,
        //         build the list 1 -> 2 -> 3 and print it with a while loop (stop when node == null).
    }
}
