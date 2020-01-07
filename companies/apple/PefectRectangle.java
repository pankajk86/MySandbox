package apple;

import java.util.HashSet;
import java.util.Set;

public class PefectRectangle {

	public static void main(String[] args) {
		int[][] rectangles = {
				{ 1, 1, 3, 3 },
				{ 3, 1, 4, 2 },
				{ 3, 2, 4, 4 },
				{ 1, 3, 2, 4 },
				{ 2, 3, 3, 4 }
		};
		
		boolean result = isRectangleCover(rectangles);
		System.out.println(result);
	}

	private static boolean isRectangleCover(int[][] a) {
		int n = a.length;
		int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
		int actualSize = 0;
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			actualSize += (a[i][2] - a[i][0]) * (a[i][3] - a[i][1]);
			
			x1 = Math.min(x1, a[i][0]);
			y1 = Math.min(y1, a[i][1]);
			x2 = Math.max(x2, a[i][2]);
			y2 = Math.max(y2, a[i][3]);
			
			String s1 = a[i][0] + " " + a[i][1];
			String s2 = a[i][2] + " " + a[i][1];
			String s3 = a[i][2] + " " + a[i][3];
			String s4 = a[i][0] + " " + a[i][3];
			
			if(!set.add(s1)) set.remove(s1);
			if(!set.add(s2)) set.remove(s2);
			if(!set.add(s3)) set.remove(s3);
			if(!set.add(s4)) set.remove(s4);
		}
		
		if(!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2)
			|| !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2)
				|| set.size() != 4)
			return false;
		
		return actualSize == (x2 - x1) * (y2 - y1);
	}

}
