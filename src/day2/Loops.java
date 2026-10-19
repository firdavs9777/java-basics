package day2;

/*
 * Day 2 · Lesson 1: Loops
 * A loop repeats code. for = known count, while = until a condition changes, do-while = at least once.
 * DSA: almost every array/string problem is "loop over items and track something" (sum, count, max).
 */
public class Loops {
    public static void main(String[] args) {
        // 1. for loop: start; condition; step
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // 1 2 3 4 5
        // Off-by-one trap: i < 5 gives 1..4, i <= 5 gives 1..5. Check your bounds!

        // 2. while loop: repeat while condition is true
        int queue = 30;
        while (queue > 0) {
            queue -= 8; // each car takes 8 minutes off the queue
        }
        System.out.println("Queue after loop: " + queue); // -2
        // Trap: if the condition never becomes false, the loop runs forever.

        // 3. do-while: body runs at least once, condition checked after
        int tries = 0;
        do {
            tries++;
            System.out.println("Checking Chilonzor station, try " + tries);
        } while (tries < 2);

        // 4. break (stop the loop) and continue (skip to the next round)
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue; // skip even numbers
            if (i > 7) break;         // stop completely after 7
            System.out.print(i + " ");
        }
        System.out.println(); // 1 3 5 7

        // 5. Which loop? for = you know how many times. while = you don't (e.g. digits, input).
        //    do-while = must run once first (menus, "ask again" input).

        // 6. Sum and count pattern
        int[] waits = {20, 40, 15, 35, 10}; // minutes at 5 stations (arrays come on Day 3)
        int sum = 0;
        int shortCount = 0;
        for (int w : waits) {
            sum += w;
            if (w <= 20) shortCount++;
        }
        System.out.println("Total: " + sum + ", short queues: " + shortCount); // 120, 3
        System.out.println("Average: " + (double) sum / waits.length);        // 24.0

        // 7. Max-tracking pattern: start with the first item, not 0 (what if all are negative?)
        int maxWait = waits[0];
        for (int i = 1; i < waits.length; i++) {
            if (waits[i] > maxWait) maxWait = waits[i];
        }
        System.out.println("Longest queue: " + maxWait); // 40

        // 8. Digit-by-digit loop: % 10 gets the last digit, / 10 removes it
        int n = 4300;
        int digitSum = 0;
        int digitCount = 0;
        while (n > 0) {
            digitSum += n % 10;
            digitCount++;
            n /= 10;
        }
        System.out.println("Digits: " + digitCount + ", sum: " + digitSum); // 4, 7
        // Trap: for n = 0 this loop runs zero times, so 0 is counted as 0 digits.

        // ===== Exercises =====
        // TODO 1: Print all numbers from 10 down to 1 with a for loop.
        for(int i=10; i>=1; i--)
        {
            System.out.println(i);
        }
        // TODO 2: Sum all even numbers from 1 to 100 (answer: 2550).
        int evenSum = 0;
        for(int i=2; i<=100; i+=2){
            evenSum += i;
        }
        System.out.println(evenSum);
        // TODO 3: Find the minimum and its index in {20, 40, 15, 35, 10} in one loop.
        int[] numbers = {20,40, 15,35,10};
        int minVal = numbers[0];
        int minIndex = 0;
        for(int i = 1; i<numbers.length; i++){
            if(numbers[i] < minVal){
                minVal = numbers[i];
                minIndex = i;
            }
        }
        System.out.println("Minimum Value: " + minVal);
        System.out.println("Minimum Index: " + minIndex);
        // TODO 4: Reverse the digits of int n = 1234 into 4321 using a while loop.
        int number = 1234;
        int reversed = 0;
        while(number > 0){
            int digit = number % 10; // step 1 => 4, step 2 => 3, step 3 => 2, step 4 => 1
            reversed = reversed * 10 + digit; // step 1=> 4,
            number = number / 10; // 1234,
        }
        System.out.println(reversed);
        // TODO 5 (DSA classic): FizzBuzz. For 1..30 print "Fizz" if divisible by 3,
        //         "Buzz" if by 5, "FizzBuzz" if by both, otherwise the number.

        int[] nums = {3, 2, 4};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println("i=" + i + ", j=" + j + " → " + nums[i] + " + " + nums[j]);
            }
        }
        // Todo 6
        for(int test = 10; test >= 1; test--){
            System.out.println(test);
        }
        // Todo 7
        int total = 0;
        for(int i = 0; i<=100; i++){
           if(i % 2 == 0){
               total += i;
           }
        }
        System.out.println(total);


        // Last Fizzbuzz
        for(int i = 1; i<=30; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.println("Fizz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }

    }
}
