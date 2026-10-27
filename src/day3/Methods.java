package day3;

import java.util.Arrays;

/*
 * Day 3 · Lesson 2: Methods
 * A method = a named, reusable block of code with inputs (parameters) and an output (return value).
 * DSA: every LeetCode answer is a method. Spring: every controller/service action is a method.
 *
 * Shape:  static  returnType  methodName(Type param, ...) { ... return value; }
 * - "static" for now, so main can call them directly (the classes lesson explains why).
 * - Methods live INSIDE the class but OUTSIDE main. Above or below main, Java doesn't care.
 */
public class Methods {
    public static void main(String[] args) {
        // 1. Calling a void method (does something, returns nothing)
        greet("Chilonzor");
        greet("Andijon");// Welcome to Chilonzor gas station!

        // 2. Calling a method that returns a value
        int total = totalPrice(20, 4300);
        System.out.println("Total: " + total + " so'm"); // 86000
        int multiplication = totalPrice(12,22);
        // Trap: totalPrice(20, 4300); on its own line computes 86000 and throws it away.

        // 3. Small pure helpers: same input -> same output, no side effects
        System.out.println(isEven(40));// true
        System.out.println(isEven(21)); // false
        System.out.println(max(20, 40));  // 40
        System.out.println(max(1,33)); // 33 is the max number

        // 4. Overloading: same name, different parameter types/count. Java picks the matching one.
        System.out.println(max(20, 40, 15));       // 40
        System.out.println(max(4300.5, 5300.25));  // 5300.25
        // Trap: overloading by return type ONLY (int max(int,int) vs double max(int,int)) is a compile error.

        // 5. Early return: handle special cases first, every path must end in a return
        System.out.println(queueLabel(false, 5));   // no gas
        System.out.println(queueLabel(true, 8));    // short queue
        System.out.println(queueLabel(true, 25));   // medium queue
        System.out.println(queueLabel(true, 45));   // long queue

        // 6. Arrays in, values or arrays out. Methods can call other methods.
        int[] queues = {20, 40, 15, 35, 10};
        System.out.println(sum(queues));                        // 120
        System.out.println(average(queues));                    // 24.0
        System.out.println(Arrays.toString(doubled(queues)));   // [40, 80, 30, 70, 20]
        System.out.println(Arrays.toString(queues));            // unchanged: [20, 40, 15, 35, 10]

        // 7. Scope: a variable lives only inside the { } where it was declared
        int queue = 30;
        if (queue > 20) {
            int extra = 5; // exists only inside this if
            queue += extra;
        }
        // System.out.println(extra); // compile error: extra is out of scope
        System.out.println(queue); // 35
        // Good news: "total" in main and "total" inside sum() are DIFFERENT variables. No name clash
        // across methods, which fixes most of the "already defined" errors you hit in Day 3.

        // 8. Pass-by-value with a primitive: the method gets a COPY
        int price = 4300;
        tryToRaise(price);
        System.out.println("Price after tryToRaise: " + price); // 4300 (unchanged!)
        // Want the new value? Return it and store it:
        price = raised(price);
        System.out.println("Price after raised: " + price);     // 4400

        // 9. Pass-by-value with an array: the copy is of the REFERENCE, so both point to the same array
        int[] prices = {4300, 5300};
        raiseAll(prices);
        System.out.println("prices after raiseAll: " + Arrays.toString(prices)); // [4400, 5400] (changed!)
        // DSA: that's why sorting an array inside a method changes the caller's array.

        // 10. Recursion preview: a method that calls itself on a smaller problem.
        System.out.println(factorial(5)); // 120
        // Without a base case it never stops -> StackOverflowError. Trees and DFS use this later.

        // ===== Exercises =====
        // Rules: write each method next to the others (outside main), call it here, run, compare.

        // TODO 1: Write static boolean isShortQueue(int minutes) that returns true if minutes <= 15.
        //         Print isShortQueue(10) and isShortQueue(20). Expected: true, false
        //         Hint: no if/else needed, the comparison itself is a boolean (see isEven).
        System.out.println(isShortQueue(10)); // true
        System.out.println(isShortQueue(20)); // false


        // TODO 2: Write static double average(int a, int b). Watch out for integer division.
        //         Print average(15, 20). Expected: 17.5
        //         Note: this overloads average(int[]) from section 6. Both can exist!

        System.out.println(average(15,20));
        // TODO 3: Overload min for (int, int) and (int, int, int). Reuse the 2-arg one inside the 3-arg one.
        //         Print min(20, 40) and min(20, 40, 15). Expected: 20, 15
        System.out.println(min(20, 40, 15));       // 40
        System.out.println(min(4300.5, 5300.25));
        // TODO 4: Write static int countDigits(int n) using the while (n > 0) loop from Day 2.
        //         Print countDigits(4821). Expected: 4
        //         Edge case: what does countDigits(0) return? It should be 1. Fix it with an early return.

        System.out.println(countDigits(1234));
        // TODO 5 (DSA classic): Write static boolean isPrime(int n). Only check divisors up to Math.sqrt(n).
        //         Print isPrime(2), isPrime(17), isPrime(21), isPrime(1). Expected: true, true, false, false
        //         Hints: numbers below 2 are not prime (early return). If any i from 2 to sqrt(n) divides n
        //         (n % i == 0), return false right away. Loop condition trick: i * i <= n.

        System.out.println(isPrime(22));
        // TODO 6: Write static int indexOfMin(int[] numbers) returning the INDEX of the smallest value.
        //         Print indexOfMin(queues). Expected: 4
        System.out.println(indexOfMin( new int[] {11,22,2,1}));

        // TODO 7: Write static void reverseInPlace(int[] arr) using your Day 3 two-pointer code.
        //         Call it on {1, 2, 3, 4, 5} and {1, 2, 3, 4}, print both.
        //         Expected: [5, 4, 3, 2, 1] and [4, 3, 2, 1]
        //         Answer in a comment: why does it work even though it returns void? (Hint: section 9)

        int[] t = {1,2,3,4,5};
        reverseInPlace(t);                        // step 1: reverse it
        System.out.println(Arrays.toString(t));
        // TODO 8: Write static boolean isSorted(int[] arr) with an early return false.
        //         Print isSorted(new int[]{3, 7, 9, 12, 20}) and isSorted(new int[]{3, 9, 7}). Expected: true, false

        // TODO 9: Write static boolean isPalindrome(int x) (your LeetCode #9 solution).
        //         Print isPalindrome(121), isPalindrome(123), isPalindrome(-121). Expected: true, false, false

        // TODO 10: Write static String fizzBuzz(int n) that returns the answer for ONE number.
        //          Loop 1..15 in main and print each result. Expected last line: FizzBuzz
    }

