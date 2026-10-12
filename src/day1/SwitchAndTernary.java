package day1;

/*
 * Day 1 · Lesson 4: Switch and Ternary
 * Ternary = a one-line if/else that returns a value. Switch = pick one branch out of many.
 * DSA/Spring: ternaries keep min/max logic short; switch expressions map codes/statuses cleanly.
 */
public class SwitchAndTernary {
    public static void main(String[] args) {
        // 1. Ternary: condition ? valueIfTrue : valueIfFalse
        int queue = 35;
        String advice = queue <= 30 ? "Go now" : "Try later";
        System.out.println(advice); // Try later
        int cheaper = 4300 < 5300 ? 4300 : 5300;
        System.out.println("Cheaper price: " + cheaper + " so'm"); // 4300
        // Tip: don't nest ternaries deeply. If it's hard to read, use if/else.

        // 2. Classic switch with break
        int pump = 2;
        switch (pump) {
            case 1:
                System.out.println("Pump 1: AI-80");
                break;
            case 2:
                System.out.println("Pump 2: AI-92");
                break;
            case 3:
                System.out.println("Pump 3: Methane");
                break;
            default:
                System.out.println("Unknown pump");
        }

        // 3. Fall-through trap: forget break and execution "falls" into the next case
        int level = 1;
        switch (level) {
            case 1:
                System.out.println("level 1");
                // no break here!
            case 2:
                System.out.println("level 2 (oops, this also runs)");
                break;
            default:
                System.out.println("default");
        }
        // expected output: level 1, level 2 (oops, this also runs)

        // 4. Modern switch expression: arrows, no fall-through, returns a value
        int day = 6;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println(dayType); // Weekend

        // 5. yield: when a case needs several lines, use a block and `yield` the value
        int liters = 20;
        int pricePerLiter = switch (pump) {
            case 1 -> 4300;
            case 2 -> {
                System.out.println("AI-92 selected");
                yield 5300;
            }
            default -> 0;
        };
        System.out.println("Total: " + liters * pricePerLiter + " so'm"); // 106000

        // 6. Switch on String (compares with equals, case-sensitive)
        String station = "Bodomzor";
        String district = switch (station) {
            case "Chilonzor" -> "Chilonzor district";
            case "Bodomzor" -> "Yunusobod district";
            default -> "Somewhere in Tashkent";
        };
        System.out.println(station + " is in " + district);
        // Trap: "bodomzor" (lowercase) would hit default. Use station.toLowerCase() if needed.

        // ===== Exercises =====
        // TODO 1: Rewrite with a ternary: print "even" or "odd" for int n = 17.
        // TODO 2: Use a ternary to store the absolute value of int x = -8 (without Math.abs).
        // TODO 3: Given int month (1-12), use a switch expression to return the season
        //         ("Winter", "Spring", "Summer", "Autumn").
        // TODO 4: Given char op ('+', '-', '*', '/') and two ints, compute the result with a
        //         switch expression. Handle division by zero inside the '/' case with yield.
    }
}
