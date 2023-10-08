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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    public void setDestinations(int num) {
        destinations.add(num);

    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }



    public void moveUserPlace(){
        if (destinations.get(0) > currentFloor) {
            direction = Direction.UP;
        } else if (destinations.get(0) < currentFloor) {
            direction = Direction.DOWN;
        }
        while (destinations.get(0) != currentFloor) {
            System.out.println(currentFloor);
            if (destinations.get(0) > currentFloor) {
                currentFloor++;
            } else {
                currentFloor--;
            }
        }
    }
}
