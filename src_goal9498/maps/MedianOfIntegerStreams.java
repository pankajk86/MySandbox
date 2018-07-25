package maps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfIntegerStreams {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 7, 9, 18, 10, 6, 15, 4, 5};
		
		double median = getMedian(a);
		System.out.println("Final Median: " + median);
	}

	private static double getMedian(int[] test) {

		double median = 0D;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		minHeap.add(Math.max(test[0], test[1]));
		maxHeap.add(Math.min(test[0], test[1]));
		
		for(int i = 2; i < test.length; i++) {
			int val = test[i];
			
			if(val > maxHeap.peek()) {
				minHeap.add(val);
				if(minHeap.size() - maxHeap.size() > 1) {
					maxHeap.add(minHeap.poll());
				}
			} else {
				maxHeap.add(val);
				if(maxHeap.size() - minHeap.size() > 1) {
					minHeap.add(maxHeap.poll());
				}
			}
			
			if(minHeap.size() > maxHeap.size()) {
				median = minHeap.peek();
			} else if(minHeap.size() < maxHeap.size()) {
				median = maxHeap.peek();
			} else {
				median = (minHeap.peek() + maxHeap.peek()) / 2D;
			}
			
			System.out.println(i + ": " + median);
		}

		return median;
	}

}
