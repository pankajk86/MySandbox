package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstruction {

	public static void main(String[] args) {
//		int[][] people = { { 0, 0 }, { 6, 2 }, { 5, 5 }, { 4, 3 }, 
//				{ 5, 2 }, { 1, 1 }, { 6, 0 }, { 6, 3 }, { 7, 0 }, { 5, 1 } };
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] result = reconstruct(people);
		
		Arrays.stream(result).forEach(t -> System.out.println(t[0] + ", " + t[1]));
	}

	private static int[][] reconstruct(int[][] people) {
		if(people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];
		
		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
		List<int[]> list = new ArrayList<>();
		
		for(int[] p: people)
			list.add(p[1], p);
		
		return list.toArray(new int[0][0]);
	}
}
