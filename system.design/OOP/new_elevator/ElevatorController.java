package OOP.new_elevator;

import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;

    public ElevatorController(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    // Handle an external request (from a floor)
    public void handleExternalRequest(int floor, Direction direction) {
        Elevator bestElevator = findBestElevator(floor, direction);
        bestElevator.addRequest(new Request(floor, RequestType.EXTERNAL));
    }

    // Find the best elevator to handle the request
    private Elevator findBestElevator(int floor, Direction direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - floor);
            if (elevator.getState() == ElevatorState.IDLE ||
                    (elevator.getCurrentDirection() == direction && distance < minDistance)) {
                bestElevator = elevator;
                minDistance = distance;
            }
        }
        return bestElevator;
    }
}
