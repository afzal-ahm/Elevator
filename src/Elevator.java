import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private Direction direction;
    private int currentFloor;
    private List<Integer> destinations;
    @Override
    public String toString() {
        String destination = new String();
        return "Elevator{" +
                "direction=" + direction +
                ", currentFloor=" + currentFloor +
                ", destination=" + destination +
                '}';
    }

    public Elevator() {
        this.direction = Direction.IDLE;
        this.currentFloor = 0;
        this.destinations = new ArrayList<>();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }



    public void move(int elevatorDestination){

    }
}
