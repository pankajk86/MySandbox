package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverageOfDataStreams {

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1));
		System.out.println(m.next(10));
		System.out.println(m.next(3));
		System.out.println(m.next(5));

		System.out.println("=========================");

		MovingAverageWithQueue mq = new MovingAverageWithQueue(3);
		System.out.println(mq.next(1));
		System.out.println(mq.next(10));
		System.out.println(mq.next(3));
		System.out.println(mq.next(5));

		System.out.println("=========================");

		MovingAverageWithArray ma = new MovingAverageWithArray(3);
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));
	}

}

class MovingAverageWithArray {

	int[] arr;
	int n, index = 0, total = 0;
	boolean reached = false;

	public MovingAverageWithArray(int size) {
		this.n = size;
		this.arr = new int[n];
	}

	public double next(int val) {
		if (reached) {
			total -= arr[index];
		}

		total += val;
		arr[index++] = val;

		if (index == n) {
			index = 0;
			reached = true;
		}

		return reached ? total / (double) n : total / (double) index;
	}
}

class MovingAverageWithQueue {

	Queue<Integer> q = new LinkedList<>();
	double total;
	int size;

	public MovingAverageWithQueue(int size) {
		this.size = size;
	}

	public double next(int val) {
		q.add(val);
		total += val;

		if (q.size() > this.size) {
			total -= q.poll();
		}

		return total / q.size();
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
