package OOP.new_elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorTest {

    public static void main(String[] args) {
        // Initialize elevators
        List<Elevator> elevators = new ArrayList<>();
        Elevator elevator1 = new Elevator();
        Elevator elevator2 = new Elevator();
        elevators.add(elevator1);
        elevators.add(elevator2);

        // Initialize the controller
        ElevatorController controller = new ElevatorController(elevators);

        // Simulate external requests
        System.out.println("Handling external request from floor 3 going up...");
        controller.handleExternalRequest(3, Direction.UP);

        System.out.println("Handling external request from floor 5 going down...");
        controller.handleExternalRequest(5, Direction.DOWN);

        // Simulate internal request within elevator1
        System.out.println("Elevator 1 internal request to floor 6...");
        elevator1.addRequest(new Request(6, RequestType.INTERNAL));

        // Simulate internal request within elevator2
        System.out.println("Elevator 2 internal request to floor 2...");
        elevator2.addRequest(new Request(2, RequestType.INTERNAL));

        // Test movement of the elevators
        System.out.println("Elevator 1 is at floor: " + elevator1.getCurrentFloor());

        System.out.println("Elevator 1 internal requests to floor 3 and 8...");
        List<Request> requests = List.of(
                new Request(3, RequestType.INTERNAL),
                new Request(8, RequestType.INTERNAL)
        );
        elevator1.addRequests(requests);

        System.out.println("Elevator 1 is at floor: " + elevator1.getCurrentFloor());

        System.out.println("Elevator 2 is at floor: " + elevator2.getCurrentFloor());

        // Adding more requests to stress test the system
        System.out.println("Handling external request from floor 7 going down...");
        controller.handleExternalRequest(7, Direction.DOWN);
    }
}

