package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Day 6 · Lists
 * List = an ordered, resizable sequence. ArrayList is the default choice (a growing array inside).
 * DSA: the go-to "dynamic array" for results, paths, and adjacency lists (List<List<Integer>>).
 * Spring: repositories and REST endpoints return List<Station> all the time.
 */
public class Lists {
    public static void main(String[] args) {
        // 1. Create an ArrayList. Declare with the interface (List), create with the class (ArrayList).
        // Big-O: get/set O(1), add at end O(1) amortized, add/remove in middle O(n), contains/indexOf O(n)
        List<String> stations = new ArrayList<>();
        stations.add("Chilonzor");
        stations.add("Bodomzor");
        stations.add("Yunusobod");
        stations.add(1, "Sergeli"); // insert at index 1, others shift right
        System.out.println(stations);                       // [Chilonzor, Sergeli, Bodomzor, Yunusobod]
        System.out.println(stations.get(0));                // Chilonzor
        stations.set(3, "Olmazor");                         // replace index 3
        System.out.println(stations.size());                // 4
        System.out.println(stations.contains("Bodomzor"));  // true
        System.out.println(stations.indexOf("Olmazor"));    // 3
        System.out.println(stations.indexOf("Mirobod"));    // -1 (not found)

        // 2. Trap: remove(int index) vs remove(Object value) on List<Integer>
        List<Integer> queues = new ArrayList<>(List.of(10, 20, 1, 40));
        queues.remove(1);                     // removes INDEX 1 (the 20), not the value 1!
        System.out.println(queues);           // [10, 1, 40]
        queues.remove(Integer.valueOf(1));    // removes the VALUE 1
        System.out.println(queues);           // [10, 40]

        // 3. Three ways to iterate
        for (int i = 0; i < stations.size(); i++) {  // classic for: when you need the index
            System.out.print(i + ":" + stations.get(i) + " ");
        }
        System.out.println();
        for (String s : stations) {                  // for-each: simplest, read-only
            System.out.print(s + " ");
        }
        System.out.println();

        // 4. Trap: removing inside for-each -> ConcurrentModificationException
        List<Integer> waits = new ArrayList<>(List.of(5, 50, 15, 70));
        try {
            for (Integer w : waits) {
                if (w > 30) waits.remove(w);
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Caught ConcurrentModificationException");
        }
        // Safe way 1: Iterator.remove()
        Iterator<Integer> it = waits.iterator();
        while (it.hasNext()) {
            if (it.next() > 30) it.remove();
        }
        System.out.println(waits); // [5, 15]
        // Safe way 2: removeIf (shortest)
        waits.removeIf(w -> w > 10);
        System.out.println(waits); // [5]

        // 5. List.of(...) is IMMUTABLE: add/remove/set throw UnsupportedOperationException
        List<String> fixed = List.of("Chilonzor", "Bodomzor");
        try {
            fixed.add("Sergeli");
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of is read-only. Copy it: new ArrayList<>(List.of(...))");
        }

        // 6. LinkedList: O(1) add/remove at both ends, but get(i) is O(n). In practice prefer
        // ArrayList for lists and ArrayDeque for queues; LinkedList is rarely the best choice.
        List<String> linked = new LinkedList<>(stations);
        System.out.println(linked.getFirst()); // Chilonzor

        // 7. Array <-> List. Trap: int[] is NOT a List<Integer>, you must convert element by element.
        String[] arr = {"Chilonzor", "Bodomzor"};
        List<String> fromArray = new ArrayList<>(Arrays.asList(arr));
        String[] backToArray = fromArray.toArray(new String[0]);
        int[] prices = {5300, 4300, 4800};
        List<Integer> priceList = new ArrayList<>();
        for (int p : prices) priceList.add(p);
        int[] backToInts = priceList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(backToArray.length + " " + priceList + " " + backToInts.length); // 2 [5300, 4300, 4800] 3

        // 8. Collections helpers: sort O(n log n), reverse O(n), max/min O(n)
        Collections.sort(priceList);
        System.out.println(priceList);                   // [4300, 4800, 5300]
        Collections.reverse(priceList);
        System.out.println(priceList);                   // [5300, 4800, 4300]
        System.out.println(Collections.max(priceList));  // 5300

        // ===== Exercises =====
        // TODO 1: Build a List<String> of 5 Tashkent districts; print the one at the middle index.
        // TODO 2: Given List<Integer> queues, remove every queue longer than 30 using removeIf.
        // TODO 3: Write `static List<Integer> merge(List<Integer> a, List<Integer> b)` that merges two
        //         SORTED lists into one sorted list in O(n + m) (two pointers, no Collections.sort).
        // TODO 4 (LeetCode 448 "Find All Numbers Disappeared in an Array"): given int[] nums with values
        //         1..n, return a List<Integer> of the numbers that never appear.
    }
}
