package day1;

/*
 * Day 1 · Lesson 3: Types and Operators
 * Java has 8 primitive types. Each one has a fixed size and range.
 * DSA: overflow (int vs long) and integer division are the #1 source of wrong answers on LeetCode.
 */
public class TypesAndOperators {
    public static void main(String[] args) {
        // 1. The 8 primitive types (byte, short, int, long, float, double, char, boolean)
        // For DSA you mostly need int, long, double, char, boolean.
        byte b = 127;                  // -128 .. 127
        short s = 32_000;              // -32,768 .. 32,767
        int liters = 2_000_000_000;    // about ±2.1 billion
        long totalSom = 9_000_000_000L; // huge; note the L at the end
        float f = 3.5f;                // rarely used, prefer double
        double price = 4300.50;
        char grade = 'A';
        boolean open = true;
        System.out.println(b + " " + s + " " + liters + " " + totalSom + " " + f + " " + price + " " + grade + " " + open);
        System.out.println("int range: " + Integer.MIN_VALUE + " .. " + Integer.MAX_VALUE);

        // 2. Overflow trap: int silently wraps around when it gets too big
        int max = Integer.MAX_VALUE;
        System.out.println(max + 1);         // -2147483648 (wrapped!)
        System.out.println((long) max + 1);  // 2147483648 (cast to long first)

        // 3. double is not exact (binary fractions)
        System.out.println(0.1 + 0.2);        // 0.30000000000000004
        System.out.println(0.1 + 0.2 == 0.3); // false -> never compare doubles with ==

        // 4. Casting: widening is automatic, narrowing needs (type) and can lose data
        int queue = 25;
        double queueD = queue;            // widening: 25.0
        int truncated = (int) 3.9;        // narrowing: 3 (cuts, does NOT round)
        System.out.println(queueD + " " + truncated + " " + Math.round(3.9)); // 25.0 3 4

        // 5. char is a number under the hood (Unicode code)
        char c = 'a';
        System.out.println(c + 1);          // 98 (char + int = int)
        System.out.println((char) (c + 1)); // b
        System.out.println('7' - '0');      // 7  (turn a digit char into its int value)

        // 6. Arithmetic: + - * / %
        int priceChilonzor = 4300, priceBodomzor = 5300;
        System.out.println((priceChilonzor + priceBodomzor) / 2);   // 4800
        System.out.println(7 / 2);    // 3   integer division drops the fraction (trap!)
        System.out.println(7 / 2.0);  // 3.5 one double operand -> double division
        System.out.println(7 % 2);    // 1   remainder: n % 2 == 0 means even
        System.out.println(1234 % 10); // 4  last digit
        System.out.println(1234 / 10); // 123 drop the last digit

        // 7. ++ and -- : prefix changes first, postfix uses old value first
        int cars = 5;
        System.out.println(cars++); // 5 (prints, then becomes 6)
        System.out.println(++cars); // 7 (becomes 7, then prints)
        cars--;
        System.out.println(cars);   // 6

        // 8. Compound assignment: x += y means x = x + y
        int waitMinutes = 10;
        waitMinutes += 5;  // 15
        waitMinutes *= 2;  // 30
        waitMinutes -= 4;  // 26
        waitMinutes /= 3;  // 8 (integer division again)
        System.out.println(waitMinutes); // 8

        // 9. Math helpers
        System.out.println(Math.max(20, 40));  // 40
        System.out.println(Math.min(20, 40));  // 20
        System.out.println(Math.abs(-15));     // 15
        System.out.println(Math.pow(2, 10));   // 1024.0 (returns double!)
        System.out.println(Math.sqrt(49));     // 7.0

        // ===== Exercises =====
        // TODO 1: Declare a long and multiply two big ints (100_000 * 100_000) into it.
        //         Why is the result wrong? Fix it with 100_000L.
        // TODO 2: Given int minutes = 135, print it as "2 h 15 min" using / and %.
        // TODO 3: Given char ch = 'd', print its position in the alphabet (a=0 ... z=25).
        // TODO 4: Given int n = 4821, print the sum of its first and last digit
        //         (hint: last = n % 10; first needs a loop tomorrow, or n / 1000 for now).
    }
}
