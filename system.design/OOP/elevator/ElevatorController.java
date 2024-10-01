package OOP.elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController implements IElevatorController {
	
	private static final int MAX_ELEVATORS = 16;
	private static final int GROUND_FLOOR = 1;
	private int countElevators = 0;
	private int countFloors = 0;
	private List<IElevator> elevators;
	private final Queue<Integer> pickupLocations;
	
	public ElevatorController(int countElevators, int countFloors) {
		this.countElevators = Math.min(countElevators, MAX_ELEVATORS);
		this.countFloors = countFloors;
		initializeElevators();
		this.pickupLocations = new LinkedList<>();
	}

	private void initializeElevators() {
		this.elevators = new ArrayList<>();
		for(int i = 0; i < countElevators; i++) {
			this.elevators.add(new Elevator(GROUND_FLOOR));
		}
	}

	@Override
	public void pickUp(int floor) {
		this.pickupLocations.add(floor);
	}

	@Override
	public boolean addDestination(int elevatorId, int destinationFloor, int passengers) {
		IElevator elevator = this.elevators.get(elevatorId);
		boolean canAccomodate = elevator.addPassengers(passengers);
		
		if(canAccomodate) {
			elevator.addDestination(destinationFloor);
			return true;
		}
		return false;
	}

	@Override
	public void step() {
		for(IElevator elevator: this.elevators) {
			switch(elevator.getStatus()) {
			
			case EMPTY:
				if(!this.pickupLocations.isEmpty())
					elevator.addDestination(this.pickupLocations.poll());
				break;
			case OCCUPIED:
				switch(elevator.getDirection()) {
				
				case UP:
					elevator.moveUp();
					break;
				case DOWN:
					elevator.moveDown();
					break;
				case HOLD:
					elevator.removeDestination();
					elevator.removePassengers(0); // TODO
				
				default:
					break;
				
				}
			default:
				break;
			
			}
		}
	}
	
	//TODO: need to see, how can we use floor count
	public int countFloors() {
		return this.countFloors;
	}

}
