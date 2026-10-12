package day6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Day 6 · Maps and Sets
 * Map = key -> value lookup (station name -> price). Set = a bag of UNIQUE items.
 * DSA: HashMap/HashSet turn O(n^2) "search again" loops into O(n). Half of easy LeetCode uses them.
 * Spring: config, JSON objects and caches are all maps under the hood.
 */
public class MapsAndSets {
    public static void main(String[] args) {
        // 1. HashMap basics. Big-O: put/get/containsKey/remove O(1) average.
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Chilonzor", 4300);
        prices.put("Bodomzor", 5300);
        prices.put("Chilonzor", 4500);                          // same key -> value is REPLACED
        System.out.println(prices.get("Chilonzor"));            // 4500
        System.out.println(prices.get("Sergeli"));              // null (missing key)
        System.out.println(prices.getOrDefault("Sergeli", 0));  // 0
        System.out.println(prices.containsKey("Bodomzor"));     // true
        prices.remove("Bodomzor");
        System.out.println(prices.size());                      // 1

        // 2. Frequency counting pattern (the #1 HashMap pattern in DSA)
        String[] visits = {"Chilonzor", "Bodomzor", "Chilonzor", "Sergeli", "Chilonzor"};
        Map<String, Integer> count = new HashMap<>();
        for (String v : visits) {
            count.put(v, count.getOrDefault(v, 0) + 1); // classic way
        }
        Map<String, Integer> count2 = new HashMap<>();
        for (String v : visits) {
            count2.merge(v, 1, Integer::sum);             // same thing, shorter
        }
        System.out.println(count.get("Chilonzor") + " " + count2.get("Chilonzor")); // 3 3

        // 3. Iterate with entrySet(). Trap: HashMap order is NOT guaranteed (don't rely on it!)
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        // 4. TreeMap: keys always SORTED. Big-O: put/get/remove/floorKey O(log n).
        TreeMap<Integer, String> byQueue = new TreeMap<>();
        byQueue.put(40, "Bodomzor");
        byQueue.put(10, "Chilonzor");
        byQueue.put(25, "Sergeli");
        System.out.println(byQueue);               // {10=Chilonzor, 25=Sergeli, 40=Bodomzor}
        System.out.println(byQueue.firstKey());    // 10
        System.out.println(byQueue.floorKey(30));  // 25 (largest key <= 30)
        System.out.println(byQueue.ceilingKey(30)); // 40 (smallest key >= 30)

        // 5. LinkedHashMap: remembers INSERTION order. Big-O same as HashMap.
        Map<String, Integer> route = new LinkedHashMap<>();
        route.put("Yunusobod", 1);
        route.put("Chilonzor", 2);
        route.put("Bodomzor", 3);
        System.out.println(route.keySet()); // [Yunusobod, Chilonzor, Bodomzor]

        // 6. Sets: HashSet (no order, O(1)), TreeSet (sorted, O(log n)), LinkedHashSet (insertion order, O(1))
        Set<String> hash = new HashSet<>();
        System.out.println(hash.add("Chilonzor")); // true
        System.out.println(hash.add("Chilonzor")); // false -> already there (duplicates ignored)
        Set<Integer> sorted = new TreeSet<>(Set.of(5300, 4300, 4800));
        System.out.println(sorted);                // [4300, 4800, 5300]
        Set<String> ordered = new LinkedHashSet<>();
        ordered.add("Sergeli");
        ordered.add("Bodomzor");
        ordered.add("Sergeli");
        System.out.println(ordered);               // [Sergeli, Bodomzor]

        // 7. Set operations: intersection (retainAll), union (addAll), difference (removeAll)
        Set<String> hasAi92 = new TreeSet<>(Set.of("Chilonzor", "Bodomzor", "Sergeli"));
        Set<String> hasMetan = new TreeSet<>(Set.of("Bodomzor", "Sergeli", "Olmazor"));
        Set<String> both = new TreeSet<>(hasAi92);
        both.retainAll(hasMetan);
        System.out.println("Both: " + both);       // Both: [Bodomzor, Sergeli]
        Set<String> any = new TreeSet<>(hasAi92);
        any.addAll(hasMetan);
        System.out.println("Any: " + any);         // Any: [Bodomzor, Chilonzor, Olmazor, Sergeli]

        // 8. When to use which:
        // HashMap / HashSet         -> default, fastest, order doesn't matter
        // TreeMap / TreeSet         -> need sorted keys or "nearest key" (floor/ceiling)
        // LinkedHashMap / LinkedHashSet -> need to keep insertion order (e.g. printing, LRU cache)

        // ===== Exercises =====
        // TODO 1: Map<String, Integer> of 4 stations -> queue minutes; print the station with the shortest queue.
        // TODO 2: Count how many times each character appears in "chilonzor" using merge().
        // TODO 3: Given two String[] of districts, print the ones that appear in BOTH (use retainAll).
        // TODO 4 (LeetCode 217 "Contains Duplicate"): return true if any int appears twice (HashSet).
        // TODO 5 (LeetCode 1 "Two Sum"): return indices of two numbers that add up to target in O(n)
        //         (HashMap<value, index>).
    }
}
