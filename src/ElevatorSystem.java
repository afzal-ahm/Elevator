import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ElevatorSystem {

    List<Elevator> elevators;  // number of elevator in the system (1)
    List<Floor> floors;    // number of floor in the system (o-9)
    public ElevatorSystem(int numOfElevators, int numOfFloor) { // elevatorSystem constructor
        elevators = new ArrayList<Elevator>();       // it can hold number of elevators (choose only one elevator, multiple elevator is not implemented yet)
        for (int i =0; i < numOfElevators; i++){
            elevators.add(new Elevator());
        }

        floors = new ArrayList<Floor>();           // it can hold any number of floors (you can add any number of floors, but display only (0-9) for now)
        for (int i =0; i < numOfFloor; i++){
            floors.add(new Floor(i));
        }

    }
    public String getElevatorSystem() {

        ListIterator<Floor> floorListIterator = floors.listIterator();
        ArrayList<Integer> a = new ArrayList<Integer>();

        while (floorListIterator.hasNext()){
            Floor floor = floorListIterator.next();
            a.add(floor.getFloorNumber());
        }

        ListIterator<Elevator> elevatorListIterator = elevators.listIterator();

        Elevator elevator = elevatorListIterator.next();

        return "ElevatorSystem{" + elevator.toString() +
                ", Floors=" + a +
                '}';


    }

    public Elevator elevatorRequest(int userFloor){
        return elevators.get(0);
    }

}