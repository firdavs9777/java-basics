package day5;

/*
 * Day 5 · Lesson 1: Inheritance
 * `extends` lets a class reuse and change (override) another class's code. Polymorphism = one type, many behaviours.
 * Spring: your classes extend Spring base classes, and Spring calls YOUR overridden methods.
 * DSA: less common in LeetCode, but you'll meet it when reading library code (every class extends Object).
 */
public class Inheritance {

    static class Vehicle {
        protected final String plate; // protected: subclasses can see it
        protected int tankLiters;

        Vehicle(String plate, int tankLiters) {
            this.plate = plate;
            this.tankLiters = tankLiters;
        }

        int refuelMinutes() {
            return 5;
        }

        String describe() {
            return plate + " (" + tankLiters + " L tank)";
        }
    }

    static class Truck extends Vehicle {
        private final int trailers;

        Truck(String plate, int tankLiters, int trailers) {
            super(plate, tankLiters); // calls Vehicle's constructor. Must be the FIRST line.
            this.trailers = trailers;
        }

        @Override // ask the compiler to check we really override something (catches typos)
        int refuelMinutes() {
            return 15;
        }

        @Override
        String describe() {
            return "Truck " + super.describe() + ", trailers: " + trailers; // super.method() reuses parent code
        }

        void honk() {
            System.out.println(plate + ": BEEP BEEP");
        }
    }

    // final class: nobody can extend it (String is final too). A final method can't be overridden.
    static final class Taxi extends Vehicle {
        Taxi(String plate) {
            super(plate, 45);
        }

        @Override
        final int refuelMinutes() {
            return 3;
        }
    }

    public static void main(String[] args) {
        // 1. A subclass gets the parent's fields and methods for free
        Truck truck = new Truck("01T555TT", 300, 2);
        System.out.println(truck.describe()); // Truck 01T555TT (300 L tank), trailers: 2

        // 2. Polymorphism: variable type is Vehicle, but the REAL object decides which method runs
        Vehicle[] queue = {new Vehicle("01A123BC", 50), new Truck("10T777AA", 250, 1), new Taxi("01X001XX")};
        int totalMinutes = 0;
        for (Vehicle v : queue) {
            System.out.println(v.describe() + " -> " + v.refuelMinutes() + " min");
            totalMinutes += v.refuelMinutes();
        }
        System.out.println("Chilonzor queue: " + totalMinutes + " min"); // 5 + 15 + 3 = 23 min

        // 3. Upcasting is automatic; downcasting needs a check
        Vehicle v = truck; // upcast: a Truck IS a Vehicle
        // v.honk();       // compile error: the Vehicle type doesn't know honk()
        if (v instanceof Truck t) { // pattern matching: check + cast in one step
            t.honk(); // 01T555TT: BEEP BEEP
        }

        // 4. Trap: a wrong cast compiles but crashes at runtime
        try {
            Vehicle taxi = new Taxi("01X002XX");
            Truck wrong = (Truck) taxi;
            wrong.honk();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: a Taxi is not a Truck");
        }

        // 5. Every class secretly extends Object -> toString(), equals(), hashCode() come from there
        Object o = truck;
        System.out.println(o.getClass().getSimpleName()); // Truck
        System.out.println(o.toString().contains("@"));    // true: default toString is ClassName@hash

        // 6. Prefer composition over inheritance: "has-a" is usually better than "is-a".
        //    A GasStation HAS pumps (a field `Pump[] pumps`); it is NOT a Pump. Use extends only for real "is-a".
        //    Java allows only ONE parent class, so inheritance is a choice you can't take back easily.

        // ===== Exercises =====
        // TODO 1: Create `static class Motorcycle extends Vehicle` with refuelMinutes() = 2 and add it to the queue.
        // TODO 2: Override toString() in Vehicle so println(vehicle) prints describe().
        // TODO 3: Try to write `class Limo extends Taxi`. Read the compiler error and explain it.
        // TODO 4: Write `static class Pump { String fuel; }` and give a GasStation class a Pump[] field (composition).
        //         Print how many pumps the "Bodomzor" station has.
    }
}
