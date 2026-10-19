package day1;

/*
 * Day 1 · Lesson 4: Switch and Ternary
 * Ternary = a one-line if/else that returns a value. Switch = pick one branch out of many.
 * DSA/Spring: ternaries keep min/max logic short; switch expressions map codes/statuses cleanly.
 *
 * Look for "FIXED:" and "ADDED:" comments to see what changed from your version.
 */
public class SwitchAndTernary {
    public static void main(String[] args) {
        // 1. Ternary: condition ? valueIfTrue : valueIfFalse
        int queue = 35;
        String advice = queue <= 30 ? "Go now" : "Try later";
        System.out.println(advice); // Try later

        int cheaper = 4300 < 5300 ? 4300 : 5300;
        System.out.println("Cheaper price: " + cheaper + " so'm"); // 4300

        int age = 20;
        String ageGroup = age >= 18 ? "Adult" : "Teenager"; // FIXED: clearer name than "adult"
        System.out.println("Age group: " + ageGroup);        // ADDED: print it so you can check
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

        int weekday = 4;
        switch (weekday) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day"); // FIXED: 8 isn't "not a weekday", it's not a day at all
                break;
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

        int grade = 1;
        switch (grade) {
            case 1:
                System.out.println("Elementary");
                // no break on purpose: fall-through practice
            case 2:
                System.out.println("Intermediate");
                break;
            case 3:
                System.out.println("Upper-intermediate"); // FIXED: missing ;
                break;                                     // ADDED: good habit even on the last case
        }
        // expected output with grade = 1: Elementary, Intermediate

        // 4. Modern switch expression: arrows, no fall-through, returns a value
        int day = 6;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println(dayType); // Weekend

        // Modern switch practice: TOPIK level
        int topik = 6;
        String topikLevel = switch (topik) {      // FIXED: renamed from "result" (name clash below)
            case 1, 2 -> "Beginner";              // FIXED: TOPIK I = levels 1-2
            case 3, 4 -> "Intermediate";          // FIXED: TOPIK II 3-4 = intermediate
            case 5, 6 -> "Advanced";
            default -> "Invalid level";           // FIXED: missing ;
        };                                         // FIXED: switch expression must end with ;
        System.out.println("TOPIK " + topik + ": " + topikLevel); // ADDED

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

        // ADDED: the lowercase trap, and how toLowerCase() fixes it
        String typedByUser = "BODOMZOR";
        String safeDistrict = switch (typedByUser.toLowerCase()) {
            case "chilonzor" -> "Chilonzor district";
            case "bodomzor" -> "Yunusobod district";
            default -> "Somewhere in Tashkent";
        };
        System.out.println(typedByUser + " is in " + safeDistrict); // Yunusobod district

        // ===== Exercises =====

        // TODO 1: Rewrite with a ternary: print "even" or "odd" for int n = 17.
        int n = 17;
        String parity = n % 2 == 0 ? "Even" : "Odd"; // FIXED: "double quotes" for text, 'x' is one char only
        System.out.println(n + " is " + parity);     // ADDED: 17 is Odd

        // TODO 2: Use a ternary to store the absolute value of int x = -8 (without Math.abs).
        int x = -8;
        int absoluteValue = x < 0 ? -x : x;          // FIXED: typo "absolue"
        System.out.println("|" + x + "| = " + absoluteValue); // ADDED: |-8| = 8

        // TODO 3: Given int month (1-12), use a switch expression to return the season.
        int month = 10;
        String season = switch (month) {             // FIXED: was switch (day), a silent logic bug
            case 12, 1, 2 -> "Winter";               // FIXED: removed extra comma before ->
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";                // FIXED: was "Autumn"
            case 9, 10, 11 -> "Autumn";              // FIXED: was "Winter"
            default -> "Invalid month";
        };
        System.out.println("Month " + month + " is " + season); // ADDED: Month 10 is Autumn

        // TODO 4: Given char op and two ints, compute the result with a switch expression.
        //         Handle division by zero inside the '/' case with yield.
        int num1 = 7;
        int num2 = 2;
        char sign = '/';
        int calcResult = switch (sign) {             // FIXED: renamed, "result" was already used
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {                            // FIXED: double arrow "-> ->"
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero!"); // ADDED: tell the user why it's 0
                    yield 0;
                }
                yield num1 / num2;                   // FIXED: missing ;
            }                                        // FIXED: no ; after a case block
            default -> throw new IllegalArgumentException("Invalid operator: " + sign); // FIXED: duplicated "default ->"
        };                                           // FIXED: missing ;
        System.out.println(num1 + " " + sign + " " + num2 + " = " + calcResult); // 7 / 2 = 3 (int division!)

        // ADDED: try changing sign to '+', '-', '*', and num2 to 0 to test every case
    }
}