package uber;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) {
		Interval[] A = createIntervals1();
		Interval[] B = createIntervals2();
		
		Interval[] result = intervalIntersectionSimple(A, B);
		for(Interval i: result) System.out.print(i + " ");
	}
	
	private static Interval[] intervalIntersectionSimple(Interval[] a, Interval[] b) {
		List<Interval> intervals = new ArrayList<>();
		
		for(int i = 0, j = 0; i < a.length && j < b.length; ) {
			Interval i1 = a[i], i2 = b[j];
			
			int start = Math.max(i1.start, i2.start);
			int end = Math.min(i1.end, i2.end);
			
			if(end >= start) 
				intervals.add(new Interval(start, end));
			
			if(i1.end == end) i++;
			if(i2.end == end) j++;
		}
		
		return intervals.toArray(new Interval[0]);
	}

	private static Interval[] createIntervals1() {
		Interval i1 = new Interval(0, 2);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(13, 23);
		Interval i4 = new Interval(24, 25);
		
		return new Interval[] {i1, i2, i3, i4};
	}

	private static Interval[] createIntervals2() {
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(8, 12);
		Interval i3 = new Interval(15, 24);
		Interval i4 = new Interval(25, 26);
		
		return new Interval[] {i1, i2, i3, i4};
	}

}

class Interval {
	int start, end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
}
