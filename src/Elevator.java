import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private Direction direction;
    private int currentFloor;
    private List<Integer> destinations;

    @Override
    public String toString() {
        return "Elevator{" +
                "direction=" + direction +
                ", currentFloor=" + currentFloor +
                ", destinations=" + destinations +
                '}';
    }

    public Elevator() {
        this.direction = Direction.IDLE;
        this.currentFloor = 0;
        this.destinations = new ArrayList<>();
    }

    public void setDirection() {
        if (destinations.get(0) > currentFloor) {
            direction = Direction.UP;
        } else if (destinations.get(0) < currentFloor) {
            direction = Direction.DOWN;
        }

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setDestinations(int num) {
        destinations.add(num);

    }


    public boolean hasDestination() {
        return !destinations.isEmpty();
    }

    public void moveUserPlace(int floors){


            System.out.println("\nElevator is on floor " + (currentFloor));
        System.out.print("------------------------------------------\n");
        for(int i=0; i < floors; ++i){

            if (i == this.currentFloor){
                System.out.print(" == ");
            } else {
                System.out.printf(" %d ", i);
            }
        }

        if (direction.equals(Direction.UP)){
            System.out.println("\n\n-->");
        } else if(direction.equals(Direction.DOWN)){
            System.out.println("\n\n<--");
        }else {
            System.out.println("\n\n--");
        }
        System.out.println("------------------------------------------\n\n");




            try {
                Thread.sleep(500); // Hold for at least 0.5 seconds on each floor
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (destinations.get(0) > currentFloor) {
                currentFloor++;
            } else if (destinations.get(0) == currentFloor) {

                destinations.remove(0);
                System.out.println("The Elevator door has opened.....\n");
                setDirection(Direction.IDLE);
            } else {
                currentFloor--;
            }

    }
}
