package day3;

/*
 * Day 3 · Lesson 4: Strings
 * A String is an immutable sequence of chars. StringBuilder is its mutable, fast cousin.
 * DSA: anagrams, palindromes, frequency counts. Spring: request params, JSON, and messages are all Strings.
 */
public class Strings {
    public static void main(String[] args) {
        // 1. Immutability: methods return a NEW String, the original never changes
        String station = "Chilonzor";
        station.toUpperCase();              // result thrown away!
        System.out.println(station);        // Chilonzor
        station = station.toUpperCase();    // reassign to keep it
        System.out.println(station);        // CHILONZOR

        // 2. == vs equals (classic trap): == compares references, equals compares content
        String a = "Bodomzor";
        String b = new String("Bodomzor");
        System.out.println(a == b);                       // false
        System.out.println(a.equals(b));                  // true  <- always use this
        System.out.println(a.equalsIgnoreCase("BODOMZOR")); // true

        // 3. Common methods
        String s = "  Chilonzor Gas Station  ";
        String t = s.trim();                      // "Chilonzor Gas Station"
        System.out.println(t.length());           // 21
        System.out.println(t.charAt(0));          // C
        System.out.println(t.substring(0, 9));    // Chilonzor (end index is EXCLUSIVE)
        System.out.println(t.indexOf("Gas"));     // 10 (-1 if not found)
        System.out.println(t.contains("Station")); // true
        System.out.println(t.toLowerCase());      // chilonzor gas station
        String[] parts = "Chilonzor,Bodomzor,Yunusobod".split(",");
        System.out.println(parts.length + " " + parts[2]); // 3 Yunusobod

        // 4. compareTo: alphabetical order. <0 means "comes before", 0 equal, >0 "comes after"
        System.out.println("Bodomzor".compareTo("Chilonzor") < 0); // true

        // 5. Iterating chars
        String word = "gas";
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i) + "-");
        }
        System.out.println(); // g-a-s-
        for (char c : word.toCharArray()) System.out.print(c);
        System.out.println();

        // 6. Char arithmetic: c - 'a' maps 'a'..'z' to 0..25. Perfect index for an int[26] counter
        int[] freq = new int[26];
        for (char c : "bodomzor".toCharArray()) {
            freq[c - 'a']++;
        }
        System.out.println("o appears " + freq['o' - 'a'] + " times"); // 3

        // 7. StringBuilder: mutable, so appending in a loop doesn't create a new String each time
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString().trim());          // 1 2 3 4 5
        System.out.println(new StringBuilder("zor").reverse()); // roz
        // Why: result += x in a loop copies the whole String every time -> O(n^2). StringBuilder is O(n).

        // 8. String.join: glue pieces with a separator
        System.out.println(String.join(" | ", "Chilonzor", "Bodomzor")); // Chilonzor | Bodomzor

        // 9. Converting between String and int
        int price = Integer.parseInt("4300");     // "4300" -> 4300
        String text = String.valueOf(price + 100); // 4400 -> "4400"
        System.out.println(price + 1);   // 4301 (math)
        System.out.println(text + 1);    // 44001 (String concatenation, trap!)
        // Integer.parseInt("43a") throws NumberFormatException.

        // ===== Exercises =====
        // TODO 1: Count the vowels in "Tashkent is the capital".
        // TODO 2: Given "chilonzor", print it with the first letter uppercase: "Chilonzor".
        // TODO 3: Given "Chilonzor:20,Bodomzor:40", split and print the station with the shortest queue.
        // TODO 4: Check if two words are anagrams ("listen", "silent") using an int[26] counter.
        // TODO 5 (DSA classic): Check if a String is a palindrome using two pointers (no StringBuilder).
    }
}
