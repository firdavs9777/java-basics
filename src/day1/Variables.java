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
        double averagePrice = 3.500;
        boolean firstStationHasGas = false;
        boolean secondStationHasGas = true;
        System.out.println(stationName);
        System.out.println(secondStationName);
        System.out.println("Time to go the station name " + totalWaiting);
        // Note: int / int drops the fraction. Use 2.0 to get a decimal result.
        System.out.println("Average price among both stations " + (firstGasStationPrice + secondStationPrice) / 2);
        System.out.println("First station has no gas " + firstStationHasGas);
        System.out.println("Second station has no gas " + secondStationHasGas);

        // ===== Exercises =====
        // TODO 1: Use averagePrice for something real, or delete it (unused variables are noise).
        // TODO 2: Fix the two "has no gas" labels so the printed text matches the value.
        // TODO 3: Declare a `final int MAX_QUEUE = 60;` and try to reassign it. Read the compiler error.
        // TODO 4: Use `var` for a local variable and hover it in IntelliJ to see the inferred type.
    }
}
