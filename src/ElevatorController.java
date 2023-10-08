import java.util.ListIterator;
import java.util.Scanner;

public class ElevatorController {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(1,10);  // initialize elevator system
        Scanner sc = new Scanner(System.in);

        System.out.println();
//        System.out.println(elevatorSystem.getElevatorSystem()); // get elevator system information (number of elevators , number of floors)

        while (true) {
            System.out.print("Enter the floor you are on (0-9) or 'q' to quit: ");
            String input = sc.next();
//            System.out.println(input);

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting elevator system.");
                break;
            }
            try {
                int userInput = Integer.parseInt(input);
                if (userInput < 0 || userInput > 9 ){
                    System.out.println("Invalid floor number. Please enter a number between 0 and 9.");
                    continue;
                }
                System.out.println("Elevator requested. Please wait.");
                Elevator elevator = elevatorSystem.elevatorRequest(userInput);
                System.out.println(elevator);
                elevator.setDestinations(userInput);
                elevator.moveUserPlace();
                System.out.println(elevator);

//                System.out.print("Enter your desired destination floor (0-9): ");
//                int destinationFloor = Integer.parseInt(sc.next());
//
//                if (destinationFloor < 0 || destinationFloor > 9){
//                    System.out.println("Invalid floor number. Please enter a number between 0 and 9.");
//                    continue;
//                }
//
//                System.out.println(elevator);

            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }


    }

}
