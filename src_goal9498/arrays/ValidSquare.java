package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSquare {
	
	private static Point diagonalPoint = null;
	private static List<Point> otherPoints = new ArrayList<>();

	public static void main(String[] args) {
		int[] p1 = {-658,-2922}, p2 = {-965,-4209}, p3 = {-2252,-3902}, p4 = {-1945,-2615};
//		int[] p1 = {0,0}, p2 = {0,1}, p3 = {1,0}, p4 = {1, 1};
		
		boolean result = isSquare(p1, p2, p3, p4);
		System.out.println(result);
	}

	private static boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		Point a1 = new Point(p1[0], p1[1]);
		Point a2 = new Point(p2[0], p2[1]);
		Point a3 = new Point(p3[0], p3[1]);
		Point a4 = new Point(p4[0], p4[1]);
		
		a2.dist = updateDistance(a1, a2);
		a3.dist = updateDistance(a1, a3);
		a4.dist = updateDistance(a1, a4);
		
		if(!isTwoSidesEqual(a2, a3, a4)) {
			return false;
		}
		
		if(isProperDiagonalMeasure(diagonalPoint, otherPoints)) {
			return true;
		}
		
		return false;
	}

	private static boolean isProperDiagonalMeasure(Point diagonalPoint, List<Point> points) {
		Point p1 = points.get(0);
		double diagDist = p1.dist * Math.sqrt(2);
		diagDist = Math.round (diagDist * 100.0) / 100.0; 
		
		if(diagonalPoint.dist == diagDist) {
			return true;
		}
		
		return false;
	}

	private static double updateDistance(Point a, Point b) {
		double distance = (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
		distance = Math.round (Math.sqrt(distance) * 100.0) / 100.0;
		return distance;
	}
	
	private static boolean isTwoSidesEqual(Point a, Point b, Point c) {		
		if((a.dist == b.dist && a.dist != c.dist)) {
			diagonalPoint = c;
			otherPoints.addAll(Arrays.asList(a, b));
			return true;
		} else if((a.dist == c.dist && a.dist != b.dist)) {
			diagonalPoint = b;
			otherPoints.addAll(Arrays.asList(a, c));
			return true;
		} else if((b.dist == c.dist && a.dist != b.dist)) {
			diagonalPoint = a;
			otherPoints.addAll(Arrays.asList(b, c));
			return true;
		}
		return false;
	}

}

class Point {
	int x, y;
	double dist = 0.0;
	
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}
}
