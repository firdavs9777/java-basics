package day1;

/*
 * Day 1 · Lesson 1: Variables
 * A variable = a named box with a type. The type decides what can go in the box.
 * DSA: every algorithm starts with picking the right type (int vs long vs double).
 */
public class Variables {
    public static void main(String[] args) {
        String stationName = "Chilonzor";
        String secondStationName = "Bodomzor";
        int queue1 = 20;
        int queue2 = 40;
        int firstGasStationPrice = 4300;
        int secondStationPrice = 5300;
        int totalWaiting = queue1 + queue2;
        double averagePrice = (firstGasStationPrice + secondStationPrice) / 2.0; // 2.0 keeps the fraction
        boolean firstStationHasGas = false;
        boolean secondStationHasGas = true;
        System.out.println(stationName);
        System.out.println(secondStationName);
        System.out.println("Time to go the station name " + totalWaiting);
        // Note: int / int drops the fraction. Use 2.0 to get a decimal result.
        System.out.println("Average price among both stations " + averagePrice);
        System.out.println("First station has gas " + firstStationHasGas);
        System.out.println("Second station has gas " + secondStationHasGas);

        // ===== Exercises (done) =====
        // TODO 1 ✅ averagePrice now holds the real average (used on line 24).
        // TODO 2 ✅ Labels say "has gas", so "false" / "true" now mean what they say.
        // TODO 3 ✅ Reassigning gives: "cannot assign a value to final variable MAX_QUEUE".
        final int MAX_QUEUE = 60;
        System.out.println("Max queue: " + MAX_QUEUE + " min");
        // TODO 4 ✅ var lets Java infer the type. Hover `city` in IntelliJ: it shows String.
        var city = "Tashkent";
        System.out.println("City: " + city);

        System.out.println("----- Part 2 -----");
        part2();
    }

    // ===================== Part 2: everything else about variables =====================
    static void part2() {
        // 1. Naming rules (compiler enforces) vs conventions (programmers expect)
        //    Rules: letters, digits, _ and $; must NOT start with a digit; no spaces; not a keyword; case-sensitive.
        //    int 2queue;   ❌ starts with digit      int my queue; ❌ space      int class; ❌ keyword
        //    Conventions: camelCase for variables (queueMinutes), UPPER_SNAKE_CASE for constants (MAX_QUEUE),
        //    PascalCase for classes (GasStation). Name says WHAT it holds: `queueMinutes`, not `q` or `x1`.
        int queueMinutes = 25;
        int QueueMinutes = 99; // legal but different variable (case-sensitive) and bad style
        System.out.println(queueMinutes + " vs " + QueueMinutes); // 25 vs 99

        // 2. Declare vs initialize
        int liters;            // declared: the box exists but is EMPTY
        liters = 30;           // initialized: first value goes in
        int price = 4300;      // both in one line (most common)
        // int x; System.out.println(x);  ❌ error: variable x might not have been initialized
        // Local variables have NO default value; Java refuses to read an empty box.
        System.out.println(liters * price); // 129000

        // 3. Several variables in one line (fine for related values; one per line is usually clearer)
        int queueA = 10, queueB = 15, queueC = 5;
        System.out.println(queueA + queueB + queueC); // 30

        // 4. Reassigning uses the OLD value first, then stores the new one
        int fuel = 50;
        fuel = fuel - 20;      // right side computed first: 50 - 20
        System.out.println(fuel); // 30

        // 5. Swapping two variables needs a temp box (a classic DSA move)
        int first = 4300, second = 5300;
        int temp = first;
        first = second;
        second = temp;
        System.out.println(first + " " + second); // 5300 4300

        // 6. Primitive vs reference types
        //    Primitives (int, double, boolean, char, long...) store the VALUE in the box.
        //    References (String, arrays, every object) store an ADDRESS that points to an object.
        int a = 20;
        int b = a;             // copies the value
        b = 99;
        System.out.println(a); // 20 (a is untouched)

        int[] queuesX = {20, 40};
        int[] queuesY = queuesX; // copies the ADDRESS: both point to the SAME array
        queuesY[0] = 99;
        System.out.println(queuesX[0]); // 99 (!) changed through the other variable
        // This is why `==` on objects compares addresses, and why Strings need equals() (Day 3).

        // 7. null: a reference that points to nothing
        String closedStation = null;
        System.out.println(closedStation); // null
        // closedStation.length();  ❌ NullPointerException at runtime: you can't ask "nothing" for its length
        // Primitives can never be null: `int n = null;` does not compile.
        if (closedStation == null) {
            System.out.println("No station chosen yet");
        }

        // 8. Scope: a variable lives only inside the { } where it was declared
        {
            int insideOnly = 5;
            System.out.println(insideOnly); // 5
        }
        // System.out.println(insideOnly); ❌ cannot find symbol: it died at the closing }
        // More on scope in Day 3 Methods.

        // 9. Literals: how you write values
        long population = 3_000_000L;   // _ for readability, L = long
        double litersLeft = 12.5;       // decimal = double by default
        float tank = 45.5f;             // f = float
        char grade = 'A';               // single quotes = char, double quotes = String
        System.out.println(population + " " + litersLeft + " " + tank + " " + grade);

        // ===== Exercises (Part 2) → solve in practice/Day1Practice: variables5() .. variables8() =====
    }
}
