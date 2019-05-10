package uber;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) {
		Interval[] A = createIntervals1();
		Interval[] B = createIntervals2();
		
		Interval[] result = intervalIntersection(A, B);
		
		for(Interval i: result)
			System.out.print(i + " ");
	}

	private static Interval[] intervalIntersection(Interval[] a, Interval[] b) {
		if(a == null || a.length == 0 || b == null || b.length == 0) return null;
		List<Interval> intervals = new ArrayList<>();
		int i = 0, j = 0;
		
		while(i < a.length && j < b.length) {
			Interval i1 = a[i], i2 = b[j];
			
			if(i1.end < i2.start) i++;
			else if(i1.start > i2.end) j++;
			else if(i1.end == i2.start) {
				intervals.add(new Interval(i1.end, i1.end));
				i++;
			} else if(i1.start == i2.end) {
				intervals.add(new Interval(i1.start, i1.start));
				j++;
			} else {
				int start = Math.max(i1.start, i2.start);
				int end = Math.min(i1.end, i2.end);
				intervals.add(new Interval(start, end));
				if(i1.end == end && i2.end == end) {
					i++; j++;
				} else if(i1.end == end) i++;
				else j++;
			}
		}
		
		Interval[] result = new Interval[intervals.size()];
		for(i = 0; i < intervals.size(); i++)
			result[i] = intervals.get(i);
		
		return result;
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
