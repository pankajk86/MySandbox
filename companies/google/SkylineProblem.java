package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {

	public static void main(String[] args) {
		int[][] a = {
				{2, 9, 10}, 
				{3, 7, 15}, 
				{5, 12, 12}, 
				{15, 20, 10}, 
				{19, 24, 8} 
		};
		
		List<int[]> result = getSkyline(a);
		
		for(int[] p: result)
			System.out.println(p[0] + ", " + p[1]);
	}

	private static List<int[]> getSkyline(int[][] a) {
		List<int[]> result = new ArrayList<>();
		Point[] points = new Point[a.length * 2];
		int i = 0;
		
		for(int[] p: a) {
			int start = p[0], end = p[1], height = p[2];
			points[i++] = new Point(start, height, true);
			points[i++] = new Point(end, height, false);
		}
		
		Arrays.sort(points);
		
		int prevMax = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(0);
		
		for(Point p: points) {
			if(p.isStart) {
				pq.add(p.height);
				int currMax = pq.peek();
				if(currMax > prevMax) {
					result.add(new int[] {p.x, p.height});
					prevMax = currMax;
				}
			} else {
				pq.remove(p.height);
				int currMax = pq.peek();
				if(currMax < prevMax) {
					result.add(new int[] {p.x, currMax});
					prevMax = currMax;
				}
			}
		}
		
		return result;
	}

}

class Point implements Comparable<Point> {
	int x, height;
	boolean isStart;
	
	Point(int x, int height, boolean isStart) {
		this.x = x;
		this.height = height;
		this.isStart = isStart;
	}

	@Override
	public int compareTo(Point p) {
		if(this.x != p.x)
			return this.x - p.x;
		else {
			// both buildings have same starting edge.
			if(this.isStart && p.isStart)
				return p.height - this.height;
			// both buildings have same ending edge.
			else if(!this.isStart && !p.isStart)
				return this.height - p.height;
			else 
				return this.isStart ? -1 : 1;
		}
	}
}
