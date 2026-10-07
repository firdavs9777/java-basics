//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // Lesson 1  Variables
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
    System.out.println("Average price among both stations " + (firstGasStationPrice + secondStationPrice ) / 2);
    System.out.println("First station has no gas " +firstStationHasGas);
    System.out.println("Second station has no gas " + secondStationHasGas);
    // Lesson 2: Conditions


    // 1. Basic if and else conditions
    boolean open = true;
    boolean hasGas;
    if(open)
    {
        hasGas = true;
    }
    else {
        hasGas = false;
    }
    if(hasGas) {
        System.out.println("Go to that station and get the gas");
    }
    else {
        System.out.println("Go to home hehe or find another gas station");
    }
    // 2.  Comparison Operators
    int queue = 25;
    System.out.println(queue > 20); // true
    System.out.println(queue < 20); // false
    System.out.println(queue >= 20); // true
    System.out.println(queue <= 10); // false
    System.out.println(queue == 25); // true
    System.out.println(queue != 25); // false

    // 3. else if for multiple options
    if(queue <= 10) {
        System.out.println("Short queue, go now!");
    }
    else if(queue <= 30) {
        System.out.println("Medium queue, okay");
    }
    else {
        System.out.println("Long queue, try later");
    }

    // 4. Combining Options
    boolean hasGases = true;
    int queue_last = 20;

    if(hasGases && queue_last == 20){
        System.out.println("Perfect, go!!");
    }
    if(!hasGases || queue_last > 60){
        System.out.println
    }





//    System.out.println("Station: " + stationName);
//    System.out.println("Has gas: " + hasGas );
//    System.out.println("Queue: " + queueMinutes + "min ");
//    System.out.println("Price: " + price);
//    int a = 15;

}
