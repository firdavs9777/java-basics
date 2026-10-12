package day4;

/*
 * Day 4 · Lesson 2: Encapsulation
 * Hide fields with `private`, expose safe getters/setters, and validate so an object can never be in a broken state.
 * Spring: entities, DTOs and services all use private fields + getters/setters (or records).
 * DSA: classes like a Stack hide their internal array so nobody can break it from outside.
 */
public class Encapsulation {

    /*
     * Access modifiers (who can see a field/method?):
     *
     *   modifier          | same class | same package | subclass (other pkg) | everyone
     *   ------------------+------------+--------------+----------------------+---------
     *   private           |    yes     |      no      |          no          |    no
     *   (none) = package  |    yes     |     yes      |          no          |    no
     *   protected         |    yes     |     yes      |         yes          |    no
     *   public            |    yes     |     yes      |         yes          |   yes
     *
     * Rule of thumb: fields private, methods public only if others really need them.
     * Note: the outer class can still see a nested class's private members; from another class they are hidden.
     */

    static class GasStation {
        private final String name;  // final: no setter, can never change after the constructor
        private int pricePerLiter;
        private int queueMinutes;

        GasStation(String name, int pricePerLiter) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name is required");
            }
            this.name = name;
            setPricePerLiter(pricePerLiter); // reuse the setter's validation
        }

        // Getter: read-only access. Naming convention: getX() (isX() for booleans).
        public String getName() { return name; }
        public int getPricePerLiter() { return pricePerLiter; }
        public int getQueueMinutes() { return queueMinutes; }
        public boolean isBusy() { return queueMinutes > 30; }

        // Setter with validation: the object protects itself.
        public void setPricePerLiter(int pricePerLiter) {
            if (pricePerLiter < 0) {
                throw new IllegalArgumentException("price can't be negative: " + pricePerLiter);
            }
            this.pricePerLiter = pricePerLiter;
        }

        // Often better than a raw setter: a method that says WHAT happens.
        public void carArrived() { queueMinutes += 5; }
        public void carLeft() { queueMinutes = Math.max(0, queueMinutes - 5); } // never below 0
    }

    public static void main(String[] args) {
        // 1. Create and read through getters
        GasStation chilonzor = new GasStation("Chilonzor", 4300);
        System.out.println(chilonzor.getName() + ": " + chilonzor.getPricePerLiter() + " so'm"); // Chilonzor: 4300 so'm

        // 2. Change through a setter
        chilonzor.setPricePerLiter(4500);
        System.out.println("New price: " + chilonzor.getPricePerLiter()); // 4500

        // 3. Validation in the setter stops bad data
        try {
            chilonzor.setPricePerLiter(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage()); // Rejected: price can't be negative: -100
        }
        System.out.println("Price is still " + chilonzor.getPricePerLiter()); // 4500

        // 4. Validation in the constructor: a broken object is never even created
        try {
            new GasStation("Bodomzor", -5300);
        } catch (IllegalArgumentException e) {
            System.out.println("Not created: " + e.getMessage());
        }

        // 5. Behaviour methods instead of setQueueMinutes(...): queue can't go negative
        chilonzor.carArrived();
        chilonzor.carLeft();
        chilonzor.carLeft(); // trap avoided: would be -5 with a plain field
        System.out.println("Queue: " + chilonzor.getQueueMinutes() + ", busy? " + chilonzor.isBusy()); // Queue: 0, busy? false

        // 6. Why bother? With a public field anyone could write `station.pricePerLiter = -1;`
        //    and you'd have to hunt every place in the code. With a setter there is ONE gate to guard.

        // ===== Exercises =====
        // TODO 1: Add a private field `boolean open` with isOpen() and setOpen(boolean).
        // TODO 2: Make setPricePerLiter also reject prices above 20000 so'm.
        // TODO 3: Write a class BankCard with private balance, deposit(int) and pay(int);
        //         pay must refuse (throw or return false) when the balance is too small.
        // TODO 4 (DSA): Write `static class IntStack` with a private int[] and private int size,
        //         and public push(int), pop(), isEmpty(). pop() on an empty stack should throw.
    }
}
