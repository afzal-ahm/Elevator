import java.util.ListIterator;

public class ElevatorController {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(1,10);  // initialize elevator system

        System.out.println();
        System.out.println(elevatorSystem.getElevatorSystem()); // get elevator system information (number of elevators , number of floors)


    }
}
