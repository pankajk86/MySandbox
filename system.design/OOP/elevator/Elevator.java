package OOP.elevator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements IElevator {
	
	private int currentFloor;
	private int currentCount;
	private Queue<Integer> destinations;
	private static final int MAX_CAPACITY = 20;
	
	public Elevator(int currentFloor) {
		this.currentFloor = currentFloor;
		this.destinations = new LinkedList<>();
	}

	@Override
	public void moveUp() {
		this.currentFloor++;
	}

	@Override
	public void moveDown() {
		this.currentFloor--;
	}

	@Override
	public void addDestination(int destination) {
		this.destinations.add(destination);
	}
	
	@Override
	public void removeDestination() {
		this.destinations.remove();
	}

	@Override
	public Direction getDirection() {
		if(this.destinations.size() == 0)
			return Direction.HOLD;
		else {
			if(this.destinations.peek() < this.currentFloor) 
				return Direction.DOWN;
			else if(this.destinations.peek() > this.currentFloor)
				return Direction.UP;
			else
				return Direction.HOLD;
		}
	}

	@Override
	public Status getStatus() {
		return this.currentCount > 0 ? Status.OCCUPIED : Status.EMPTY;
	}

	@Override
	public boolean addPassengers(int count) {
		boolean result = false;
		int currentSpace = MAX_CAPACITY - currentCount;
		
		if(currentSpace >= count) {
			currentCount += count;
			result = true;
		}
		return result;
	}

	@Override
	public void removePassengers(int count) {
		if(this.currentCount >= count)
			this.currentCount -= count;
	}

}
