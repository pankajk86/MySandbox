package google;

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
	
	double average;
	int[] cache;
	int currentCap, size;
	
	public MovingAverage(int size) {
		this.cache = new int[size];
		this.currentCap = 0;
		this.size = size;
	}
	
	public double next(int val) {
		average = 0D;
		cache[currentCap % size] = val;
		currentCap++;
		
		for(int i = 0; i < size; i++)
			average += cache[i];
		
		int den = (currentCap < size ? currentCap : size);
		return average / den;
	}
}
