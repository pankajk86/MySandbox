package elevator;

public interface IElevator {

	public void moveUp();
	public void moveDown();
	public void addDestination(int destination);
	public void removeDestination();
	public Direction getDirection();
	public Status getStatus();
	public boolean addPassengers(int count);
	public void removePassengers(int count);
}
