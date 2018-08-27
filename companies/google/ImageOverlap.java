package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlap {

	public static void main(String[] args) {
		int[][] A = {{1,1,0},
			    {0,1,0},
			    {0,1,0}};
		int[][] B = {{0,0,0},
			    {0,1,1},
			    {0,0,1}};
		
		int result = maxOverlap(A, B);
		System.out.println(result);
	}

	private static int maxOverlap(int[][] a, int[][] b) {

		List<Integer> al = new ArrayList<>();
		List<Integer> bl = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		int n = a.length;
		
		for(int i = 0; i < n * n; i++) {
			if(a[i / n][i % n] == 1)
				al.add(i / n * 100 + i % n);
		}
		
		for(int i = 0; i < n * n; i++) {
			if(b[i / n][i % n] == 1)
				bl.add(i / n * 100 + i % n);
		}
		
		for(int i: al) {
			for(int j: bl) 
				map.put(i - j, map.getOrDefault(i - j, 0) + 1);
		}
		
		int result = 0;
		
		for(int i: map.values())
			result = Math.max(result, i);
		
		return result;
	}

}
