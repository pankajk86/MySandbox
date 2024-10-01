package OOP.new_elevator;

import java.util.List;
import java.util.PriorityQueue;

public class Elevator {
    private int currentFloor;
    private Direction currentDirection;
    private ElevatorState state;
    private final PriorityQueue<Request> requests;

    public Elevator() {
        this.currentFloor = 0; // Assuming ground-floor is the initial floor
        this.currentDirection = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.requests = new PriorityQueue<>(new RequestComparator(this));
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public ElevatorState getState() {
        return state;
    }

    // Add a request to the elevator's queue
    public void addRequest(Request request) {
        requests.add(request);
        processRequests();
    }

    public void addRequests(List<Request> input) {
        requests.addAll(input);
        processRequests();
    }

    // Process the next request
    private void processRequests() {
        if (requests.isEmpty()) {
            state = ElevatorState.IDLE;
            currentDirection = Direction.IDLE;
            return;
        }

        Request nextRequest = requests.poll();
        moveToFloor(nextRequest.getDestinationFloor());
    }

    // Move the elevator to a specific floor
    private void moveToFloor(int destinationFloor) {
        if (destinationFloor > currentFloor) {
            currentDirection = Direction.UP;
        } else if (destinationFloor < currentFloor) {
            currentDirection = Direction.DOWN;
        } else {
            currentDirection = Direction.IDLE;
        }

        // Simulate the movement (in a real system, this would control hardware)
        while (currentFloor != destinationFloor) {
            if (currentDirection == Direction.UP) {
                currentFloor++;
            } else { // if the currentDirection is Direction.DOWN
                currentFloor--;
            }
            // Code to open and close doors, check for other requests, etc.
        }

        state = ElevatorState.IDLE;
        currentDirection = Direction.IDLE;
        processRequests(); // Check if there are more requests
    }
}

