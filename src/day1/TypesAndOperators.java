package day1;

/*
 * Day 1 · Lesson 3: Types and Operators
 * Java has 8 primitive types. Each one has a fixed size and range.
 * DSA: overflow (int vs long) and integer division are the #1 source of wrong answers on LeetCode.
 *
 * Look for "FIXED:" and "ADDED:" comments to see what changed from your version.
 */
public class TypesAndOperators {
    public static void main(String[] args) {
        // 1. The 8 primitive types (byte, short, int, long, float, double, char, boolean)
        // For DSA you mostly need int, long, double, char, boolean.
        byte b = 127;                   // -128 .. 127
        short s = 32_000;               // -32,768 .. 32,767
        int liters = 2_000_000_000;     // about ±2.1 billion
        long totalSom = 9_000_000_000L; // huge; note the L at the end
        float f = 3.5f;                 // rarely used, prefer double
        double price = 4300.50;
        char grade = 'A';
        boolean open = true;
        System.out.println(b + " " + s + " " + liters + " " + totalSom + " " + f + " " + price + " " + grade + " " + open);
        System.out.println("int range: " + Integer.MIN_VALUE + " .. " + Integer.MAX_VALUE);

        // My example
        byte q = 127;
        short s2 = 12_000;              // FIXED: "s" already exists above -> compile error
        int myLiters = 1_000_000_000;   // FIXED: "liters" already exists above -> compile error
        long totalAmount = 9_000_000_000L;
        float fl = 4.5f;
        double priceA = 4300.20;
        char gradeF = 'F';
        boolean close = false;
        System.out.println(q + " " + s2 + " " + myLiters + " " + totalAmount + " " + fl + " " + priceA + " " + gradeF + " " + close); // ADDED

        // 2. Overflow trap: int silently wraps around when it gets too big
        int max = Integer.MAX_VALUE;
        System.out.println(max + 1);         // -2147483648 (wrapped!)
        System.out.println((long) max + 1);  // 2147483648 (cast to long first)

        // My example
        int minInt = Integer.MIN_VALUE;      // FIXED: renamed, "min" is used again in TODO 2
        System.out.println(minInt - 1);         // ADDED: 2147483647 (wraps the other way!)
        System.out.println((long) minInt - 1);  // ADDED: -2147483649

        // 3. double is not exact (binary fractions)
        System.out.println(0.1 + 0.2);        // 0.30000000000000004
        System.out.println(0.1 + 0.2 == 0.3); // false -> never compare doubles with ==

        // My example
        System.out.println(0.1 + 0.7);        // FIXED: 0.7999999999999999 (your 0.4 + 0.7 example had a wrong comment)
        System.out.println(0.1 + 0.7 == 0.8); // FIXED: missing ; -> false
        // Note: some sums like 0.1 + 0.4 happen to come out exact (0.5), so always test, never guess!

        // 4. Casting: widening is automatic, narrowing needs (type) and can lose data
        int queue = 25;
        double queueD = queue;            // widening: 25.0
        int truncated = (int) 3.9;        // narrowing: 3 (cuts, does NOT round)
        System.out.println(queueD + " " + truncated + " " + Math.round(3.9)); // 25.0 3 4

        // My example
        int queueE = 36;
        double queueEX = queueE;          // 36.0
        int cuts = (int) 4.99;            // 4
        System.out.println(queueEX + " " + cuts + " " + Math.round(4.99)); // ADDED: 36.0 4 5

        // 5. char is a number under the hood (Unicode code)
        char c = 'a';
        System.out.println(c + 1);          // 98 (char + int = int)
        System.out.println((char) (c + 1)); // b
        System.out.println('7' - '0');      // 7  (turn a digit char into its int value)

        // My example
        char letter = 'b';                  // FIXED: "b" already exists (the byte) -> compile error
        System.out.println(letter);         // b
        System.out.println((int) letter);   // ADDED: 98 (its Unicode number)
        System.out.println(letter - 'a');   // FIXED: 1 -> position in alphabet ('7' - 'b' = -43, meaningless)
        System.out.println('9' - '0');      // ADDED: 9

        // 6. Arithmetic: + - * / %
        int priceChilonzor = 4300, priceBodomzor = 5300;
        System.out.println((priceChilonzor + priceBodomzor) / 2);   // 4800
        System.out.println(7 / 2);     // 3   integer division drops the fraction (trap!)
        System.out.println(7 / 2.0);   // 3.5 one double operand -> double division
        System.out.println(7 % 2);     // 1   remainder: n % 2 == 0 means even
        System.out.println(1234 % 10); // 4   last digit
        System.out.println(1234 / 10); // 123 drop the last digit

        // My example
        int priceAndijon = 3200, priceOltinkul = 1400;
        System.out.println(priceAndijon + priceOltinkul); // FIXED: was Andijon + Andijon (6400) -> 4600
        System.out.println(12 / 2);      // 6
        System.out.println(12 / 2.0);    // 6.0
        System.out.println(13 % 2);      // 1 -> 13 is odd
        System.out.println(12345 % 10);  // 5 last digit
        System.out.println(4555 / 10);   // FIXED: "Sytem" typo -> 455

        // 7. ++ and -- : prefix changes first, postfix uses old value first
        int cars = 5;
        System.out.println(cars++); // 5 (prints, then becomes 6)
        System.out.println(++cars); // 7 (becomes 7, then prints)
        cars--;
        System.out.println(cars);   // 6

        // My example
        int motorbikes = 7;
        System.out.println(motorbikes++); // FIXED comment: 7 (prints, then becomes 8)
        System.out.println(++motorbikes); // ADDED comment: 9 (becomes 9, then prints)
        motorbikes--;
        System.out.println(motorbikes);   // ADDED comment: 8

        // 8. Compound assignment: x += y means x = x + y
        int waitMinutes = 10;
        waitMinutes += 5;  // 15
        waitMinutes *= 2;  // 30
        waitMinutes -= 4;  // 26
        waitMinutes /= 3;  // 8 (integer division again)
        System.out.println(waitMinutes); // 8

        // My example
        int waitSec = 30;
        waitSec += 5;      // 35
        waitSec *= 33;     // 1155
        waitSec /= 3;      // 385
        System.out.println(waitSec); // 385

        // 9. Math helpers
        System.out.println(Math.max(20, 40));  // 40
        System.out.println(Math.min(20, 40));  // 20
        System.out.println(Math.abs(-15));     // 15
        System.out.println(Math.pow(2, 10));   // 1024.0 (returns double!)
        System.out.println(Math.sqrt(49));     // 7.0

        // ===== Exercises =====

        // TODO 1: Declare a long and multiply two big ints (100_000 * 100_000) into it.
        //         Why is the result wrong? Fix it with 100_000L.
        long wrong = 100_000 * 100_000;   // ADDED: int * int is calculated as int FIRST, overflows,
        System.out.println(wrong);        //        then the broken value is stored: 1410065408
        long right = 100_000 * 100_000L;  // one long operand -> whole calculation done in long
        System.out.println(right);        // 10000000000
        long big = 200_000 * 200_000L;    // your example, correct!
        System.out.println(big);          // 40000000000

        // TODO 2: Given int minutes = 135, print it as "2 h 15 min" using / and %.
        int mins = 135;
        int h = mins / 60;   // 2
        int min = mins % 60; // 15
        System.out.println(h + " h " + min + " min"); // FIXED: spaces -> "2 h 15 min" (was "2h15min")

        // TODO 3: Given char ch = 'd', print its position in the alphabet (a=0 ... z=25).
        char ch = 'd';
        System.out.println(ch - 'a');     // FIXED: 3 ('d' is 100, 'a' is 97)

        // TODO 4: Given int n = 4821, print the sum of its first and last digit
        //         (hint: last = n % 10; first needs a loop tomorrow, or n / 1000 for now).
        int n = 4821;
        int last = n % 10;                // FIXED: use n, not 4821 -> 1
        int first = n / 1000;             // FIXED: use n, not 4821 -> 4
        int digitSum = first + last;      // ADDED: the actual task
        System.out.println(first + " + " + last + " = " + digitSum); // 4 + 1 = 5
    }
}