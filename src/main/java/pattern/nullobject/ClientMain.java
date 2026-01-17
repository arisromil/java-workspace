package pattern.nullobject;

import java.util.Scanner;

/*
This pattern can be useful in the following cases:
• You do not want to encounter a NullPointerException (for example, if by mistake you try to invoke a method from a null object).
• You like to ignore lots of null checks in your code.
• You want to make your code cleaner and easily maintainable., e.g. no need for if-null checks
 */
public class ClientMain {
    public static void main(String[] args) {
        System.out.println("***The Null Object pattern demonstration.***\n");
        String input = null;
        Vehicle vehicle = null;
        Boolean flag = true;
        int totalObjects = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            while (flag) {
                System.out.println("Enter your choice(Type 'b' for Bus, 't' for Train ) ");
                input = scanner.next();
                switch (input.toLowerCase()) {
                    case "b":
                        vehicle = new Bus();
                        break;
                    case "t":
                        vehicle = new Train();
                        break;
                    case "exit":
                        flag = false;
                        System.out.println("Closing the application.");
                        break;
                    default:
                        System.out.println("Invalid input.");
                        vehicle=NullVehicle.getInstance();
            }
            // There is no need to do a null check now.
            vehicle.travel();
            totalObjects =
                    Bus.busCount +
                            Train.trainCount +
                            NullVehicle.nullVehicleCount;
            System.out.println("Number of objectscreated:" + totalObjects);
        }
    } finally {
        scanner.close();
    }
}}