    // ===== Section 1-4 methods =====

    static void greet(String station) {
        System.out.println("Welcome to " + station + " gas station!");
    }

    static int totalPrice(int liters, int pricePerLiter) {
        return liters * pricePerLiter;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;          // the comparison IS the boolean, no if/else needed
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int max(int a, int b, int c) {
        return max(max(a, b), c);   // reuse the 2-arg version
    }

    static double max(double a, double b) {
        return a > b ? a : b;
    }

    // ===== Section 5: early return =====

    static String queueLabel(boolean hasGas, int minutes) {
        if (!hasGas) {
            return "no gas";        // leaves the method right here
        }
        if (minutes <= 10) {
            return "short queue";
        }
        if (minutes <= 30) {
            return "medium queue";
        }
        return "long queue";        // the final path also returns
    }

    // ===== Section 6: arrays in and out =====

    static int sum(int[] numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    static double average(int[] numbers) {
        return (double) sum(numbers) / numbers.length;   // calls sum()
    }

    static int[] doubled(int[] numbers) {               // returns a NEW array, original untouched
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i] * 2;
        }
        return result;
    }

    // ===== Section 8-9: pass-by-value =====

    static void tryToRaise(int price) {
        price += 100;               // changes only the local copy
    }

    static int raised(int price) {
        return price + 100;         // the fix: return the new value
    }

