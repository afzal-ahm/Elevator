import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Direction {
    UP, DOWN, IDLE
}

class Elevator {
    private int currentFloor;
    private Direction direction;
    private List<Integer> destinations;

    public Elevator() {
        this.currentFloor = 0; // Start from the ground floor (0)
        this.direction = Direction.IDLE;
        this.destinations = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void addDestination(int destination) {
        destinations.add(destination);
        if (destination > currentFloor) {
            direction = Direction.UP;
        } else if (destination < currentFloor) {
            direction = Direction.DOWN;
        }
    }

    public boolean hasDestination() {
        return !destinations.isEmpty();
    }

    public void move() {
        if (hasDestination()) {
            int destination = destinations.get(0);
            if (destination > currentFloor) {
                currentFloor++;
            } else if (destination < currentFloor) {
                currentFloor--;
            }

            System.out.println("Elevator is on floor " + currentFloor);
            if (currentFloor == destinations.get(0)) {
                System.out.println("Boarding the elevator...");
            }

            try {
                Thread.sleep(500); // Hold for at least 0.5 seconds on each floor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (destination == currentFloor) {
                destinations.remove(0);
                System.out.println("Exiting the elevator...");
            }
        } else {
            direction = Direction.IDLE;
        }
    }
}

class Floor {
    private int floorNumber;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}

class ElevatorSystem {
    private List<Elevator> elevators;
    private List<Floor> floors;

    public ElevatorSystem(int numElevators, int numFloors) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator());
        }
        floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            floors.add(new Floor(i));
        }
    }

    public Elevator requestElevator(int floor) {
        // Implement a simple elevator request algorithm here
        // For now, let's just return the first elevator.
        if (!elevators.isEmpty()) {
            return elevators.get(0);
        }
        return null;
    }
}

public class ElevatorController {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(2, 10); // 10 floors (0-9)
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the floor you are on (0-9) or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting elevator system.");
                break;
            }

            try {
                int userFloor = Integer.parseInt(input);
                if (userFloor < 0 || userFloor > 9) {
                    System.out.println("Invalid floor number. Please enter a number between 0 and 9.");
                    continue;
                }

                Elevator elevator = elevatorSystem.requestElevator(userFloor);
                if (elevator != null) {
                    System.out.println("Elevator requested. Please wait.");

                    System.out.print("Enter your desired destination floor (0-9): ");
                    int destinationFloor = Integer.parseInt(scanner.nextLine());
                    if (destinationFloor < 0 || destinationFloor > 9) {
                        System.out.println("Invalid destination floor. Please enter a number between 0 and 9.");
                        continue;
                    }

                    elevator.addDestination(userFloor);
                    elevator.addDestination(destinationFloor);

                    while (elevator.hasDestination()) {
                        elevator.move();
                    }
                } else {
                    System.out.println("No available elevators. Please wait.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
}
