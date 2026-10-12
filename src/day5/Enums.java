package day5;

import java.util.EnumMap;
import java.util.Map;

/*
 * Day 5 · Lesson 3: Enums
 * An enum = a type with a fixed list of values (fuel types, order statuses). No typos like "AI-92" vs "AI92".
 * Spring: enums map to DB columns (@Enumerated) and JSON fields like "status": "PAID".
 * DSA: enums show up for directions (UP, DOWN, LEFT, RIGHT) in grid problems.
 */
public class Enums {

    enum FuelType { AI80, AI92, AI95, GAS, ELECTRIC }

    // Enum with fields + constructor + method. Each constant calls the constructor.
    enum Fuel {
        AI80(4300), AI92(5300), AI95(6900), GAS(3500), ELECTRIC(1000);

        private final int pricePerLiter; // so'm (per kWh for ELECTRIC)

        Fuel(int pricePerLiter) { // enum constructors are always private
            this.pricePerLiter = pricePerLiter;
        }

        int getPrice() { return pricePerLiter; }

        int costFor(int liters) { return liters * pricePerLiter; }
    }

    public static void main(String[] args) {
        // 1. Using an enum value
        FuelType myFuel = FuelType.AI92;
        System.out.println("I need " + myFuel); // I need AI92

        // 2. values(), ordinal(), name()
        for (FuelType f : FuelType.values()) {
            System.out.println(f.ordinal() + ": " + f.name()); // 0: AI80, 1: AI92, ...
        }
        // Trap: don't store ordinal() in a DB; adding a new constant in the middle shifts all numbers.

        // 3. valueOf: String -> enum (exact, case-sensitive)
        FuelType parsed = FuelType.valueOf("AI95");
        System.out.println(parsed == FuelType.AI95); // true (== is safe for enums: one object per constant)
        try {
            FuelType.valueOf("ai95");
        } catch (IllegalArgumentException e) {
            System.out.println("No such fuel: ai95");
        }

        // 4. switch on an enum (no `FuelType.` prefix inside cases)
        String pump = switch (myFuel) {
            case AI80, AI92, AI95 -> "petrol pump";
            case GAS -> "gas pump";
            case ELECTRIC -> "charger";
        };
        System.out.println("Go to the " + pump); // Go to the petrol pump

        // 5. Enum with fields and methods
        System.out.println("AI95 price: " + Fuel.AI95.getPrice() + " so'm");       // 6900 so'm
        System.out.println("30 L of GAS: " + Fuel.GAS.costFor(30) + " so'm");       // 105000 so'm
        Fuel cheapest = Fuel.AI80;
        for (Fuel f : Fuel.values()) {
            if (f.getPrice() < cheapest.getPrice()) {
                cheapest = f;
            }
        }
        System.out.println("Cheapest at Chilonzor: " + cheapest); // ELECTRIC

        // 6. EnumMap: a fast Map whose keys are enum constants (kept in declaration order)
        Map<FuelType, Integer> litersSold = new EnumMap<>(FuelType.class);
        litersSold.put(FuelType.AI92, 1200);
        litersSold.put(FuelType.GAS, 800);
        litersSold.put(FuelType.AI80, 300);
        System.out.println("Bodomzor sales: " + litersSold); // {AI80=300, AI92=1200, GAS=800}

        // ===== Exercises =====
        // TODO 1: Add a new FuelType DIESEL and see which switch breaks at compile time. Fix it.
        // TODO 2: Add a `boolean isPetrol()` method to Fuel (true for AI80/AI92/AI95).
        // TODO 3: Write `enum Status { WAITING, FUELING, PAID }` and a method `Status next(Status s)`.
        // TODO 4 (DSA): Write `enum Direction { UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1) }` with
        //         fields dRow, dCol. Starting at (2, 2) in a 5x5 grid, print the 4 neighbour cells.
    }
}
