package day4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * Day 4 · Lesson 3: static, final, equals/hashCode and records
 * static = belongs to the class (shared), instance = belongs to each object. Records = short immutable data classes.
 * DSA: HashMap/HashSet only work right if equals() and hashCode() are correct.
 * Spring: JPA entities need equals/hashCode; records are perfect for DTOs (request/response data).
 */
public class StaticAndRecords {

    static class GasStation {
        static int createdCount = 0;     // ONE counter shared by all stations
        private final String name;       // instance field: each station has its own; final = set once
        private final int pricePerLiter;

        GasStation(String name, int pricePerLiter) {
            this.name = name;
            this.pricePerLiter = pricePerLiter;
            createdCount++;
        }

        // Two stations are "equal" if their data is equal (not if they are the same object).
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GasStation other)) return false;
            return pricePerLiter == other.pricePerLiter && Objects.equals(name, other.name);
        }

        // Contract: if a.equals(b) then a.hashCode() == b.hashCode(). Override BOTH, always.
        @Override
        public int hashCode() {
            return Objects.hash(name, pricePerLiter);
        }
    }

    // Static utility method: needs no object, just input -> output (like Math.max).
    static int litersFor(int budgetSom, int pricePerLiter) {
        return budgetSom / pricePerLiter;
    }

    // Record: fields, constructor, getters, equals, hashCode and toString are generated for you.
    record Car(String plate, int liters) {
        // Compact constructor: validation only, fields are assigned automatically afterwards.
        Car {
            if (liters < 0) {
                throw new IllegalArgumentException("liters can't be negative");
            }
        }
    }

    public static void main(String[] args) {
        // 1. static vs instance: the counter is shared
        new GasStation("Chilonzor", 4300);
        new GasStation("Bodomzor", 5300);
        System.out.println("Stations created: " + GasStation.createdCount); // 2 (use ClassName.field)

        // 2. Static utility methods: call on the class, no `new` needed
        System.out.println("100000 so'm buys " + litersFor(100000, 4300) + " L"); // 23 L
        // Trap: a static method can't use instance fields directly (there is no `this` in static).

        // 3. final: the variable can't be reassigned (try `MAX_LITERS = 70;` -> compile error)
        final int MAX_LITERS = 60;
        System.out.println("Max per car: " + MAX_LITERS);

        // 4. Why == fails for objects, and equals() fixes it
        GasStation s1 = new GasStation("Chilonzor", 4300);
        GasStation s2 = new GasStation("Chilonzor", 4300);
        System.out.println(s1 == s2);      // false: different objects
        System.out.println(s1.equals(s2)); // true: same data
        String x = new String("AI92");
        System.out.println(x == "AI92");      // false  <- classic trap, always compare Strings with equals()
        System.out.println(x.equals("AI92")); // true

        // 5. hashCode matters for HashSet/HashMap: without it, "equal" stations would both be stored
        Set<GasStation> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println("Set size: " + set.size()); // 1

        // 6. Records: all that boilerplate in one line
        Car car1 = new Car("01A123BC", 40);
        Car car2 = new Car("01A123BC", 40);
        System.out.println(car1);               // Car[plate=01A123BC, liters=40]
        System.out.println(car1.equals(car2));  // true
        System.out.println(car1.plate());       // 01A123BC  (getter is plate(), not getPlate())
        // Records are immutable: there is no setter. Make a new Car to "change" it.

        // 7. Compact constructor validation
        try {
            new Car("10B777AA", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad car: " + e.getMessage());
        }

        // ===== Exercises =====
        // TODO 1: Add a static method `static int totalCost(int liters, int price)` and call it from main.
        // TODO 2: Remove hashCode() from GasStation and run again. What is the set size now? Why?
        // TODO 3: Write `record Payment(String method, int amountSom)` that rejects amountSom <= 0.
        // TODO 4 (DSA): Put 5 Car records (some duplicates) into a HashSet and print how many unique cars came.
    }
}
