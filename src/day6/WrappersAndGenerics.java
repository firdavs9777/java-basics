package day6;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 6 · Wrappers and Generics
 * Wrapper = an object version of a primitive (int -> Integer). Generics = <T>, "a box for any type".
 * DSA: every collection (List, Map, Queue) stores wrappers, never primitives.
 * Spring: generics are everywhere (List<Station>, ResponseEntity<Station>, JpaRepository<Station, Long>).
 */
public class WrappersAndGenerics {

    // A generic class: T is decided when you create the Box.
    static class Box<T> {
        private final T value;

        Box(T value) {
            this.value = value;
        }

        T get() {
            return value;
        }
    }

    // A generic method: <T> before the return type. Works for List<String>, List<Integer>, ...
    static <T> T first(List<T> list) {
        return list.get(0);
    }

    public static void main(String[] args) {
        // 1. Wrapper classes: Integer, Double, Character, Boolean (one per primitive)
        Integer queue = 25;
        Double price = 4300.5;
        Character grade = 'A';
        Boolean hasGas = true;
        System.out.println(queue + " " + price + " " + grade + " " + hasGas); // 25 4300.5 A true
        System.out.println(Integer.parseInt("5300") + 1);   // 5301 (String -> int)
        System.out.println(Character.isDigit('7'));          // true

        // 2. Autoboxing (int -> Integer) and unboxing (Integer -> int) happen automatically
        List<Integer> queues = new ArrayList<>();
        queues.add(20);                 // autoboxing: 20 becomes Integer.valueOf(20)
        int firstQueue = queues.get(0); // unboxing: Integer becomes int
        System.out.println(firstQueue); // 20

        // 3. Trap: unboxing null -> NullPointerException
        Integer unknownQueue = null; // "no data yet" for Bodomzor
        try {
            int minutes = unknownQueue; // Java calls unknownQueue.intValue() -> boom
            System.out.println(minutes);
        } catch (NullPointerException e) {
            System.out.println("Caught NPE: cannot unbox null"); // Caught NPE: cannot unbox null
        }

        // 4. Trap: == on Integer compares references. Java caches only -128..127.
        Integer a = 100, b = 100;
        Integer c = 4300, d = 4300;
        System.out.println(a == b);      // true  (same cached object)
        System.out.println(c == d);      // false (two different objects!)
        System.out.println(c.equals(d)); // true  -> always use equals() for wrappers
        // DSA: map.get(x) == map.get(y) is a classic LeetCode bug. Use .equals() or unbox to int.

        // 5. Integer.MAX_VALUE / MIN_VALUE as sentinels ("start with worst possible value")
        int[] prices = {5300, 4300, 4800};
        int cheapest = Integer.MAX_VALUE;
        for (int p : prices) {
            cheapest = Math.min(cheapest, p);
        }
        System.out.println("Cheapest: " + cheapest);             // Cheapest: 4300
        System.out.println(Integer.MAX_VALUE + 1);               // -2147483648 (overflow wraps!)

        // 6. Generic class Box<T>
        Box<String> nameBox = new Box<>("Chilonzor");
        Box<Integer> priceBox = new Box<>(4300);
        String name = nameBox.get(); // no cast needed: compiler knows it is a String
        System.out.println(name + " " + priceBox.get()); // Chilonzor 4300

        // 7. Generic method <T> T first(List<T>)
        System.out.println(first(List.of("Bodomzor", "Chilonzor"))); // Bodomzor
        System.out.println(first(List.of(15, 40)));                  // 15

        // 8. Why not List<int>? Generics only work with objects, and int is a primitive.
        // List<int> bad = new ArrayList<>();  // compile error
        List<Integer> good = List.of(1, 2, 3);
        System.out.println(good); // [1, 2, 3]
        // Note: int[] is fast and primitive; List<Integer> is flexible but boxes every number.

        // ===== Exercises =====
        // TODO 1: Parse "4300", "abc" with Integer.parseInt; catch NumberFormatException for "abc".
        // TODO 2: Write a generic class Pair<A, B> with first() and second(); store ("Chilonzor", 20).
        // TODO 3: Write `static <T> T last(List<T> list)` and test it on List<String> and List<Double>.
        // TODO 4: Find the max AND min of {20, 5, 60, 35} in one loop using MIN_VALUE / MAX_VALUE sentinels.
        // TODO 5 (LeetCode 7 "Reverse Integer"): reverse the digits of an int; return 0 if it overflows
        //         (hint: compare with Integer.MAX_VALUE / 10 before multiplying).
    }
}
