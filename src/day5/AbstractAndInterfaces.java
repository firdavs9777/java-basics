package day5;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 5 · Lesson 2: Abstract classes and Interfaces
 * An interface = a contract ("can do X"). An abstract class = a half-built parent you can't `new` directly.
 * Spring: you depend on interfaces (PaymentService), Spring injects the real implementation (dependency injection).
 * DSA: List, Map, Queue, Comparator are interfaces. Lambdas implement functional interfaces.
 */
public class AbstractAndInterfaces {

    // Abstract class: shared code + an abstract method each child MUST implement.
    abstract static class Pump {
        protected final int number;

        Pump(int number) { this.number = number; }

        abstract String fuel(); // no body

        void start() { System.out.println("Pump " + number + " pumping " + fuel()); }
    }

    static class GasPump extends Pump {
        GasPump(int number) { super(number); }

        @Override
        String fuel() { return "AI92"; }
    }

    // Interface: just WHAT, not HOW.
    interface PaymentMethod {
        boolean pay(int amount);

        default void printReceipt(int amount) { // default method: has a body, implementations may override
            System.out.println("Receipt: " + amount + " so'm");
        }
    }

    interface Refundable {
        void refund(int amount);
    }

    static class Cash implements PaymentMethod {
        @Override
        public boolean pay(int amount) { // interface methods are public, so the override must be public
            System.out.println("Paid " + amount + " so'm in cash");
            return true;
        }
    }

    // One class can implement MANY interfaces (but extend only ONE class).
    static class Card implements PaymentMethod, Refundable {
        private int balance;

        Card(int balance) { this.balance = balance; }

        @Override
        public boolean pay(int amount) {
            if (amount > balance) {
                System.out.println("Card declined: not enough money");
                return false;
            }
            balance -= amount;
            System.out.println("Paid " + amount + " so'm by card, left " + balance);
            return true;
        }

        @Override
        public void refund(int amount) { balance += amount; }
    }

    // Programming to an interface: this method works with ANY PaymentMethod, even ones not written yet.
    // Spring does the same: `PaymentMethod payment` in a constructor, and Spring passes in Card or Cash.
    static void checkout(PaymentMethod payment, int amount) {
        if (payment.pay(amount)) {
            payment.printReceipt(amount);
        }
    }

    @FunctionalInterface // exactly ONE abstract method -> can be implemented by a lambda
    interface Discount {
        int apply(int price);
    }

    // Sealed: only the listed classes may implement it (the compiler knows ALL the cases).
    sealed interface Fuel permits Petrol, Electric {}
    record Petrol(int octane) implements Fuel {}
    record Electric(int kw) implements Fuel {}

    public static void main(String[] args) {
        // 1. Abstract class: `new Pump(1)` would not compile; use a concrete child
        Pump pump = new GasPump(1);
        pump.start(); // Pump 1 pumping AI92

        // 2. Interface + two implementations, used through the interface type
        checkout(new Cash(), 86000);
        checkout(new Card(50000), 86000); // Card declined: not enough money

        // 3. Multiple interfaces: the same object can be seen as either type
        Card card = new Card(100000);
        Refundable r = card;
        r.refund(5000);
        checkout(card, 43000); // left 62000

        // 4. List<...> style: declare the interface, choose the implementation on the right
        List<PaymentMethod> methods = new ArrayList<>(); // could switch to LinkedList with no other change
        methods.add(new Cash());
        methods.add(card);
        System.out.println("Payment methods: " + methods.size()); // 2

        // 5. Functional interface implemented by a lambda (more on Day 6/7)
        Discount loyalty = price -> price * 90 / 100;
        System.out.println("With 10% off: " + loyalty.apply(4300)); // 3870

        // 6. Sealed interface + pattern matching switch: no default needed, all cases are known
        Fuel fuel = new Electric(50);
        String info = switch (fuel) {
            case Petrol p -> "Petrol AI" + p.octane();
            case Electric e -> "Charging at " + e.kw() + " kW";
        };
        System.out.println(info); // Charging at 50 kW

        // ===== Exercises =====
        // TODO 1: Add `static class Payme implements PaymentMethod` (mobile payment) and checkout with it.
        // TODO 2: Override printReceipt in Card so it also prints "card ****".
        // TODO 3: Write a Discount lambda for "minus 500 so'm, but never below 0" and test it.
        // TODO 4 (DSA): Write `interface Shape { double area(); }` with Circle and Rectangle,
        //         put them in a List<Shape> and print the total area.
    }
}
