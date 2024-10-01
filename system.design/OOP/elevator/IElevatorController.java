package OOP.elevator;

public interface IElevatorController {

	public void pickUp(int floor);
	public boolean addDestination(int elevatorId, int destinationFloor, int passengers);
	public void step();
}
