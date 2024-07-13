package google;

import java.util.ArrayList;
import java.util.List;

public class MovingAvgOfIntegers {

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));
	}

}

class MovingAverage {

	List<Integer> list = new ArrayList<>();
	double total;
	int size;
	
	public MovingAverage(int size) {
		this.size = size;
	}
	
	public double next(int val) {
		if (list.size() == this.size) {
			total -= list.remove(0);
		}
		
		list.add(val);
		total += val;
		return total / list.size();
	}
}
