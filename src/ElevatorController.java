import java.util.ListIterator;
import java.util.Scanner;

public class ElevatorController {
    public static void main(String[] args) {
        int numberOfFloors = 10;
        ElevatorSystem elevatorSystem = new ElevatorSystem(1,numberOfFloors);  // initialize elevator system
        Scanner sc = new Scanner(System.in);

//        System.out.println(elevatorSystem.getElevatorSystem()); // get elevator system information (number of elevators , number of floors)

        while (true) {
            System.out.print("Enter the floor you are on (0-"+(numberOfFloors-1)+") or 'q' to quit: ");
            String input = sc.next();
//            System.out.println(input);

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting elevator system.");
                break;
            }
            try {
                int userInput = Integer.parseInt(input);
                if (userInput < 0 || userInput > (numberOfFloors-1) ){
                    System.out.println("Invalid floor number. Please enter a number between 0 and "+(numberOfFloors-1)+".");
                    continue;
                }
                System.out.println("Elevator requested. Please wait.");
                System.out.println();
                Elevator elevator = elevatorSystem.elevatorRequest(userInput);
//                System.out.println(elevator);
                elevator.setDestinations(userInput);
                elevator.setDirection();
//                System.out.println(elevator);

                while (elevator.hasDestination()){
                    elevator.moveUserPlace();
//                    System.out.println(elevator);
                }

//                System.out.println(elevator);

                System.out.print("Enter your desired destination floor (0-"+(numberOfFloors-1)+"): ");
                int destinationFloor = Integer.parseInt(sc.next());

                if (destinationFloor < 0 || destinationFloor > (numberOfFloors-1)){
                    System.out.println("Invalid floor number. Please enter a number between 0 and "+(numberOfFloors-1)+".");
                    continue;
                }
//                System.out.println(elevator);

                elevator.setDestinations(destinationFloor);
                elevator.setDirection();

//                System.out.println(elevator);

                while (elevator.hasDestination()){
                    elevator.moveUserPlace();
//                    System.out.println(elevator);
                }


//                System.out.println(elevator);

            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }


    }

}
