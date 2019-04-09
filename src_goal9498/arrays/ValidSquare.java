package arrays;

public class ValidSquare {
	
	public static void main(String[] args) {
		int[] p1 = {-658,-2922}, p2 = {-965,-4209}, p3 = {-2252,-3902}, p4 = {-1945,-2615};
//		int[] p1 = {0,0}, p2 = {0,1}, p3 = {1,0}, p4 = {1, 1};
		
		boolean result = isSquare(p1, p2, p3, p4);
		System.out.println(result);
	}

	private static boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int d1 = getDist(p1, p2), d2 = getDist(p1, p3), d3 = getDist(p1, p4);
		
		if(d1 == d2)
			return (d3 == 2 * d1) && checkOtherDistance(d1, p2, p3, p4);
		else if(d1 == d3)
			return (d2 == 2 * d1) && checkOtherDistance(d1, p2, p4, p3);
		else if(d2 == d3)
			return (d1 == 2 * d2) && checkOtherDistance(d2, p3, p4, p2);
		return false;
	}

	private static boolean checkOtherDistance(int d, int[] p1, int[] p2, int[] p3) {
		int d1 = getDist(p1, p3), d2 = getDist(p2, p3);
		return d1 == d && d2 == d;
	}

	private static int getDist(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}
}

