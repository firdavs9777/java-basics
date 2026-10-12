package day6;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Day 6 · Stacks and Queues
 * Stack = LIFO (last in, first out, like plates). Queue = FIFO (first in, first out, like cars at a pump).
 * PriorityQueue = always gives you the smallest (or largest) item first.
 * DSA: stacks -> brackets, undo, DFS. Queues -> BFS. PriorityQueue -> top-K, Dijkstra, scheduling.
 */
public class StacksAndQueues {

    record Car(String plate, int liters) {
    }

    public static void main(String[] args) {
        // 1. ArrayDeque as a STACK: push / pop / peek all work on the top. Big-O: O(1) each.
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Chilonzor");
        stack.push("Bodomzor");
        stack.push("Sergeli");
        System.out.println(stack.peek()); // Sergeli (look, don't remove)
        System.out.println(stack.pop());  // Sergeli (remove top)
        System.out.println(stack.pop());  // Bodomzor
        System.out.println(stack);        // [Chilonzor]

        // 2. Why not java.util.Stack? It is an old class (extends Vector): synchronized = slower,
        // and it lets you insert in the middle. The Java docs themselves say: use ArrayDeque.

        // 3. ArrayDeque as a QUEUE: offer (add to back) / poll (take from front) / peek. Big-O: O(1) each.
        Queue<String> pumpQueue = new ArrayDeque<>();
        pumpQueue.offer("01A123BC");
        pumpQueue.offer("01B777AA");
        pumpQueue.offer("10C555DD");
        System.out.println(pumpQueue.peek()); // 01A123BC (first car)
        System.out.println(pumpQueue.poll()); // 01A123BC is served
        System.out.println(pumpQueue.size()); // 2
        // Trap: poll()/peek() return null on empty; pop()/remove() THROW NoSuchElementException.
        Queue<String> empty = new ArrayDeque<>();
        System.out.println(empty.poll());     // null
        // Trap 2: ArrayDeque does NOT allow null elements (offer(null) throws NPE).

        // 4. PriorityQueue = MIN-HEAP by default. Big-O: offer/poll O(log n), peek O(1).
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5300);
        minHeap.offer(4300);
        minHeap.offer(4800);
        System.out.println(minHeap.poll()); // 4300 (cheapest first)
        System.out.println(minHeap.poll()); // 4800
        // Trap: printing a PriorityQueue does NOT show sorted order; only poll() order is sorted.

        // 5. MAX-HEAP: pass Comparator.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(20);
        maxHeap.offer(60);
        maxHeap.offer(35);
        System.out.println(maxHeap.poll()); // 60 (longest queue first)

        // 6. PriorityQueue of objects by a field: tell it HOW to compare
        PriorityQueue<Car> byLiters = new PriorityQueue<>(Comparator.comparingInt(Car::liters));
        byLiters.offer(new Car("01A123BC", 40));
        byLiters.offer(new Car("01B777AA", 10));
        byLiters.offer(new Car("10C555DD", 25));
        while (!byLiters.isEmpty()) {
            Car c = byLiters.poll();
            System.out.println(c.plate() + " needs " + c.liters() + "L"); // 10L, then 25L, then 40L
        }

        // 7. Simulate a pump: each car takes 5 minutes, print when each one finishes
        Queue<String> cars = new ArrayDeque<>();
        cars.offer("Damas");
        cars.offer("Nexia");
        cars.offer("Cobalt");
        int minute = 0;
        while (!cars.isEmpty()) {
            minute += 5;
            System.out.println(cars.poll() + " done at minute " + minute); // Damas 5, Nexia 10, Cobalt 15
        }

        // ===== Exercises =====
        // TODO 1: Reverse the String "Chilonzor" using an ArrayDeque<Character> as a stack.
        // TODO 2: Two pumps, one queue: give cars alternately to pump A and pump B; print each pump's list.
        // TODO 3: Using a PriorityQueue<Car>, serve the car with the MOST liters first (max-heap by field).
        // TODO 4 (LeetCode 20 "Valid Parentheses"): check "([]{})" is valid using an ArrayDeque stack.
        // TODO 5 (LeetCode 215 "Kth Largest Element in an Array"): use a min-heap of size k.
    }
}
