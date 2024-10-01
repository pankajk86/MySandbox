package OOP.new_elevator;

import java.util.Comparator;

public class Request {
    private final int destinationFloor;
    private final RequestType type;

    public Request(int destinationFloor, RequestType type) {
        this.destinationFloor = destinationFloor;
        this.type = type;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}

class RequestComparator implements Comparator<Request> {
    private final Elevator elevator;

    public RequestComparator(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public int compare(Request r1, Request r2) {
        int currentFloor = elevator.getCurrentFloor();
        int r1Floor = r1.getDestinationFloor();
        int r2Floor = r2.getDestinationFloor();
        Direction direction = elevator.getCurrentDirection();

        // Prioritize requests that are in the same direction as the elevator's current direction
        if (direction == Direction.UP) {
            // If going up, prioritize requests above the current floor
            if (r1Floor >= currentFloor && r2Floor < currentFloor) {
                return -1;
            } else if (r1Floor < currentFloor && r2Floor >= currentFloor) {
                return 1;
            }
        } else if (direction == Direction.DOWN) {
            // If going down, prioritize requests below the current floor
            if (r1Floor <= currentFloor && r2Floor > currentFloor) {
                return -1;
            } else if (r1Floor > currentFloor && r2Floor <= currentFloor) {
                return 1;
            }
        }

        // If both requests are in the same direction, compare by proximity to the current floor
        return Integer.compare(Math.abs(r1Floor - currentFloor), Math.abs(r2Floor - currentFloor));
    }
}
