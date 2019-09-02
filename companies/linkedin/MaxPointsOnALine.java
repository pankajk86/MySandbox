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
		
		int[][] locations = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		result = maxPointsBetter(locations);
		System.out.println(result);
		
		int[][] locs = { { 0, 0 }, { 1, 65536 }, { 65536, 0 } };
		result = maxPointsBetterAndSimpler(locs);
		System.out.println(result);
	}
	
	private static int maxPointsBetterAndSimpler(int[][] a) {
		if(a == null || a.length == 0) return 0;
		int result = 2, n = a.length;
		if(n < 3) return n;
		
		for(int i = 1; i < n; i++) {
			long x1 = a[i - 1][0], y1 = a[i - 1][1];
			long x2 = a[i][0], y2 = a[i][1];
			int count = 0;
			
			if(x1 == x2 && y1 == y2) {
				for(int j = 0; j < n; j++) {
					if(a[j][0] == x1 && a[j][1] == y1) count++;
				}
			} else {
				for(int j = 0; j < n; j++) {
					long x3 = a[j][0], y3 = a[j][1];
					/* 
					 * same slope condition for (x1, y1), (x2, y2), (x3, y3)
					 * (y2 - y1) / (x2 - x1) = (y3 - y2) / (x3 - x2)
					 * => (y2 - y1) * (x3 - x2) = (y3 - y2) * (x2 - x1) 
					 */
					if((y3 - y2) * (x2 - x1) == (y2 - y1) * (x3 - x2)) count++;
				}
			}
			result = Math.max(result, count);
		}
		return result;
	}

	private static int maxPointsBetter(int[][] a) {
		if(a == null || a.length == 0) return 0;
		int result = 0;
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < a.length; i++) {
			int max = 0, overlap = 0;
			map.clear();
			for(int j = i + 1; j < a.length; j++) {
				int x = a[j][0] - a[i][0], y = a[j][1] - a[i][1];
				if(x == 0 && y == 0) {
					overlap++; continue;
				}
				
				int gcd = findGcd(x, y);
				if(gcd != 0) {
					x /= gcd; y /= gcd;
				}
				String key = x + "@" + y;
				map.put(key, map.getOrDefault(key, 0) + 1);
				max = Math.max(max, map.get(key));
			}
			result = Math.max(result, max + overlap + 1);
		}
		
		return result;
	}

	private static int findGcd(int x, int y) {
		if(y == 0) return x;
		return findGcd(y, x % y);
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