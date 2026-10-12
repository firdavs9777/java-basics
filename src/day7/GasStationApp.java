package day7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

/*
 * Day 7 · MINI PROJECT: Tashkent Gas Station Manager (console app)
 * A SPEC + SKELETON. It compiles, but most methods are TODO: your job is to implement them.
 * This is the "week 1 final exam": if you can build it alone, you are ready for DSA and then Spring
 * (a Spring app is basically this, with HTTP instead of a console menu and a DB instead of a List).
 *
 * REQUIREMENTS (and which day's topics they practice):
 *  R1. Model: record Station(name, district, FuelType fuel, int price, int queueMinutes, boolean hasGas)
 *      + enum FuelType { AI_80, AI_92, AI_95, METAN, PROPAN }               -> Day 1 types, Day 5 classes/records/enums
 *  R2. Store stations in a List<Station> AND a Map<String, Station> by name (keep both in sync)
 *                                                                           -> Day 6 Lists, MapsAndSets
 *  R3. Menu loop with Scanner: 1 list, 2 add, 3 cheapest with gas, 4 sort by queue,
 *      5 filter by fuel, 6 simulate queue, 0 exit                          -> Day 2 loops, switch
 *  R4. List stations: print every station on one line (nice formatting) -> Day 3 strings, Day 4 methods
 *  R5. Add station: read fields from the user; reject duplicates by name (use the Map) -> Day 6 Maps
 *  R6. Find cheapest station that HAS gas; print "none" if there is none (Optional) -> Day 7 streams/Optional
 *  R7. Sort by queue minutes ascending (ties -> by price) WITHOUT changing the original list
 *                                                                           -> Day 6 Sorting (Comparator)
 *  R8. Filter by fuel type the user types (e.g. "ai_92"); use at least one stream here -> Day 7 streams
 *  R9. Simulate a car queue at one station with ArrayDeque<String>: N cars, each takes 5 minutes,
 *      print who is served at which minute                                -> Day 6 StacksAndQueues
 *  R10. Bad input must NOT crash the app: wrong menu number, "abc" for a price, unknown fuel type,
 *       unknown station -> catch NumberFormatException / IllegalArgumentException, print a message,
 *       show the menu again                                                -> Day 7 Exceptions
 *  BONUS: custom StationNotFoundException; "update price" menu item; count stations per district
 *         with Collectors.groupingBy.
 */
public class GasStationApp {

    enum FuelType { AI_80, AI_92, AI_95, METAN, PROPAN }

    record Station(String name, String district, FuelType fuel, int price, int queueMinutes, boolean hasGas) {
    }

    // R2: two views of the same data
    private static final List<Station> stations = new ArrayList<>();
    private static final Map<String, Station> byName = new HashMap<>();

    // R2: add to BOTH collections. Throw IllegalArgumentException if the name already exists.
    static void addStation(Station s) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    // R4
    static void listStations() {
        // TODO: print each station, or "No stations yet" if empty
    }

    // R5: ask the user for each field, parse numbers and the enum, then call addStation(...)
    static void addStationFromInput(Scanner in) {
        // TODO (hint: Integer.parseInt, FuelType.valueOf(text.toUpperCase()))
        throw new UnsupportedOperationException("TODO");
    }

    // R6
    static Optional<Station> findCheapestWithGas() {
        // TODO: stream + filter + min
        throw new UnsupportedOperationException("TODO");
    }

    // R7: return a NEW sorted list
    static List<Station> sortedByQueue() {
        // TODO: copy the list, sort with Comparator.comparingInt(...).thenComparingInt(...)
        throw new UnsupportedOperationException("TODO");
    }

    // R8
    static List<Station> filterByFuel(FuelType fuel) {
        // TODO: stream + filter + toList
        throw new UnsupportedOperationException("TODO");
    }

    // R9: build an ArrayDeque of cars, poll them one by one, print the minute each one finishes
    static void simulateQueue(String stationName, int cars) {
        Queue<String> queue = new ArrayDeque<>();
        // TODO: look up the station in byName (handle "not found"), fill the queue, serve every car
        throw new UnsupportedOperationException("TODO");
    }

    // Some starting data so the menu has something to show
    static void seed() {
        // TODO: once addStation works, uncomment these
        // addStation(new Station("Chilonzor-1", "Chilonzor", FuelType.AI_92, 4300, 25, true));
        // addStation(new Station("Bodomzor", "Yunusobod", FuelType.METAN, 5300, 10, true));
        // addStation(new Station("Sergeli", "Sergeli", FuelType.AI_95, 4800, 5, false));
    }

    static void printMenu() {
        System.out.println("""
                ==== Tashkent Gas Stations ====
                1. List stations
                2. Add station
                3. Find cheapest with gas
                4. Sort by queue
                5. Filter by fuel type
                6. Simulate car queue
                0. Exit""");
        System.out.print("Choose: ");
    }

    public static void main(String[] args) {
        seed();
        Scanner in = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            if (!in.hasNextLine()) break; // input closed (e.g. Ctrl+D)
            String choice = in.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> listStations();
                    case "2" -> addStationFromInput(in);
                    case "3" -> System.out.println("TODO: call findCheapestWithGas() and print the result");
                    case "4" -> System.out.println("TODO: print sortedByQueue()");
                    case "5" -> System.out.println("TODO: read a fuel type, print filterByFuel(...)");
                    case "6" -> System.out.println("TODO: read station name + car count, call simulateQueue(...)");
                    case "0" -> running = false;
                    default -> System.out.println("Unknown option: " + choice);
                }
            } catch (UnsupportedOperationException e) {
                System.out.println("Not implemented yet - that's your job!");
            }
            // TODO R10: also catch NumberFormatException, then IllegalArgumentException (in THAT order:
            //           NumberFormatException is a subclass of IllegalArgumentException)
        }
        System.out.println("Bye! Xayr!");
    }
}