    static void raiseAll(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            prices[i] += 100;       // changes the shared array
        }
    }

    // ===== Section 10: recursion =====

    static int factorial(int n) {
        if (n <= 1) {
            return 1;               // base case: stops the recursion
        }
        return n * factorial(n - 1);
    }

    // ===== Your TODO methods go below =====
    // TODO 1 ✅ (example): "minutes <= 15" is already true/false, so just return it.
    //   Long way, same result:  if (minutes <= 15) { return true; } else { return false; }
    static boolean isShortQueue(int minutes) {   // named "minutes", not "n": says what the number means
        return minutes <= 15;
    }

    // TODO 2: Write static double average(int a, int b). Watch out for integer division.
    //         Print average(15, 20). Expected: 17.5
    //         Note: this overloads average(int[]) from section 6. Both can exist!
    static double average(int num1 , int num2){
        return (double) (num1 + num2) / 2;
    }
    // TODO 3: Overload min for (int, int) and (int, int, int). Reuse the 2-arg one inside the 3-arg one.
    //         Print min(20, 40) and min(20, 40, 15). Expected: 20, 15
    static int min(int a, int b) {
        return a < b ? a : b;
    }
    static double min(double a, double b) {
        return a < b ? a : b;
    }

    static int min(int a, int b, int c) {
        return min(min(a, b), c);   // reuse the 2-arg version
    }
    // TODO 4: Write static int countDigits(int n) using the while (n > 0) loop from Day 2.
    //         Print countDigits(4821). Expected: 4
    //         Edge case: what does countDigits(0) return? It should be 1. Fix it with an early return.
    static int countDigits(int n){
        if(n ==0) {
            return 1;
        }
        int count = 0;
        while(n>0){
            count++;
            n = n / 10;
        }
        return count;
    }
    // TODO 5 (DSA classic): Write static boolean isPrime(int n). Only check divisors up to Math.sqrt(n).
    //         Print isPrime(2), isPrime(17), isPrime(21), isPrime(1). Expected: true, true, false, false
    //         Hints: numbers below 2 are not prime (early return). If any i from 2 to sqrt(n) divides n
    //         (n % i == 0), return false right away. Loop condition trick: i * i <= n.
   static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2;i<n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
   }
    // TODO 6: Write static int indexOfMin(int[] numbers) returning the INDEX of the smallest value.
    //         Print indexOfMin(queues). Expected: 4
    static int indexOfMin(int[] numbers){
        int index = 0;
        for(int i = 0;i<numbers.length; i++){
         if(numbers[i]< numbers[index]){
            index = i;
         }
        }
        return index;
    }

    // TODO 7: Write static void reverseInPlace(int[] arr) using your Day 3 two-pointer code.
    //         Call it on {1, 2, 3, 4, 5} and {1, 2, 3, 4}, print both.
    //         Expected: [5, 4, 3, 2, 1] and [4, 3, 2, 1]
    //         Answer in a comment: why does it work even though it returns void? (Hint: section 9)

    static void reverseInPlace(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while(left< right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    // TODO 8: Write static boolean isSorted(int[] arr) with an early return false.
    //         Print isSorted(new int[]{3, 7, 9, 12, 20}) and isSorted(new int[]{3, 9, 7}). Expected: true, false
//    static boolean isSorted(int[] arr){
//
//    }
    // TODO 9: Write static boolean isPalindrome(int x) (your LeetCode #9 solution).
    //         Print isPalindrome(121), isPalindrome(123), isPalindrome(-121). Expected: true, false, false

    // TODO 10: Write static String fizzBuzz(int n) that returns the answer for ONE number.
    //          Loop 1..15 in main and print each result. Expected last line: FizzBuzz
}