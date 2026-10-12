package day7;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Day 7 · Lambdas and Streams
 * Lambda = a tiny anonymous function: (x) -> x * 2. Stream = a pipeline: filter -> map -> collect.
 * Spring: streams and lambdas are everywhere in service code. DSA: plain loops are often clearer
 * and faster, so use streams for "data shaping", loops for algorithms.
 */
public class LambdasAndStreams {

    record Station(String name, String district, int price, int queue) {
    }

    public static void main(String[] args) {
        // 1. Lambda syntax + the 5 most common functional interfaces (interfaces with ONE method)
        Predicate<Integer> isShort = q -> q <= 10;                 // T -> boolean
        Function<Integer, Integer> withTax = p -> p + p / 10;     // T -> R
        Consumer<String> greet = s -> System.out.println("Welcome to " + s); // T -> nothing
        Supplier<String> defaultStation = () -> "Chilonzor";       // nothing -> T
        BiFunction<Integer, Integer, Integer> total = (price, liters) -> price * liters; // (T, U) -> R
        System.out.println(isShort.test(5));          // true
        System.out.println(withTax.apply(4300));      // 4730
        greet.accept(defaultStation.get());           // Welcome to Chilonzor
        System.out.println(total.apply(4300, 20));    // 86000

        // 2. Method references: a shortcut when the lambda just calls one method
        Function<String, String> upper = String::toUpperCase; // same as s -> s.toUpperCase()
        System.out.println(upper.apply("bodomzor"));           // BODOMZOR
        List.of("A-92", "A-95").forEach(System.out::println); // same as x -> System.out.println(x)

        List<Station> stations = List.of(
                new Station("Chilonzor-1", "Chilonzor", 4300, 25),
                new Station("Bodomzor", "Yunusobod", 5300, 10),
                new Station("Chilonzor-2", "Chilonzor", 4500, 5),
                new Station("Sergeli", "Sergeli", 4300, 40));

        // 3. filter / map / collect(toList)
        List<String> cheapNames = stations.stream()
                .filter(s -> s.price() < 5000)
                .map(Station::name)
                .toList();
        System.out.println(cheapNames); // [Chilonzor-1, Chilonzor-2, Sergeli]

        // 4. sorted / distinct / limit / count
        List<Integer> uniquePrices = stations.stream().map(Station::price).distinct().sorted().toList();
        System.out.println(uniquePrices); // [4300, 4500, 5300]
        List<String> top2Shortest = stations.stream()
                .sorted((a, b) -> Integer.compare(a.queue(), b.queue()))
                .limit(2).map(Station::name).toList();
        System.out.println(top2Shortest); // [Chilonzor-2, Bodomzor]
        long longQueues = stations.stream().filter(s -> s.queue() > 20).count();
        System.out.println(longQueues);   // 2

        // 5. Sum with mapToInt (avoids boxing) and reduce
        int totalQueue = stations.stream().mapToInt(Station::queue).sum();
        int maxPrice = stations.stream().map(Station::price).reduce(0, Integer::max);
        System.out.println(totalQueue + " " + maxPrice); // 80 5300

        // 6. Collectors.groupingBy and joining
        Map<String, List<String>> byDistrict = stations.stream()
                .collect(Collectors.groupingBy(Station::district,
                        Collectors.mapping(Station::name, Collectors.toList())));
        System.out.println(byDistrict.get("Chilonzor")); // [Chilonzor-1, Chilonzor-2]
        String all = stations.stream().map(Station::name).collect(Collectors.joining(", "));
        System.out.println(all); // Chilonzor-1, Bodomzor, Chilonzor-2, Sergeli

        // 7. IntStream.range: a stream of numbers (end is EXCLUSIVE)
        System.out.println(IntStream.range(0, 5).sum());         // 0+1+2+3+4 = 10
        IntStream.rangeClosed(1, 3).forEach(i -> System.out.print("Pump " + i + " ")); // Pump 1 Pump 2 Pump 3
        System.out.println();

        // 8. Optional: "maybe a value". Never call get() blindly (it throws if empty).
        Optional<Station> cheapest = stations.stream().min((a, b) -> Integer.compare(a.price(), b.price()));
        cheapest.ifPresent(s -> System.out.println("Cheapest: " + s.name())); // Cheapest: Chilonzor-1
        Optional<Station> inMirobod = stations.stream().filter(s -> s.district().equals("Mirobod")).findFirst();
        System.out.println(inMirobod.map(Station::name).orElse("none")); // none
        Optional<String> some = Optional.of("Sergeli");
        Optional<String> nothing = Optional.empty();
        System.out.println(some.orElse("?") + " " + nothing.orElse("?")); // Sergeli ?

        // ===== Exercises =====
        // TODO 1: Write a Predicate<Station> hasShortQueue and a Function<Station, String> label,
        //         then print labels of all short-queue stations.
        // TODO 2: Using streams, compute the AVERAGE price (hint: mapToInt(...).average()).
        // TODO 3: Group stations by district and COUNT them (Collectors.counting()).
        // TODO 4: Rewrite section 4's "top2Shortest" with a plain for-loop. Which is easier to read?
        // TODO 5 (LeetCode 1365 "How Many Numbers Are Smaller Than the Current Number"): solve it once
        //         with streams and once with loops + counting array; compare.
    }
}
