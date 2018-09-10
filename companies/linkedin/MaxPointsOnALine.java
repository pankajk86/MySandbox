package linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		Point[] points = createPoints();
		int result = maxPoints(points);
		System.out.println(result);
		
		points = createPoints2();
		result = maxPoints(points);
		System.out.println(result);
		//testLineMap();
	}

	private static int maxPoints(Point[] points) {

		int result = 0, n = points.length;
		Map<Line, Set<Point>> map = new HashMap<>();
		
		if(n == 1) return 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					Point p1 = points[i], p2 = points[j];
					Line line = getLine(p1, p2); // 0.9999999894638303
					Set<Point> set = map.getOrDefault(line, new HashSet<>());
					set.addAll(Arrays.asList(p1, p2));
					map.put(line, set);
				}
			}
		}
		
		for(Set<Point> set: map.values()) {
			result = Math.max(result, set.size());
		}
		
		return result;
	}
	
	private static Line getLine(Point p1, Point p2) {

		// slope = (y2 - y1) / (x2 - x1)
		double den = (double) (p2.x - p1.x);
		double slope = den == 0D ? Integer.MAX_VALUE : (p2.y - p1.y) / den;
		
		// intercept = y - mx
		double intercept = (double) (p2.y - slope * p2.x);
		
		return new Line(slope, intercept);
	}
	
	public static void testLineMap() {
		Map<Line, Set<Point>> map = new HashMap<>();
		
		Line l1 = new Line(0.5D, 1D);
		Set<Point> set = new HashSet<>();
		set.addAll(Arrays.asList(new Point(2, 3), new Point(3, 2)));
		map.put(l1, set);
		
		Line l2 = new Line(0.5D, 1D);
		set = map.getOrDefault(l2, new HashSet<>());
		set.add(new Point(4, 1));
		System.out.println();
	}

	private static Point[] createPoints() {

		Point[] points = new Point[6];
		points[0] = new Point(1, 1);
		points[1] = new Point(3, 2);
		points[2] = new Point(5, 3);
		points[3] = new Point(4, 1);
		points[4] = new Point(2, 3);
		points[5] = new Point(1, 4);
		
		return points;
	}
	
	private static Point[] createPoints2() {
		Point[] points = new Point[3];
		points[0] = new Point(0, 0);
		points[1] = new Point(94911151,94911150);
		points[2] = new Point(94911152,94911151);
		return points;
	}

}

class Line {
	double slope, intercept;
	
	Line(double slope, double intercept) {
		this.slope = slope; this.intercept = intercept;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Line))
			return false;
		
		if(o == this)
			return true;
		
		Line line = (Line) o;
		
		if(line.slope == this.slope && line.intercept == this.intercept)
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = (int) (31 * slope + intercept);
		return result;
	}
}

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x; this.y = y;
	}
}